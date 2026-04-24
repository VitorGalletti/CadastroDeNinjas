package dev.java10x.CadastroDeNinja.Missoes;

import dev.java10x.CadastroDeNinja.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinja.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private final MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

        // Listar minhas missoes
        public List<MissoesModel> listarMissoes(){
            return missoesRepository.findAll();
    }
    // Listar minhas missoes por id
    public Optional<MissoesModel> listarMissoesPorId(Long id){
        return missoesRepository.findById(id);
    }
    // Criar missoes
}