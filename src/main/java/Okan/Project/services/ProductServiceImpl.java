package Okan.Project.services;

import Okan.Project.commands.ProductForm;
import Okan.Project.converters.ProductFormToProduct;
import Okan.Project.entities.Product;
import Okan.Project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;
    private final ProductFormToProduct productFormToProduct;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductFormToProduct productFormToProduct)
    {
        this.productRepository = productRepository;
        this.productFormToProduct = productFormToProduct;
    }

    @Override
    public List<Product> listAll()
    {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getById(Long id)
    {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveOrUpdate(Product product)
    {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(Long id)
    {
        productRepository.deleteById(id);

    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm)
    {
        return saveOrUpdate(productFormToProduct.convert(productForm));
    }
}