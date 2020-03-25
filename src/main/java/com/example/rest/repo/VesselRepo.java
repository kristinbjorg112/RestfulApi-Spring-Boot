package com.example.rest.repo;

import com.example.rest.model.VesselModel;
import org.springframework.data.repository.CrudRepository;

public interface VesselRepo extends CrudRepository<VesselModel,Long> {
    }

