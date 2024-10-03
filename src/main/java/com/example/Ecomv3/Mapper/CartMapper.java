package com.example.Ecomv3.Mapper;

import com.example.Ecomv3.DTO.CartDTO;
import com.example.Ecomv3.DTO.CartItemDTO;
import com.example.Ecomv3.Model.Cart;
import com.example.Ecomv3.Model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(target = "userId", source = "user.id")
    CartDTO toDTO(Cart Cart);
    @Mapping(target="user.id", source = "userId")
    Cart toEntity(CartDTO cartDTO);

    @Mapping(target="productId", source="product.id")
    CartItemDTO toDTO(CartItem cartItem);

    @Mapping(target="product.id", source="productId")
    CartItem toEntity(CartItemDTO cartItemDTO);
}
