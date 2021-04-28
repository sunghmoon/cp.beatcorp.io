package io.beatcorp.cp.menuSales.service;

import io.beatcorp.cp.menuSales.dto.MenuSalesDto;
import io.beatcorp.cp.menuSales.repository.MenuSalesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuSalesService {
    private final MenuSalesRepository menuSalesRepository;
    private final ModelMapper modelMapper;

    public MenuSalesService(MenuSalesRepository menuSalesRepository, ModelMapper modelMapper) {
        this.menuSalesRepository = menuSalesRepository;
        this.modelMapper = modelMapper;
    }

    // menu 판매 리스트
    public List<MenuSalesDto.Response> menuSalesList(MenuSalesDto.Request request) {
        MenuSalesDto.Condition condition = modelMapper.map(request, MenuSalesDto.Condition.class);
        return menuSalesRepository.menuSalesList(condition);
    }

}
