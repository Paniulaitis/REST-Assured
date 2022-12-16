import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import objects.User;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class PostTests {

    @Test
    void postUsingObjectMapping() {

        User user = new User("Ivan", "Programmer");

        given().
                log().method().
                log().uri().
                log().params().
                contentType(ContentType.JSON).
                body(user).
                when().
                baseUri(BaseUrl.reqres).
                post(EndPoints.reqresUsers).
                then().
                statusCode(HttpStatus.SC_CREATED).
                body(
                        "name", Matchers.is(user.getName()),
                        "job", Matchers.is(user.getJob()),
                        "id", notNullValue(),
                        "createdAt", notNullValue()
                );
    }
}
