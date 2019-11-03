package migsoft.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import migsoft.model.ItemProduto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("data")
    private String data;
    @JsonProperty("cliente_id")
    private Integer cliente;
    @JsonProperty("itemProduto")
    private List<ItemProdutoResponse> itemProdutos;
    @JsonProperty("total")
    private Double total;
}
