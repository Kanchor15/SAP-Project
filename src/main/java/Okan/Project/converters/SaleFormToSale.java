package Okan.Project.converters;

import Okan.Project.commands.SaleForm;
import Okan.Project.entities.Sale;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class SaleFormToSale implements Converter<SaleForm, Sale>
{
    @Override
    public Sale convert(SaleForm saleForm)
    {
        Sale sale = new Sale();
        if (saleForm.getId() != null  && !StringUtils.isEmpty(saleForm.getId()))
        {
            sale.setId(saleForm.getId());
        }
        sale.setRepresentative(saleForm.getRepresentative());
        sale.setClient(saleForm.getClient());
        sale.setProduct(saleForm.getProduct());
        sale.setPrice(saleForm.getPrice());
        sale.setQuantity(saleForm.getQuantity());
        sale.setValue(saleForm.getValue());
        sale.setDate(saleForm.getDate());
        return sale;
    }
}
