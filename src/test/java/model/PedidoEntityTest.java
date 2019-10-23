package model;

import migsoft.model.FornecedorEntity;
import migsoft.model.PedidoEntity;
import migsoft.model.ProdutoEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PedidoEntityTest {

    private PedidoEntity pedidoExpected;
    private List<ProdutoEntity> produtosExpected;
    private List<FornecedorEntity> fornecedorExpected;

    @Before
    public void setUp(){
        pedidoExpected = new PedidoEntity(1,"01-10-2019",null,null,10.00);

        produtosExpected = new ArrayList<>();
        produtosExpected.add(new ProdutoEntity(1,"produto",10.00,null,null,null,null));

        fornecedorExpected = new ArrayList<>();
        fornecedorExpected.add(new FornecedorEntity("01.033.574/0001-29","nome_empresa"));
    }

    @Test
    public void testGetterIdPedido_Sucesso(){
        Assert.assertEquals(1, pedidoExpected.getId());
    }

    @Test
    public void testGetterIdPedido_Falha(){
        Assert.assertNotEquals(null, pedidoExpected.getId());
    }

    @Test
    public void testGetterDataPedido_sucesso(){
        Assert.assertSame("01-10-2019", pedidoExpected.getData());
    }

    @Test
    public void testGetterDataPedido_Falha(){
        Assert.assertNotSame(null, pedidoExpected.getData());
    }

    @Test
    public void testGetterTotalPedido_Sucesso(){
        Assert.assertEquals(10.00, pedidoExpected.getTotal(),0.0);
    }

    @Test
    public void testGetterTotalPedido_Falha(){
        Assert.assertNotEquals(null,pedidoExpected.getTotal());
    }

    @Test
    public void testGetterProdutoPedido_Sucesso(){
        List<ProdutoEntity> produtoTeste = new ArrayList<>();
        produtoTeste.add(new ProdutoEntity(1,"produto",10.00,null,null,null,null));
        produtoTeste.forEach(produtoEntity -> {
            int i = 0;
            Assert.assertEquals(produtoTeste.get(i).getId(),produtosExpected.get(i).getId());
            Assert.assertEquals(produtoTeste.get(i).getNome(),produtosExpected.get(i).getNome());
            Assert.assertEquals(produtoTeste.get(i).getPreco(),produtosExpected.get(i).getPreco(), 0.0);
            i++;
        });
    }

    @Test
    public void testGetterProdutoPedido_Falha(){
        List<ProdutoEntity> produtoTeste = new ArrayList<>();
        produtoTeste.add(new ProdutoEntity(2,"teste",20.00,null,null,null,null));
        produtoTeste.forEach(produtoEntity -> {
            int i = 0;
            Assert.assertNotEquals(produtoTeste.get(i).getId(),produtosExpected.get(i).getId());
            Assert.assertNotEquals(produtoTeste.get(i).getNome(),produtosExpected.get(i).getNome());
            Assert.assertNotEquals(produtoTeste.get(i).getPreco(),produtosExpected.get(i).getPreco());
            i++;
        });
    }

    @Test
    public void testGetterFornecedorPedido_Sucesso(){
        List<FornecedorEntity> fornecedorTeste = new ArrayList<>();
        fornecedorTeste.add(new FornecedorEntity("01.033.574/0001-29","nome_empresa"));
        fornecedorTeste.forEach(fornecedorEntity -> {
            int i = 0;
            Assert.assertEquals(fornecedorTeste.get(i).getNomeFantasia(), fornecedorExpected.get(i).getNomeFantasia());
            Assert.assertEquals(fornecedorTeste.get(i).getCnpj(),fornecedorExpected.get(i).getCnpj());
        });
    }

    @Test
    public void testGetterFornecedorPedido_Falha(){
        List<FornecedorEntity> fornecedorTeste = new ArrayList<>();
        fornecedorTeste.add(new FornecedorEntity(null,"teste"));
        fornecedorTeste.forEach(fornecedorEntity -> {
            int i = 0;
            Assert.assertNotEquals(fornecedorTeste.get(i).getNomeFantasia(), fornecedorExpected.get(i).getNomeFantasia());
            Assert.assertNotEquals(fornecedorTeste.get(i).getCnpj(),fornecedorExpected.get(i).getCnpj());
        });
    }
}
