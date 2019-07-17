package com.seeren.staruml.commands;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.seeren.staruml.loggers.Logger;
import com.seeren.staruml.watermarks.IWatermarker;
import com.seeren.staruml.watermarks.SVGWatermarker;

public final class WaterMarkCommand extends Command {

    public Map<String, IWatermarker> markers;

    public WaterMarkCommand(final Map<String, String> options, Logger logger) throws RuntimeException {
	super(options, logger);
	if (options.get(Option.DIRECTORY.key()) == null || options.get(Option.DIRECTORY.key()).isEmpty()) {
	    throw new RuntimeException("Missing " + Option.DIRECTORY.value());
	}
    }

    public final void execute() throws RuntimeException {
	File file = (new File(options.get(Option.DIRECTORY.key())));
	if (!file.exists()) {
	    throw new RuntimeException("Directory \"" + file.getPath() + "\" do not exists");
	}
	markers = new HashMap<String, IWatermarker>();
	markers.put("svg", new SVGWatermarker());
	logger.warning("\nClear watermark:\n");
	unmark(file);
    }

    private final void unmark(final File directory) {
	for (File file : directory.listFiles()) {
	    if (file.isFile() && file.getName().substring(file.getName().lastIndexOf('.') + 1).contentEquals("svg")) {
		try {
		    markers.get("svg").unmark(file);
		    logger.success(" v ");
		} catch (RuntimeException e) {
		    logger.error(" x ");
		}
		logger.log(file.getPath() + "\n");
	    } else if (null != options.get(Option.RECURSIVE.key()) && file.isDirectory()) {
		unmark(file);
	    }
	}
    }

}
