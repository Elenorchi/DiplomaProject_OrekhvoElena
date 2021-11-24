import API.POJO.Root;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class APItest {

    @Test (description = "Test verifies GET request for Onliner.by API ")
    public void checkResponseByTownID() {
        baseURI = "https://geo.api.onliner.by";
        String minskEndpoint = "/towns/17030";
        Gson gson = new Gson();
        Root root = gson.fromJson(given().when().get(minskEndpoint).getBody().asPrettyString(), Root.class);
        Assert.assertEquals(root.district.name, "Минский");
    }

    @Test (description ="Test for login through POST request")
    public void checkLogin() {
        baseURI = "https://www.onliner.by";
        String login = "/sdapi/user.api/login";
        String element = "expires_in";
        Integer expectedResponse = 315360000;
        String requestBody = "{\n" +
                "    \"login\": \"ellenorree@gmail.com\",\n" +
                "    \"password\": \"QA07_onl2021\"\n" +
                "}";
        Response response = given().header("Content-Type","application/json").body(requestBody).and().post(login).then().extract().response();
        Assert.assertEquals(response.jsonPath().get(element),expectedResponse);
        Assert.assertEquals(response.statusCode(),200);
    }
}

