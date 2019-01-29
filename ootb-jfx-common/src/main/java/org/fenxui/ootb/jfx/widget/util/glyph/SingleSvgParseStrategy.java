package org.fenxui.ootb.jfx.widget.util.glyph;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SingleSvgParseStrategy implements SvgParseStrategy {
	private final Map<String, GlyphConfig> map;

	public SingleSvgParseStrategy(Map<String, GlyphConfig> map) {
		this.map = map;
	}

	@Override
	public void loadFromDocument(Document doc, String prefix, String resourceName) {
		NodeList svgPath = doc.getDocumentElement().getElementsByTagName("path");
		if (svgPath != null) {
			Node node = svgPath.item(0);//should only be one
			Node dNode = node.getAttributes().getNamedItem("d");
			GlyphConfig glyphConfig = new GlyphConfig(map.size(), resourceName, dNode.getNodeValue());
			String key = Stream.of(prefix, resourceName)
					.filter(s->s != null)
					.collect(Collectors.joining("."));
			map.put(key, glyphConfig);
		}
	}
}
