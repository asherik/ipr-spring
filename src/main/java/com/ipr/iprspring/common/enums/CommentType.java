package com.ipr.iprspring.common.enums;

public enum CommentType {
    FIRST(1),
    SECOND(2),
    THIRD(3);

    private final int value;

    CommentType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}