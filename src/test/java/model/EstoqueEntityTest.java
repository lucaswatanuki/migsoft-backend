package model;

import migsoft.model.EstoqueEntity;
import migsoft.model.ProdutoEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EstoqueEntityTest {

    private EstoqueEntity estoqueEntity;
    private List<ProdutoEntity> produtoExpected;

    @Before
    public void setUp(){
        estoqueEntity = new EstoqueEntity();
        produtoExpected = new ArrayList<>();
        produtoExpected.add(new ProdutoEntity(1, "produto",10.00));
    }

    @Test
    public void testEstoqueId_Sucesso(){
        estoqueEntity.setId(1);
        Assert.assertTrue(estoqueEntity.getId() == 1);
    }

    @Test
    public void testEstoqueId_Falha(){
        estoqueEntity.setId(1);
        Assert.assertFalse(estoqueEntity.getId() == 2);
    }

    @Test
    public void testEstoqueQtd_Sucesso(){
        estoqueEntity.setQuantidade(10);
        Assert.assertTrue(estoqueEntity.getQuantidade() == 10);
    }

    @Test
    public void testEstoqueQtd_Falha(){
        estoqueEntity.setQuantidade(10);
        Assert.assertFalse(estoqueEntity.getQuantidade() == 15);
    }

    @Test
    public void testGetterProdutoEstoque_Sucesso(){
        List<ProdutoEntity> produtoTeste = new ArrayList<>();
        produtoTeste.add(new ProdutoEntity(1,"produto",10.00));
        produtoTeste.forEach(produtoEntity -> {
            int i = 0;
            Assert.assertEquals(produtoTeste.get(i).getId(), produtoExpected.get(i).getId());;
            Assert.assertEquals(produtoTeste.get(i).getNome(), produtoExpected.get(i).getNome());
            Assert.assertEquals(produtoTeste.get(i).getPreco(), produtoExpected.get(i).getPreco(), 0.0);
        });
    }

    @Test
    public void testGetterProdutoEstoque_Falha(){
        List<ProdutoEntity> produtoTeste = new ArrayList<>();
        produtoTeste.add(new ProdutoEntity(2,"teste",15.00));
        produtoTeste.forEach(produtoEntity -> {
            int i = 0;
            Assert.assertNotEquals(produtoTeste.get(i).getId(), produtoExpected.get(i).getId());;
            Assert.assertNotEquals(produtoTeste.get(i).getNome(), produtoExpected.get(i).getNome());
            Assert.assertNotEquals(produtoTeste.get(i).getPreco(), produtoExpected.get(i).getPreco(), 0.0);
        });
    }
}
