package com.kodilla.proxy.weather;

public class WeatherForecastProxy implements WeatherService {

    private WeatherService realWeatherService;

    @Override
    public String getWeather() {
        if (realWeatherService == null) {
            return "Weather data not available";
        }
        return realWeatherService.getWeather();
    }

    @Override
    public void refreshData() throws InterruptedException {
        if (realWeatherService == null) {
            realWeatherService = new WeatherForecast();
        }
        realWeatherService.refreshData();
    }
}
