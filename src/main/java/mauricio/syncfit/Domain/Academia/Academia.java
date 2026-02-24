package mauricio.syncfit.Domain.Academia;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "academias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Academia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String fantasia;

    private String contato;
}