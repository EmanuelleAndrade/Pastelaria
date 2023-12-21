package edu.unifaa.pastelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unifaa.pastelaria.model.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    Ingrediente findByDescricao(String descricao);
} 