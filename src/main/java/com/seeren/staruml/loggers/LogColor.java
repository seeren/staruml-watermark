package com.seeren.staruml.loggers;

public enum LogColor {

    RESET("\u001B[0m"),

    MAGENTA("\033[0;95m"),

    RED("\033[0;91m"),

    YELLOW("\033[0;93m"),

    BLUE("\033[0;94m"),

    GREEN("\033[0;92m");

    private final String code;

    private LogColor(final String code) {
	this.code = code;
    }

    @Override
    public final String toString() {
	return code;
    }

}
