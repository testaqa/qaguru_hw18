package tests;

import config.ConfigHelper;
import io.qameta.allure.restassured.AllureRestAssured;
import models.Issue;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GithubApiTests {

    int issueId = 1;
    String issueTitle = "Test Issue Title Here";
    String issueBody = "Some issue description";

    @Test
    void getGithubIssueApiTest() {
        Issue response = given()
                .baseUri(ConfigHelper.getBaseURL())
                .basePath("repos/testaqa/qaguru_hw18")
                .filter(new AllureRestAssured().setRequestTemplate("request.ftl").setResponseTemplate("response.ftl"))
                .log().uri()
                .when()
                .get("/issues/{issue}", issueId)
                .then()
                .log().body()
                .extract()
                .as(Issue.class);

        assertThat(response.getNumber(), is(issueId));
        assertThat(response.getTitle(), is(issueTitle));
        assertThat(response.getBody(), is(issueBody));
    }

}
