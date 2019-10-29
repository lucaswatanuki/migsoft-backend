package service;

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
import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    private ProdutoService produtoService;

    @Before
    public void setUp(){
        produtoService = new ProdutoServiceImp(produtoRepository);
    }

    @Test
    public void findByIdSucesso(){
        ProdutoEntity produto = new ProdutoEntity(1, "mouse");
        when(produtoRepository.findById(anyInt())).thenReturn(produto);
        ProdutoEntity produtoTeste = produtoService.findById(produto.getId());
        Assertions.assertThat(produto).isEqualToComparingFieldByField(produtoTeste);
    }


}
