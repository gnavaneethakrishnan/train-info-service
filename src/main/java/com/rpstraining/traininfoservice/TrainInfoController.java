package com.rpstraining.traininfoservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainInfoController {

    private List<TrainDetails> trainList = Arrays.asList(
            new TrainDetails(2986, "Pandiyan Express", 10),
            new TrainDetails(1, "Cheran Express", 11),
            new TrainDetails(7873, "Nilgiris Express", 12)
    );

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/{trainID}")
    public ResponseEntity<TrainDetails> getTrainDetails(@PathVariable("trainID") Integer trainID) {
        TrainDetails train = trainList.stream().filter(trainDetails -> trainDetails.getTrainID().equals(trainID))
                .findFirst()
                .orElseThrow(null);

        return new ResponseEntity<>(train, HttpStatus.OK);
    };



    @GetMapping("/details/{trainID}")
    public ResponseEntity<CombinedDetails> getTrainStationDetails(@PathVariable("trainID") Integer trainID) {
        ResponseEntity<TrainDetails> trainEntity = getTrainDetails(trainID);
        TrainDetails train = trainEntity.getBody();

        String stationDetailsServiceUrl = "http://station-details-service/stations/" + trainID;
        StationDetails station = restTemplate.getForObject(stationDetailsServiceUrl, StationDetails.class);

        CombinedDetails combinedDetails = new CombinedDetails(train,station);

        return new ResponseEntity<>(combinedDetails, HttpStatus.OK);

    }
}
