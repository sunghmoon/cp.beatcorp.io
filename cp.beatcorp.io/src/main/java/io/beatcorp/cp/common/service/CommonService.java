package io.beatcorp.cp.common.service;

import io.beatcorp.cp.common.dto.CommonDto;
import io.beatcorp.cp.common.repository.CommonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommonService {
    private final CommonRepository commonRepository;
    private final ModelMapper modelMapper;

    public CommonService(CommonRepository commonRepository, ModelMapper modelMapper) {
        this.commonRepository = commonRepository;
        this.modelMapper = modelMapper;
    }

    // 음료 목록
    public List<CommonDto.Response> beverageCodeList() {
        return commonRepository.beverageCodeList();
    }

    // 매장 목록
    public List<CommonDto.Response> boothCodeList() {
        return commonRepository.boothCodeList();
    }

    // 음료 이름
    public CommonDto.Response getBeverageName(String beverageCode) {
        return commonRepository.getBeverageName(beverageCode);
    }

    // 매장 이름
    public CommonDto.Response getBoothName(String boothCode) {
        return commonRepository.getBoothName(boothCode);
    }
}
