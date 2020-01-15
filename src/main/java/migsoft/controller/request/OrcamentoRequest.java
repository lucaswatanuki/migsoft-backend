package migsoft.controller.request;

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
public class OrcamentoRequest {
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
