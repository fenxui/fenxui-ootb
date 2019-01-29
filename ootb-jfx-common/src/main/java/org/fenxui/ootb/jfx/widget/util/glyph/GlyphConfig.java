package org.fenxui.ootb.jfx.widget.util.glyph;

public class GlyphConfig {
	private final String name;
	private final String path;
	private final int id;

	public GlyphConfig(int id, String name, String path) {
		this.id = id;
		this.name = name;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

}
