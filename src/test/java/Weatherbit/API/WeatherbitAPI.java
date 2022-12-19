package Weatherbit.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

public class WeatherbitAPI {

    public static String DIR = System.getProperty("user.dir");
    public static String JSON_FILE = DIR+"/src/test/resources/JSON";
    public static String URL = "http://api.weatherbit.io/v2.0";
    public static String CURRENT_WEATHER = URL+"/current";
    public static String HOURLY_FORECAST = URL+"/forecast/hourly";

    public void getCurrentWeather(double lat, double lon, String key) {
        SerenityRest.given()
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("key", key);
    }

    public void getHourlyForecast(int postal_code, int hours, String key) {
        SerenityRest.given()
                .queryParam("postal_code", postal_code)
                .queryParam("hours", hours)
                .queryParam("key", key);
    }


}
