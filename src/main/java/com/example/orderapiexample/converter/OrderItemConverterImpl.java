package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.OrderItemDTO;
import com.example.orderapiexample.model.OrderItem;
import com.example.orderapiexample.service.OrderService;
import com.example.orderapiexample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemConverterImpl implements OrderItemConverter{

    private final OrderService orderService;
    private final ProductService productService;


    @Override
    public OrderItem addToOrderItem(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();



        orderItem.setPrice(orderItemDTO.price());
        orderItem.setDiscountPrice(orderItemDTO.discountPrice());
        orderItem.setTaxPrice(orderItemDTO.taxPrice());
        orderItem.setShippingPrice(orderItemDTO.shippingPrice());
        orderItem.setTotalPrice(orderItemDTO.totalPrice());

        orderItem.setOrder(orderService.getOneOrder(orderItemDTO.orderID()));
        orderItem.setProduct(productService.getProduct(orderItemDTO.productID()));


        return orderItem;
    }
}
