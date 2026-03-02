package mauricio.syncfit.Domain.Plano;

import mauricio.syncfit.Domain.Beneficio.Beneficio;
import mauricio.syncfit.Domain.Contrato.Contrato;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "plano")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 75)
    private String nome;

    @Column(nullable = false)
    private Boolean ativo;

    /// Ligacoes entre tabelas
    @OneToMany(mappedBy = "plano", orphanRemoval = true)
    private List<Contrato> contratos = new ArrayList<>();

    @OneToMany(mappedBy = "plano", orphanRemoval = true)
    private List<Beneficio> beneficios = new ArrayList<>();
}