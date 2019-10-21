package model;

import migsoft.model.EstoqueEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EstoqueEntityTest {

    private EstoqueEntity estoqueEntity;

    @Before
    public void setUp(){
        estoqueEntity = new EstoqueEntity();
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
}
