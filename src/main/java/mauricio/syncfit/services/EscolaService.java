package mauricio.syncfit.services;

import mauricio.syncfit.Client.Dto.PokemonResponse;
import mauricio.syncfit.Domain.ApiResponse;
import mauricio.syncfit.Domain.Escola.Escola;
import mauricio.syncfit.Domain.Pokemons.Pokemon;
import mauricio.syncfit.Mapper.EscolaMapper;
import mauricio.syncfit.PokemonProto;
import mauricio.syncfit.PokemonServiceGrpc;
import mauricio.syncfit.dto.EscolaEditInputDto;
import mauricio.syncfit.dto.EscolaInputDto;
import mauricio.syncfit.dto.EscolaOutputDto;
import mauricio.syncfit.dto.EscolaVInculoDto;
import mauricio.syncfit.exceptions.NotFoundException;
import mauricio.syncfit.repositories.EscolaRepository;
import mauricio.syncfit.repositories.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {
    private final EscolaRepository repo;
    private final EscolaMapper mapper;
    private final PokemonServiceGrpc.PokemonServiceBlockingStub stub;
    private final PokemonRepository pokeRepo;

    public EscolaService(EscolaRepository repo, EscolaMapper mapper, PokemonServiceGrpc.PokemonServiceBlockingStub stub, PokemonRepository pokeRepo) {
        this.repo = repo;
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
        Optional<Escola> escola = repo.findById(id);
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

    public ApiResponse VinculoPokesEscola(EscolaVInculoDto input){
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
}
