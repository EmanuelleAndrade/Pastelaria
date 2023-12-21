package edu.unifaa.pastelaria.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unifaa.pastelaria.model.Ingrediente;
import edu.unifaa.pastelaria.model.exception.ResourceBadRequestException;
import edu.unifaa.pastelaria.model.exception.ResourceNotFoundException;
import edu.unifaa.pastelaria.repository.IngredienteRepository;

@Service
public class IngredienteService {
    
    @Autowired
    private IngredienteRepository ingredienteRepository;

    public Ingrediente adicionar(Ingrediente ingrediente){
        // Aqui poderia verificar muitas coisas.

        ingrediente.setId(0);

        if(ingrediente.getDataValidade().getTime() <= new Date().getTime()){
            throw new ResourceBadRequestException("A data de validade deve ser maior que a data atual.");
        }

        return ingredienteRepository.save(ingrediente);
    }

    public List<Ingrediente> obterTodos(){
        return ingredienteRepository.findAll();
    }

    public Ingrediente obterPorId(Long id){
        Optional<Ingrediente> optIngrediente = ingredienteRepository.findById(id);

        if(optIngrediente.isEmpty()){
            throw new ResourceNotFoundException("Não existe um ingrediente com o ID " + id);
        }

        return optIngrediente.get();
    }

    public Ingrediente atualizar(Long id, Ingrediente ingrediente){
        // Aqui poderia verificar muitas coisas.

        if(ingrediente.getDataValidade().getTime() <= new Date().getTime()){
            throw new ResourceBadRequestException("A data de validade deve ser maior que a data atual.");
        }
        
        // Aqui o ideal é verificar se o ingrediente existe no banco antes de mandar atualizar.
        // Se não existir, ai mando uma exception que vai precisar chegar no cliente com o statusCode 404
        ingrediente.setId(id);
        return ingredienteRepository.save(ingrediente);
    }

    public void deletar(long id){
        ingredienteRepository.deleteById(id);
    }

    public Ingrediente obterPelaDescricao(String descricao){

        return ingredienteRepository.findByDescricao(descricao);
    }
}
