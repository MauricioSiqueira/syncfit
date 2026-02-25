package mauricio.syncfit.Domain.Contrato;

import mauricio.syncfit.Domain.Aluno.Aluno;
import mauricio.syncfit.Domain.Plano.Plano;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name = "contrato")
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
    private EnumVigenciaContrato vigencia_unidade;

    @Column(nullable = false)
    private LocalDateTime dt_inicio;

    private LocalDate dt_final;

    @Column(nullable = false)
    private boolean ativo;

    @Column(nullable = false)
    private BigDecimal valor;

    /// Ligacoes entre tabelas
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false, foreignKey = @ForeignKey(name = "fk_contrato_aluno"))
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false, foreignKey = @ForeignKey(name = "fk_contrato_plano"))
    private Plano plano;
}