package com.example.rest.service;


import com.example.rest.model.VesselModel;
import com.example.rest.repo.VesselRepo;
import com.example.rest.Data.Vessel;
import com.example.rest.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class VesselService {

    @Autowired
    VesselRepo vesselRepository;

    /*
     Parameters are vessel to create, sends vessel to repo to save to database.
     Returns a vessel.
    */
    public Vessel createVessel(final Vessel vessel) {
        VesselModel vesselModel = new VesselModel();
        BeanUtils.copyProperties(vessel, vesselModel);
        vesselModel = vesselRepository.save(vesselModel);
        Vessel vesselData = new Vessel();
        BeanUtils.copyProperties(vesselModel, vesselData);

        return vesselData;
    }

    /*
    Function that takes in knots and returns it as meters per second.
     */
    public double knotsToMS(double knots)
    {
        double ms = knots * 0.5144444444;
        return ms;
    }

    /*
    Function that takes in degrees and returns them as radians
    */
    public double degreesToRadians(double degrees)
    {
        double radians = degrees * 0.0174532925;
        return radians;
    }

    /*
     Takes in a id and calls repo to find vessel by id
     Returns the found vessel.
     */
    public Vessel getVessel(Long id) throws ResourceNotFoundException {
            VesselModel vessel = vesselRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Vessel not found on: " + id));;
            Vessel vesselData = new Vessel();
            BeanUtils.copyProperties(vessel, vesselData);
            return vesselData;
    }

    /*
     Takes in a and id of a vessel to change the position
     and the new position. Returns updated vessel.
    */
    public Vessel updatePosition(Vessel updateVessel, Long id) throws ResourceNotFoundException {
        Vessel vesselData = new Vessel();
        vesselData = getVessel(id);
        VesselModel vesselModel = new VesselModel();
        BeanUtils.copyProperties(vesselData, vesselModel);
        vesselModel.setLongitude(updateVessel.getLongitude());
        vesselModel.setLatitude(updateVessel.getLatitude());
        vesselModel.setDate(updateVessel.getDate());
        vesselModel.setSpeed(updateVessel.getSpeed());
        Date date = new Date();
        vesselModel.setReceiveDate(date);
        vesselModel = vesselRepository.save(vesselModel);
        BeanUtils.copyProperties(vesselModel, vesselData);
        return vesselData;
    }

}