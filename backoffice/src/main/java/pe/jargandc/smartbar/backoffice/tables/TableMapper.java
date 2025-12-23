package pe.jargandc.smartbar.backoffice.tables;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import pe.jargandc.backoffice.api.model.Table;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface TableMapper {
    @Mapping(target = "id", ignore = true)
    void mapToEntity(Table table, @MappingTarget TableEntity entity);

    Table mapToTable(TableEntity entity);

}
