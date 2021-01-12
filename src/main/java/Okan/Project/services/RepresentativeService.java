package Okan.Project.services;

import Okan.Project.commands.RepresentativeForm;
import Okan.Project.entities.Representative;
import java.util.List;

public interface RepresentativeService
{
    List<Representative> listAll();

    Representative getById(Long id);

    Representative saveOrUpdate(Representative representative);

    void delete(Long id);

    Representative saveOrUpdateRepresentativeForm(RepresentativeForm representativeForm);
}