package org.example;


public interface CoffeeMapper {
    CoffeeDto toDto(Coffee coffee);

    @Mapping(target = "id",ignore =true)
    //Coffee
}
