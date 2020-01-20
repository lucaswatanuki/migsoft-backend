package migsoft.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponse {
    @JsonProperty("id")
    private Integer idProduto;
    @JsonProperty("nome")
    private String nomeProduto;
    @JsonProperty("preco")
    private double precoProduto;
    @JsonProperty("qtdEstoque")
    private Integer qtdEstoqueProduto;

    public Integer getIdProduto() {
        return idProduto;
    }
}
