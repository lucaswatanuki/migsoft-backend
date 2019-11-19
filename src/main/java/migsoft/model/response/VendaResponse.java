package migsoft.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaResponse {
    @JsonProperty("id")
    private Integer id;
    @Temporal(TemporalType.DATE)
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
