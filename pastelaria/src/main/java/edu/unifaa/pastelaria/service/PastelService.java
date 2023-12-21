package edu.unifaa.pastelaria.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unifaa.pastelaria.model.Pastel;
import edu.unifaa.pastelaria.model.exception.ResourceBadRequestException;
import edu.unifaa.pastelaria.model.exception.ResourceNotFoundException;
import edu.unifaa.pastelaria.repository.PastelRepository;

@Service
public class PastelService {

    @Autowired
    private PastelRepository pastelRepository;

    public Pastel adicionar(Pastel pastel) {
        // Aqui poderia verificar muitas coisas.

        pastel.setId(0);
        return pastelRepository.save(pastel);
    }

    public List<Pastel> obterTodos() {
        return pastelRepository.findAll();
    }

    public Pastel obterPorId(Long id) {
        Optional<Pastel> optPastel = pastelRepository.findById(id);

        if (optPastel.isEmpty()) {
            throw new ResourceNotFoundException("Não existe um pastel com o ID " + id);
        }

        return optPastel.get();
    }

    public Pastel atualizar(Long id, Pastel pastel) {
        // Aqui poderia verificar muitas coisas.

        // Aqui o ideal é verificar se o pastel existe no banco antes de mandar
        // atualizar.
        // Se não existir, ai mando uma exception que vai precisar chegar no cliente com
        // o statusCode 404
        pastel.setId(id);
        return pastelRepository.save(pastel);
    }

    public void deletar(long id) {
        pastelRepository.deleteById(id);
    }

}
