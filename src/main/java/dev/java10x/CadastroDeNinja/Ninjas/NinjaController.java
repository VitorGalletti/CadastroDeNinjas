package dev.java10x.CadastroDeNinja.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas",description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria novo ninja", description = "Rota cria um novo ninja e inseri no DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criacao do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + "(ID): " + novoNinja.getId());
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista ninja por id", description = "Rota lista um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Ninja nao encontrado")
    })
    public ResponseEntity<?> ListarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja como o id: " + id + " não encontrado");
        }
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera ninja por id", description = "Rota altera um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Ninja nao encontrado, nao foi possivel alterar")
    })
    public ResponseEntity<?> alterarNinjaPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id,
            @Parameter(description = "Usuario mando os dados do ninha a ser atualizado no corpo da requisicao")
            @RequestBody NinjaDTO ninjaAtualizado) {

            NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
            if (ninja != null) {
                return ResponseEntity.ok(ninja);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Ninja com esse id: " + id + " não encontrado");
            }
    }


    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id) {

        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + "deletado");
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O Ninja com o id " + id + " não encontrado");
        }

    }
}