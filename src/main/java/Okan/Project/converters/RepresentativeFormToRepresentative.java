package Okan.Project.converters;

import Okan.Project.commands.RepresentativeForm;
import Okan.Project.entities.Representative;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class RepresentativeFormToRepresentative implements Converter<RepresentativeForm, Representative>
{
    @Override
    public Representative convert(RepresentativeForm representativeForm)
    {
        Representative representative = new Representative();
        if (representativeForm.getId() != null  && !StringUtils.isEmpty(representativeForm.getId()))
        {
            representative.setId(representativeForm.getId());
        }
        representative.setUsername(representativeForm.getUsername());
        representative.setPassword(representativeForm.getPassword());
        return representative;
    }
}
