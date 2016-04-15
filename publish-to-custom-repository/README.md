# Publishing to a custom Plugin Repository

This example project demonstrates how plugins can be published to a custom Maven repository.

## Usage

- run `./gradlew publish`
- the plugins in this project will be published to `../maven-repo`

Alternatively, you can:
- run `./gradlew run`
- `run` depends on `plublish` and also runs a simple jetty server to serve the repo over http.

## Project Structure

- this project currently contains two simple plugins that each add a task
- both plugins are published as a single jar
- along with the jar, a marker POM for each plugin is published. This serves as a mapping
from the plugin's id to the actual artifact containing the plugin implementation.
- creation of these marker POMs will be automated as part of milestone 1.3
