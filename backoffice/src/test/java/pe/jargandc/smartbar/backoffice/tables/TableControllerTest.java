package pe.jargandc.smartbar.backoffice.tables;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class TableControllerTest {

    @InjectMock
    TableRepository repository;

    @BeforeEach
    void setup(){
        final TableEntity entity = new TableEntity();
        entity.setName("Mock");
        Mockito.when(repository.listAll()).thenReturn(List.of(entity));
    }

    @Test
    void getAllTables(){
        final Response response = given()
                .when().get("/tables")
                .then()
                .statusCode(200)
                .extract().response();
        final JsonPath jsonPath = response.jsonPath();
        Assertions.assertEquals("Mock", jsonPath.getString("[0].name"));

    }
}
