package templates.entity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import migsoft.model.ClienteEntity;
import migsoft.model.OrcamentoEntity;
import migsoft.model.ProdutoEntity;

public class OrcamentoEntityTemplate implements TemplateLoader {

    public static final String ORCAMENTO_VALIDO = "orcamento valido";

    @Override
    public void load() {
        Fixture.of(OrcamentoEntity.class).addTemplate(ORCAMENTO_VALIDO, new Rule(){
            {
                add("id", "1");
                add("produto", has(1).of(ProdutoEntity.class, ProdutoEntityTemplate.PRODUTO_VALIDO));
                add("cliente", has(1).of(ClienteEntity.class, ClienteEntityTemplate.CLIENTE_VALIDO));
                add("quantidade", "10");
                add("data", "14-10-1996");
            }
        });
    }
}
