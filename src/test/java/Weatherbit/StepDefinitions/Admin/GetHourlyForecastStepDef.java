package Weatherbit.StepDefinitions.Admin;

import Weatherbit.API.WeatherbitAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class GetHourlyForecastStepDef {
    @Steps
    WeatherbitAPI weatherbitAPI;
    @Given("set path get hourly forecast with postal_code {int} hours {int} and key {string}")
    public void setPathGetHourlyForecastTo(int postal_code, int hours, String key){
        weatherbitAPI.getHourlyForecast(postal_code, hours, key);
    }

    @When("send request get hourly forecast")
    public void sendRequestGetHourlyForecast() {
        SerenityRest.when().get(WeatherbitAPI.HOURLY_FORECAST);
    }

    @And("assert response body get hourly forecast to json schema")
    public void assertResponseBodyGetHourlyForecastToJsonSchema() {
        File json = new File(WeatherbitAPI.JSON_FILE+"/JsonSchema/GetHourlyForecastJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
