package mauricio.syncfit.controllers;

import jakarta.validation.Valid;
import mauricio.syncfit.Domain.ApiResponse;
import mauricio.syncfit.dto.*;
import mauricio.syncfit.services.EscolaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/escola/")
public class EscolaController {
    private final EscolaService service;

    public EscolaController(EscolaService service){
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> Add(@Valid @RequestBody EscolaInputDto input){
        return ResponseEntity.ok(service.AddEscola(input));
    }

    @PostMapping("pokevinculo")
    public ResponseEntity<ApiResponse> VincularPokes(@Valid @RequestBody EscolaVinculoDto input){
        return ResponseEntity.ok(service.VinculoPokesEscola(input));
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<ApiResponse> DeleteEscola(@PathVariable long id){
        return ResponseEntity.ok(service.DeleteById(id));
    }

    @PutMapping("")
    public ResponseEntity<ApiResponse> EditEscola(@Valid @RequestBody EscolaEditInputDto input){
        return ResponseEntity.ok(service.EditEscola(input));
    }

    @GetMapping("id/{id}")
    public ResponseEntity<EscolaOutputDto> GetEscolaById(@PathVariable Long id){
        return ResponseEntity.ok(service.GetById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<EscolaOutputDto>> GetAllEscola(){
        return ResponseEntity.ok(service.GetEscolas());
    }


    @PostMapping("matricula")
    public ResponseEntity<ApiResponse> Matricular(@RequestBody MatriculaDTO input){
        return ResponseEntity.ok(service.MatriculaAluno(input));
    }
}
