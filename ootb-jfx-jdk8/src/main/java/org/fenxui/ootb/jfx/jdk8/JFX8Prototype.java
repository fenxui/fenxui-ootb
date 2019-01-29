package org.fenxui.ootb.jfx.jdk8;

import org.fenxui.application.view.FenxuiViewModel;
import org.fenxui.application.view.factory.ootb.DefaultAppFactory;
import org.fenxui.application.view.prototype.FenxuiPrototype;
import org.fenxui.ootb.jfx.JFXPrototype;
import org.fenxui.ootb.jfx.jdk8.factory.JFX8FactoryInitContext;

/**
 * Prototype for a page styled with JFoenix library
 */
public interface JFX8Prototype extends FenxuiPrototype {

	static FenxuiPrototype newInstance(FenxuiViewModel fenxuiViewModel, Runnable onCloseAction) {
		return newInstance(fenxuiViewModel, onCloseAction, false);
	}

	static FenxuiPrototype newInstance(FenxuiViewModel fenxuiViewModel, Runnable onCloseAction, boolean useJFXDecorator) {
		return new JFXPrototype(fenxuiViewModel, new DefaultAppFactory(onCloseAction, new JFX8FactoryInitContext()), useJFXDecorator).newInstance();
	}

}
