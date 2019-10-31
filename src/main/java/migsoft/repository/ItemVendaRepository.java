package migsoft.repository;

import migsoft.model.ItemProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemProduto, Integer> {
    ItemProduto findById(int id);
    List<ItemProduto> findAll();
    void delete(ItemProduto item);
}
