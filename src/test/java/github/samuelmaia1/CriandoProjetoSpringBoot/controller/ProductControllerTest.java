package github.samuelmaia1.CriandoProjetoSpringBoot.controller;

import com.github.javafaker.Faker;
import github.samuelmaia1.CriandoProjetoSpringBoot.model.Product;
import github.samuelmaia1.CriandoProjetoSpringBoot.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController;

    private Faker faker = new Faker();

    public ProductControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProduct() {
        String fakeName = faker.commerce().productName();
        String fakeDescription = faker.lorem().sentence();
        Double fakePrice = faker.number().randomDouble(2, 10, Integer.MAX_VALUE);
        ResponseEntity<Product> response = productController
                .createProduct(
                        new Product(
                                fakeName,
                                fakeDescription,
                                fakePrice)
                );
        Product product = response.getBody();
        String id = product.getId();

        Product productTest = new Product(
                fakeName,
                fakeDescription,
                fakePrice
        );
        productTest.setId(id);

        assertNotNull(product);
        assertEquals(201,
                response.getStatusCodeValue(),
                "O produto é criado e retorna um status de criado");
        assertEquals(productTest,
                response.getBody(),
                "O método deve criar o produto e retorná-lo");
    }

    @Test
    void createProductInvalidData(){

    }

    @Test
    void getProducts() {
    }

    @Test
    void getProductById() {
    }
}