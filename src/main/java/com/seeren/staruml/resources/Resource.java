package com.seeren.staruml.resources;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Resource {

	private Document document;

	public Resource(String path) throws RuntimeException {
		try {
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new File("src/main/resources/" + path + ".xml"));
		} catch (SAXException | IOException | ParserConfigurationException e) {
			throw new RuntimeException("Unable to load " + path);
		}
	}

	public Node getElement(String tagName) {
		return document.getElementsByTagName(tagName).item(0);
	}

	public NamedNodeMap getAttributes(String tagName) {
		return getElement(tagName).getAttributes();
	}

	public String getValue(String tagName) {
		return getElement(tagName).getTextContent();
	}

}
