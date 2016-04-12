package org.example.hello;

import org.gradle.api.Project;
import org.gradle.api.Plugin;

public class HelloPlugin implements Plugin<Project> {
  public void apply(Project project) {
    project.getLogger().lifecycle("Hello!");
  }
}
