package migsoft.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemProdutoResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("quantidade")
    private Integer quantidade;
    @JsonProperty("produto")
    private String produto;
}
