package io.beatcorp.cp.common.repository;

import io.beatcorp.cp.common.dto.CommonDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommonRepository {

    List<CommonDto.Response> beverageCodeList();

    List<CommonDto.Response> boothCodeList();

    CommonDto.Response getBeverageName(String beverageCode);

    CommonDto.Response getBoothName(String boothCode);
}
