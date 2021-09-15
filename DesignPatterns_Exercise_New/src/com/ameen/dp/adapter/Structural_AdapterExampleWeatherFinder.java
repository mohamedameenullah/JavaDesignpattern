package com.ameen.dp.adapter;

public class Structural_AdapterExampleWeatherFinder {
    public static void main(String[] args) {
        WeatherUI weatherUI = new WeatherUIImpl();
        System.err.println(weatherUI.findTemperature(123));
    }
}

interface WeatherFinderCity {
    int findTemperature(String city);
}

class WeatherFinderCityImpl implements WeatherFinderCity {

    @Override
    public int findTemperature(String city) {
        int temparature = 0;
        switch (city) {
            case "Tenkasi":
                temparature = 25;
            case "TRL":
                temparature = 28;
            case "Chennai":
                temparature = 30;
        }
        return temparature;
    }

}

interface WeatherUI {
    int findTemperature(int zipcode);
}

class WeatherUIImpl implements WeatherUI {
    WeatherAdapter weatherAdapter = new WeatherAdapter();

    @Override
    public int findTemperature(int zipcode) {
        return weatherAdapter.findTemp(zipcode);
    }
}

class WeatherAdapter {

    public int findTemp(int zipCode) {
        WeatherFinderCity weatherFinder = new WeatherFinderCityImpl();
        String city = null;
        switch (zipCode) {
            case 123:
                city = "Tenkasi";
            case 124:
                city = "TRL";
            case 111:
                city = "Chennai";
        }
        return weatherFinder.findTemperature(city);
    }
}
