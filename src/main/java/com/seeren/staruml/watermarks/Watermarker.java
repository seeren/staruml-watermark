package com.seeren.staruml.watermarks;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public abstract class Watermarker {

    public final Document getDocument(final String fileName) throws IllegalArgumentException {
	try {
	    return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(fileName));
	} catch (SAXException | IOException | ParserConfigurationException e) {
	    throw new IllegalArgumentException("Unable to read " + fileName);
	}
    }

}
