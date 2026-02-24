package mauricio.syncfit.Domain.Contrato;

import lombok.Getter;

@Getter
public enum EnumVigenciaContrato {
    Dia(1),
    Mes(2),
    Ano(3);

    private final int cod;

    EnumVigenciaContrato(int cod){
        this.cod = cod;
    }

}
