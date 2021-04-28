package io.beatcorp.cp.order.service;

import io.beatcorp.cp.order.dto.OrderDto;
import io.beatcorp.cp.order.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    // 세부 내역 list
    public List<OrderDto.Response> orderList(OrderDto.Request request) {
        OrderDto.Condition condition = modelMapper.map(request, OrderDto.Condition.class);
        return orderRepository.orderList(condition);
    }


}
