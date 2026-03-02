package mauricio.syncfit.services;

import mauricio.syncfit.Domain.Plano.Plano;
import mauricio.syncfit.Mapper.PlanoMapper;
import mauricio.syncfit.dto.PlanoInputDto;
import mauricio.syncfit.repositories.PlanoRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanoService {
    private final PlanoRepository repository;
    private final PlanoMapper mapper;


    public PlanoService(PlanoRepository repository, PlanoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public void add(PlanoInputDto input){
        Plano values = mapper.toEntity(input);
        repository.save(values);
    }
}
