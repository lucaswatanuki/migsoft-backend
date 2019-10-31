package migsoft.service;

import migsoft.model.ItemProduto;

import java.util.List;

public interface ItemVendaService {
     ItemProduto findById(int id);
     List<ItemProduto> findAll();
     ItemProduto save(ItemProduto item);
     ItemProduto update(ItemProduto item);
     void deleteById(int id);
}
