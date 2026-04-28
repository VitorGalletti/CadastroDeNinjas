package dev.java10x.CadastroDeNinja.Missoes;

import dev.java10x.CadastroDeNinja.Ninjas.NinjaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//LOCALHOST:8080/adicionar
@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET --Mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao(){
        return missoesService.listarMissoes();
    }

    //GET por id
    @GetMapping("/listar/{id}")
    public Optional<MissoesModel> listarMissaoPorId(@PathVariable Long id) {
        return missoesService.listarMissoesPorId(id);
    }

    // Post -- Mandar uma requisicao para criar as missoes
    @PostMapping("/criar")
    public String criarNinja(@RequestBody MissoesModel missaoModel) {
        missoesService.criarNinja(missaoModel);
        return "Missao criada com sucesso: " + missaoModel.getNome() + "(ID): " + missaoModel.getId();
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public String alterarMissoesPorId(
            @PathVariable Long id,
            @RequestBody MissoesModel missoesModel) {

        missoesService.atualizarMissao(id, missoesModel);
        if (missoesModel != null) {
            return "Missao atualizada/n " + (missoesModel);
        } else {
            return ("Missao com esse id: " + id + " não encontrado");
        }
    }

        // Deletar Ninja (DELETE)
        @DeleteMapping("/deletar/{id}")
        public String deletarMissaoPorID (@PathVariable Long id){

            if (missoesService.listarMissoesPorId(id) != null) {
                missoesService.deletarMissaoPorId(id);
                return "A Missao com o id " + id + "deletado";
            } else {
                return "A Missao com o id " + id + " não encontrado";
            }
        }


    }

