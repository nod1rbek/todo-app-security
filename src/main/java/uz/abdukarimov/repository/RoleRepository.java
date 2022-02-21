package uz.abdukarimov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.abdukarimov.entity.role.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
