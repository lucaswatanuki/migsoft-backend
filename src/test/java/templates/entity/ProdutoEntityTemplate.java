package templates.entity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import migsoft.model.CotacaoEntity;
import migsoft.model.OrcamentoEntity;
import migsoft.model.ProdutoEntity;
import migsoft.model.VendaEntity;

public class ProdutoEntityTemplate implements TemplateLoader {

    public static final String PRODUTO_VALIDO = "produto informações validas";

    @Override
    public void load() {
        Fixture.of(ProdutoEntity.class).addTemplate(PRODUTO_VALIDO, new Rule() {
            {
                add("id", "1");
                add("nome", "mouse");
                add("preco", "15.00");
                add("qtdEstoque", "10");
            }
        });
    }
}
