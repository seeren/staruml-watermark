package com.seeren.staruml.watermarks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class SVGWatermarker extends Watermarker implements IWatermarker {

    @Override
    public final void mark(final File file) throws RuntimeException {
    }

    @Override
    public final void unmark(final File file) throws RuntimeException {
	try {
	    List<Node> watermarks = new ArrayList<Node>();
	    Document document = getDocument(file.getAbsolutePath());
	    NodeList childNodes = document.getElementsByTagName("text");
	    for (int i = 0; i < childNodes.getLength(); i++) {
		if (childNodes.item(i).getTextContent().contentEquals("UNREGISTERED")) {
		    watermarks.add(childNodes.item(i));
		}
	    }
	    if (0 == watermarks.size()) {
		throw new RuntimeException("Document is not watermarked");
	    }
	    watermarks.forEach(watermark -> watermark.getParentNode().removeChild(watermark));
	    TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document),
		    new StreamResult(new OutputStreamWriter(new FileOutputStream(new File(file.getAbsolutePath())),
			    StandardCharsets.UTF_8)));
	} catch (TransformerException | IOException e) {
	    throw new RuntimeException(e.getMessage());
	}
    }

}
