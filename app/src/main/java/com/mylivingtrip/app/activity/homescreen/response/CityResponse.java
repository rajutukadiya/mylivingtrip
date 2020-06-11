package com.mylivingtrip.app.activity.homescreen.response;

import java.util.List;

public class CityResponse {



    private boolean status;
    private List<FlightcityBean> flightcity;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<FlightcityBean> getFlightcity() {
        return flightcity;
    }

    public void setFlightcity(List<FlightcityBean> flightcity) {
        this.flightcity = flightcity;
    }

    public static class FlightcityBean {
        /**
         * airportCode : BIN
         * airportName : Bamiyan
         * airportCity : Bamiyan
         * airportCountry : Afghanistan
         */

        private String airportCode;
        private String airportName;
        private String airportCity;
        private String airportCountry;

        public String getAirportCode() {
            return airportCode;
        }

        public void setAirportCode(String airportCode) {
            this.airportCode = airportCode;
        }

        public String getAirportName() {
            return airportName;
        }

        public void setAirportName(String airportName) {
            this.airportName = airportName;
        }

        public String getAirportCity() {
            return airportCity;
        }

        public void setAirportCity(String airportCity) {
            this.airportCity = airportCity;
        }

        public String getAirportCountry() {
            return airportCountry;
        }

        public void setAirportCountry(String airportCountry) {
            this.airportCountry = airportCountry;
        }
    }
}
