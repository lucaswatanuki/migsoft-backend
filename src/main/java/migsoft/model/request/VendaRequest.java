package migsoft.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import migsoft.model.response.ClienteResponse;
import migsoft.model.response.ProdutoResponse;
import migsoft.model.response.VendaResponse;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaRequest {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("cliente")
    private String cliente;

    @JsonProperty("produto")
    private String produto;

    @JsonProperty("data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @JsonProperty("quantidade")
    private Integer quantidade;
}
