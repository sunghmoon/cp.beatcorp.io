package io.beatcorp.cp.order;

import io.beatcorp.cp.common.CommonUtil;
import io.beatcorp.cp.order.dto.OrderDto;
import io.beatcorp.cp.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;


    /*
    QualityControl > Coffee Discharge
     */
    @RequestMapping(value = "/order/list", method = RequestMethod.GET)
    public ModelAndView coffeeDischargeInfo(@ModelAttribute("condition") OrderDto.Request request) {

        OrderDto.Response responseData = new OrderDto.Response();

        // 오늘 날짜 기본 셋팅
        String today = CommonUtil.getToday("yyyy-MM-dd");

        ModelAndView mav = new ModelAndView();
        mav.setViewName("order/list");
        return mav;
    }
}
