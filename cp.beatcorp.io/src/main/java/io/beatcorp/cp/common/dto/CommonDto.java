package io.beatcorp.cp.common.dto;

import lombok.Data;

public class CommonDto {

    @Data
    public static class Request {
        private String boothCode;
        private String beverageCode;
    }

    @Data
    public static class Response {
        private String boothCode;
        private String boothName;
        private String beverageCode;
        private String beverageName;
    }

    @Data
    public static class Condition {
        private String boothCode;
        private String boothName;
        private String beverageCode;
        private String beverageName;
    }
}
