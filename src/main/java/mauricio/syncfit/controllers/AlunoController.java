package mauricio.syncfit.controllers;

import mauricio.syncfit.Domain.Aluno.Aluno;
import mauricio.syncfit.dto.AlunoInputDto;
import mauricio.syncfit.dto.AlunoOutputDto;
import mauricio.syncfit.repositories.AlunoRepository;
import mauricio.syncfit.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Constructor;
import java.util.List;

@RestController
@RequestMapping("v1/aluno/")
public class AlunoController {
    private final AlunoService service;

    public AlunoController(AlunoService service){
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<List<Aluno>> AddAlunos(@RequestBody AlunoInputDto input){
        service.AddAluno(input);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<AlunoOutputDto>> GetAll(){
        return ResponseEntity.ok(service.GetAll());
    }
}
