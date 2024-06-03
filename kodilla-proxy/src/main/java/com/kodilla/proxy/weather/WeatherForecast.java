package com.kodilla.proxy.weather;

public class WeatherForecast implements WeatherService {

    private String weatherData;

    public WeatherForecast() throws InterruptedException {
        refreshData();
    }

    @Override
    public String getWeather() {
        return weatherData;
    }

    @Override
    public void refreshData() throws InterruptedException {
        System.out.println("Refreshing weather data...");
        Thread.sleep(5000);
        weatherData = "Sunny, 25°C";
        System.out.println("Weather data refreshed.");
    }
}
