package org.fenxui.ootb.jfx.widget.util.glyph;

import org.fenxui.core.exception.FenxuiInitializationException;

import java.io.File;
import java.util.Map;

/**
 * Directory with single-glyph *.svg files or single single-glyph *.svg file
 */
public class SvgGlyphFileResource implements GlyphResource<File> {
	private final File file;

	public SvgGlyphFileResource(File file) {
		this.file = file;
	}

	@Override
	public void init(Map<String, GlyphConfig> glyphMap) throws FenxuiInitializationException {
		new FenxuiGlyphLoader(new SingleSvgParseStrategy(glyphMap)).loadGlyphs(file, null);
	}
}
