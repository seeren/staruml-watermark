package com.seeren.staruml.loggers;

public class Logger {

    public final void log(String message) {
	System.out.print(message + LogColor.RESET);
    }

    public final void log(String message, Boolean lineBreak) {
	log(message + "\n");
    }

    public final void emergency(String message) {
	log(LogColor.MAGENTA + message);
    }

    public final void error(String message) {
	log(LogColor.RED + message);
    }

    public final void warning(String message) {
	log(LogColor.YELLOW + message);
    }

    public final void success(String message) {
	log(LogColor.GREEN + message);
    }

    public final void info(String message) {
	log(LogColor.BLUE + message);
    }

    public final void debug(String message) {
	log(LogColor.RESET + message);
    }

}
