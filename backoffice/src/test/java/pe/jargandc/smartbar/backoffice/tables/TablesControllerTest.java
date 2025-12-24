package pe.jargandc.smartbar.backoffice.tables;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class TablesControllerTest {
    @Test
    void getAllTables(){
        final Response response = given()
                .when().get("/tables")
                .then()
                .statusCode(200)
                .extract().response();
        final JsonPath jsonPath = response.jsonPath();
        Assertions.assertEquals("Oslo", jsonPath.getString("[0].name"));
    }
}
