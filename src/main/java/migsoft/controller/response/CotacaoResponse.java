package migsoft.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CotacaoResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("data")
    private String data;

    @JsonProperty("data_resposta")
    private String data_resposta;

    @JsonProperty("produto")
    private String produto;

    @JsonProperty("fornecedor")
    private String fornecedor;

    @JsonProperty("quantidade")
    private Integer quantidade;

    @JsonProperty("total")
    private Double total;

    @JsonProperty("status")
    private String status;


}
