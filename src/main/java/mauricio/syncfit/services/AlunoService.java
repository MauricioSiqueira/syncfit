package mauricio.syncfit.services;

import mauricio.syncfit.Domain.Aluno.Aluno;
import mauricio.syncfit.Mapper.AlunoMapper;
import mauricio.syncfit.dto.AlunoInputDto;
import mauricio.syncfit.dto.AlunoOutputDto;
import mauricio.syncfit.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;
    private final AlunoMapper mapper;
    public AlunoService(AlunoRepository repository, AlunoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public void AddAluno(AlunoInputDto input){
        Aluno aluno = input.toModel();
        repository.save(aluno);
    }

    public List<AlunoOutputDto> GetAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
}
