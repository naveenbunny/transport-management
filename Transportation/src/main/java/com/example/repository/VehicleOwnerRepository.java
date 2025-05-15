package com.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.VehicleOwner;

public interface VehicleOwnerRepository extends JpaRepository<VehicleOwner, Long> {

}
