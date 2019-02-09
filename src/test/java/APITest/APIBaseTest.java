package APITest;

import Common.Environment;
import Model.Post;
import Model.PostDataWrapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.List;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.config.LogConfig.logConfig;


public class APIBaseTest {

    protected RequestSpecification requestSpec;

    @BeforeSuite
    protected void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(Environment.getGraphBaseUrl() + Environment.getGraphVersion() + "/")
                .addHeader("Authorization", "Bearer " + Environment.getPageAccessToken())
                .build();
        RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails());
    }

    @AfterSuite
    protected void tearDown(){
        GetListOfPostObjects()
                .forEach(
                    x -> given()
                        .spec(requestSpec)
                        .delete(x.getId()));
    }

    protected String AddPost(String messageText){
        return given()
                .spec(requestSpec)
                .when()
                .param("message", messageText)
                .post("me/feed")
                .body()
                .path("id");
    }

    protected List<Post> GetListOfPostObjects(){
        return given()
                .spec(requestSpec)
                .get("me/posts")
                .body()
                .as(PostDataWrapper.class)
                .getData();
    }

    protected ValidatableResponse GetPostResponse(String postID){
        return given()
                .spec(requestSpec)
                .get(postID)
                .then();
    }
}
