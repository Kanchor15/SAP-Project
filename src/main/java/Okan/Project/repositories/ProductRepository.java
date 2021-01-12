package Okan.Project.repositories;

import Okan.Project.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>
{
}