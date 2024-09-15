package data.pet.repository;

import data.pet.entity.UserProfile;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {

    @Override
    @NonNull
    List<UserProfile> findAll();

    @Override
    @NonNull
    <S extends UserProfile> S save(@NonNull S entity);

    @Override
    void delete(@NonNull UserProfile entity);

}
