package Okan.Project.converters;

import Okan.Project.commands.RepresentativeForm;
import Okan.Project.entities.Representative;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.stereotype.Component;

@Component
public class RepresentativeToRepresentativeForm implements Converter<Representative, RepresentativeForm>
{
    @Override
    public RepresentativeForm convert(Representative representative)
    {
        RepresentativeForm representativeForm = new RepresentativeForm();
        representativeForm.setId(representative.getId());
        representativeForm.setUsername(representative.getUsername());
        representativeForm.setPassword(representative.getPassword());
        return representativeForm;
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
