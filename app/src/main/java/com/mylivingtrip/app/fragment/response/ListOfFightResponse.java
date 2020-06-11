package com.mylivingtrip.app.fragment.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;



    public class ListOfFightResponse {



        private boolean status;
        private SearchresultBean searchresult;
        private AirlinesBean airlines;

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public SearchresultBean getSearchresult() {
            return searchresult;
        }

        public void setSearchresult(SearchresultBean searchresult) {
            this.searchresult = searchresult;
        }

        public AirlinesBean getAirlines() {
            return airlines;
        }

        public void setAirlines(AirlinesBean airlines) {
            this.airlines = airlines;
        }

        public static class SearchresultBean {
            private List<FirstBean> first;

            public List<FirstBean> getFirst() {
                return first;
            }

            public void setFirst(List<FirstBean> first) {
                this.first = first;
            }

            public static class FirstBean {
                /**
                 * id : 0
                 * flightId : OB1
                 * IsLCC : true
                 * IsRefundable : true
                 * GSTAllowed : true
                 * key : 0
                 * fare : {"ActualBaseFare":2000,"Tax":4538,"othercharges":1180}
                 * total_fare : 7718
                 * airline : {"airlineCode":"I5","airlineName":"Compagnie Aerienne du Mali","flightNumber":"314"}
                 * origin : {"fromCity":"Delhi","fromCityCode":"DEL","airportCode":"DEL","fromCountryCode":"IN","fromCountryName":"India","depTime":"2020-07-10T05:45:00"}
                 * destination : {"toCity":"Mumbai","toCityCode":"BOM","airportCode":"BOM","toCountryCode":"IN","toCountryName":"India","arrTime":"2020-07-10T07:55:00"}
                 * remark : This is a Economy Promo fare. I5 TEST.
                 * offeredfare : 7718
                 * duration : 130
                 * bags : {"baggage":"0 Kg","cabinebag":"7 Kg"}
                 * source : 19
                 * classtype : 2
                 * stopcount : 0
                 * segments : [{"airline":{"airlineCode":"I5","airlineName":"Compagnie Aerienne du Mali","flightNumber":"314"},"origin":{"fromCity":"Delhi","fromCityCode":"DEL","airportCode":"DEL","depTime":"2020-07-10T05:45:00","fromCountryCode":"IN","fromCountryName":"India"},"destination":{"toCity":"Mumbai","toCityCode":"BOM","toCountryCode":"IN","toCountryName":"India","airportCode":"BOM","arrTime":"2020-07-10T07:55:00"},"bags":{"baggage":"0 Kg","cabinebag":"7 Kg"},"duration":130,"NoOfSeatAvailable":15}]
                 * farebreakdown : [{"Currency":"INR","PassengerType":1,"PassengerCount":1,"BaseFare":1000,"Tax":1519,"YQTax":0,"AdditionalTxnFeeOfrd":0,"AdditionalTxnFeePub":0,"PGCharge":0},{"Currency":"INR","PassengerType":2,"PassengerCount":1,"BaseFare":1000,"Tax":1519,"YQTax":0,"AdditionalTxnFeeOfrd":0,"AdditionalTxnFeePub":0,"PGCharge":0},{"Currency":"INR","PassengerType":3,"PassengerCount":1,"BaseFare":0,"Tax":1500,"YQTax":0,"AdditionalTxnFeeOfrd":0,"AdditionalTxnFeePub":0,"PGCharge":0}]
                 * journtype : 1
                 */

                private int id;
                private String flightId;
                private boolean IsLCC;
                private boolean IsRefundable;
                private boolean GSTAllowed;
                private int key;
                private FareBean fare;
                private float total_fare;
                private AirlineBean airline;
                private OriginBean origin;
                private DestinationBean destination;
                private String remark;
                private float offeredfare;
                private int duration;
                private BagsBean bags;
                private int source;
                private String classtype;
                private int stopcount;
                private String journtype;
                private List<SegmentsBean> segments;
                private List<FarebreakdownBean> farebreakdown;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getFlightId() {
                    return flightId;
                }

                public void setFlightId(String flightId) {
                    this.flightId = flightId;
                }

                public boolean isIsLCC() {
                    return IsLCC;
                }

                public void setIsLCC(boolean IsLCC) {
                    this.IsLCC = IsLCC;
                }

                public boolean isIsRefundable() {
                    return IsRefundable;
                }

                public void setIsRefundable(boolean IsRefundable) {
                    this.IsRefundable = IsRefundable;
                }

                public boolean isGSTAllowed() {
                    return GSTAllowed;
                }

                public void setGSTAllowed(boolean GSTAllowed) {
                    this.GSTAllowed = GSTAllowed;
                }

                public int getKey() {
                    return key;
                }

                public void setKey(int key) {
                    this.key = key;
                }

                public FareBean getFare() {
                    return fare;
                }

                public void setFare(FareBean fare) {
                    this.fare = fare;
                }

                public float getTotal_fare() {
                    return total_fare;
                }

                public void setTotal_fare(int total_fare) {
                    this.total_fare = (float)total_fare;
                }

                public AirlineBean getAirline() {
                    return airline;
                }

                public void setAirline(AirlineBean airline) {
                    this.airline = airline;
                }

                public OriginBean getOrigin() {
                    return origin;
                }

                public void setOrigin(OriginBean origin) {
                    this.origin = origin;
                }

                public DestinationBean getDestination() {
                    return destination;
                }

                public void setDestination(DestinationBean destination) {
                    this.destination = destination;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public float getOfferedfare() {
                    return offeredfare;
                }

                public void setOfferedfare(int offeredfare) {
                    this.offeredfare =(float) offeredfare;
                }

                public int getDuration() {
                    return duration;
                }

                public void setDuration(int duration) {
                    this.duration = duration;
                }

                public BagsBean getBags() {
                    return bags;
                }

                public void setBags(BagsBean bags) {
                    this.bags = bags;
                }

                public int getSource() {
                    return source;
                }

                public void setSource(int source) {
                    this.source = source;
                }

                public String getClasstype() {
                    return classtype;
                }

                public void setClasstype(String classtype) {
                    this.classtype = classtype;
                }

                public int getStopcount() {
                    return stopcount;
                }

                public void setStopcount(int stopcount) {
                    this.stopcount = stopcount;
                }

                public String getJourntype() {
                    return journtype;
                }

                public void setJourntype(String journtype) {
                    this.journtype = journtype;
                }

                public List<SegmentsBean> getSegments() {
                    return segments;
                }

                public void setSegments(List<SegmentsBean> segments) {
                    this.segments = segments;
                }

                public List<FarebreakdownBean> getFarebreakdown() {
                    return farebreakdown;
                }

                public void setFarebreakdown(List<FarebreakdownBean> farebreakdown) {
                    this.farebreakdown = farebreakdown;
                }

                public static class FareBean {
                    /**
                     * ActualBaseFare : 2000
                     * Tax : 4538
                     * othercharges : 1180
                     */

                    private int ActualBaseFare;
                    private int Tax;
                    private float othercharges;

                    public int getActualBaseFare() {
                        return ActualBaseFare;
                    }

                    public void setActualBaseFare(int ActualBaseFare) {
                        this.ActualBaseFare = ActualBaseFare;
                    }

                    public int getTax() {
                        return Tax;
                    }

                    public void setTax(int Tax) {
                        this.Tax = Tax;
                    }

                    public float getOthercharges() {
                        return othercharges;
                    }

                    public void setOthercharges(int othercharges) {
                        this.othercharges =(float) othercharges;
                    }
                }

                public static class AirlineBean {
                    /**
                     * airlineCode : I5
                     * airlineName : Compagnie Aerienne du Mali
                     * flightNumber : 314
                     */

                    private String airlineCode;
                    private String airlineName;
                    private String flightNumber;

                    public String getAirlineCode() {
                        return airlineCode;
                    }

                    public void setAirlineCode(String airlineCode) {
                        this.airlineCode = airlineCode;
                    }

                    public String getAirlineName() {
                        return airlineName;
                    }

                    public void setAirlineName(String airlineName) {
                        this.airlineName = airlineName;
                    }

                    public String getFlightNumber() {
                        return flightNumber;
                    }

                    public void setFlightNumber(String flightNumber) {
                        this.flightNumber = flightNumber;
                    }
                }

                public static class OriginBean {
                    /**
                     * fromCity : Delhi
                     * fromCityCode : DEL
                     * airportCode : DEL
                     * fromCountryCode : IN
                     * fromCountryName : India
                     * depTime : 2020-07-10T05:45:00
                     */

                    private String fromCity;
                    private String fromCityCode;
                    private String airportCode;
                    private String fromCountryCode;
                    private String fromCountryName;
                    private String depTime;

                    public String getFromCity() {
                        return fromCity;
                    }

                    public void setFromCity(String fromCity) {
                        this.fromCity = fromCity;
                    }

                    public String getFromCityCode() {
                        return fromCityCode;
                    }

                    public void setFromCityCode(String fromCityCode) {
                        this.fromCityCode = fromCityCode;
                    }

                    public String getAirportCode() {
                        return airportCode;
                    }

                    public void setAirportCode(String airportCode) {
                        this.airportCode = airportCode;
                    }

                    public String getFromCountryCode() {
                        return fromCountryCode;
                    }

                    public void setFromCountryCode(String fromCountryCode) {
                        this.fromCountryCode = fromCountryCode;
                    }

                    public String getFromCountryName() {
                        return fromCountryName;
                    }

                    public void setFromCountryName(String fromCountryName) {
                        this.fromCountryName = fromCountryName;
                    }

                    public String getDepTime() {
                        return depTime;
                    }

                    public void setDepTime(String depTime) {
                        this.depTime = depTime;
                    }
                }

                public static class DestinationBean {
                    /**
                     * toCity : Mumbai
                     * toCityCode : BOM
                     * airportCode : BOM
                     * toCountryCode : IN
                     * toCountryName : India
                     * arrTime : 2020-07-10T07:55:00
                     */

                    private String toCity;
                    private String toCityCode;
                    private String airportCode;
                    private String toCountryCode;
                    private String toCountryName;
                    private String arrTime;

                    public String getToCity() {
                        return toCity;
                    }

                    public void setToCity(String toCity) {
                        this.toCity = toCity;
                    }

                    public String getToCityCode() {
                        return toCityCode;
                    }

                    public void setToCityCode(String toCityCode) {
                        this.toCityCode = toCityCode;
                    }

                    public String getAirportCode() {
                        return airportCode;
                    }

                    public void setAirportCode(String airportCode) {
                        this.airportCode = airportCode;
                    }

                    public String getToCountryCode() {
                        return toCountryCode;
                    }

                    public void setToCountryCode(String toCountryCode) {
                        this.toCountryCode = toCountryCode;
                    }

                    public String getToCountryName() {
                        return toCountryName;
                    }

                    public void setToCountryName(String toCountryName) {
                        this.toCountryName = toCountryName;
                    }

                    public String getArrTime() {
                        return arrTime;
                    }

                    public void setArrTime(String arrTime) {
                        this.arrTime = arrTime;
                    }
                }

                public static class BagsBean {
                    /**
                     * baggage : 0 Kg
                     * cabinebag : 7 Kg
                     */

                    private String baggage;
                    private String cabinebag;

                    public String getBaggage() {
                        return baggage;
                    }

                    public void setBaggage(String baggage) {
                        this.baggage = baggage;
                    }

                    public String getCabinebag() {
                        return cabinebag;
                    }

                    public void setCabinebag(String cabinebag) {
                        this.cabinebag = cabinebag;
                    }
                }

                public static class SegmentsBean {
                    /**
                     * airline : {"airlineCode":"I5","airlineName":"Compagnie Aerienne du Mali","flightNumber":"314"}
                     * origin : {"fromCity":"Delhi","fromCityCode":"DEL","airportCode":"DEL","depTime":"2020-07-10T05:45:00","fromCountryCode":"IN","fromCountryName":"India"}
                     * destination : {"toCity":"Mumbai","toCityCode":"BOM","toCountryCode":"IN","toCountryName":"India","airportCode":"BOM","arrTime":"2020-07-10T07:55:00"}
                     * bags : {"baggage":"0 Kg","cabinebag":"7 Kg"}
                     * duration : 130
                     * NoOfSeatAvailable : 15
                     */

                    private AirlineBeanX airline;
                    private OriginBeanX origin;
                    private DestinationBeanX destination;
                    private BagsBeanX bags;
                    private int duration;
                    private int NoOfSeatAvailable;

                    public AirlineBeanX getAirline() {
                        return airline;
                    }

                    public void setAirline(AirlineBeanX airline) {
                        this.airline = airline;
                    }

                    public OriginBeanX getOrigin() {
                        return origin;
                    }

                    public void setOrigin(OriginBeanX origin) {
                        this.origin = origin;
                    }

                    public DestinationBeanX getDestination() {
                        return destination;
                    }

                    public void setDestination(DestinationBeanX destination) {
                        this.destination = destination;
                    }

                    public BagsBeanX getBags() {
                        return bags;
                    }

                    public void setBags(BagsBeanX bags) {
                        this.bags = bags;
                    }

                    public int getDuration() {
                        return duration;
                    }

                    public void setDuration(int duration) {
                        this.duration = duration;
                    }

                    public int getNoOfSeatAvailable() {
                        return NoOfSeatAvailable;
                    }

                    public void setNoOfSeatAvailable(int NoOfSeatAvailable) {
                        this.NoOfSeatAvailable = NoOfSeatAvailable;
                    }

                    public static class AirlineBeanX {
                        /**
                         * airlineCode : I5
                         * airlineName : Compagnie Aerienne du Mali
                         * flightNumber : 314
                         */

                        private String airlineCode;
                        private String airlineName;
                        private String flightNumber;

                        public String getAirlineCode() {
                            return airlineCode;
                        }

                        public void setAirlineCode(String airlineCode) {
                            this.airlineCode = airlineCode;
                        }

                        public String getAirlineName() {
                            return airlineName;
                        }

                        public void setAirlineName(String airlineName) {
                            this.airlineName = airlineName;
                        }

                        public String getFlightNumber() {
                            return flightNumber;
                        }

                        public void setFlightNumber(String flightNumber) {
                            this.flightNumber = flightNumber;
                        }
                    }

                    public static class OriginBeanX {
                        /**
                         * fromCity : Delhi
                         * fromCityCode : DEL
                         * airportCode : DEL
                         * depTime : 2020-07-10T05:45:00
                         * fromCountryCode : IN
                         * fromCountryName : India
                         */

                        private String fromCity;
                        private String fromCityCode;
                        private String airportCode;
                        private String depTime;
                        private String fromCountryCode;
                        private String fromCountryName;

                        public String getFromCity() {
                            return fromCity;
                        }

                        public void setFromCity(String fromCity) {
                            this.fromCity = fromCity;
                        }

                        public String getFromCityCode() {
                            return fromCityCode;
                        }

                        public void setFromCityCode(String fromCityCode) {
                            this.fromCityCode = fromCityCode;
                        }

                        public String getAirportCode() {
                            return airportCode;
                        }

                        public void setAirportCode(String airportCode) {
                            this.airportCode = airportCode;
                        }

                        public String getDepTime() {
                            return depTime;
                        }

                        public void setDepTime(String depTime) {
                            this.depTime = depTime;
                        }

                        public String getFromCountryCode() {
                            return fromCountryCode;
                        }

                        public void setFromCountryCode(String fromCountryCode) {
                            this.fromCountryCode = fromCountryCode;
                        }

                        public String getFromCountryName() {
                            return fromCountryName;
                        }

                        public void setFromCountryName(String fromCountryName) {
                            this.fromCountryName = fromCountryName;
                        }
                    }

                    public static class DestinationBeanX {
                        /**
                         * toCity : Mumbai
                         * toCityCode : BOM
                         * toCountryCode : IN
                         * toCountryName : India
                         * airportCode : BOM
                         * arrTime : 2020-07-10T07:55:00
                         */

                        private String toCity;
                        private String toCityCode;
                        private String toCountryCode;
                        private String toCountryName;
                        private String airportCode;
                        private String arrTime;

                        public String getToCity() {
                            return toCity;
                        }

                        public void setToCity(String toCity) {
                            this.toCity = toCity;
                        }

                        public String getToCityCode() {
                            return toCityCode;
                        }

                        public void setToCityCode(String toCityCode) {
                            this.toCityCode = toCityCode;
                        }

                        public String getToCountryCode() {
                            return toCountryCode;
                        }

                        public void setToCountryCode(String toCountryCode) {
                            this.toCountryCode = toCountryCode;
                        }

                        public String getToCountryName() {
                            return toCountryName;
                        }

                        public void setToCountryName(String toCountryName) {
                            this.toCountryName = toCountryName;
                        }

                        public String getAirportCode() {
                            return airportCode;
                        }

                        public void setAirportCode(String airportCode) {
                            this.airportCode = airportCode;
                        }

                        public String getArrTime() {
                            return arrTime;
                        }

                        public void setArrTime(String arrTime) {
                            this.arrTime = arrTime;
                        }
                    }

                    public static class BagsBeanX {
                        /**
                         * baggage : 0 Kg
                         * cabinebag : 7 Kg
                         */

                        private String baggage;
                        private String cabinebag;

                        public String getBaggage() {
                            return baggage;
                        }

                        public void setBaggage(String baggage) {
                            this.baggage = baggage;
                        }

                        public String getCabinebag() {
                            return cabinebag;
                        }

                        public void setCabinebag(String cabinebag) {
                            this.cabinebag = cabinebag;
                        }
                    }
                }

                public static class FarebreakdownBean {
                    /**
                     * Currency : INR
                     * PassengerType : 1
                     * PassengerCount : 1
                     * BaseFare : 1000
                     * Tax : 1519
                     * YQTax : 0
                     * AdditionalTxnFeeOfrd : 0
                     * AdditionalTxnFeePub : 0
                     * PGCharge : 0
                     */

                    private String Currency;
                    private int PassengerType;
                    private int PassengerCount;
                    private int BaseFare;
                    private int Tax;
                    private int YQTax;
                    private int AdditionalTxnFeeOfrd;
                    private float AdditionalTxnFeePub;
                    private int PGCharge;

                    public String getCurrency() {
                        return Currency;
                    }

                    public void setCurrency(String Currency) {
                        this.Currency = Currency;
                    }

                    public int getPassengerType() {
                        return PassengerType;
                    }

                    public void setPassengerType(int PassengerType) {
                        this.PassengerType = PassengerType;
                    }

                    public int getPassengerCount() {
                        return PassengerCount;
                    }

                    public void setPassengerCount(int PassengerCount) {
                        this.PassengerCount = PassengerCount;
                    }

                    public int getBaseFare() {
                        return BaseFare;
                    }

                    public void setBaseFare(int BaseFare) {
                        this.BaseFare = BaseFare;
                    }

                    public int getTax() {
                        return Tax;
                    }

                    public void setTax(int Tax) {
                        this.Tax = Tax;
                    }

                    public int getYQTax() {
                        return YQTax;
                    }

                    public void setYQTax(int YQTax) {
                        this.YQTax = YQTax;
                    }

                    public int getAdditionalTxnFeeOfrd() {
                        return AdditionalTxnFeeOfrd;
                    }

                    public void setAdditionalTxnFeeOfrd(int AdditionalTxnFeeOfrd) {
                        this.AdditionalTxnFeeOfrd = AdditionalTxnFeeOfrd;
                    }

                    public float getAdditionalTxnFeePub() {
                        return AdditionalTxnFeePub;
                    }

                    public void setAdditionalTxnFeePub(int AdditionalTxnFeePub) {
                        this.AdditionalTxnFeePub = (float)AdditionalTxnFeePub;
                    }

                    public int getPGCharge() {
                        return PGCharge;
                    }

                    public void setPGCharge(int PGCharge) {
                        this.PGCharge = PGCharge;
                    }
                }
            }
        }

        public static class AirlinesBean {
            /**
             * I5 : {"airlineCode":"I5","airlineName":"Compagnie Aerienne du Mali"}
             * SG : {"airlineCode":"SG","airlineName":"SpiceJet"}
             * AI : {"airlineCode":"AI","airlineName":"Air India"}
             * 6E : {"airlineCode":"6E","airlineName":"Indigo"}
             */

            private I5Bean I5;
            private SGBean SG;
            private AIBean AI;
            @SerializedName("6E")
            private _$6EBean _$6E;

            public I5Bean getI5() {
                return I5;
            }

            public void setI5(I5Bean I5) {
                this.I5 = I5;
            }

            public SGBean getSG() {
                return SG;
            }

            public void setSG(SGBean SG) {
                this.SG = SG;
            }

            public AIBean getAI() {
                return AI;
            }

            public void setAI(AIBean AI) {
                this.AI = AI;
            }

            public _$6EBean get_$6E() {
                return _$6E;
            }

            public void set_$6E(_$6EBean _$6E) {
                this._$6E = _$6E;
            }

            public static class I5Bean {
                /**
                 * airlineCode : I5
                 * airlineName : Compagnie Aerienne du Mali
                 */

                private String airlineCode;
                private String airlineName;

                public String getAirlineCode() {
                    return airlineCode;
                }

                public void setAirlineCode(String airlineCode) {
                    this.airlineCode = airlineCode;
                }

                public String getAirlineName() {
                    return airlineName;
                }

                public void setAirlineName(String airlineName) {
                    this.airlineName = airlineName;
                }
            }

            public static class SGBean {
                /**
                 * airlineCode : SG
                 * airlineName : SpiceJet
                 */

                private String airlineCode;
                private String airlineName;

                public String getAirlineCode() {
                    return airlineCode;
                }

                public void setAirlineCode(String airlineCode) {
                    this.airlineCode = airlineCode;
                }

                public String getAirlineName() {
                    return airlineName;
                }

                public void setAirlineName(String airlineName) {
                    this.airlineName = airlineName;
                }
            }

            public static class AIBean {
                /**
                 * airlineCode : AI
                 * airlineName : Air India
                 */

                private String airlineCode;
                private String airlineName;

                public String getAirlineCode() {
                    return airlineCode;
                }

                public void setAirlineCode(String airlineCode) {
                    this.airlineCode = airlineCode;
                }

                public String getAirlineName() {
                    return airlineName;
                }

                public void setAirlineName(String airlineName) {
                    this.airlineName = airlineName;
                }
            }

            public static class _$6EBean {
                /**
                 * airlineCode : 6E
                 * airlineName : Indigo
                 */

                private String airlineCode;
                private String airlineName;
                private String airlineLogo;

                public String getAirlineLogo() {
                    return airlineLogo;
                }

                public void setAirlineLogo(String airlineLogo) {
                    this.airlineLogo = airlineLogo;
                }

                public String getAirlineCode() {
                    return airlineCode;
                }

                public void setAirlineCode(String airlineCode) {
                    this.airlineCode = airlineCode;
                }

                public String getAirlineName() {
                    return airlineName;
                }

                public void setAirlineName(String airlineName) {
                    this.airlineName = airlineName;
                }
            }
        }
    }



