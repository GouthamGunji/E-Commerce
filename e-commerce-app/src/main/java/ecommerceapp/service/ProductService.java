package ecommerceapp.service;

import ecommerceapp.exception.ProductDetailsNotFoundException;
import ecommerceapp.model.Product;
import ecommerceapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static final String PRODUCT_NOT_FOUND = " : Products not available";
    private static final String PRODUCT_UPDATE_SUCCESS_MSG = "Product Details Saved Successfully";

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProduts() {
        return repository.findAll();
    }

    public List<Product> getByProductName(String productName) throws ProductDetailsNotFoundException {
        return Optional.ofNullable(repository.findByProductName(productName))
                .orElseThrow(() ->
                        new ProductDetailsNotFoundException(productName + PRODUCT_NOT_FOUND));
    }

    public Product getByProductId(Integer id) throws ProductDetailsNotFoundException {
        return Optional.ofNullable(repository.findById(id).get())
                .orElseThrow(() ->
                        new ProductDetailsNotFoundException(id + PRODUCT_NOT_FOUND));
    }

    public String createProduct(Product product) {
        return saveOrUpdateProduct(product);
    }

    public String updatProductName(Integer productId, String productName) throws ProductDetailsNotFoundException {
        Product product = getByProductId(productId);
        product.setProductName(productName);
        return saveOrUpdateProduct(product);
    }

    public String updatProductMsrp(Integer productId, Double msrp) throws ProductDetailsNotFoundException {
        Product product = getByProductId(productId);
        product.setMsrp(msrp);
        return saveOrUpdateProduct(product);
    }

    public String updateProductQuantity(Integer productId, Integer quantity) throws ProductDetailsNotFoundException {
        Product product = getByProductId(productId);
        product.setQuantityInStock(quantity);
        return saveOrUpdateProduct(product);
    }

    public String updateProductVendor(Integer productId, String vendor) throws ProductDetailsNotFoundException {
        Product product = getByProductId(productId);
        product.setProductVendor(vendor);
        return saveOrUpdateProduct(product);
    }

    private String saveOrUpdateProduct(Product product) {
        repository.save(product);
        return PRODUCT_UPDATE_SUCCESS_MSG;
    }

    public String deleteProductById(Integer id) {
        repository.deleteById(id);
        return "Product Deleted Successfully";
    }
}
