package mauricio.syncfit.Domain.Plano;

import mauricio.syncfit.Domain.Academia.Academia;
import mauricio.syncfit.Domain.Contrato.Contrato;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "academia_id", nullable = false)
    private Academia academia;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Boolean ativo;

    @Column(nullable = false)
    private Long valor;

    @OneToMany(mappedBy = "plano", orphanRemoval = true)
    private List<Contrato> contratos = new ArrayList<>();
}