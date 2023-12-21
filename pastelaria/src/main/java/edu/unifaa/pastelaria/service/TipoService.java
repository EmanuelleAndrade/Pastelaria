package edu.unifaa.pastelaria.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unifaa.pastelaria.model.Tipo;
import edu.unifaa.pastelaria.model.exception.ResourceBadRequestException;
import edu.unifaa.pastelaria.model.exception.ResourceNotFoundException;
import edu.unifaa.pastelaria.repository.TipoRepository;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public Tipo adicionar(Tipo tipo) {
        // Aqui poderia verificar muitas coisas.

        tipo.setId(0);
        return tipoRepository.save(tipo);
    }

    public List<Tipo> obterTodos() {
        return tipoRepository.findAll();
    }

    public Tipo obterPorId(Long id) {
        Optional<Tipo> optTipo = tipoRepository.findById(id);

        if (optTipo.isEmpty()) {
            throw new ResourceNotFoundException("Não existe um tipo com o ID " + id);
        }

        return optTipo.get();
    }

    public Tipo atualizar(Long id, Tipo tipo) {
        // Aqui poderia verificar muitas coisas.

        // Aqui o ideal é verificar se o tipo existe no banco antes de mandar atualizar.
        // Se não existir, ai mando uma exception que vai precisar chegar no cliente com
        // o statusCode 404
        tipo.setId(id);
        return tipoRepository.save(tipo);
    }

    public void deletar(long id) {
        tipoRepository.deleteById(id);
    }

}
