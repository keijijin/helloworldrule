package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@QuarkusTest
public class MessageRuleTest {

    @Test
    public void testHelloEndpoint() {
        Message message = given()
                .body("{\n" +
                        "  \"messages\": [\n" +
                        "    {\n" +
                        "      \"message\": \"Hello World!\",\n" +
                        "      \"status\": 0\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .contentType(ContentType.JSON)
          .when().post("/helloworld/first")
          .then()
             .statusCode(200)
                .extract()
                .as(Message.class);

        assertThat(message.getステータス(), equalTo(Message.GOODBYE));
        assertThat(message.getメッセージ(), equalTo("Goodbye cruel world!"));
    }

}