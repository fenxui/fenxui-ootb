package org.fenxui.ootb.jfx.widget.util.glyph;

import com.jfoenix.svg.SVGGlyph;
import javafx.beans.binding.Bindings;
import javafx.scene.paint.Paint;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fenxui.core.exception.FenxuiInitializationException;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class GlyphUtil {
	private static final Map<String, GlyphConfig> glyphMap = new HashMap<>();

	private static final Logger logger = LogManager.getLogger(GlyphUtil.class);
	private static final double DEFAULT_ICON_SIZE = 16;

	private static Deque<GlyphResource> glyphResources = new ArrayDeque<>();
	static {
		glyphResources.add(new FontGlyphStreamResource(GlyphUtil.class.getResourceAsStream("icomoon.svg"), "icomoon.svg"));
		glyphResources.add(new SvgGlyphStreamResource(GlyphUtil.class.getResourceAsStream("fenxui.svg"),  "fenxui.svg"));
		glyphResources.add(new SvgGlyphStreamResource(GlyphUtil.class.getResourceAsStream("fenxui2.svg"),  "fenxui2.svg"));
	}

	public static void addGlyphResource(GlyphResource glyphResource) {
		glyphResources.add(glyphResource);
	}
	
	private static void loadIcons() throws Exception {
		while (!glyphResources.isEmpty()) {
			GlyphResource resource = glyphResources.pop();//resources should only be loaded once
			resource.init(glyphMap);
		}
	}

	public static SVGGlyph getGlyph(String name, String iconColor, double iconSize) throws FenxuiInitializationException {
		try {
			loadIcons();
			GlyphConfig config = glyphMap.get(name);
			if (config != null) {
				SVGGlyph glyph = new SVGGlyph(config.getId(), config.getName(), config.getPath(), Paint.valueOf(iconColor));
//				glyph.getTransforms().add(new Scale(1, 1));
				Translate height = new Translate();
				height.yProperty().bind(glyph.heightProperty().subtract(iconSize));
				glyph.getTransforms().add(height);
				glyph.setSize(iconSize);
				glyph.setFill(Paint.valueOf(iconColor));
				return glyph;
			}
		} catch (Exception ex) {
			logger.error("Error loading fonts", ex);
			throw new FenxuiInitializationException(ex);
		}
		return null;
	}

	public static SVGGlyph getGlyph(String name, String iconColor) throws FenxuiInitializationException {
		return getGlyph(name, iconColor, DEFAULT_ICON_SIZE);
	}
}
