import API.POJO.Root;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class APItest {

    String token;

    @BeforeTest(description = "Authorization")
    public void Login() {
        baseURI = "https://www.onliner.by";
        String login = "/sdapi/user.api/login";
        String requestBody = "{\n" +
                "    \"login\": \"ellenorree@gmail.com\",\n" +
                "    \"password\": \"QA07_onl2021\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(requestBody).and().post(login).then().extract().response();
        this.token = response.jsonPath().get("access_token").toString();
    }

    @Test(description = "Test verifies GET request for Onliner.by API ")
    public void checkResponseByTownID() {
        baseURI = "https://geo.api.onliner.by";
        String minskEndpoint = "/towns/17030";
        Gson gson = new Gson();
        Root root = gson.fromJson(given().when().get(minskEndpoint).getBody().asPrettyString(), Root.class);
        Assert.assertEquals(root.district.name, "Минский");
    }

    @Test (description = "Checks access token after authorization")
    public void successfulAuthorization () {
        Assert.assertTrue(token != null );
    }

    @Test(description = "Verify possible variants of cancel messages")
    public void checkErrorText() {
        baseURI = "https://cart.api.onliner.by";
        List<String> errors = Arrays.asList("Товара нет в наличии", "Заказ продублирован", "Покупателя не устроила стоимость товара", "Покупателя не устроил срок доставки", "Покупателя не устроила стоимость доставки", "Покупатель отказался от заказа", "Не удалось связаться с покупателем", "Иное");
        String errorAPI = "/resources/shop-cancel-reasons";
        Response response = given().get(errorAPI).then().extract().response();
        Assert.assertEquals(errors, response.jsonPath().get("text"));
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test (description = "Verify profile email after authorization")
    public void checkProfileEmail() {
        baseURI = "https://www.onliner.by";
        String endpoint = "/sdapi/user.api/me";
        Response response = given().when().header("Authorization", "Bearer " + token).and().get(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("email").toString(), "ellenorree@gmail.com");
    }
    @Test (description = "Verify error for the incorrect order request")
    public void checkNonExistentOrderError() {
        baseURI = "https://cart.api.onliner.by";
        String endpoint = "/orders/qz2wa";
        Response response = given().when().header("Authorization", "Bearer " + token).and().get(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 404);
        Assert.assertEquals(response.jsonPath().get("message").toString(), "Заказ не найден");
    }
}

