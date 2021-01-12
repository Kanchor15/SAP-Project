package Okan.Project.services;

import Okan.Project.commands.ProductForm;
import Okan.Project.entities.Product;
import java.util.List;

public interface ProductService
{
    List<Product> listAll();

    Product getById(Long id);

    Product saveOrUpdate(Product product);

    void delete(Long id);

    Product saveOrUpdateProductForm(ProductForm productForm);
}
