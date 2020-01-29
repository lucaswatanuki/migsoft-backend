package service;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import migsoft.controller.response.ProdutoResponse;
import migsoft.model.ProdutoEntity;
import migsoft.repository.ProdutoRepository;
import migsoft.service.ProdutoService;
import migsoft.service.ProdutoServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import templates.entity.ProdutoEntityTemplate;

import javax.persistence.criteria.CriteriaBuilder;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    private ProdutoService produtoService;

    @Before
    public void setUp(){
        FixtureFactoryLoader.loadTemplates("templates.entity");
        produtoService = new ProdutoServiceImp(produtoRepository);
    }

    @Test
    public void deveBuscarProdutoPorId() {
        final Integer id = 1;

        ProdutoEntity produtoEntityExpected = from(ProdutoEntity.class).gimme(ProdutoEntityTemplate.PRODUTO_VALIDO);

        when(produtoRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(produtoEntityExpected));

        ProdutoResponse response = produtoService.findById(produtoEntityExpected.getId());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getIdProduto()).isEqualTo(produtoEntityExpected.getId());
        verify(produtoRepository, times(1)).findById(produtoEntityExpected.getId());
    }

    @Test
    public void deveBuscarProdutoPorNome() {
        final String nome = "mouse";

        ProdutoEntity produtoEntityExpected = from(ProdutoEntity.class).gimme(ProdutoEntityTemplate.PRODUTO_VALIDO);

        when(produtoRepository.findByNome(nome)).thenReturn(produtoEntityExpected);

        ProdutoResponse response = produtoService.findByNome(produtoEntityExpected.getNome());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getNomeProduto()).isEqualTo(produtoEntityExpected.getNome());
        verify(produtoRepository, times(1)).findByNome(produtoEntityExpected.getNome());
    }

}
