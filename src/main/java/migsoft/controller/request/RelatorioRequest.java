package migsoft.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioRequest {

    @JsonProperty("dataInicial")
    @Temporal(TemporalType.DATE)
    private Date dataInicial;

    @JsonProperty("dataFinal")
    @Temporal(TemporalType.DATE)
    private Date dataFinal;

    @JsonProperty("status")
    private String status;
}
