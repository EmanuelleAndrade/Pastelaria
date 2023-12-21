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

import edu.unifaa.pastelaria.model.Tipo;
import edu.unifaa.pastelaria.service.TipoService;

@RestController
@RequestMapping("/api/tipos") // Rota ou endpoint
@CrossOrigin("*")
public class TipoController {
    
    @Autowired
    private TipoService tipoService;

    @GetMapping
    public List<Tipo> obterTodos(){
        return tipoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Tipo obterPorId(@PathVariable long id ){
        return tipoService.obterPorId(id);
    }

    @PostMapping
    public Tipo adicionar(@RequestBody Tipo tipo){
        return tipoService.adicionar(tipo);
    }

    @PutMapping("/{id}")
    public Tipo atualizar(@PathVariable long id, @RequestBody Tipo tipo){
        return tipoService.atualizar(id, tipo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        tipoService.deletar(id);
    }
}

// http://localhost:8080/api/tipos
