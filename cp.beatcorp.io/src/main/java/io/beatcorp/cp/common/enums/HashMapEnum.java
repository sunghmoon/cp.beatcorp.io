package io.beatcorp.cp.common.enums;

import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public enum HashMapEnum {
    USE("사용중"),
    UNUSED("미사용"),
    UNKNOWN("알수없음");

    @Getter
    private final String desc;

    HashMapEnum(String desc ){
        this.desc = desc;
    }

    
    

    // HashMap 이용
    private static final Map<String, HashMapEnum> descriptions =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(toMap(HashMapEnum::getDesc, Function.identity())));

    public static HashMapEnum findHashMap(String description) {
        return Optional.ofNullable(descriptions.get(description)).orElse(UNKNOWN);
    }

    // Arrays.stream 이용
    public static HashMapEnum findArrayStream(String description) {
        return Arrays.stream(values())
                .filter(accountStatus -> accountStatus.desc.equals(description))
                .findAny()
                .orElse(UNKNOWN); }

    // Streams.of 이용
    public static HashMapEnum findStreamOf(String description) {
        return Stream.of(values())
                .filter(accountStatus -> accountStatus.desc.equals(description))
                .findAny()
                .orElse(UNKNOWN); }


    public enum Transition {
        MELT(USE);

        private final HashMapEnum use;
        private HashMapEnum to;
        private HashMapEnum from;

        Transition(HashMapEnum use) {
            this.use = use;
        }

        // EnumMap 이용
        public static final Map<HashMapEnum, Map<HashMapEnum, Transition>> m = Stream.of(values())
                .collect(groupingBy(t -> t.from, () -> new EnumMap<>(HashMapEnum.class),
                        toMap(t -> t.to, //key-mapper
                                t -> t,  //value-mapper
                                (x, y) -> y, //merge-function
                                () -> new EnumMap<>(HashMapEnum.class))));
        
        public static Transition from (HashMapEnum from, HashMapEnum to) {
            return m.get(from).get(to);
        }
    }
}
