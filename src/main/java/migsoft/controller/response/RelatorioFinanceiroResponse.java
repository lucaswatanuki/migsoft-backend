package migsoft.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioFinanceiroResponse {

    @JsonProperty("receita")
    private Double receita;

    @JsonProperty("despesa")
    private Double despesa;

    @JsonProperty("lucro")
    private Double lucro;

    @JsonProperty("prejuizo")
    private Double prejuizo;

    public RelatorioFinanceiroResponse(Double despesa, Double receita) {
    }
}
