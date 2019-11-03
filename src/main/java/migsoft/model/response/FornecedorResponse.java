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
}
