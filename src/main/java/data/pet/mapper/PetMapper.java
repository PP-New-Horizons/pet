package data.pet.mapper;

import data.pet.dto.response.PetDto;
import data.pet.entity.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Mapper

public interface PetMapper {
    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    @Mapping(source = "healthType.name", target = "health")
    @Mapping(source = "petTypeId.name", target = "petType")
    @Mapping(source = "color.name", target = "color")
    @Mapping(source = "hair.name", target = "hair")
    @Mapping(source = "size.name", target = "size")
    @Mapping(source = "createdAt", target = "createdDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "dateOfBirth", target = "allMonths", qualifiedByName = "calculateAgeInMonths")
    PetDto petToPetDto(Pet pet);

    @Mapping(source = "health", target = "healthType.name")
    @Mapping(source = "petType", target = "petTypeId.name")
    @Mapping(source = "color", target = "color.name")
    @Mapping(source = "hair", target = "hair.name")
    @Mapping(source = "size", target = "size.name")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "dateOfBirth", ignore = true)
    Pet petDtoToPet(PetDto petDto);

    List<PetDto> petsToPetDtos(List<Pet> pets);
    List<Pet> petDtosToPets(List<PetDto> petDtos);

    @Named("calculateAgeInMonths")
    default Integer calculateAgeInMonths(LocalDateTime dateOfBirth) {
        return Period.between(dateOfBirth.toLocalDate(), LocalDate.now()).getMonths();
    }
}
