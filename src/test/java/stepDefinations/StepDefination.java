package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.DefaultDestination;
import pojo.flightResponse;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefination extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data = new TestDataBuild();

    @Given("Valid country code {string}")
    public void validCountryCode(String countryCode) throws IOException {
        res = given().spec(requestSpecification(countryCode));
    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        APIResources resourceAPI = APIResources.valueOf(resource);
        resspec = new ResponseSpecBuilder().log(LogDetail.ALL).expectStatusCode(200).expectContentType(ContentType.JSON).build();
        if (method.equalsIgnoreCase("POST"))
            response = res.expect().defaultParser(Parser.JSON).when().post(resourceAPI.getResource());
        else if (method.equalsIgnoreCase("GET")) response = res.when().log().all().get(resourceAPI.getResource());
    }

    @Then("the API call got success with status code {int}")
    public void the_API_call_got_success_with_status_code(Integer int1) {
        assertEquals(response.getStatusCode(), 200);

    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String Expectedvalue) {
        assertEquals(getJsonPath(response, keyValue), Expectedvalue);

    }

    @Given("The valid payload with country code - {string}")
    public void theValidPayloadWithCountryDetails(String country) throws IOException {
        res = given().spec(requestSpecification(country)).body(data.flightPayload(country));
    }

    @And("Validate origins {string} and destinations {string} are available in Response")
    public void validateOriginsAndDestinationsAreAvailableInResponse(String origin, String destination) {
        flightResponse fr = response.getBody().as(flightResponse.class);
        List<Object> originsList = new ArrayList<>();
        if (Objects.nonNull(fr) && (Objects.nonNull(fr.getOrigins()))) for (pojo.origins or : fr.getOrigins()) {
            originsList.add(or.getIata());
        }
        List<Object> destinationList = new ArrayList<>();
        if (Objects.nonNull(fr) && (Objects.nonNull(fr.getDefault_destinations())))
            for (DefaultDestination dd : fr.getDefault_destinations()) {
                destinationList.add(dd.getIata());
            }
        assertEquals(originsList.contains(origin), destinationList.contains(destination));

    }
}

