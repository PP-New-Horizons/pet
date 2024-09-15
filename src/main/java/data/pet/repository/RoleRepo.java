package data.pet.repository;

import data.pet.entity.Hair;
import data.pet.entity.Role;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepo extends JpaRepository<Role,Long> {
    @Override
    @NonNull
    <S extends Role> S save(@NonNull S entity);
    @Override
    @NonNull
    List<Role> findAll();

    @Override
    void delete(@NonNull Role entity);
}
