package model;

import migsoft.model.OrcamentoEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrcamentoEntityTest {

    private OrcamentoEntity orcamentoExpected;

    @Before
    public void setUp(){
        orcamentoExpected = new OrcamentoEntity(1,"descricao_teste",10.00);
    }

    @Test
    public void testGetterIdOrcamento_Sucesso(){
        Assert.assertEquals(1, orcamentoExpected.getId());
    }

    @Test
    public void testGetterIdOrcamento_Falha(){
        Assert.assertNotEquals(2, orcamentoExpected.getId());
    }

    @Test
    public void testGetterDescricaoOrcamento_Sucesso(){
        Assert.assertSame("descricao_teste", orcamentoExpected.getDescricao());
    }

    @Test
    public void testGetterDescricaoOrcamento_Falha(){
        Assert.assertNotSame(null, orcamentoExpected.getDescricao());
    }

    @Test
    public void testGetterTotalOrcamento_Sucesso(){
        Assert.assertEquals(10.00, orcamentoExpected.getTotal(), 0.0);
    }

    @Test
    public void testGetterTotalOrcamento_Falha(){
        Assert.assertNotEquals(null, orcamentoExpected.getTotal());
    }

}
