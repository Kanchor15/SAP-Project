package Okan.Project.services;

import Okan.Project.commands.SaleForm;
import Okan.Project.converters.SaleFormToSale;
import Okan.Project.entities.Sale;
import Okan.Project.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService
{
    private final SaleRepository saleRepository;
    private final SaleFormToSale saleFormToSale;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, SaleFormToSale saleFormToSale)
    {
        this.saleRepository = saleRepository;
        this.saleFormToSale = saleFormToSale;
    }

    @Override
    public List<Sale> listAll()
    {
        return (List<Sale>) saleRepository.findAll();
    }

    @Override
    public Sale getById(Long id)
    {
        return saleRepository.findById(id).orElse(null);
    }

    @Override
    public Sale saveOrUpdate(Sale sale)
    {
        saleRepository.save(sale);
        return null;
    }

    @Override
    public void delete(Long id)
    {
        saleRepository.deleteById(id);

    }

    @Override
    public Sale saveOrUpdateSaleForm(SaleForm saleForm)
    {
        return saveOrUpdate(saleFormToSale.convert(saleForm));
    }
}