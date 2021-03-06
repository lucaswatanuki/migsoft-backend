package migsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "produto")
@Data
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer qtdEstoque;

    @ManyToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private Set<CotacaoEntity> cotacao;

    @ManyToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private Set<OrcamentoEntity> orcamento;

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private Set<VendaEntity> venda;

    @ManyToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private Set<FormulaProdutoEntity> formula;

}
