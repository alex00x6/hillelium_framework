import base.api.RequestSender;
import com.jayway.restassured.RestAssured;
import models.jiraapi.ApiGenerateJSONForJIRA;
import models.jiraapi.ApiRequestGroups;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Storm on 18.11.2016.
 */
public class DeleteRedundantIssues_API {

    private final String[] usefulIssues = {"QAAUT-1830", "QAAUT-137", "QAAUT-30", "QAAUT-29"};
    private final String searchJql = "project=QAAUT and assignee=geloksmmm";

    //BFG9000 удаляет все ISSUE, полученные в поиске по Jira через метод searchForIss2929ues, кроме указанных в usefulIssues
    //(сейчас поиск работает по передаваемому параметру searchJql)


    @Test
    public void makeMagic(){
        //эта команда покажет ответ от сервера в JSON
        //searchForIssues();

        //эта команда позволяет посмотреть отдельно ключи, полученные из поиска
        //getKeysFromResponse(searchForIssues());

        //эта команда позволяет посмотреть отфильрованный(подготовленный к удалению) список ключей
        //removeUsefulIssuesFromList(getKeysFromResponse(searchForIssues()));

        //а эта команда позволяет разбомбить всё найденное и отфильрованное
        deleteIssuesInList(removeUsefulIssuesFromList(getKeysFromResponse(searchForIssues())));

    }

    private void deleteIssuesInList(List<String> list){
        ApiRequestGroups apiRequestGroups = new ApiRequestGroups();
        list.forEach(apiRequestGroups::deleteIssue);

    }


    private String searchForIssues(){
        ApiRequestGroups apiRequestGroups = new ApiRequestGroups();
        ApiGenerateJSONForJIRA generateJSONForJIRA = new ApiGenerateJSONForJIRA();
        RestAssured.baseURI = "http://soft.it-hillel.com.ua:8080/"; //JIRA Hillel
        //apiRequestGroups.authenticate();

        RequestSender requestSender = apiRequestGroups
                .search(generateJSONForJIRA.searchByJql(searchJql));
        System.out.println(requestSender.response.asString());
        return requestSender.response.asString();
    }

    private List<String> getKeysFromResponse(String jsonAsString){
        JSONObject obj = new JSONObject(jsonAsString);
        JSONArray issues = obj.getJSONArray("issues");
        int n = issues.length();
        List<String> keys = new ArrayList<>();
        System.out.println(n);
        for(int i = 0; i < n; i++){
            JSONObject key = issues.getJSONObject(i);
            System.out.println(key.getString("key"));
            keys.add(key.getString("key"));
        }
        System.out.println(keys.size());
        return keys;
    }

    private List<String> removeUsefulIssuesFromList(List<String> list){
        for(int i = 0; i < list.size(); i++){
            for (String usefulIssue : usefulIssues) {
                if (list.get(i).equals(usefulIssue)) {
                    list.remove(i);
                }
            }
        }
        System.out.println(list.toString());
        return list;
    }

}
