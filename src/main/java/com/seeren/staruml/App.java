package com.seeren.staruml;

import java.util.Map;
import java.util.TreeMap;

import com.seeren.staruml.commands.Option;
import com.seeren.staruml.commands.WaterMarkCommand;
import com.seeren.staruml.loggers.Logger;

public final class App {

    public final static void main(String[] args) {
	Logger logger = new Logger();
	Map<String, String> options = new TreeMap<String, String>();
	options.put(Option.DIRECTORY.key(), null);
	options.put(Option.RECURSIVE.key(), null);
	try {
	    if (0 == args.length) {
		throw new IllegalArgumentException();
	    }
	    for (int i = 0; i < args.length; i++) {
		if (options.keySet().contains(args[i])) {
		    options.put(args[i], i + 1 < args.length ? args[i + 1] : "");
		}
	    }
	    (new WaterMarkCommand(options, logger)).execute();
	} catch (RuntimeException e) {
	    if (e instanceof IllegalArgumentException) {
		logger.success("\nStar UML WaterMark remover\n");
	    } else {
		logger.error("\n" + e.getMessage() + "\n");
	    }
	    options.put(Option.DIRECTORY.key(), Option.DIRECTORY.value());
	    options.put(Option.RECURSIVE.key(), Option.RECURSIVE.value());
	    logger.warning("\nUsage:");
	    logger.log("\n   [options]\n", true);
	    logger.warning("Options:");
	    options.forEach((String key, String value) -> {
		logger.success("\n  " + key + "  ");
		logger.log(value);
	    });
	    logger.log("\n");
	}
    }

}
