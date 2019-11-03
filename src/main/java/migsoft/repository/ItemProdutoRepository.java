package migsoft.repository;

import migsoft.model.ItemProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemProdutoRepository extends JpaRepository<ItemProduto, Integer> {

}
