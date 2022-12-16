import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.restassured.filter.log.LogDetail;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;


public class GetTests {

    @Test
    public void archiveGetTest() {
        // RequestSpecification - класс спецификация ответа
        ResponseSpecification response = RestAssured.expect();
        response.logDetail(LogDetail.ALL);
        response.statusCode(HttpStatus.SC_OK);

        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri(BaseUrl.archive);
        request.log().method();
        request.log().uri();
        request.log().params();

        // Проверка ответа
        request.get(EndPoints.principleOfRelations).then().spec(response);
    }

    @Test
    public void jikanGetTest() {
        // RequestSpecification - класс спецификация ответа
        ResponseSpecification response = RestAssured.expect();
        response.logDetail(LogDetail.ALL);
        response.statusCode(HttpStatus.SC_OK);

        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri(BaseUrl.jikan);
        request.log().method();
        request.log().uri();
        request.log().params();

        // Проверка ответа
        request.get(EndPoints.jikanAnna).then().spec(response);
    }

    @Test
    public void archiveGetFailedTest() {
        // RequestSpecification - класс спецификация ответа
        ResponseSpecification response = RestAssured.expect();
        response.logDetail(LogDetail.ALL);
        response.statusCode(HttpStatus.SC_NOT_FOUND);

        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri(BaseUrl.archive);
        request.log().method();
        request.log().uri();
        request.log().params();

        // Проверка ответа
        request.get(EndPoints.archiveFailedString).then().spec(response);
    }

    @Test
    public void jikanGetFailedTest() {
        // RequestSpecification - класс спецификация ответа
        ResponseSpecification response = RestAssured.expect();
        response.logDetail(LogDetail.ALL);
        response.statusCode(HttpStatus.SC_NOT_FOUND);

        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri(BaseUrl.jikan);
        request.log().method();
        request.log().uri();
        request.log().params();

        // Проверка ответа
        request.get(EndPoints.jikanFailedString).then().spec(response);
    }

    @Test
    public void getAgifyJSONNameTest() {
        // RequestSpecification - класс спецификация ответа
        ResponseSpecification response = RestAssured.expect();
        response.logDetail(LogDetail.ALL);
        response.body("name", equalTo("michael"));

        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri(BaseUrl.agify);
        request.log().method();
        request.log().uri();
        request.log().params();

        // Проверка ответа
        request.get(EndPoints.agifyMichael).then().spec(response);
    }

    @Test
    public void getAgifyJSONAgeTest() {
        // RequestSpecification - класс спецификация ответа
        ResponseSpecification response = RestAssured.expect();
        response.logDetail(LogDetail.ALL);
        response.body("age", equalTo("61"));

        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri(BaseUrl.agify);
        request.log().method();
        request.log().uri();
        request.log().params();

        // Проверка ответа
        request.get(EndPoints.agifyMichael).then().spec(response);
    }

    @Test
    public void getAgifyContentTypeTest() {
        // RequestSpecification - класс спецификация ответа
        ResponseSpecification response = RestAssured.expect();
        response.logDetail(LogDetail.ALL);
        response.contentType(ContentType.JSON);

        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri(BaseUrl.agify);
        request.log().method();
        request.log().uri();
        request.log().params();

        // Проверка ответа
        request.get(EndPoints.agifyMichael).then().spec(response);
    }

    @Test
    public void getAgifyContentLengthTest() {
        // RequestSpecification - класс спецификация ответа
        ResponseSpecification response = RestAssured.expect();
        response.logDetail(LogDetail.ALL);
        response.header("content-length", "42");;

        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri(BaseUrl.agify);
        request.log().method();
        request.log().uri();
        request.log().params();

        // Проверка ответа
        request.get(EndPoints.agifyMichael).then().spec(response);
    }

}
