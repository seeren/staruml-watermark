package com.seeren.staruml.controllers;

import java.util.List;

import com.seeren.staruml.loggers.Logger;

public abstract class Controller {

	public final List<String> input;

	public final Logger logger;

	abstract public void execute() throws RuntimeException;

	public Controller(List<String> input, Logger logger) {
		this.input = input;
		this.logger = logger;
	}

}
