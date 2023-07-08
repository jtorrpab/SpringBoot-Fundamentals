package com.market.persistence.mapper;

import com.market.domain.dto.Category;
import com.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//Indicar que es de Spring
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    //Con esta anotación se especifica como se traducira y que se traducira
    @Mappings({
            @Mapping(source = "idCategoria" , target = "categoryId"),
            @Mapping(source = "descripcion" , target = "category"),
            @Mapping(source = "estado" , target = "active")
    })
    Category toCategory (Categoria categoria);

    //Este otro metodo hace la conversión inversa y se ignora el producto
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
