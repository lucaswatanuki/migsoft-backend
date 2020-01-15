package migsoft.controller.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrcamentoResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("data")
    private Date data;
    @JsonProperty("cliente")
    private String cliente;
    @JsonProperty("produto")
    private String produto;
    @JsonProperty("quantidade")
    private Integer quantidade;
    @JsonProperty("total")
    private Double total;
}
