package mauricio.syncfit.services;

import mauricio.syncfit.Domain.Aluno.Aluno;
import mauricio.syncfit.Domain.AlunoEscola.AlunoEscola;
import mauricio.syncfit.Domain.ApiResponse;
import mauricio.syncfit.Domain.Escola.Escola;
import mauricio.syncfit.Domain.Pokemons.Pokemon;
import mauricio.syncfit.Mapper.EscolaMapper;
import mauricio.syncfit.PokemonProto;
import mauricio.syncfit.PokemonServiceGrpc;
import mauricio.syncfit.dto.*;
import mauricio.syncfit.exceptions.NotFoundException;
import mauricio.syncfit.repositories.AlunoEscolaRepository;
import mauricio.syncfit.repositories.AlunoRepository;
import mauricio.syncfit.repositories.EscolaRepository;
import mauricio.syncfit.repositories.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {
    private final EscolaRepository repo;
    private final AlunoRepository alunoRepository;
    private final AlunoEscolaRepository alunoEscolaRepository;
    private final EscolaMapper mapper;
    private final PokemonServiceGrpc.PokemonServiceBlockingStub stub;
    private final PokemonRepository pokeRepo;

    public EscolaService(EscolaRepository repo, AlunoRepository alunoRepository, AlunoEscolaRepository alunoEscolaRepository, EscolaMapper mapper, PokemonServiceGrpc.PokemonServiceBlockingStub stub, PokemonRepository pokeRepo) {
        this.repo = repo;
        this.alunoRepository = alunoRepository;
        this.alunoEscolaRepository = alunoEscolaRepository;
        this.mapper = mapper;
        this.stub = stub;
        this.pokeRepo = pokeRepo;
    }

    public ApiResponse AddEscola(EscolaInputDto input){
        Escola escola = mapper.toModel(input);
        repo.save(escola);
        return new ApiResponse("Escola Cadastrada", 201);
    }

    public EscolaOutputDto GetById(Long id){
        Escola escola = repo.findById(id).orElseThrow(() -> new NotFoundException("Escola não encontradas."));
        return mapper.toOutput(escola);
    }

    public List<EscolaOutputDto> GetEscolas(){
        List<Escola> escolas = repo.findAll();
        return mapper.toListOutput(escolas);
    }

    public ApiResponse EditEscola(EscolaEditInputDto input){
        Escola escola = mapper.toModel(input);
        repo.save(escola);
        return new ApiResponse("Escola editada", 200);
    }

    public ApiResponse DeleteById(Long id){
        repo.deleteById(id);
        return new ApiResponse("Escola deletada", 204);
    }

    public ApiResponse VinculoPokesEscola(EscolaVinculoDto input){
    Escola escola = repo.findById(input.Id())
            .orElseThrow(() -> new NotFoundException("Escola não encontrada."));

    List<PokemonProto.Ids> ids = input.pokes()
            .stream()
            .map(id -> PokemonProto.Ids.newBuilder().setId(id).build())
            .toList();

    PokemonProto.GetPokesVinculo request = PokemonProto.GetPokesVinculo
            .newBuilder()
            .addAllId(ids)
            .build();

    List<Pokemon> pokemons = stub.getPokesByList(request)
            .getPokesList()
            .stream()
            .map(p -> new Pokemon(0, p.getName(), escola))
            .toList();

    pokeRepo.saveAll(pokemons);
    return new ApiResponse("Pokemons vinculados à escola com sucesso", 200);
    }

    public ApiResponse MatriculaAluno(MatriculaDTO input){

        Escola escola = repo.findById(input.EscolaId()).orElseThrow(() -> new NotFoundException("Escola não encontrada."));
        Aluno aluno = alunoRepository.findById(input.AlunoId()).orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AlunoEscola matricula = new AlunoEscola(aluno, escola);
        alunoEscolaRepository.save(matricula);
        return new ApiResponse("Matricula realizada", 200);
    }
}
