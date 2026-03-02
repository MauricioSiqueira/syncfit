package mauricio.syncfit.services;

import mauricio.syncfit.Domain.Aluno.Aluno;
import mauricio.syncfit.Mapper.AlunoMapper;
import mauricio.syncfit.dto.AlunoInputDto;
import mauricio.syncfit.dto.AlunoOutputDto;
import mauricio.syncfit.exceptions.BussinesException;
import mauricio.syncfit.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private final AlunoRepository repository;
    private final AlunoMapper mapper;

    public AlunoService(AlunoRepository repository, AlunoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void add(AlunoInputDto input) {

        if(repository.existsAlunoByCpf(input.cpf())){
            throw new BussinesException("Cpf já cadastrado na base de dados.");
        };

        Aluno value = DtoToModel(input);
        repository.save(value);
    }

    public void edit(AlunoInputDto input){
        Aluno value = DtoToModel(input);
        repository.save(value);
    }

    public void Delete(int id){
        repository.deleteById(id);
    }

    public AlunoOutputDto getById(int id){
        Optional<Aluno> dbResponse = repository.findById(id);
        return mapper.toDTO(dbResponse);
    }

    public List<AlunoOutputDto> getAllAlunos(){
        List<Aluno> dbResponse = repository.findAll();
        return mapper.toDTO(dbResponse);
    }

    private Aluno DtoToModel(AlunoInputDto input) {
        return new Aluno(input.senha(), input.cpf(), input.nome(), input.dt_nascimento());
    }
}
