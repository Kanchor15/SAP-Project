package Okan.Project.converters;

import Okan.Project.commands.SaleForm;
import Okan.Project.entities.Sale;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.stereotype.Component;

@Component
public class SaleToSaleForm implements Converter<Sale, SaleForm>
{
    @Override
    public SaleForm convert(Sale sale)
    {
        SaleForm saleForm = new SaleForm();
        saleForm.setId(sale.getId());
        saleForm.setRepresentative(sale.getRepresentative());
        saleForm.setClient(sale.getClient());
        saleForm.setProduct(sale.getProduct());
        saleForm.setPrice(sale.getPrice());
        saleForm.setQuantity(sale.getQuantity());
        saleForm.setValue(sale.getValue());
        saleForm.setDate(sale.getDate());
        return saleForm;
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