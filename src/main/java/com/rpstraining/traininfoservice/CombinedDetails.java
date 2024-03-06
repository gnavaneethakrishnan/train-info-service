package com.rpstraining.traininfoservice;

public class CombinedDetails {

    private Integer trainID;
    private String trainName;
    private Integer numberOfCoaches;
    private String fromStation;
    private String toStation;

    public CombinedDetails(TrainDetails trainDetails, StationDetails stationDetails) {
        this.trainID = trainDetails.getTrainID();
        this.trainName = trainDetails.getTrainName();
        this.numberOfCoaches = trainDetails.getNumberOfCoaches();
        this.fromStation = stationDetails.getFromStation();
        this.toStation = stationDetails.getToStation();
    }

    public CombinedDetails() {
    }

    public Integer getTrainID() {
        return trainID;
    }

    public void setTrainID(Integer trainID) {
        this.trainID = trainID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Integer getNumberOfCoaches() {
        return numberOfCoaches;
    }

    public void setNumberOfCoaches(Integer numberOfCoaches) {
        this.numberOfCoaches = numberOfCoaches;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }
}
