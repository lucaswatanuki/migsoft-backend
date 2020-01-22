package migsoft.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CotacaoRequest {

    @JsonProperty("data")
    private String data;

    @JsonProperty("quantidade")
    private Integer quantidade;

    @JsonProperty("produto")
    private String produto;

    @JsonProperty("fornecedor")
    private String fornecedor;

    @JsonProperty("status")
    private String status;

}
