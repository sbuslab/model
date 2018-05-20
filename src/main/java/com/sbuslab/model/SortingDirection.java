package com.sbuslab.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


public enum SortingDirection {
    ASC("ASC"),
    DESC("DESC");

    private final String value;

    private final static Map<String, SortingDirection> values = new HashMap<>();

    static {
        for (SortingDirection c : values()) {
            values.put(c.value.toLowerCase(), c);
        }
    }

    private SortingDirection(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static SortingDirection fromValue(String value) {
        if (value == null) return null;

        SortingDirection v = values.get(value.toLowerCase());
        if (v == null) {
            throw new IllegalArgumentException(value);
        } else {
            return v;
        }
    }
}
