package migsoft.controller.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormulaRequest {

    @JsonProperty("produto")
    private String produto;

    @JsonProperty("material")
    private String material;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("quantidade")
    private Integer quantidade;
}


