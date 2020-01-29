package templates.entity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import migsoft.model.ClienteEntity;
import migsoft.model.Pessoa;

public class ClienteEntityTemplate implements TemplateLoader {

    public static final String CLIENTE_VALIDO = "cotação cliente valido";

    @Override
    public void load() {
        Fixture.of(ClienteEntity.class).addTemplate(CLIENTE_VALIDO, new Rule(){
            {
                add("id", has(1).of(Pessoa.class, PessoaEntityTemplate.PESSOA_VALIDA));
                add("tipo", "PF");
            }
        });

    }
}
