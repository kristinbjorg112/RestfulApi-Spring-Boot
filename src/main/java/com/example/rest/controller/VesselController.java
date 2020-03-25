package com.example.rest.controller;

import com.example.rest.Data.Vessel;
import com.example.rest.exception.ResourceNotFoundException;
import com.example.rest.service.VesselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation. *;

@RestController
@RequestMapping(value = "/vessel")
public class VesselController {

    @Autowired
    VesselService vesselService;

    /*
      Creates a Vessel, accepts vessel in jason format.
     returns the created vessel.
     */
    @PostMapping(value = "/vessel")
    public ResponseEntity <Vessel> createVessel(@RequestBody Vessel vessel) {
        final Vessel vesselData = vesselService.createVessel(vessel);
        return new ResponseEntity < >(vesselData, HttpStatus.CREATED);
    }

    /*
     Updates a Vessel position by ID, accepts position in jason format.
    returns vessel with formatted speed, latitude and longitude.
    */
    @PostMapping(value = "/position/{id}")
    public ResponseEntity <Vessel> updatePosition(@RequestBody Vessel vessel, @PathVariable Long id) throws ResourceNotFoundException {
        final Vessel vesselData = vesselService.updatePosition(vessel, id);
        vesselData.setSpeed(vesselService.knotsToMS(vesselData.getSpeed()));
        vesselData.setLatitude(vesselService.degreesToRadians(vesselData.getLatitude()));
        vesselData.setLongitude(vesselService.degreesToRadians(vesselData.getLongitude()));
        return new ResponseEntity < >(vesselData, HttpStatus.OK);
    }

    /*
        Get the Vessel by id passed by the client API.
        returns vessel
     */
    @GetMapping(value = "/vessel/{id}")
    public ResponseEntity <Vessel> getVessel(@PathVariable Long id) throws ResourceNotFoundException {
        Vessel vessel = vesselService.getVessel(id);
        return new ResponseEntity < >(vessel, HttpStatus.OK);
    }
}
