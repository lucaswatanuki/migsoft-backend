package model;

import migsoft.model.ClienteEntity;
import migsoft.model.ItemVendaEntity;
import migsoft.model.VendaEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VendaEntityTest {

    private VendaEntity vendaExpected;
    private List<ClienteEntity> clientesExpected;
    private List<ItemVendaEntity> itensVendaExpected;

    @Before
    public void setUp(){
        vendaExpected = new VendaEntity(1,"01-10-2019",null,null,10.00);

        clientesExpected = new ArrayList<>();
        clientesExpected.add(new ClienteEntity("admin"));

        itensVendaExpected = new ArrayList<>();
        itensVendaExpected.add(new ItemVendaEntity(1,10,null,null));
    }

    @Test
    public void testGetterIdVenda_Sucesso(){
        Assert.assertEquals(1,vendaExpected.getId());
    }

    @Test
    public void testGetterIdVenda_Falha(){
        Assert.assertNotEquals(null,vendaExpected.getId());
    }

    @Test
    public void testGetterDataVenda_Sucesso(){
        Assert.assertEquals("01-10-2019",vendaExpected.getData());
    }

    @Test
    public void testGetterDataVenda_Falha(){
        Assert.assertNotEquals(null,vendaExpected.getData());
    }

    @Test
    public void testGetterTotalVenda_Sucesso(){
        Assert.assertEquals(10.00,vendaExpected.getTotal(),0.0);
    }

    @Test
    public void testGetterTotalVenda_Falha(){
        Assert.assertNotEquals(null,vendaExpected.getTotal());
    }

    @Test
    public void testGetterClienteVenda_Sucesso(){
        List<ClienteEntity> clienteTeste = new ArrayList<>();
        clienteTeste.add(new ClienteEntity("admin"));
        clienteTeste.forEach(clienteEntity -> {
            int i = 0;
            Assert.assertEquals(clienteTeste.get(i).getTipo(),clientesExpected.get(i).getTipo());
        });
    }

    @Test
    public void testGetterClienteVenda_Falha(){
        List<ClienteEntity> clienteTeste = new ArrayList<>();
        clienteTeste.add(new ClienteEntity(null));
        clienteTeste.forEach(clienteEntity -> {
            int i = 0;
            Assert.assertNotEquals(clienteTeste.get(i).getTipo(),clientesExpected.get(i).getTipo());
        });
    }

    @Test
    public void testGetterItemVendaVenda_Sucesso(){
        List<ItemVendaEntity> itemVendaTeste = new ArrayList<>();
        itemVendaTeste.add(new ItemVendaEntity(1,10,null,null));
        itemVendaTeste.forEach(itemVendaEntity -> {
            int i = 0;
            Assert.assertEquals(itemVendaTeste.get(i).getId(),itensVendaExpected.get(i).getId());
            Assert.assertEquals(itemVendaTeste.get(i).getQuantidade(), itensVendaExpected.get(i).getQuantidade());
        });
    }

    @Test
    public void testGetterItemVendaVenda_Falha(){
        List<ItemVendaEntity> itemVendaTeste = new ArrayList<>();
        itemVendaTeste.add(new ItemVendaEntity(2,20,null,null));
        itemVendaTeste.forEach(itemVendaEntity -> {
            int i = 0;
            Assert.assertNotEquals(itemVendaTeste.get(i).getId(),itensVendaExpected.get(i).getId());
            Assert.assertNotEquals(itemVendaTeste.get(i).getQuantidade(), itensVendaExpected.get(i).getQuantidade());
        });
    }
}
