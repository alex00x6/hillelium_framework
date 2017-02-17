import com.google.gson.JsonObject;
import org.jglue.fluentjson.JsonBuilderFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/**
 * Created by Storm on 15.12.2016.
 */
public class JSONBuilderTest {


    @Test
    public void test3(){
        JsonObject jsonObject = JsonBuilderFactory.buildObject() //Create a new builder for an object
                .addNull("nullKey")                            //1. Add a null to the object

                .add("stringKey", "Hello")                     //2. Add a string to the object
                .add("stringNullKey", (String) null)           //3. Add a null string to the object

                .add("numberKey", 2)                           //4. Add a number to the object
                .add("numberNullKey", (Float) null)            //5. Add a null number to the object

                .add("booleanKey", true)                       //6. Add a boolean to the object
                .add("booleanNullKey", (Boolean) null)         //7. Add a null boolean to the object

                .add("characterKey", 'c')                      //8. Add a character to the object
                .add("characterNullKey", (Character) null)     //9. Add a null character to the object

                .addObject("objKey")                           //10. Add a nested object
                .add("nestedPropertyKey", 4)                 //11. Add a nested property to the nested object
                .end()                                       //12. End nested object and return to the parent builder

                .addArray("arrayKey")                          //13. Add an array to the object
                .addObject()                                 //14. Add a nested object to the array
                .end()                                     //15. End the nested object
                .add("arrayElement")                         //16. Add a string to the array
                .end()                                       //17. End the array

                .getJson();                                  //Get the JsonObject

        String json = jsonObject.toString();
        System.out.println(json);
    }

    @Test
    public void jsonFluentTest(){
        JsonObject jsonObject = JsonBuilderFactory.buildObject()
                .addObject("update")
                .addArray("summary")
                .addObject()
                .add("set", "changing summary with soap")
                .getJson();
        System.out.println(jsonObject.toString());
        //{"update":{"summary":[{"set":"changing summary with soap"}]}}
    }

    @Test
    public void oldJsonTest(){
        JSONObject credentials = new JSONObject();
        JSONObject update = new JSONObject();
        JSONObject summary = new JSONObject();
        JSONArray insideSummary = new JSONArray();
        summary.put("set", "changing summary with soap");
        insideSummary.add(summary);
        update.put("summary", insideSummary);
        credentials.put("update", update);
        System.out.println(credentials.toString());
        //{"update":{"summary":[{"set":"changing summary with soap"}]}}
        }
    }
