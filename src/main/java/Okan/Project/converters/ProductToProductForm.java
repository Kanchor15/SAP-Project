package Okan.Project.converters;

import Okan.Project.commands.ProductForm;
import Okan.Project.entities.Product;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductForm implements Converter<Product, ProductForm>
{
    @Override
    public ProductForm convert(Product product)
    {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId());
        productForm.setName(product.getName());
        productForm.setPrice(product.getPrice());
        productForm.setQuantity(product.getQuantity());
        return productForm;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory)
    {
        return null;
    }
    @Override
    public JavaType getOutputType(TypeFactory typeFactory)
    {
        return null;
    }
}
