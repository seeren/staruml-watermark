package com.seeren.staruml;

import java.util.ArrayList;
import java.util.Arrays;

import com.seeren.staruml.controllers.WaterMarkController;
import com.seeren.staruml.loggers.Logger;
import com.seeren.staruml.resources.Resource;

public class App {

	public static void main(String[] args) {
		Logger logger = new Logger();
		try {
			if (0 == args.length) {
				throw new RuntimeException();
			}
			(new WaterMarkController(new ArrayList<String>(Arrays.asList(args)), logger)).execute();
		} catch (RuntimeException e) {
			logger.log("\nStar UML WaterMark" + (new Resource("brand")).getValue("resource"));
			logger.warning("Usage:");
			logger.log("\n  command [options]\n", true);
			logger.warning("Options:");
			logger.success("\n  -d  ");
			logger.log("Directory path");
			logger.success("\n  -r  ");
			logger.log("Recursive remove\n");
		}
	}

}
