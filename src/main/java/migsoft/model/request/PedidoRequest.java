package migsoft.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {

    @JsonProperty("id")
    Integer id;

    @JsonProperty("fornecedor_id")
    Integer fornecedor_id;

    @JsonProperty("produto_id")
    Integer produto_id;

    @JsonProperty("data")
    String data;

}


