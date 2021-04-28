package io.beatcorp.cp.dashboard.service;

import io.beatcorp.cp.dashboard.dto.DashBoardDto;
import io.beatcorp.cp.dashboard.repository.DashBoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class DashBoardService {
    private final DashBoardRepository dashBoardDtoRepository;
    private final ModelMapper modelMapper;

    public DashBoardService(DashBoardRepository dashBoardDtoRepository, ModelMapper modelMapper) {
        this.dashBoardDtoRepository = dashBoardDtoRepository;
        this.modelMapper = modelMapper;
    }

    // Coffee Discharge 차트
    public List<DashBoardDto.Response> coffeeDischargeChart(DashBoardDto.Request request) {
        DashBoardDto.Condition condition = modelMapper.map(request, DashBoardDto.Condition.class);
        return dashBoardDtoRepository.coffeeDischargeChart(condition);
    }

    // QC 리스트
    public List<DashBoardDto.Response> coffeeDischargeList(DashBoardDto.Request request) {
        DashBoardDto.Condition condition = modelMapper.map(request, DashBoardDto.Condition.class);
        return dashBoardDtoRepository.coffeeDischargeList(condition);
    }

    // QC 정보
    public DashBoardDto.Response getCoffeeDischargeMinMax(DashBoardDto.Request request, String orderSort) {
        DashBoardDto.Condition condition = modelMapper.map(request, DashBoardDto.Condition.class);
        condition.setOrderSort(orderSort);
        return dashBoardDtoRepository.getCoffeeDischargeMinMax(condition);
    }

}
