import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin

plugins {
    id("com.android.application") version "8.7.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.dagger.hilt.android") version "2.46" apply false
}

buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
    }
}


fun BaseExtension.applyPlugin(){
    compileSdkVersion(34)

    defaultConfig {
        minSdk = 24
        targetSdk = 34
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


    buildFeatures.viewBinding=true
    buildFeatures.compose=true
    composeOptions.kotlinCompilerExtensionVersion="1.5.9"
}

fun PluginContainer.applyDefault(project: Project){
   whenPluginAdded {
       when(this){
           is AppPlugin->project.extensions.getByType<AppExtension>().apply {
               applyPlugin()
           }
           is LibraryPlugin ->project.extensions.getByType<LibraryExtension>().apply {
               applyPlugin()
           }
           is JavaPlugin-> project.extensions.getByType<JavaPluginExtension>().apply {
               sourceCompatibility = JavaVersion.VERSION_17
               targetCompatibility = JavaVersion.VERSION_17
           }
       }
   }
}

subprojects {
    plugins.applyDefault(this)
}