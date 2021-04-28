package io.beatcorp.cp.order.repository;

import io.beatcorp.cp.order.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderRepository {

    List<OrderDto.Response> orderList(@Param("condition") OrderDto.Condition condition);
}
