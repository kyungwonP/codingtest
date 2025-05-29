package com.codingtest.livecoding.subject.wordfiltering;

public enum FilterPolicy {
    DEFAULT("default"),
    REMOVE("remove"),
    PARTIAL("partial");

    private final String code;

    FilterPolicy(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
