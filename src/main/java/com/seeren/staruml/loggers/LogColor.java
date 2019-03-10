package com.seeren.staruml.loggers;

public enum LogColor {

	RESET("\u001B[0m"),

	MAGENTA("\033[0;95m"),

	RED("\033[0;91m"),

	YELLOW("\033[0;93m"),

	BLUE("\033[0;94m"),

	GREEN("\033[0;92m");

	private String code;

	private LogColor(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return code;
	}

}
