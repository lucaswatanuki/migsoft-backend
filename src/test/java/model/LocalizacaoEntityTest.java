package model;

import migsoft.model.LocalizacaoEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LocalizacaoEntityTest {
    private LocalizacaoEntity localizacaoExpected;

    @Before
    public void setUp(){
        localizacaoExpected = new LocalizacaoEntity(1,"R. Teste, 245 - Bairro Teste, São Paulo, Brasil");
    }

    @Test
    public void testGetterIdLocalizacao_Sucesso(){
        int testeId = 1;
        Assert.assertTrue(localizacaoExpected.getId() == testeId);
    }

    @Test
    public void testGetterIdLocalizacao_Falha(){
        int testeId = 2;
        Assert.assertFalse(localizacaoExpected.getId() == testeId);
    }

    @Test
    public void testGetterEnderecoLocalizacao_Sucesso(){
        String testeEndereco = "R. Teste, 245 - Bairro Teste, São Paulo, Brasil";
        Assert.assertEquals(localizacaoExpected.getEndereco(), testeEndereco);
    }

    @Test
    public void testGetterEnderecoLocalizacao_Falha(){
        String testeEndereco = " ";
        Assert.assertNotEquals(localizacaoExpected.getEndereco(), testeEndereco);
    }
}
