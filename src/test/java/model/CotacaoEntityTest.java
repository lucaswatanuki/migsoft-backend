package model;

import migsoft.model.CotacaoEntity;
import migsoft.model.FornecedorEntity;
import migsoft.model.ProdutoEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CotacaoEntityTest {

    public CotacaoEntity cotacaoEntity;
    public List<ProdutoEntity> produtosExpected;
    public List<FornecedorEntity> fornecedorExpected;

    @Before
    public void setUp(){
        cotacaoEntity = new CotacaoEntity();
        produtosExpected = new ArrayList<>();
        produtosExpected.add(new ProdutoEntity(1,"produto",10.00));
        fornecedorExpected = new ArrayList<>();
        fornecedorExpected.add(new FornecedorEntity("01.033.574/0001-29","teste"));
    }


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

    @Test
    public void testGetterVendaProdutos_Sucesso(){
        List<ProdutoEntity> produtoTeste = new ArrayList<>();
        produtoTeste.add(new ProdutoEntity(1,"produto",10.00));
        produtoTeste.forEach(produtoEntity -> {
            int i = 0;
            Assert.assertEquals(produtoTeste.get(i).getId(), produtosExpected.get(i).getId());
            Assert.assertEquals(produtoTeste.get(i).getNome(), produtosExpected.get(i).getNome());
            Assert.assertEquals(produtoTeste.get(i).getPreco(), produtosExpected.get(i).getPreco(), 0.0);
            i++;
        });
    }

    @Test
    public void testGetterVendaProdutos_Falha(){
        List<ProdutoEntity> produtoTeste = new ArrayList<>();
        produtoTeste.add(new ProdutoEntity(2,"test",15.00));
        produtoTeste.forEach(produtoEntity -> {
            int i = 0;
            Assert.assertNotEquals(produtoTeste.get(i).getId(),produtosExpected.get(i).getId());
            Assert.assertNotEquals(produtoTeste.get(i).getNome(), produtosExpected.get(i).getNome());
            Assert.assertNotEquals(produtoTeste.get(i).getPreco(), produtosExpected.get(i).getPreco());
            i++;
        });
    }

    @Test
    public void testGetterFornecedorProdutos_Sucesso(){
        List<FornecedorEntity> fornecedorTeste = new ArrayList<>();
        fornecedorTeste.add(new FornecedorEntity("01.033.574/0001-29","teste"));
        fornecedorTeste.forEach(fornecedorEntity -> {
            int i = 0;
            Assert.assertEquals(fornecedorTeste.get(i).getCnpj(),fornecedorExpected.get(i).getCnpj());
            Assert.assertEquals(fornecedorTeste.get(i).getNomeFantasia(), fornecedorExpected.get(i).getNomeFantasia());
            i++;
        });
    }

    @Test
    public void testGetterFornecedorProdutos_Falha(){
        List<FornecedorEntity> fornecedorTeste = new ArrayList<>();
        fornecedorTeste.add(new FornecedorEntity("01.033.574/0001-30", "produto"));
        fornecedorTeste.forEach(fornecedorEntity -> {
            int i = 0;
            Assert.assertNotEquals(fornecedorTeste.get(i).getCnpj(), fornecedorExpected.get(i).getCnpj());
            Assert.assertNotEquals(fornecedorTeste.get(i).getNomeFantasia(), fornecedorExpected.get(i).getNomeFantasia());
            i++;
        });
    }

}
