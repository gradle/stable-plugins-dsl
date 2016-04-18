# Resolving from custom Plugin Repository

This example project demonstrates how plugins can be resolved from a custom Maven
repository.

## Usage

- publish the [example plugins](../publish-to-custom-repository)
- run `./gradlew hello` in this project to verify plugin resolution worked
- try resolving other plugins to see that failure is handled gracefully
and that resolving from the Plugin Portal still works

If you ran the Jetty server from the [example plugins](../publish-to-custom-reposiotry), you can specify
that repo using:

- `./gradlew hello -Dorg.gradle.plugin.repoUrl=http://localhost:8080` in a separate console

## Project Structure

- `build.gradle` references a plugin published by the example plugins project
- `gradle.properties` sets up the system property pointing to the custom Maven repository.
This mechanism will be replaced by a more sophisticated repository declaration as part of milestone 1.2.
