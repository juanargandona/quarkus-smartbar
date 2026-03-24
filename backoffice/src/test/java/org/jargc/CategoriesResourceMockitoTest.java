package org.jargc;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jakarta.inject.Inject;
import org.jargc.categories.CategoriesService;
import org.jargc.smartbar.backoffice.api.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CategoriesResourceMockitoTest {
    @InjectMock
    CategoriesService categoriesService;

    @BeforeEach
    void setUp(){
        Mockito.when(categoriesService.getCategory()).thenReturn(new Category().name("Mock"));
    }

    @Test
    void getListOfCategories(){
        final Response response = given()
                .when().get("/categories")
                .then()
                .statusCode(200)
                .extract().response();
        final JsonPath jsonPath = response.jsonPath();

        Assertions.assertEquals("Mock", jsonPath.getString("[0].name"));
    }
}
