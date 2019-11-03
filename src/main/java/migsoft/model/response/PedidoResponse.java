package migsoft.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import migsoft.model.ItemProduto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("data")
    private String data;
    @JsonProperty("fornecedor")
    private String fornecedor;
    @JsonProperty("produto")
    private String produto;
    @JsonProperty("quantidade")
    private Integer quantidade;
 /*   @JsonProperty("itemProduto")
    private List<ItemProdutoResponse> itemProduto; */
    @JsonProperty("total")
    private Double total;
}
