package stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.weather.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;

    @Given("city ID: {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather date")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.getWeatherData(cityId);
    }

    @Then("coordinates are:")
    public void check_coords(Map<String, Double> coords) {
        Assertions.assertEquals(coords.get("lon"), response.getCoord().getLon(), "Incorrect Coord lon");
        Assertions.assertEquals(coords.get("lat"), response.getCoord().getLat(), "Incorrect Coord lat");
    }

    @And("weather is:")
    public void check_weather(Map<String, String> weather) {
        Assertions.assertEquals(Long.parseLong(weather.get("id")), response.getWeathers().get(0).getId(), "Incorrect id");
        Assertions.assertEquals(weather.get("main"), response.getWeathers().get(0).getMain(), "Incorrect main");
        Assertions.assertEquals(weather.get("description"), response.getWeathers().get(0).getDescription(), "Incorrect description");
        Assertions.assertEquals(weather.get("icon"), response.getWeathers().get(0).getIcon(), "Incorrect icon");
    }

    @And("base is:")
    public void check_base(Map<String, String> base) {
        Assertions.assertEquals(base.get("base"), response.getBase(), "Incorrect base");
    }

    @And("main is:")
    public void check_main(Map<String, String> main)  {
        Assertions.assertEquals(Double.parseDouble(main.get("temp")), response.getMain().getTemp(), "Incorrect temp");
        Assertions.assertEquals(Integer.parseInt(main.get("pressure")), response.getMain().getPressure(), "Incorrect pressure");
        Assertions.assertEquals(Integer.parseInt(main.get("humidity")), response.getMain().getHumidity(), "Incorrect humidity");
        Assertions.assertEquals(Double.parseDouble(main.get("temp_min")), response.getMain().getTempMin(), "Incorrect min_temp");
        Assertions.assertEquals(Double.parseDouble(main.get("temp_max")), response.getMain().getTempMax(), "Incorrect max_temp");
    }

    @And("visibility is:")
    public void check_visibility(Map<String, Integer> visibility) {
        Assertions.assertEquals(visibility.get("visibility"), response.getVisibility(), "Incorrect visibility");
    }

    @And("wind is:")
    public void check_wind(Map<String, String> wind) {
        Assertions.assertEquals(Double.parseDouble(wind.get("speed")), response.getWind().getSpeed(), "Incorrect");
        Assertions.assertEquals(Integer.parseInt(wind.get("deg")), response.getWind().getDeg(), "Incorrect");
    }

    @And("clouds is:")
    public void check_clouds(Map<String, Integer> clouds) {
        Assertions.assertEquals(clouds.get("clouds"), response.getClouds().getAll(), "Incorrect clouds");
    }

    @And("dt is:")
    public void check_dt(Map<String, Long> dt) {
        Assertions.assertEquals(dt.get("dt"), response.getDt(), " Incorrect dt");
    }

    @And("sys is:")
    public void check_sys(Map<String, String> sys) {
        Assertions.assertEquals(Integer.parseInt(sys.get("type")), response.getSys().getType(), "Incorrect type");
        Assertions.assertEquals(Integer.parseInt(sys.get("id")), response.getSys().getId(), "Incorrect id");
        Assertions.assertEquals(Double.parseDouble(sys.get("message")), response.getSys().getMessage(), "Incorrect message");
        Assertions.assertEquals(sys.get("country"), response.getSys().getCountry(), "Incorrect country");
        Assertions.assertEquals(Long.parseLong(sys.get("sunrise")), response.getSys().getSunrise(), "Incorrect sunrise");
        Assertions.assertEquals(Long.parseLong(sys.get("sunset")), response.getSys().getSunset(), "Incorrect sunset");
    }

    @And("id is:")
    public void check_id(Map<String, Integer> id) {
        Assertions.assertEquals(id.get("id"), response.getId());
    }

    @And("name is:")
    public void check_name(Map<String, String> name) {
        Assertions.assertEquals(name.get("name"), response.getName());
    }

    @And("cod is:")
    public void check_cod(Map<String, Integer> cod) {
        Assertions.assertEquals(cod.get("cod"), response.getCod());
    }
}
