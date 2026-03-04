package mauricio.syncfit.Client.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import mauricio.syncfit.PokemonServiceGrpc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {

    @Value("${grpc.server.host}")
    private String host;

    @Value("${grpc.server.port}")
    private int port;

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
    }

    @Bean
    public PokemonServiceGrpc.PokemonServiceBlockingStub pokemonStub(ManagedChannel channel) {
        return PokemonServiceGrpc.newBlockingStub(channel);
    }
}
