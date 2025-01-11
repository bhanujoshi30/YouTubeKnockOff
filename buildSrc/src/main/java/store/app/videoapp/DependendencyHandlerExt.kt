package store.app.videoapp

import org.gradle.api.artifacts.ModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.exclude
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.exclude


fun DependencyHandler.implement(dependencyName:String){
    add("implementation",dependencyName)
}

fun DependencyHandler.implementDependencyWithExclusions(
    dependencyName: String,
    excludeGroup: String? = null,
    excludeModule: String? = null
) {
    val dependency=(create(dependencyName) as ModuleDependency)
    add("implementation",dependency)
    dependency.exclude(group = "com.github.bumptech.glide", module = "annotations")
}



fun DependencyHandler.getPlatformAndImplement(dependencyName:String){
    platform(dependencyName).apply {
        add("implementation",this)
    }
}

fun DependencyHandler.kapt(dependencyName:String){
    add("kapt",dependencyName)
}