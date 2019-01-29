# fenxui-ootb
Out-of-the-box factories/prototypes for fenxui applications
## Getting Started
* Clone the fenxui-lib repository
* Build fenxui library using gradle <i>install</i> target
```
C:\Users\Me\Documents\GitHub\fenxui-lib>gradle install
```
* Clone the fenxui-ootb repository
* Build the fenxui-ootb dependencies using the gradle <i>install</i> target
```
C:\Users\Me\Documents\GitHub\fenxui-ootb>gradle install
```
* Add to your app
```
repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    compile group: 'org.fenxui', name: 'ootb-jfx-jdk8', version: '1.0+'
```

* Make your main class extend <b>FenxuiApplication</b> and provide an annotated view model for introspection.
```java
public class SampleApp extends FenxuiApplication {

	@Override
	public FenxuiConfig getFenxuiConfig() {
		return new FenxuiConfig.Builder()
				.css(SampleApp.class.getResource("/css/SampleApp.css"))
				.title("Sample Fenxui App")
				.build();
	}

	@Override
	public FenxuiPrototype getFenxuiPrototype() {
		return JFX8Prototype.newInstance(new SampleViewModel(), () -> {
			log.info("Application closing");
			Platform.exit();
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
```
* That's it!  See the [samples](https://github.com/fenxui/samples) repository for more demo applications.
### Prerequisites
* You must have a JDK (version 8) that supports JavaFX such as [Amazon Corretto 8](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html/).
* You must have Gradle installed to be able to build fenxui
## Built With
* [Amazon Corretto 8](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html/) - JDK8/OpenJFX8
* [Gradle](https://gradle.org/) - Dependency Management
* [Foenix](https://github.com/jfoenixadmin/JFoenix) - Material Design UI styleing
## Contributing

## Versioning

## Authors

* **Ben Arnold** - *Initial work*

See also the list of [contributors](https://github.com/benfarnold/fenxui/contributors) who participated in this project.

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgment
* SVGs by ICOMOON.
