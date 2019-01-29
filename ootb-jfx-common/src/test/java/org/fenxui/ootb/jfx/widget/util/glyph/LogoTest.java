package org.fenxui.ootb.jfx.widget.util.glyph;

import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.fenxui.application.view.components.option.ColorOptions;
import org.fenxui.ootb.jfx.layout.FenxuiLogo;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class LogoTest extends ApplicationTest {
	VBox contentPane;

	@Override
	public void start(Stage stage) {
		contentPane = new VBox();
		contentPane.setId("content");
		contentPane.setBackground(new Background(new BackgroundFill(Paint.valueOf("000000"), new CornerRadii(0), null)));
		FenxuiLogo logo = new FenxuiLogo("#91b7f2", ColorOptions.BLUEISH, 120);
		contentPane.getChildren().add(logo);
		Scene scene = new Scene(contentPane, 800, 600);
		stage.setScene(scene);
		stage.show();
	}

	@Test
	public void marshallSkinnedNumberFieldToBigDecimal() {
		clickOn("#content	");
		boolean breakHere = true;
	}
}
