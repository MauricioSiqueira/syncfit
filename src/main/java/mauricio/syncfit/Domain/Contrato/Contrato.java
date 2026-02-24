package mauricio.syncfit.Domain.Contrato;

import mauricio.syncfit.Domain.Aluno.Aluno;
import mauricio.syncfit.Domain.Plano.Plano;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "contratos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false)
    private Plano plano;

    @Column(nullable = false)
    private Long vigencia;

    @Column(nullable = false)
    private Date dtInicio;

    private Date dtFinal;

    @Column(nullable = false)
    private Boolean ativo;

    @Column(nullable = false)
    private Float valor;
}