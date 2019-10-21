package model;

import migsoft.model.CotacaoEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CotacaoEntityTest {

    public CotacaoEntity cotacaoEntity;

    @Before
    public void setUp(){ cotacaoEntity = new CotacaoEntity(); }

    @Test
    public void testGetterCotacaoId_Sucesso(){
        cotacaoEntity.setId(1);
        Assert.assertTrue(cotacaoEntity.getId() == 1);
    }

    @Test
    public void testGetterCotacaoId_Falha(){
        cotacaoEntity.setId(1);
        Assert.assertFalse(cotacaoEntity.getId() == 2);
    }

    @Test
    public void testGetterCotacaoPreco_Sucesso(){
        cotacaoEntity.setPreco(10.50);
        Assert.assertTrue(cotacaoEntity.getPreco() == 10.50);
    }

    @Test
    public void testGetterCotacaoPreco_Falha(){
        cotacaoEntity.setPreco(10.50);
        Assert.assertFalse(cotacaoEntity.getPreco() == 15.00);
    }

    @Test
    public void testGetterCotacaoData_Sucesso(){
        cotacaoEntity.setData("14-04-2019");
        Assert.assertTrue(cotacaoEntity.getData() == "14-04-2019");
    }

    @Test
    public void testGetterCotacaoData_Falha(){
        cotacaoEntity.setData("14-04-2019");
        Assert.assertFalse(cotacaoEntity.getData() == "21-01-2019");
    }

}
