package migsoft.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "estoque")
@Data
public class EstoqueEntity {
    private ProdutoEntity idProduto;
    private int quantidade;
}
