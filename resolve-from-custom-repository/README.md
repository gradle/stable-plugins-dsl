# Resolving from custom Plugin Repository

This example project demonstrates how plugins can be resolved from a custom Maven
repository.

## Usage

- publish the [example plugins](../publish-to-custom-repository)
- run `./gradlew hello` in this project to verify plugin resolution worked
- try resolving other plugins to see that failure is handled gracefully
and that resolving from the Plugin Portal still works

You can also run the the Http repo server in [example plugins](../publish-to-custom-reposiotry)
and uncomment it in `settings.gradle` to see authentication in action.

## Project Structure

- `build.gradle` references a plugin published by the example plugins project
- `settings.gradle` sets up a maven repo based on the `../maven-repo` directory
