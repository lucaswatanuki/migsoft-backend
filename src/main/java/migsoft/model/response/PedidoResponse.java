package migsoft.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("data")
    private String data;
    @JsonProperty("cotacao")
    private Integer cotacao;
    @JsonProperty("fornecedor")
    private String fornecedor;
    @JsonProperty("produto")
    private String produto;
    @JsonProperty("produto_id")
    private Integer produto_id;
    @JsonProperty("quantidade")
    private Integer quantidade;
    @JsonProperty("total")
    private Double total;
    @JsonProperty("status")
    private String status;
}
