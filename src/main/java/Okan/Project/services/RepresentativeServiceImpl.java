package Okan.Project.services;

import Okan.Project.commands.RepresentativeForm;
import Okan.Project.converters.RepresentativeFormToRepresentative;
import Okan.Project.entities.Representative;
import Okan.Project.repositories.RepresentativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RepresentativeServiceImpl implements RepresentativeService
{
    private final RepresentativeRepository representativeRepository;
    private final RepresentativeFormToRepresentative representativeFormToRepresentative;

    @Autowired
    public RepresentativeServiceImpl(RepresentativeRepository representativeRepository, RepresentativeFormToRepresentative representativeFormToRepresentative)
    {
        this.representativeRepository = representativeRepository;
        this.representativeFormToRepresentative = representativeFormToRepresentative;
    }

    @Override
    public List<Representative> listAll()
    {
        return (List<Representative>) representativeRepository.findAll();
    }

    @Override
    public Representative getById(Long id)
    {
        return representativeRepository.findById(id).orElse(null);
    }

    @Override
    public Representative saveOrUpdate(Representative representative)
    {
        representativeRepository.save(representative);
        return representative;
    }

    @Override
    public void delete(Long id)
    {
        representativeRepository.deleteById(id);

    }

    @Override
    public Representative saveOrUpdateRepresentativeForm(RepresentativeForm representativeForm)
    {
        return saveOrUpdate(representativeFormToRepresentative.convert(representativeForm));
    }
}