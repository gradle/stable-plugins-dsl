## Project Summary

The Stable Plugins DSL project is sponsored work to reduce the burden of configuring, resolving, and publishing plugins (especially, for enterprise users.)

## Background

Currently, we have several competing ways to declare plugins to be used by a project, each with their own limitations:

* `apply from: 'some/path/foo.gradle'` - Allows applying script plugins

* `apply plugin : 'aplugin'` - Applies a plugin which is already on the `buildscript.configurations.classpath`. It is either a core plugin like `'java'`, a plugin from the `buildSrc` directory or it has been added as a dependency using the `repositories {}` and `dependencies {}` blocks.

* `plugins { id 'some.plugin' version '2.3' }` - resolves the plugin using the [https://plugins.gradle.org](https://plugins.gradle.org) to map from the plugin id and version to the implementing jar file and its dependencies which are then downloaded and added to the buildscript.configurations.classpath.

Some larger enterprise users invest a lot of time and energy into setting up internal plugins and using them on all of their projects to standardize their development and make the lives of their developers easier.  These plugins are often not published to [https://plugins.gradle.org](https://plugins.gradle.org).  Asking these users to configure the same buildscript repositories and dependencies blocks for each of their projects is a nuisance.

## Solution

The key milestones are:

1. Resolve plugins from a maven/ivy repository based on the plugin id

    1. Specify which repositories to look in for plugins

    2. Publish plugins to a maven/ivy repository complete with metadata needed to map from the plugin id to a maven/ivy artifact and its dependencies

2. Specify plugins to be used on multiple projects in a multi-project build in a single block

3. Support dynamic versions for plugins

4. Support locking versions of plugins in version control to increase build reproducibility

We are currently committed to delivering #1 and #2. #3 and #4 are still being prioritized.

## Gradle Team

Technical Leadership: Luke Daley [@alkemist](https://github.com/alkemist)

Engineering Coordination: Piotr Jagielski ([piotr@gradle.com](mailto:piotr@gradle.com))

Engineers: Pepper Lebeck-Jobe [@eljobe](https://github.com/alkemist), Stefan Oehme [@oehme](https://github.com/oehme)

## Development Process

* ZenHub on top of GitHub issues to track progress

* [Design documents](https://github.com/gradle/gradle/tree/master/design-docs/features/stable-plugins-dsl) are iterated on in Google Docs and then checked into gradle/gradle

* Weekly team meeting

* Weekly stream update on discourse

* Time tracking using the engineering spreadsheet

