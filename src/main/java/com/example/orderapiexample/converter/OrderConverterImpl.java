package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.OrderDTO;
import com.example.orderapiexample.model.Order;
import com.example.orderapiexample.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class OrderConverterImpl implements OrderConverter{

    private final CouponService couponService;

    @Override
    public Order toCreateOrder(OrderDTO orderDTO) {

        Order order = new Order();
        order.setOrderDate(new Date());
        order.setShippingDate(orderDTO.shippingDate());
        order.setShippingMethod(orderDTO.shippingMethod());
        order.setOrderPrice(orderDTO.orderPrice());
        order.setOrderDiscountPrice(orderDTO.orderDiscountPrice());
        order.setOrderTaxPrice(orderDTO.orderTaxPrice());
        order.setOrderShippingPrice(orderDTO.orderShippingPrice());
        order.setOrderTotalPrice(orderDTO.orderTotalPrice());


        // connect orderItemService after that orderItemID set in here
        // connect shippingAddressService after that shippingAddressID set in here
        // connect payment after that paymentID set in here


        return order;
    }
}
