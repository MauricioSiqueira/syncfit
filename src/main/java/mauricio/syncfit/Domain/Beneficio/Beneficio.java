package mauricio.syncfit.Domain.Beneficio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mauricio.syncfit.Domain.Plano.Plano;

@Entity
//@Table(name = "beneficio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beneficio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 1024)
    private String descricao;

    /// Ligacoes entre tabelas
    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false, foreignKey = @ForeignKey(name = "fk_benenficio_plano"))
    private Plano plano;
}
