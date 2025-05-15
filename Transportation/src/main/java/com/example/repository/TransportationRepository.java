package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Transportation;

public interface TransportationRepository extends JpaRepository<Transportation, Long> {

}
