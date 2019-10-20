package model;

import migsoft.model.ProdutoEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutoEntityTest {

    private ProdutoEntity produtoEntity;

    @Before
    public void setUp() { produtoEntity = new ProdutoEntity();}

    @Test
    public void testGetterProdutoId_Sucesso(){
        produtoEntity.setId(1);
        Assert.assertTrue(produtoEntity.getId() == 1);
    }

    @Test
    public void testGetterProdutoId_Falha(){
        produtoEntity.setId(1);
        Assert.assertFalse(produtoEntity.getId() == 2);
    }

    @Test
    public void testGetterProdutoNome_Sucesso(){
        produtoEntity.setNome("test");
        Assert.assertTrue(produtoEntity.getNome() == "test");
    }

    @Test
    public void testGetterProdutoNome_Falha(){
        produtoEntity.setNome("test");
        Assert.assertFalse(produtoEntity.getNome() == " ");
    }

    @Test
    public void testGetterProdutoPreco_Sucesso(){
        produtoEntity.setPreco(2.50);
        Assert.assertTrue(produtoEntity.getPreco() == 2.50);
    }

    @Test
    public void testGetterProdutoPreco_Falha(){
        produtoEntity.setPreco(2.50);
        Assert.assertFalse(produtoEntity.getPreco() == 5.00);
    }

}
