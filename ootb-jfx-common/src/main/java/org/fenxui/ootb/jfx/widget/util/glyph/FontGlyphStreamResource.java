package org.fenxui.ootb.jfx.widget.util.glyph;

import org.fenxui.core.exception.FenxuiInitializationException;

import java.io.InputStream;
import java.util.Map;

public class FontGlyphStreamResource implements GlyphResource<InputStream> {
	private final InputStream resourceAsStream;
	private final String resourceKey;

	public FontGlyphStreamResource(InputStream resourceAsStream, String resourceKey) {
		this.resourceAsStream = resourceAsStream;
		this.resourceKey = resourceKey;
	}

	@Override
	public void init(Map<String, GlyphConfig> glyphMap) throws FenxuiInitializationException {
		new FenxuiGlyphLoader(new FontGlyphParseStrategy(glyphMap)).loadGlyphs(resourceAsStream, resourceKey);
	}
}
