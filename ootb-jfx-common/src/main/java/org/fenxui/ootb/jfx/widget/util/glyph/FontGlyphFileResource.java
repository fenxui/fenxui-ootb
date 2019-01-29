package org.fenxui.ootb.jfx.widget.util.glyph;

import org.fenxui.core.exception.FenxuiInitializationException;

import java.io.File;
import java.util.Map;

/**
 * Load svgs from font files.
 */
public class FontGlyphFileResource implements GlyphResource {
	private final File file;

	public FontGlyphFileResource(File file) {
		this.file = file;
	}

	@Override
	public void init(Map glyphMap) throws FenxuiInitializationException {
		new FenxuiGlyphLoader(new FontGlyphParseStrategy(glyphMap)).loadGlyphs(file, null);
	}
}
