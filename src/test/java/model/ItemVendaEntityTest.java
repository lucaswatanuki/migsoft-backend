package model;

import migsoft.model.ItemVendaEntity;
import migsoft.model.ProdutoEntity;
import migsoft.model.VendaEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ItemVendaEntityTest {

    public ItemVendaEntity itemVendaEntity;
    public List<ProdutoEntity> produtosExpected;
    public List<VendaEntity> vendasExpected;

    @Before
    public void setUp(){
        itemVendaEntity = new ItemVendaEntity();

        produtosExpected = new ArrayList<>();
        produtosExpected.add(new ProdutoEntity(1,"produto",10,null,null,null,null));

        vendasExpected = new ArrayList<>();
        vendasExpected.add(new VendaEntity(1, "01-10-2019", null, null, 10));
    }

    @Test
    public void testItemVendaId_Sucesso(){
        itemVendaEntity.setId(1);
        Assert.assertTrue(itemVendaEntity.getId() == 1);
    }

    @Test
    public void testItemVendaId_Falha(){
        itemVendaEntity.setId(1);
        Assert.assertFalse(itemVendaEntity.getId() == 2);
    }

    @Test
    public void testItemVendaQtd_Sucesso(){
        itemVendaEntity.setQuantidade(10);
        Assert.assertTrue(itemVendaEntity.getQuantidade() == 10);
    }

    @Test
    public void testItemVendaQtd_Falha(){
        itemVendaEntity.setQuantidade(10);
        Assert.assertFalse(itemVendaEntity.getId() == 15);
    }

    @Test
    public void testGetterProdutosItemVenda_Sucesso(){
        List<ProdutoEntity> produtoTeste = new ArrayList<>();
        produtoTeste.add(new ProdutoEntity(1,"produto",10,null,null,null,null));
        produtoTeste.forEach(produtoEntity -> {
            int i = 0;
            Assert.assertEquals(produtoTeste.get(i).getId(), produtosExpected.get(i).getId());
            Assert.assertEquals(produtoTeste.get(i).getNome(), produtosExpected.get(i).getNome());
            Assert.assertEquals(produtoTeste.get(i).getPreco(), produtosExpected.get(i).getPreco(),0.0);
            i++;
        });
    }

    @Test
    public void testGetterProdutosItemVenda_Falha(){
        List<ProdutoEntity> produtoTeste = new ArrayList<>();
        produtoTeste.add(new ProdutoEntity(2,"teste",15,null,null,null,null));
        produtoTeste.forEach(produtoEntity -> {
            int i = 0;
            Assert.assertNotEquals(produtoTeste.get(i).getId(), produtosExpected.get(i).getId());
            Assert.assertNotEquals(produtoTeste.get(i).getNome(), produtosExpected.get(i).getNome());
            Assert.assertNotEquals(produtoTeste.get(i).getPreco(), produtosExpected.get(i).getPreco(),0.0);
            i++;
        });
    }

    @Test
    public void testGetterVendaItemVenda_Sucesso(){
        List<VendaEntity> vendaTeste = new ArrayList<>();
        vendaTeste.add(new VendaEntity(1, "01-10-2019", null, null, 10));
        vendaTeste.forEach(vendaEntity -> {
            int i = 0;
            Assert.assertEquals(vendaTeste.get(i).getId(), vendasExpected.get(i).getId());
            Assert.assertEquals(vendaTeste.get(i).getData(), vendasExpected.get(i).getData());
            Assert.assertEquals(vendaTeste.get(i).getTotal(), vendasExpected.get(i).getTotal(),0.0);
            i++;
        });
    }

    @Test
    public void testGetterVendaItemVenda_Falha(){
        List<VendaEntity> vendaTeste = new ArrayList<>();
        vendaTeste.add(new VendaEntity(2, "10-10-2019", null, null, 20));
        vendaTeste.forEach(vendaEntity -> {
            int i = 0;
            Assert.assertNotEquals(vendaTeste.get(i).getId(), vendasExpected.get(i).getId());
            Assert.assertNotEquals(vendaTeste.get(i).getData(), vendasExpected.get(i).getData());
            Assert.assertNotEquals(vendaTeste.get(i).getTotal(), vendasExpected.get(i).getTotal(),0.0);
            i++;
        });
    }
}
