package model;

import migsoft.model.FornecedorEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FornecedorEntityTest {

    FornecedorEntity fornecedorEntity;

    @Before
    public void setUp(){
        fornecedorEntity = new FornecedorEntity();
    }

    @Test
    public void testEstoqueId_Sucesso(){
        fornecedorEntity.setId(1);
        Assert.assertTrue(fornecedorEntity.getId() == 1);
    }

    @Test
    public void testEstoqueId_Falha(){
        fornecedorEntity.setId(1);
        Assert.assertFalse(fornecedorEntity.getId() == 2);
    }

    @Test
    public void testGetterClienteNome_Sucesso(){
        fornecedorEntity.setNome("test");
        Assert.assertTrue(fornecedorEntity.getNome() == "test");
    }

    @Test
    public void testGetterClienteNome_Falha(){
        fornecedorEntity.setNome("test");
        Assert.assertFalse(fornecedorEntity.getNome() == " ");
    }

    @Test
    public void testGetterClienteCpf_Sucesso(){
        fornecedorEntity.setCpf("333.111.000-88");
        Assert.assertTrue(fornecedorEntity.getCpf() == "333.111.000-88");
    }

    @Test
    public void testGetterClienteCpf_Falha(){
        fornecedorEntity.setCpf("333.111.000-88");
        Assert.assertFalse(fornecedorEntity.getCpf() == "333.222.111-00");
    }

    @Test
    public void testGetterTelefone_Sucesso(){
        fornecedorEntity.setTelefone("+551930004000");
        Assert.assertTrue(fornecedorEntity.getTelefone() == "+551930004000");
    }

    @Test
    public void testGetterTelefone_Falha(){
        fornecedorEntity.setTelefone("+551930004000");
        Assert.assertFalse(fornecedorEntity.getTelefone() == "+551932004200");
    }

    @Test
    public void testGetterEmail_Sucesso(){
        fornecedorEntity.setEmail("test@test.com");
        Assert.assertTrue(fornecedorEntity.getEmail() == "test@test.com");
    }

    @Test
    public void testGetterEmail_Falha(){
        fornecedorEntity.setEmail("test@test.com");
        Assert.assertFalse(fornecedorEntity.getEmail() == "tilt@test.com");
    }

    @Test
    public void testGetterEndereco_Sucesso(){
        fornecedorEntity.setEndereco("R. Teste, 245 - Bairro Teste, São Paulo, Brasil");
        Assert.assertTrue(fornecedorEntity.getEndereco() == "R. Teste, 245 - Bairro Teste, São Paulo, Brasil");
    }

    @Test
    public void testGetterEndereco_Falha(){
        fornecedorEntity.setEndereco("R. Teste, 245 - Bairro Teste, São Paulo, Brasil");
        Assert.assertFalse(fornecedorEntity.getEndereco() == "Av. Testing - Bairro Teste, São Paulo, Brasil");
    }

    @Test
    public void testGetterCnpj_Sucesso(){
        fornecedorEntity.setCnpj("01.033.574/0001-29");
        Assert.assertTrue(fornecedorEntity.getCnpj() == "01.033.574/0001-29");
    }

    @Test
    public void testGetterCnpj_Falha(){
        fornecedorEntity.setCnpj("01.033.574/0001-29");
        Assert.assertFalse(fornecedorEntity.getCnpj() == " ");
    }

    @Test
    public void testGetterNomeFantasia_Sucesso(){
        fornecedorEntity.setNomeFantasia("teste");
        Assert.assertTrue(fornecedorEntity.getNomeFantasia() == "teste");
    }

    @Test
    public void testGetterNomeFantasia_Falha(){
        fornecedorEntity.setNomeFantasia("teste");
        Assert.assertFalse(fornecedorEntity.getNomeFantasia() == " ");
    }

}
