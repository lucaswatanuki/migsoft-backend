package migsoft.model;

import lombok.Data;

@Data
public class EstoqueEntity {
    private ProdutoEntity idProduto;
    private int quantidade;
}
