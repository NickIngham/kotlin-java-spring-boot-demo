package com.kotlinjavademo.javaAPI.repositories;

import com.kotlinjavademo.javaAPI.entities.VehicleEntity;
import org.hibernate.validator.internal.engine.valueextraction.ValueExtractorHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    VehicleEntity getVehicleByRegistration(String registration);
}
