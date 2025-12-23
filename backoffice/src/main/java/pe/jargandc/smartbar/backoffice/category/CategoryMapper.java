package pe.jargandc.smartbar.backoffice.category;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import pe.jargandc.backoffice.api.model.Category;
@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CategoryMapper {
    @Mapping(target = "id", ignore = true)
    void mapToEntity(Category table, @MappingTarget CategoryEntity entity);

    Category mapToCategory(CategoryEntity entity);

}
