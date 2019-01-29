package org.fenxui.ootb.jfx.layout;

import com.jfoenix.svg.SVGGlyph;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import org.fenxui.core.exception.FenxuiInitializationException;
import org.fenxui.ootb.jfx.widget.util.glyph.GlyphUtil;

public class FenxuiLogoSkin extends SkinBase<FenxuiLogo> {
	private final VBox logo;

	public FenxuiLogoSkin(FenxuiLogo fenxuiLogo) throws FenxuiInitializationException {
		super(fenxuiLogo);

		SVGGlyph glyph = GlyphUtil.getGlyph("fenxui.svg", fenxuiLogo.getColorTop(), fenxuiLogo.getSize()*.93);
		glyph.setId("logo");
		SVGGlyph glyph2 = GlyphUtil.getGlyph("fenxui2.svg", fenxuiLogo.getColorBottom(), fenxuiLogo.getSize());
		DoubleProperty diffWidth = new SimpleDoubleProperty();
		diffWidth.bind(glyph2.widthProperty().subtract(glyph.widthProperty()));
		//indent top path
		Translate width = new Translate();
		width.xProperty().bind(diffWidth.divide(2));
		glyph.getTransforms().add(width);

		//move bottom path to approximate position
		Translate height = new Translate();
		height.yProperty().bind(glyph.heightProperty().multiply(0.7));
		glyph2.getTransforms().add(height);

		logo = new VBox();
		logo.getChildren().addAll(glyph, glyph2);
		logo.setAlignment(Pos.BOTTOM_LEFT);
		Rectangle rectangle2D = new Rectangle();
		rectangle2D.heightProperty().bind(glyph.heightProperty().multiply(1.2));
		rectangle2D.widthProperty().bind(glyph2.widthProperty());
		logo.setClip(rectangle2D);

		getChildren().add(logo);
	}
}
