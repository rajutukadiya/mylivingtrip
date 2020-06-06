package com.mylivingtrip.app.fragment.response;

public class test {

    private String flight_adl_val;
    private String flight_chld_val, flight_infant_val, flightType, flightFrom, flightTo, flight_business_class, departDt, returnDt;

    public test(String flight_adl_val,
                String flight_chld_val
            , String flight_infant_val
            , String flightType
            , String flightFrom
            , String flightTo
            , String flight_business_class
            , String departDt
            , String returnDt) {
        this.flight_adl_val = flight_adl_val;
        this.flight_chld_val = flight_chld_val;
        this.flight_infant_val = flight_infant_val;
        this.flightType = flightType;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.flight_business_class = flight_business_class;
        this.departDt = departDt;
        this.returnDt = returnDt;
    }
}


