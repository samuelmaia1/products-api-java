package github.samuelmaia1.CriandoProjetoSpringBoot.repository;

import github.samuelmaia1.CriandoProjetoSpringBoot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
