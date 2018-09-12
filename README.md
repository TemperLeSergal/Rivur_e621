# Rivfur e621 downloading application

[![version](https://img.shields.io/badge/version-1.0.0.a-lightgreen.svg)](https://semver.org)

This application is built with Java and JavaFX. The application is an image downloading tool for e621 with a unique and user friendly interface
that can be built natively. It allows for full control over images you wish to download. 

## Getting Started

Fork the project, and contact me for the dependencies used in this project, and run it.

### Prerequisites

Java:
```
JDK 10
```
JavaFX:
```
JavaFX 2
```
Scene Builder:
```
Gluon Scene Builder
```
Dependencies: 
```
  - typhon0 AnimateFX (Maven)
  - Joda-Time (Maven)
  - ControlsFX
  - Javax.mail
  - JFoenix
  - JSON Simple
  - Unirest (for Java)
```

### Installing

In order to properly set up your enviroment with JavaFX:

Do your best to import your dependencies as jars:

```
These dependencies can be downloaded as jars:
  - ControlsFX
  - Javax.mail
  - JFoenix
  - JSON Simple
  - Unirest (for Java)
```

Import through Maven, do not add a Maven framework to the JavaFX project as it is known to create issues, and JavaFX will no longer work with that project.

```
These dependencies can be downloaded through Maven in your IDE:
  - typhon0 AnimateFX (Maven)
  - Joda-Time (Maven)
```

## Deployment

Before you can build and deploy your workspace, you must ensure that you have properly set up native packaging for your IDE. There are a lot of articles that cover this topic on google.

## Built With

* [JSON simple](https://github.com/fangyidong/json-simple) - To parse JSON files recieved from e621 API calls.
* [ControlsFX](https://gluonhq.com/controlsfx/) - For UI design
* [JFoenix](https://github.com/jfoenixadmin/JFoenix) - For UI design
* [Java Mail](https://javaee.github.io/javamail/) - For sending mail through POP3 and SMTP protocols
* [Unirest](http://unirest.io/java.html) - For simplified API calls through HTTP GET and POST methods
* [AnimateFX](https://github.com/Typhon0/AnimateFX) - For UI design and simple node animation methods
* [Joda Time](http://www.joda.org/joda-time/) - For ease of time management in application methods

## Contributing

Please read [CONTRIBUTING.md](https://github.com/TemperLeSergal/Rivur_e621_Downloader/blob/master/Contributing.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Cotton Le Sergal** - *Initial work* - [Rivfur](https://github.com/TemperLeSergal/Rivur_e621_Downloader)

See also the list of [contributors](https://github.com/TemperLeSergal/Rivur_e621_Downloader/blob/master/Contributors.md) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* This project is still a WIP, but I would like to thank all of those that have contributed thus far for doing so!
