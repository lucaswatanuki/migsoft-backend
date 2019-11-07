package migsoft.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorResponse {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("nomeFantasia")
    private String nomeFantasia;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("cpf")
    private String cpf;

}
