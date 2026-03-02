package mauricio.syncfit.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse {
    private String mensagem;
    private int status;

    public ApiResponse(String mensagem, int status) {
        this.mensagem = mensagem;
        this.status = status;
    }
}