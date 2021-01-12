package Okan.Project.repositories;

import Okan.Project.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>
{
}
