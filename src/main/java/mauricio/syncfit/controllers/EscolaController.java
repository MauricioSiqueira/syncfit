package mauricio.syncfit.controllers;

import jakarta.validation.Valid;
import mauricio.syncfit.Domain.ApiResponse;
import mauricio.syncfit.dto.EscolaInputDto;
import mauricio.syncfit.services.EscolaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/pokevinculo")
    public ResponseEntity<ApiResponse> VincularPokes(@Valid @RequestBody EscolaInputDto input){
        return ResponseEntity.ok(service.AddEscola(input));
    }

}
