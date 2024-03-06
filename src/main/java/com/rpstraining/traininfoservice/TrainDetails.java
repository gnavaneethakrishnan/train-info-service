package com.rpstraining.traininfoservice;

public class TrainDetails {

    private Integer trainID;

    private String trainName;

    private Integer numberOfCoaches;

    public TrainDetails(Integer trainID, String trainName, Integer numberOfCoaches) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.numberOfCoaches = numberOfCoaches;
    }

    public TrainDetails() {
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
}
