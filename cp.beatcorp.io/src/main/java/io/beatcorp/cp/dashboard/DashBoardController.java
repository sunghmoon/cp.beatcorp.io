package io.beatcorp.cp.dashboard;


import io.beatcorp.cp.common.CommonUtil;
import io.beatcorp.cp.common.dto.CommonDto;
import io.beatcorp.cp.common.service.CommonService;
import io.beatcorp.cp.dashboard.dto.DashBoardDto;
import io.beatcorp.cp.dashboard.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RestController
public class DashBoardController {

    private final DashBoardService dashBoardService;
    private final CommonService commonService;

    /*
    QualityControl > Coffee Discharge
     */
    @RequestMapping(value = "/dashboard/", method = RequestMethod.GET)
    public ModelAndView coffeeDischargeInfo(@ModelAttribute("condition") DashBoardDto.Request request) {

        DashBoardDto.Response responseData = new DashBoardDto.Response();

        // 오늘 날짜 기본 셋팅
        String today = CommonUtil.getToday("yyyy-MM-dd");


        List<DashBoardDto.Response> list = dashBoardService.coffeeDischargeList(request);
        DashBoardDto.Response minData = dashBoardService.getCoffeeDischargeMinMax(request, "asc");
        DashBoardDto.Response maxData = dashBoardService.getCoffeeDischargeMinMax(request, "desc");


        List<CommonDto.Response> beverageCodeList = commonService.beverageCodeList();
        List<CommonDto.Response> boothCodeList = commonService.boothCodeList();

        responseData.setStatCount(list.size());

        if (list.size() > 0) {
//            BeatBoxDto.Response minStat = list.stream().min(Comparator.comparing(BeatBoxDto.Response::getStatData)).orElseThrow(NoSuchElementException::new);
            DashBoardDto.Response maxStat = list.stream().max(Comparator.comparing(DashBoardDto.Response::getStatData)).orElseThrow(NoSuchElementException::new);
//            responseData.setMinStatData(minStat.getStatData());
//            responseData.setMinStatDate(minStat.getStatDate());
//            responseData.setMinStatOrderId(minStat.getOrderId());
//
            responseData.setMaxStatData(maxStat.getStatData());
//            responseData.setMaxStatDate(maxStat.getStatDate());
//            responseData.setMaxStatOrderId(maxStat.getOrderId());

            // 합, 평균 구하기
            BigDecimal sum = list.stream().map(DashBoardDto.Response::getStatData).reduce(BigDecimal.ZERO, BigDecimal::add);
            responseData.setAverageData(sum.divide(BigDecimal.valueOf(list.size()), 2, RoundingMode.HALF_EVEN));
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("condition", request);
        mav.addObject("list", list);
        mav.addObject("beverageCodeList", beverageCodeList);
        mav.addObject("boothCodeList", boothCodeList);
        mav.addObject("responseData", responseData);
        mav.addObject("minData", minData);
        mav.addObject("maxData", maxData);
        mav.addObject("today", today);
        mav.addObject("beverage", commonService.getBeverageName(request.getBeverageCode()));
        mav.addObject("booth", commonService.getBoothName(request.getBoothCode()));
        mav.setViewName("dashboard/index");
        return mav;
    }

    @RequestMapping(value = "/qualityControl/coffeeDischargeChart", method = RequestMethod.GET)
    public List<DashBoardDto.Response> coffeeDischargeChart(DashBoardDto.Request request) {
        return dashBoardService.coffeeDischargeChart(request);
    }
}
