package templates.entity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import migsoft.model.Pessoa;

public class PessoaEntityTemplate implements TemplateLoader {

    public static final String PESSOA_VALIDA = "informações pessoa valida";
    public static final String ID = "informações pessoa ID";


    @Override
    public void load() {
        Fixture.of(Pessoa.class).addTemplate(PESSOA_VALIDA, new Rule(){
            {
                add("id", "1");
                add("nome", "Lucas");
                add("cpf", "522.931.310-25");
                add("telefone", "1824238423");
                add("endereco", "Rua limeira");
                add("email", "lucaswatanuki@gmail.com");
            }
        }).addTemplate(ID).inherits(PESSOA_VALIDA, new Rule(){
            {
                add("id", "1");
            }
        });
    }
}
