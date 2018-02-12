package ua.ucu.edu.sparkcourse.model;

import java.util.Arrays;

public enum EventType {

    YELLOW_CARD(1, "yellow card"),
    RED_CARD(2, "red card"),
    PASS_SENT(3, "pass sent"),
    PASS_RECEIVED(4, "pass received"),
    KICK_TO_ROD(5, "kick to rod"),
    KICK_TO_GATE(6, "kick to gate"),
    GOAL(7,"goal"),
    PENALTY(9, "penalty"),
    FREE_KICK(10, "free kick");

    private Integer code;
    private String description;


    EventType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public static EventType fromCode(Integer code) {
        return Arrays.stream(values()).filter(type -> type.getCode().equals(code)).findFirst().orElse(null);
    }
}
