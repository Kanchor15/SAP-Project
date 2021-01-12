package Okan.Project.services;

import Okan.Project.commands.SaleForm;
import Okan.Project.entities.Sale;
import java.util.List;

public interface SaleService
{
    List<Sale> listAll();

    Sale getById(Long id);

    Sale saveOrUpdate(Sale sale);

    void delete(Long id);

    Sale saveOrUpdateSaleForm(SaleForm saleForm);
}

