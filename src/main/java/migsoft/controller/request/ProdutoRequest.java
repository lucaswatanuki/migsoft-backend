package migsoft.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("qtdEstoque")
    private Integer qtdEstoque;

    @JsonProperty("preco")
    private Double preco;
}
