package Okan.Project.repositories;

import Okan.Project.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long>
{
}
