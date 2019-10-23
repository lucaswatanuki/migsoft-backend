package model;

import migsoft.model.ClienteEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ClienteEntityTest {
    private ClienteEntity clienteEntity;

    @Before
    public void setUp(){
        clienteEntity = new ClienteEntity();
    }

    @Test
    public void testGetterClienteId_Sucesso(){
        clienteEntity.setId(1);
        Assert.assertTrue(clienteEntity.getId() == 1);
    }

    @Test
    public void testGetterClienteId_Falha(){
        clienteEntity.setId(1);
        Assert.assertFalse(clienteEntity.getId() == 2);
    }

    @Test
    public void testGetterClienteNome_Sucesso(){
        clienteEntity.setNome("test");
        Assert.assertTrue(clienteEntity.getNome() == "test");
    }

    @Test
    public void testGetterClienteNome_Falha(){
        clienteEntity.setNome("test");
        Assert.assertFalse(clienteEntity.getNome() == " ");
    }

    @Test
    public void testGetterClienteCpf_Sucesso(){
        clienteEntity.setCpf("333.111.000-88");
        Assert.assertTrue(clienteEntity.getCpf() == "333.111.000-88");
    }

    @Test
    public void testGetterClienteCpf_Falha(){
        clienteEntity.setCpf("333.111.000-88");
        Assert.assertFalse(clienteEntity.getCpf() == "333.222.111-00");
    }

    @Test
    public void testGetterTelefone_Sucesso(){
        clienteEntity.setTelefone("+551930004000");
        Assert.assertTrue(clienteEntity.getTelefone() == "+551930004000");
    }

    @Test
    public void testGetterTelefone_Falha(){
        clienteEntity.setTelefone("+551930004000");
        Assert.assertFalse(clienteEntity.getTelefone() == "+551932004200");
    }

    @Test
    public void testGetterEmail_Sucesso(){
        clienteEntity.setEmail("test@test.com");
        Assert.assertTrue(clienteEntity.getEmail() == "test@test.com");
    }

    @Test
    public void testGetterEmail_Falha(){
        clienteEntity.setEmail("test@test.com");
        Assert.assertFalse(clienteEntity.getEmail() == "tilt@test.com");
    }

    @Test
    public void testGetterEndereco_Sucesso(){
        clienteEntity.setEndereco("R. Teste, 245 - Bairro Teste, São Paulo, Brasil");
        Assert.assertTrue(clienteEntity.getEndereco() == "R. Teste, 245 - Bairro Teste, São Paulo, Brasil");
    }

    @Test
    public void testGetterEndereco_Falha(){
        clienteEntity.setEndereco("R. Teste, 245 - Bairro Teste, São Paulo, Brasil");
        Assert.assertFalse(clienteEntity.getEndereco() == "Av. Testing - Bairro Teste, São Paulo, Brasil");
    }

    @Test
    public void testGetterTipo_Sucesso(){
        clienteEntity.setTipo("admin");
        Assert.assertTrue(clienteEntity.getTipo() == "admin");
    }

    @Test
    public void testGetterTipo_Falha(){
        clienteEntity.setTipo("admin");
        Assert.assertFalse(clienteEntity.getTipo() == "user");
    }
}
