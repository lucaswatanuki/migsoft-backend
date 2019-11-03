package migsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "estoque")
@Data
public class EstoqueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String rua;

    private Integer numero;

    private String cidade;

    private String estado;

    private String cep;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ProdutoEntity> produto;
}
