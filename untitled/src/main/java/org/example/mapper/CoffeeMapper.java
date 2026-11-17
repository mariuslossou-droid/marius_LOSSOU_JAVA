package org.example.mapper;


public interface CoffeeMapper {
    CoffeeDto toDto(Coffee coffee);

    @Mapping(target = "id",ignore =true)
    //Coffee
}
