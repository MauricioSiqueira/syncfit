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
    private int id;

    @Column(nullable = false)
    private int vigencia;

    @Column(nullable = false)
    private EnumVigenciaContrato vigenciaUnidade;

    @Column(nullable = false)
    private Date dtInicio;

    private Date dtFinal;

    @Column(nullable = false)
    private boolean ativo;

    @Column(nullable = false)
    private float valor;

    /// Ligacoes entre tabelas
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false, foreignKey = @ForeignKey(name = "fk_contrato_aluno"))
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false, foreignKey = @ForeignKey(name = "fk_contrato_plano"))
    private Plano plano;
}