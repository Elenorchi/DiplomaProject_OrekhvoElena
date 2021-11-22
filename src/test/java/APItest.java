import API.POJO.Root;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class APItest {

    @BeforeTest
    public void precondition() {
        baseURI = "https://geo.api.onliner.by";
    }

    @Test
    public void checkResponseByTownID() {
        String minskAPI = "/towns/17030";
        Gson gson = new Gson();
        Root root = gson.fromJson(given().when().get(minskAPI).getBody().asPrettyString(), Root.class);
        Assert.assertEquals(root.district.name, "Минский");
    }
}

