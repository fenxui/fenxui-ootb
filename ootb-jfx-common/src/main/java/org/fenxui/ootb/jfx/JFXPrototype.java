package org.fenxui.ootb.jfx;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.fenxui.application.config.FenxuiConfig;
import org.fenxui.application.view.FenxuiViewModel;
import org.fenxui.application.view.decorator.FactoryInvocation;
import org.fenxui.application.view.decorator.SceneDecorator;
import org.fenxui.application.view.factory.FenxuiFactory;
import org.fenxui.application.view.factory.ootb.AppFactory;
import org.fenxui.application.view.prototype.FenxuiPrototype;
import org.fenxui.ootb.jfx.layout.JFXWindowDressingDecorator;

public class JFXPrototype {
	private final FenxuiViewModel fenxuiViewModel;
	private final AppFactory appFactory;
	private final boolean useJFXDecorator;

	public JFXPrototype(FenxuiViewModel fenxuiViewModel, AppFactory appFactory, boolean useJFXDecorator) {
		this.fenxuiViewModel = fenxuiViewModel;
		this.appFactory = appFactory;
		this.useJFXDecorator = useJFXDecorator;
	}

	public FenxuiPrototype newInstance() {
		return (FenxuiConfig fenxuiConfig) -> {
			appFactory.setViewModel(fenxuiViewModel);
			SceneDecorator sceneDecorator;
			if (useJFXDecorator) {
				sceneDecorator = new SceneDecorator(new JFXWindowDressingDecorator(new FactoryInvocation(appFactory)));
			} else {
				sceneDecorator = new SceneDecorator(new FactoryInvocation(appFactory));
			}
			return (FenxuiFactory) (Stage stage) -> {
				fenxuiViewModel.setStage(stage);
				if (!useJFXDecorator) {
					Image image = new Image(JFXPrototype.class.getResourceAsStream("fenxui-logo-blueonblack.png"));
					stage.getIcons().add(image);
				}
				return sceneDecorator.decorate(fenxuiConfig);
			};
		};
	}
}
