package org.fenxui.ootb.jfx.widget.util.glyph;

import com.jfoenix.svg.SVGGlyph;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;

public class GlyphUtilTest {

	@Test
	public void loadsGlyphFromFont() throws Exception{
		SVGGlyph glyph = GlyphUtil.getGlyph("icomoon.svg.trash", "#999999");
		assertNotNull(glyph);
		File fontsDir = new File(GlyphUtilTest.class.getResource("fonts").toURI());
		GlyphUtil.addGlyphResource(new FontGlyphFileResource(fontsDir));
		SVGGlyph glyph2 = GlyphUtil.getGlyph("fonts.fa-regular-400.svg.address-book", "#999999");
		assertNotNull(glyph2);
	}

	@Test
	public void loadsGlyphFromSVG() throws Exception{
		SVGGlyph glyph = GlyphUtil.getGlyph("fenxui.svg", "#999999");
		assertNotNull(glyph);
		File svgsDir = new File(GlyphUtilTest.class.getResource("svgs").toURI());
		GlyphUtil.addGlyphResource(new SvgGlyphFileResource(svgsDir));
		SVGGlyph glyph2 = GlyphUtil.getGlyph("svgs.angry.svg", "#999999");
		assertNotNull(glyph2);
	}


}
