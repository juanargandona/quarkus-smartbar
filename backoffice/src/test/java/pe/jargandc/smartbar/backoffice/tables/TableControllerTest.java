package pe.jargandc.smartbar.backoffice.tables;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class TableControllerTest {

    @BeforeEach
    void setup(){
        PanacheMock.mock(TableEntity.class);
        final TableEntity entity = new TableEntity();
        entity.name = "table mock";
        Mockito.when(TableEntity.listAll()).thenReturn(List.of(entity));
    }

    @Test
    void getAllTables(){
        final Response response = given()
                .when().get("/categories")
                .then()
                .statusCode(200)
                .extract().response();
        final JsonPath jsonPath = response.jsonPath();

    }
}
