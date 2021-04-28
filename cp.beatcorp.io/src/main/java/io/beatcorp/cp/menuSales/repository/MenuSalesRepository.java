package io.beatcorp.cp.menuSales.repository;

import io.beatcorp.cp.menuSales.dto.MenuSalesDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MenuSalesRepository {

    List<MenuSalesDto.Response> menuSalesList(@Param("condition") MenuSalesDto.Condition condition);
}
