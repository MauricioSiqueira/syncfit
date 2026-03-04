package mauricio.syncfit.Client;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import mauricio.syncfit.Client.Dto.PokemonResponse;
import mauricio.syncfit.PokemonProto;
import mauricio.syncfit.PokemonServiceGrpc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonGrpcClient {

    private final PokemonServiceGrpc.PokemonServiceBlockingStub stub;

    public PokemonGrpcClient(PokemonServiceGrpc.PokemonServiceBlockingStub stub) {
        this.stub = stub;
    }

    public List<PokemonResponse> listarPokemons() {
        PokemonProto.PokemonRequest request = PokemonProto.PokemonRequest
                .newBuilder()
                .build();

        return stub.listPokes(request)
                .getPokesList()
                .stream()
                .map(p -> new PokemonResponse(p.getId(), p.getName()))
                .toList();
    }

    public PokemonResponse getPokemon(int id){
        PokemonProto.GetPokeRequest request = PokemonProto.GetPokeRequest
                .newBuilder()
                .setId(id)
                .build();

        PokemonProto.PokemonData p = stub.getPoke(request);
        return new PokemonResponse(p.getId(), p.getName());
    }

    public PokemonResponse getPokeByKeyword(String name){
        PokemonProto.GetPokeRequestByName request = PokemonProto.GetPokeRequestByName
                .newBuilder()
                .setName(name)
                .build();

        PokemonProto.PokemonData p = stub.getPokeByName(request);
        return new PokemonResponse(p.getId(), p.getName());
    }

}