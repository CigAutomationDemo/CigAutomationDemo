package com.automation.slack;

/**
 * @author Pankaj Kumar (HOOQ Team)
 */
public enum SlackActionStyle {
    DEFAULT("default"),
    PRIMARY("primary"),
    DANGER("danger");

    private String code;

    SlackActionStyle(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}