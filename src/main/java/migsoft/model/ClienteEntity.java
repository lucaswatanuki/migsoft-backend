package migsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cliente")
@Data
@PrimaryKeyJoinColumn(name = "id")
public class ClienteEntity extends Pessoa {
    private String tipo;
    @ManyToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<OrcamentoEntity> orcamento;
}
