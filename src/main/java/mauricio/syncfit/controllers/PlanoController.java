package mauricio.syncfit.controllers;

import jakarta.servlet.ServletRequest;
import jakarta.validation.Valid;
import mauricio.syncfit.Domain.ApiResponse;
import mauricio.syncfit.dto.PlanoInputDto;
import mauricio.syncfit.services.PlanoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/plano/")
public class PlanoController {
    private final PlanoService service;

    public PlanoController(PlanoService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> addAlunos(@Valid @RequestBody PlanoInputDto input){
        service.add(input);
        ApiResponse response = new ApiResponse("Plano Cadastrado com sucesso", 201);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
