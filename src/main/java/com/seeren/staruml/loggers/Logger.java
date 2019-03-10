package com.seeren.staruml.loggers;

public class Logger {

	public final void log(String message) {
		System.out.print(message + LogColor.RESET);
	}

	public final void log(String message, Boolean lineBreak) {
		System.out.println(message + LogColor.RESET);
	}

	private String logColor(LogColor color, String message) {
		return color + message;
	}

	public final void emergency(String message) {
		log(logColor(LogColor.MAGENTA, message));
	}

	public final void error(String message) {
		log(logColor(LogColor.RED, message));
	}

	public final void warning(String message) {
		log(logColor(LogColor.YELLOW, message));
	}

	public final void success(String message) {
		log(logColor(LogColor.GREEN, message));
	}

	public final void info(String message) {
		log(logColor(LogColor.BLUE, message));
	}

	public final void debug(String message) {
		log(logColor(LogColor.RESET, message));
	}

}
