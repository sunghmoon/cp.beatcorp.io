package io.beatcorp.cp.dashboard.repository;

import io.beatcorp.cp.dashboard.dto.DashBoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DashBoardRepository {

    List<DashBoardDto.Response> coffeeDischargeList(@Param("condition") DashBoardDto.Condition condition);

    List<DashBoardDto.Response> coffeeDischargeChart(@Param("condition") DashBoardDto.Condition condition);

    DashBoardDto.Response getCoffeeDischargeMinMax(@Param("condition") DashBoardDto.Condition condition);
}
