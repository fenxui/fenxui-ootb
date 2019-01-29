package org.fenxui.ootb.jfx.widget.util.glyph;

import org.fenxui.core.exception.FenxuiInitializationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Load all SVGs in a directory or individually by resource
 */
public class FenxuiGlyphLoader {
	private SvgParseStrategy svgParseStrategy;

	public FenxuiGlyphLoader(SvgParseStrategy svgParseStrategy) {
		this.svgParseStrategy = svgParseStrategy;
	}

	public void loadGlyphs(InputStream resourceAsStream, String resourceKey) throws FenxuiInitializationException {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(resourceAsStream);

			svgParseStrategy.loadFromDocument(doc, resourceKey, null);
		} catch (ParserConfigurationException|IOException|SAXException e) {
			throw new FenxuiInitializationException(e);
		}
	}

	public void loadGlyphs(File file, String resourceKey) throws FenxuiInitializationException {
		if (file.isDirectory()) {
			for (File fileInDirectory : file.listFiles()) {
				loadGlyphs(fileInDirectory, Stream.of(resourceKey, file.getName())
						.filter(s->s!= null)
						.collect(Collectors.joining("."))
				);

			}
		} else if (file.getName().endsWith(".svg")) {
			try {
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				Document doc = docBuilder.parse(file);

				svgParseStrategy.loadFromDocument(doc, resourceKey, file.getName());
			} catch (IOException|ParserConfigurationException|SAXException ex) {
				throw new FenxuiInitializationException(ex);
			}
		}
	}
}
