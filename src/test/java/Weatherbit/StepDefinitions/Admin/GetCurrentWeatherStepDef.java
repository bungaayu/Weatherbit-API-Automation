package Weatherbit.StepDefinitions.Admin;

import Weatherbit.API.WeatherbitAPI;
import Weatherbit.Responses.GlobalEnvironment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetCurrentWeatherStepDef {
    @Steps
    WeatherbitAPI weatherbitAPI;
    @Given("set path get current weather with lat {double} lon {double} and key {string}")
    public void setPathGetCurrentWeatherWithLatLatLonLonAndKey(double lat, double lon, String key) {
        weatherbitAPI.getCurrentWeather(lat,lon,key);
    }
    @When("send request get current weather data")
    public void sendRequestGetCurrentWeatherData() {
        SerenityRest.when().get(WeatherbitAPI.CURRENT_WEATHER);
    }

    @Then("should return {int} ok")
    public void shouldReturnOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("response body count should be {int}")
    public void responseBodyCountShouldBe(int count) {
        SerenityRest.then().body(GlobalEnvironment.COUNT, equalTo(count));
    }

    @And("assert response body get current weather to json schema")
    public void assertResponseBodyGetCurrentWeatherToJsonSchema() {
        File json = new File(WeatherbitAPI.JSON_FILE+"/JsonSchema/GetCurrentWeatherJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


}
