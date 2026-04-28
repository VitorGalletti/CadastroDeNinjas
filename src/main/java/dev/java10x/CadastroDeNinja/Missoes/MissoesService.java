package dev.java10x.CadastroDeNinja.Missoes;

import dev.java10x.CadastroDeNinja.Ninjas.NinjaDTO;
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
        public MissoesModel criarNinja(MissoesModel missaoModel) {
            missoesRepository.save(missaoModel);
            return missaoModel;
        }

        // Deletar Ninja - Tem que ser um metodo VOID
        public void deletarMissaoPorId(Long id) {
            missoesRepository.deleteById(id);
        }

        // Atualizar ninja
        public MissoesModel atualizarMissao(Long id, MissoesModel missoesModel) {
            Optional<MissoesModel> missoesExistente = missoesRepository.findById(id);
            if (missoesExistente.isPresent()) {
                missoesModel.setId(id);
                missoesRepository.save(missoesModel);
                return missoesModel;
            }
            return null;

        }
    }