package reqres;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import reqres.builders.UserBuilder;
import reqres.models.UserPostPut;
import reqres.models.UsersListPage;

import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsersTestes {

    private static int idUserParaRequestPut;

    private static int idUserParaRequestDelete;

    private static int numeroPagina;

    @BeforeAll
    public static void antesTestes(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI     = "https://reqres.in/";
        RestAssured.basePath    = "api";
        idUserParaRequestPut    = 2;
        idUserParaRequestDelete = 2;
        numeroPagina            = 2;

    }

    @Test
    public void deveRetornarUsuariosQuandoPesquisarListaUsuarios(){

        UsersListPage users =
                given()
                    .spec(UserBuilder.requestUsersListPage(numeroPagina))
                .when()
                    .get("users")
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .contentType(ContentType.JSON)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsons/usersListPage.json"))
                    .extract().body().as(UsersListPage.class);

        assertEquals(6, users.getData().size());

    }

    @Test
    public void deveRetornarUsuarioCriadoComIdQuandoMetodoPostForRequisitado(){

        UserPostPut user = given()
                    .spec(UserBuilder.requestUsersPost())
                .when()
                    .post("users")
                .then()
                    .statusCode(HttpStatus.SC_CREATED)
                    .contentType(ContentType.JSON)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsons/usersPost.json"))
                    .extract().body().as(UserPostPut.class);

        assertTrue(Objects.nonNull(user.getId()));

    }

    @Test
    public void deveRetornarUsuarioAlteradoQuandoMetodoPutForRequisitado(){

        UserPostPut user = given()
                    .spec(UserBuilder.requestUsersPut(idUserParaRequestPut))
                .when()
                    .put("users/{user}")
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .contentType(ContentType.JSON)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsons/usersPut.json"))
                    .extract().body().as(UserPostPut.class);

        assertTrue(Objects.nonNull(user.getUpdatedAt()));

    }

    @Test
    public void deveRetornarStatus204QuandoMetodoDeleteForRequisitado(){

        given()
            .spec(UserBuilder.requestUsersDelete(idUserParaRequestDelete))
        .when()
            .delete("users/{user}")
        .then()
            .statusCode(HttpStatus.SC_NO_CONTENT);

    }

}
