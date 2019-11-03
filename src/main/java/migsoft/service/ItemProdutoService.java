package migsoft.service;

import migsoft.model.ItemProduto;
import migsoft.model.response.ItemProdutoResponse;

import java.util.List;

public interface ItemProdutoService {
     ItemProdutoResponse findById(Integer id);
     List<ItemProdutoResponse> findAll();
     ItemProdutoResponse save(ItemProduto item);
     ItemProdutoResponse update(ItemProduto item);
     void deleteById(Integer id);
}
