package org.fenxui.ootb.jfx.widget.util.glyph;

import org.w3c.dom.Document;

public interface SvgParseStrategy {
	void loadFromDocument(Document doc, String prefix, String filename);
}
