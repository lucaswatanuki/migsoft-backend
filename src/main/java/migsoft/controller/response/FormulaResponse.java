package migsoft.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormulaResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("produto")
    private String produto;

    @JsonProperty("material")
    private String material;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("quantidade")
    private Integer quantidade;
}
