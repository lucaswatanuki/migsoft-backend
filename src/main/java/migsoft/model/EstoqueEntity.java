package migsoft.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "estoque")
@Data
public class EstoqueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private ProdutoEntity idProduto;
    private int quantidade;
}
