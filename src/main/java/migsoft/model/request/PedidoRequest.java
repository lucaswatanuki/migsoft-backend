package migsoft.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import migsoft.model.CotacaoEntity;
import migsoft.model.response.CotacaoResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {

    @JsonProperty("cotacao")
    private CotacaoResponse cotacaoResponse;

    @JsonProperty("data")
    private String data;

}


