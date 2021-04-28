package io.beatcorp.cp.menuSales.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MenuSalesDto {

    @Data
    public static class Request {
        private String startDate;
        private String endDate;
        private String boothCode;
        private int beverageCode;
        private int orderId;
    }

    @Data
    public static class Response {

        private long orderId;
        private String boothCode;
        private String boothName;
        private LocalDateTime manufactureStartTime;
        private LocalDateTime manufactureEndTime;

        private BigDecimal iceMachineDischargeUseTime;
        private BigDecimal coffeeMachineDischarge;
        private BigDecimal pickupLoadcellLeft;
        private BigDecimal pickupLoadcellRight;
        private int beverageCode;
        private String BeverageName;
        private String option1Group;
        private String option1Value;
        private String option2Group;
        private String option2Value;
        private String option3Group;
        private String option3Value;
        private int nozzleId;
        private BigDecimal dischargeUseTime;
        private int dischargeCount;
        private int dischargeTargetWeight;
        private int nozzleIdExt;
        private BigDecimal dischargeUseTimeExt;
        private int dischargeCountExt;
        private int dischargeTargetWeightExt;
        private BigDecimal loadcellLeft;
        private BigDecimal loadcellRight;
        private int status;
        private String statusDesc;

        private BigDecimal statData;
        private String statDate;


        private BigDecimal averageData;
        private BigDecimal minStatData;
        private String minStatDate;
        private long minStatOrderId;
        private BigDecimal maxStatData;
        private String maxStatDate;
        private long maxStatOrderId;
        private int statCount;

        private int coffeeMachineId;
        private int cupDispenseId;
        private int iceMachineId;
        private int iceMachineUseType;



    }

    @Data
    public static class Condition {
        private LocalDateTime manufactureStartTime;
        private LocalDateTime manufactureEndTime;
        private String boothCode;
        private int beverageCode;
        private String statDate;
        private String startDate;
        private String endDate;
        private String orderSort;
    }
}
