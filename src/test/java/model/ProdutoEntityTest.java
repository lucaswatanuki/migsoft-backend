package model;

import migsoft.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProdutoEntityTest {

    private ProdutoEntity produtoEntity;
    private List<ItemVendaEntity> itensVendaExpected;
    private List<EstoqueEntity> estoquesExpected;
    private List<CotacaoEntity> cotacoesExpected;
    private List<PedidoEntity> pedidosExpected;

    @Before
    public void setUp() {
        produtoEntity = new ProdutoEntity();

        itensVendaExpected = new ArrayList<>();
        itensVendaExpected.add(new ItemVendaEntity(1,10,null,null));

        estoquesExpected = new ArrayList<>();
        estoquesExpected.add(new EstoqueEntity(1,null,10));

        cotacoesExpected = new ArrayList<>();
        cotacoesExpected.add(new CotacaoEntity(1,10.00,null,null,"01-10-2019"));

        pedidosExpected = new ArrayList<>();
        pedidosExpected.add(new PedidoEntity(1,"01-10-2019",null,null,10.00));
    }

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

    @Test
    public void testGetterItemVendaProduto_Sucesso(){
        List<ItemVendaEntity> itemVendaTeste = new ArrayList<>();
        itemVendaTeste.add(new ItemVendaEntity(1,10,null,null));
        itemVendaTeste.forEach(itemVendaEntity -> {
            int i = 0;
            Assert.assertEquals(itemVendaTeste.get(i).getId(), itensVendaExpected.get(i).getId());
            Assert.assertEquals(itemVendaTeste.get(i).getQuantidade(), itensVendaExpected.get(i).getQuantidade());
        });
    }

    @Test
    public void testGetterItemVendaProduto_Falha(){
        List<ItemVendaEntity> itemVendaTeste = new ArrayList<>();
        itemVendaTeste.add(new ItemVendaEntity(2,15,null,null));
        itemVendaTeste.forEach(itemVendaEntity -> {
            int i = 0;
            Assert.assertNotEquals(itemVendaTeste.get(i).getId(), itensVendaExpected.get(i).getId());
            Assert.assertNotEquals(itemVendaTeste.get(i).getQuantidade(), itensVendaExpected.get(i).getQuantidade());
        });
    }

    @Test
    public void testGetterEstoqueProdutoSucesso(){
        List<EstoqueEntity> estoqueTeste = new ArrayList<>();
        estoqueTeste.add(new EstoqueEntity(1,null,10));
        estoqueTeste.forEach(estoqueEntity -> {
            int i = 0;
            Assert.assertEquals(estoqueTeste.get(i).getId(),estoquesExpected.get(i).getId());
            Assert.assertEquals(estoqueTeste.get(i).getQuantidade(), estoquesExpected.get(i).getQuantidade());
        });
    }

    @Test
    public void testGetterEstoqueProdutoFalha(){
        List<EstoqueEntity> estoqueTeste = new ArrayList<>();
        estoqueTeste.add(new EstoqueEntity(2,null,20));
        estoqueTeste.forEach(estoqueEntity -> {
            int i = 0;
            Assert.assertNotEquals(estoqueTeste.get(i).getId(),estoquesExpected.get(i).getId());
            Assert.assertNotEquals(estoqueTeste.get(i).getQuantidade(), estoquesExpected.get(i).getQuantidade());
        });
    }

    @Test
    public void testGetterCotacaoProduto_Sucesso(){
        List<CotacaoEntity> cotacaoTeste = new ArrayList<>();
        cotacaoTeste.add(new CotacaoEntity(1,10.00,null,null,"01-10-2019"));
        cotacaoTeste.forEach(cotacaoEntity -> {
            int i = 0;
            Assert.assertEquals(cotacaoTeste.get(i).getId(), cotacoesExpected.get(i).getId());
            Assert.assertEquals(cotacaoTeste.get(i).getPreco(), cotacoesExpected.get(i).getPreco(),0.0);
            Assert.assertEquals(cotacaoTeste.get(i).getData(), cotacoesExpected.get(i).getData());
        });
    }

    @Test
    public void testGetterCotacaoProduto_Falha(){
        List<CotacaoEntity> cotacaoTeste = new ArrayList<>();
        cotacaoTeste.add(new CotacaoEntity(2,15.00,null,null,"10-10-2019"));
        cotacaoTeste.forEach(cotacaoEntity -> {
            int i = 0;
            Assert.assertNotEquals(cotacaoTeste.get(i).getId(), cotacoesExpected.get(i).getId());
            Assert.assertNotEquals(cotacaoTeste.get(i).getPreco(), cotacoesExpected.get(i).getPreco(),0.0);
            Assert.assertNotEquals(cotacaoTeste.get(i).getData(), cotacoesExpected.get(i).getData());
        });
    }

    @Test
    public void testGetterPedidoProduto_Sucesso(){
        List<PedidoEntity> pedidoTeste = new ArrayList<>();
        pedidoTeste.add(new PedidoEntity(1,"01-10-2019",null,null,10.00));
        pedidoTeste.forEach(pedidoEntity -> {
            int i = 0;
            Assert.assertEquals(pedidoTeste.get(i).getId(), pedidosExpected.get(i).getId());
            Assert.assertEquals(pedidoTeste.get(i).getData(), pedidosExpected.get(i).getData());
            Assert.assertEquals(pedidoTeste.get(i).getTotal(), pedidosExpected.get(i).getTotal(),0.0);
        });
    }

    @Test
    public void testGetterPedidoProduto_Falha(){
        List<PedidoEntity> pedidoTeste = new ArrayList<>();
        pedidoTeste.add(new PedidoEntity(2,"10-10-2019",null,null,15.00));
        pedidoTeste.forEach(pedidoEntity -> {
            int i = 0;
            Assert.assertNotEquals(pedidoTeste.get(i).getId(), pedidosExpected.get(i).getId());
            Assert.assertNotEquals(pedidoTeste.get(i).getData(), pedidosExpected.get(i).getData());
            Assert.assertNotEquals(pedidoTeste.get(i).getTotal(), pedidosExpected.get(i).getTotal(),0.0);
        });
    }

}
