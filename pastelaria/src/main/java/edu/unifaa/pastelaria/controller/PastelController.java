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

import edu.unifaa.pastelaria.model.Pastel;
import edu.unifaa.pastelaria.service.PastelService;

@RestController
@RequestMapping("/api/pastels") // Rota ou endpoint
@CrossOrigin("*")
public class PastelController {
    
    @Autowired
    private PastelService pastelService;

    @GetMapping
    public List<Pastel> obterTodos(){
        return pastelService.obterTodos();
    }

    @GetMapping("/{id}")
    public Pastel obterPorId(@PathVariable long id ){
        return pastelService.obterPorId(id);
    }

    @PostMapping
    public Pastel adicionar(@RequestBody Pastel pastel){
        return pastelService.adicionar(pastel);
    }

    @PutMapping("/{id}")
    public Pastel atualizar(@PathVariable long id, @RequestBody Pastel pastel){
        return pastelService.atualizar(id, pastel);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        pastelService.deletar(id);
    }
}

