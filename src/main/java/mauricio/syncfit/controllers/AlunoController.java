package mauricio.syncfit.controllers;

import jakarta.validation.Valid;
import mauricio.syncfit.Domain.Aluno.Aluno;
import mauricio.syncfit.Domain.ApiResponse;
import mauricio.syncfit.dto.AlunoInputDto;
import mauricio.syncfit.dto.AlunoOutputDto;
import mauricio.syncfit.dto.EscolaEditInputDto;
import mauricio.syncfit.dto.EscolaOutputDto;
import mauricio.syncfit.services.AlunoService;
import org.hibernate.mapping.UnionSubclass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/aluno/")
public class AlunoController {
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> AddAlunos(@RequestBody @Valid AlunoInputDto input){
        service.add(input);
        ApiResponse response = new ApiResponse("Aluno Cadastrado com sucesso", 201);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("")
    public ResponseEntity<List<AlunoOutputDto>> GetAll(){
        return ResponseEntity.ok(service.getAllAlunos());
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<ApiResponse> Delete(@PathVariable int id){
        return ResponseEntity.ok(service.Delete(id));
    }

    @PutMapping("")
    public ResponseEntity<ApiResponse> EditAluno(@Valid @RequestBody AlunoInputDto input){
        return ResponseEntity.ok(service.edit(input));
    }

    @GetMapping("id/{id}")
    public ResponseEntity<AlunoOutputDto> GetById(@PathVariable int id){
        return ResponseEntity.ok(service.getById(id));
    }
}
