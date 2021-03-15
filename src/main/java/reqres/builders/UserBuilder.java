package reqres.builders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import reqres.models.UserPostPut;

public class UserBuilder {

    public UserBuilder() {}

    public static RequestSpecification requestUsersListPage(int numeroPagina){
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.addParam("page",numeroPagina);
        return reqBuilder.build();
    }

    public static RequestSpecification requestUsersPost() {

        UserPostPut user = new UserPostPut();
        user.setNome("Name");
        user.setJob("Job");

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(ContentType.JSON);
        reqBuilder.setAccept(ContentType.JSON);
        reqBuilder.setBody(user);
        return reqBuilder.build();

    }

    public static RequestSpecification requestUsersPut(int idUser) {

        UserPostPut user = new UserPostPut();
        user.setNome("Name");
        user.setJob("Job");

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.addPathParam("user",idUser);
        reqBuilder.setContentType(ContentType.JSON);
        reqBuilder.setAccept(ContentType.JSON);
        reqBuilder.setBody(user);
        return reqBuilder.build();

    }

    public static RequestSpecification requestUsersDelete(int idUserParaRequestDelete) {

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.addPathParam("user",idUserParaRequestDelete);
        reqBuilder.setContentType(ContentType.JSON);
        reqBuilder.setAccept(ContentType.JSON);
        return reqBuilder.build();

    }

}
