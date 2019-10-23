package model;

import migsoft.model.CotacaoEntity;
import migsoft.model.FornecedorEntity;
import migsoft.model.PedidoEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FornecedorEntityTest {

    private FornecedorEntity fornecedorEntity;
    private List<CotacaoEntity> cotacoesExpected;
    private List<PedidoEntity> pedidosExpected;

    @Before
    public void setUp(){
        fornecedorEntity = new FornecedorEntity();

        cotacoesExpected = new ArrayList<>();
        cotacoesExpected.add(new CotacaoEntity(1,10.00,null,null,"01-10-2019"));

        pedidosExpected = new ArrayList<>();
        pedidosExpected.add(new PedidoEntity(1,"01-10-2019",null,null,10));
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

    @Test
    public void testGetterCotacaoFornecedor_Sucesso(){
        List<CotacaoEntity> cotacaoTeste = new ArrayList<>();
        cotacaoTeste.add(new CotacaoEntity(1,10.00,null,null, "01-10-2019"));
        cotacaoTeste.forEach(cotacaoEntity -> {
            int i = 0;
            Assert.assertEquals(cotacaoTeste.get(i).getId(),    cotacoesExpected.get(i).getId());
            Assert.assertEquals(cotacaoTeste.get(i).getPreco(), cotacoesExpected.get(i).getPreco(),0.0);
            Assert.assertEquals(cotacaoTeste.get(i).getData(),  cotacoesExpected.get(i).getData());
            i++;
        });
    }

    @Test
    public void testGetterCotacaoFornecedor_Falha(){
        List<CotacaoEntity> cotacaoTeste = new ArrayList<>();
        cotacaoTeste.add(new CotacaoEntity(2,15.00,null,null,"10-10-2019"));
        cotacaoTeste.forEach(cotacaoEntity -> {
            int i = 0;
            Assert.assertNotEquals(cotacaoTeste.get(i).getId(),    cotacoesExpected.get(i).getId());
            Assert.assertNotEquals(cotacaoTeste.get(i).getPreco(), cotacoesExpected.get(i).getPreco(),0.0);
            Assert.assertNotEquals(cotacaoTeste.get(i).getData(),  cotacoesExpected.get(i).getData());
            i++;
        });
    }

    @Test
    public void testGetterPedidoFornecedor_Sucesso(){
        List<PedidoEntity> pedidoTeste = new ArrayList<>();
        pedidoTeste.add(new PedidoEntity(1,"01-10-2019",null,null,10));
        pedidoTeste.forEach(pedidoEntity -> {
            int i = 0;
            Assert.assertEquals(pedidoTeste.get(i).getId(), pedidosExpected.get(i).getId());
            Assert.assertEquals(pedidoTeste.get(i).getData(), pedidosExpected.get(i).getData());
            Assert.assertEquals(pedidoTeste.get(i).getTotal(), pedidosExpected.get(i).getTotal(),0.0);
            i++;
        });
    }

    @Test
    public void testGetterPedidoFornecedor_Falha(){
        List<PedidoEntity> pedidoTeste = new ArrayList<>();
        pedidoTeste.add(new PedidoEntity(2,"10-10-2019",null,null,20));
        pedidoTeste.forEach(pedidoEntity -> {
            int i = 0;
            Assert.assertNotEquals(pedidoTeste.get(i).getId(), pedidosExpected.get(i).getId());
            Assert.assertNotEquals(pedidoTeste.get(i).getData(), pedidosExpected.get(i).getData());
            Assert.assertNotEquals(pedidoTeste.get(i).getTotal(), pedidosExpected.get(i).getTotal(),0.0);
            i++;
        });
    }

}
