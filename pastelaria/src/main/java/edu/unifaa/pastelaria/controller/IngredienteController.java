package edu.unifaa.pastelaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unifaa.pastelaria.model.Ingrediente;
import edu.unifaa.pastelaria.service.IngredienteService;

@RestController
@RequestMapping("/api/ingredientes") // Rota ou endpoint
@CrossOrigin("*")
public class IngredienteController {
    
    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping
    public List<Ingrediente> obterTodos(){
        return ingredienteService.obterTodos();
    }

    @GetMapping("/{id}")
    public Ingrediente obterPorId(@PathVariable long id ){
        return ingredienteService.obterPorId(id);
    }

    @PostMapping
    public Ingrediente adicionar(@RequestBody Ingrediente ingrediente){
        return ingredienteService.adicionar(ingrediente);
    }

    @PutMapping("/{id}")
    public Ingrediente atualizar(@PathVariable long id, @RequestBody Ingrediente ingrediente){
        return ingredienteService.atualizar(id, ingrediente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        ingredienteService.deletar(id);
    }
}

// http://localhost:8080/api/ingredientes
