package migsoft.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioProdutos {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("quantidadeTotal")
    private Integer quantidadeTotal;

    @JsonProperty("vendasTotal")
    private Double vendasTotal;

}
