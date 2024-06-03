package com.kodilla.proxy;

import com.kodilla.proxy.weather.WeatherService;
import com.kodilla.proxy.weather.WeatherForecastProxy;
import java.util.Random;

public class WeatherProxyApp {

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            WeatherService forecast = new WeatherForecastProxy();
            System.out.println("Weather: " + forecast.getWeather());

            if (new Random().nextInt(100) < 20) { // 20% chance to refresh data
                forecast.refreshData();
                System.out.println("Weather after refresh: " + forecast.getWeather());
            }

            System.out.println("Execution #" + i + " just finished");
        }

        long end = System.currentTimeMillis();
        System.out.println("The execution took: " + (end - begin) + " [ms]");
    }
}
