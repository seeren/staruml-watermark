package com.seeren.staruml.commands;

public enum Option {

    DIRECTORY("-d", "Directory path"),

    RECURSIVE("-r", "Recursive remove");

    private final String key;

    private final String value;

    private Option(String key, String value) {
	this.key = key;
	this.value = value;
    }

    public final String key() {
	return key;
    }

    public final String value() {
	return value;
    }

}
