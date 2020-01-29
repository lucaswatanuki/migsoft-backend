package templates.entity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import migsoft.model.*;

public class VendaEntityTemplate implements TemplateLoader {

    public static final String VENDA_VALIDA = "informações venda validas";

    @Override
    public void load() {
        Fixture.of(VendaEntity.class).addTemplate(VENDA_VALIDA, new Rule(){
            {
                add("id", "1");
                add("cliente",has(1).of(ClienteEntity.class, ClienteEntityTemplate.CLIENTE_VALIDO));
                add("produto", has(1).of(ProdutoEntity.class, ProdutoEntityTemplate.PRODUTO_VALIDO));
                add("quantidade", "40");
            }
        });
    }
}
