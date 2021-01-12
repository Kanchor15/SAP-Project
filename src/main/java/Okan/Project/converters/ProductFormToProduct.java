package Okan.Project.converters;

import Okan.Project.commands.ProductForm;
import Okan.Project.entities.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ProductFormToProduct implements Converter<ProductForm, Product>
{
    @Override
    public Product convert(ProductForm productForm)
    {
        Product product = new Product();
        if (productForm.getId() != null  && !StringUtils.isEmpty(productForm.getId()))
        {
            product.setId(productForm.getId());
        }
        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());
        product.setQuantity(productForm.getQuantity());
        return product;
    }
}
