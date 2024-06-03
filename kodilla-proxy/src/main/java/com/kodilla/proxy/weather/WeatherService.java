package com.kodilla.proxy.weather;

public interface WeatherService {
    String getWeather();
    void refreshData() throws InterruptedException;
}
