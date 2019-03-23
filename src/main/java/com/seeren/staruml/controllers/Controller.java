package com.seeren.staruml.controllers;

import java.util.Map;

import com.seeren.staruml.loggers.Logger;

public abstract class Controller {

	public final Map<String, String> options;

	public final Logger logger;

	abstract public void execute() throws RuntimeException;

	public Controller(final Map<String, String> options, final Logger logger) {
		this.options = options;
		this.logger = logger;
	}

}
