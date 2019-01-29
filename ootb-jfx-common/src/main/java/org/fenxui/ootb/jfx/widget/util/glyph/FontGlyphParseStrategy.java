package org.fenxui.ootb.jfx.widget.util.glyph;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FontGlyphParseStrategy implements SvgParseStrategy {
	private final Map<String, GlyphConfig> map;

	public FontGlyphParseStrategy(Map<String, GlyphConfig> map) {
		this.map = map;
	}

	@Override
	public void loadFromDocument(Document doc, String prefix, String resourceName) {
		NodeList glyphsList = doc.getElementsByTagName("glyph");
		for (int i = 0; i < glyphsList.getLength(); i++) {
			Node glyphNode = glyphsList.item(i);
			Node glyphNameNode = glyphNode.getAttributes().getNamedItem("glyph-name");
			if (glyphNameNode != null) {
				Node dPath = glyphNode.getAttributes().getNamedItem("d");
				GlyphConfig glyphConfig = new GlyphConfig(map.size(), glyphNameNode.getNodeValue(), dPath.getNodeValue());
				String key = Stream.of(prefix, resourceName, glyphConfig.getName())
						.filter(s -> s != null)
						.collect(Collectors.joining("."));
				map.put(key, glyphConfig);
			}
		}
	}
}
