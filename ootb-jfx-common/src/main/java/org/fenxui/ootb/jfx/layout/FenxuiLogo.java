package org.fenxui.ootb.jfx.layout;

import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fenxui.core.exception.FenxuiInitializationException;

public class FenxuiLogo extends Control {
	private static final Logger logger = LogManager.getLogger(FenxuiLogo.class);

	private final String colorTop;
	private final String colorBottom;

	private final double size;

	public FenxuiLogo(String colorTop, String colorBottom, double size) {
		this.colorTop = colorTop;
		this.colorBottom = colorBottom;
		this.size = size;
	}

	@Override
	protected Skin<?> createDefaultSkin() {
		try {
			return new FenxuiLogoSkin(this);
		} catch (FenxuiInitializationException e) {
			logger.error("Error creating logo skin", e);
		}
		return null;
	}

	public double getSize() {
		return size;
	}

	public String getColorTop() {
		return colorTop;
	}

	public String getColorBottom() {
		return colorBottom;
	}
}
