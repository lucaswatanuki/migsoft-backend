package templates.entity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import migsoft.model.CotacaoEntity;
import migsoft.model.OrcamentoEntity;
import migsoft.model.ProdutoEntity;
import migsoft.model.VendaEntity;

public class CotacaoEntityTemplate implements TemplateLoader {

    public static final String COTACAO_VALIDA = "cotação informações validas";

    @Override
    public void load() {
        Fixture.of(CotacaoEntity.class).addTemplate(COTACAO_VALIDA, new Rule(){
            {
                add("id", "1");
                add("preco","15.00");
                add("produto",has(1).of(ProdutoEntity.class, ProdutoEntityTemplate.PRODUTO_VALIDO));
                add("orcamento",has(1).of(OrcamentoEntity.class, OrcamentoEntityTemplate.ORCAMENTO_VALIDO));
                add("venda",has(1).of(VendaEntity.class, VendaEntityTemplate.VENDA_VALIDA));
            }
        });
    }
}
