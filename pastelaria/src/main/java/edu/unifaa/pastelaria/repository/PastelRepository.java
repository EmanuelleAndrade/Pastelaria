package edu.unifaa.pastelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unifaa.pastelaria.model.Pastel;

public interface PastelRepository extends JpaRepository<Pastel, Long> {

} 