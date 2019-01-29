package org.fenxui.ootb.jfx.widget.util.glyph;

import org.fenxui.core.exception.FenxuiInitializationException;

import java.util.Map;

public interface GlyphResource<T> {
	void init(Map<String, GlyphConfig> glyphMap) throws FenxuiInitializationException;
}
