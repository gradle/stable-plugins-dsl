# Resolving from custom Plugin Repository

This example project demonstrates how plugins can be resolved from a custom Maven
repository.

## Usage

- publish the [example plugins](../publish-to-custom-repository)
- run `./gradlew hello` in this project to verify plugin resolution worked
- try resolving other plugins to see that failure is handled gracefully
and that resolving from the Plugin Portal still works

If you ran the Jetty server from the [example plugins](../publish-to-custom-reposiotry), you can specify
that in the [settings.gradle](settings.gradle) file:

```
pluginRepositories {
  maven {
    url 'http://localhost:8080'
  }
}
```

## Project Structure

- `build.gradle` references a plugin published by the example plugins project
