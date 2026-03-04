package mauricio.syncfit.Client.controllers;

import mauricio.syncfit.Client.Dto.PokemonResponse;
import mauricio.syncfit.Client.PokemonGrpcClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons/")
public class PokemonController {

    private final PokemonGrpcClient service;

    public PokemonController(PokemonGrpcClient service) {
        this.service = service;
    }

    @GetMapping("listar")
    public ResponseEntity<List<PokemonResponse>> FindAll() {
        return ResponseEntity.ok(service.listarPokemons());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<PokemonResponse> GetById(@PathVariable int id) {
        return ResponseEntity.ok(service.getPokemon(id));
    }

    @GetMapping("keyword/{keyword}")
    public ResponseEntity<PokemonResponse> GetByKeyword(@PathVariable String keyword) {
        return ResponseEntity.ok(service.getPokeByKeyword(keyword));
    }
}