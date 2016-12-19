package models.jiraapi;


import base.api.RequestSender;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;


public class RequestConstructor extends RequestSender {
    private static String JSESSIONID = null;
    private static String STUDIO_TOKEN = null;
    private final static ContentType CONTENT_TYPE = ContentType.JSON;

    public RequestSender createRequest(String body){
        if (RestAssured.baseURI.contains("https://")){
            this.createRequestSpecification()
                    .addHeader("Content-Type", CONTENT_TYPE.toString())
                    .addHeader("Cookie", "JSESSIONID="+RequestConstructor.JSESSIONID)
                    .addHeader("Cookie", "studio.crowd.tokenkey="+RequestConstructor.STUDIO_TOKEN)
                    .addBody(body);
            return this;
        }
        else{
            this.createRequestSpecification()
                    .addHeader("Content-Type", CONTENT_TYPE.toString())
                    .addHeader("Cookie", "JSESSIONID=" + RequestConstructor.JSESSIONID)
                    .addBody(body);
            return this;
        }
    }


    public RequestSender createEmptyRequest(){
        if(RestAssured.baseURI.contains("https://")){
            this.createRequestSpecification()
                    .addHeader("Content-Type", CONTENT_TYPE.toString())
                    .addHeader("Cookie", "JSESSIONID="+RequestConstructor.JSESSIONID)
                    .addHeader("Cookie", "studio.crowd.tokenkey="+RequestConstructor.STUDIO_TOKEN);
            return this;
        }

        else{
            this.createRequestSpecification()
                    .addHeader("Content-Type", CONTENT_TYPE.toString())
                    .addHeader("Cookie", "JSESSIONID=" + RequestConstructor.JSESSIONID);
            return this;
        }
    }

    public void authenticate(){
        ApiGenerateJSONForJIRA generateJSON = new ApiGenerateJSONForJIRA();
        String credentials = generateJSON.login();

        createRequest(credentials)
                .post(ApiURLs.LOGIN.getUri());


        if (RestAssured.baseURI.contains("https://")){
            System.out.println("Connected via HTTPS");

            JSESSIONID = response.then().extract().path("session.value");
            STUDIO_TOKEN = response.then().extract().cookie("studio.crowd.tokenkey");
            System.out.println(JSESSIONID);
            System.out.println(STUDIO_TOKEN);
        }
        else{
            System.out.println("Connected via HTTP");

            JSESSIONID = response.then().extract().path("session.value");
            System.out.println(JSESSIONID);
        }

    }

}
