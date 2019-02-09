package APITest;

import Common.EndPoint;
import Common.Parameter;
import Common.JSONSchema;
import org.testng.annotations.Test;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;

public class APIFaceBookPostTests extends APIBaseTest {

    @Test
    public void createPostTest(){
        String messageText = UUID.randomUUID().toString();
        String postID =
                given()
                .spec(requestSpec)
                .when()
                .param(Parameter.MESSAGE, messageText)
                .post(EndPoint.ME_FEED)
                .then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath(JSONSchema.ID))
                .extract()
                .path("id");

        GetPostResponse(postID)
                .statusCode(200)
                .body("message", equalTo(messageText))
                .body("id", equalTo(postID))
                .body(matchesJsonSchemaInClasspath(JSONSchema.POST));
    }

    @Test
    public void deletePostTest(){
        String messageText = UUID.randomUUID().toString();
        String postID = AddPost(messageText);
        String errorResponseMessage = "(#10) Object does not exist, " +
                "cannot be loaded due to missing reviewable feature " +
                "'Page Public Content Access', or does not support this operation. " +
                "To use 'Page Public Content Access', " +
                "your use of this endpoint must be reviewed and approved by Facebook. " +
                "To submit this 'Page Public Content Access' feature " +
                "for review please read our documentation " +
                "on reviewable features: https://developers.facebook.com/docs/apps/review.";

        given()
                .spec(requestSpec)
                .delete(postID)
                .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body(matchesJsonSchemaInClasspath(JSONSchema.SUCCESS));

        GetPostResponse(postID)
                .statusCode(400)
                .body("error.message", equalTo(errorResponseMessage))
                .body("$", not(hasKey("id")))
                .body(matchesJsonSchemaInClasspath(JSONSchema.ERROR));
    }

    @Test
    public void updatePostTest(){
        String createMessageText = UUID.randomUUID().toString();
        String updateMessageText = UUID.randomUUID().toString();
        String postID = AddPost(createMessageText);

        given()
                .spec(requestSpec)
                .when()
                .param(Parameter.MESSAGE, updateMessageText)
                .post(postID)
                .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body(matchesJsonSchemaInClasspath(JSONSchema.SUCCESS));

        GetPostResponse(postID)
                .statusCode(200)
                .body("message", equalTo(updateMessageText))
                .body("id", equalTo(postID))
                .body(matchesJsonSchemaInClasspath(JSONSchema.POST));
    }
}
