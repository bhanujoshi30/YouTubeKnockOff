import store.app.videoapp.installActivityExt
import store.app.videoapp.installAndroidCore
import store.app.videoapp.installCompose
import store.app.videoapp.installComposeNavigation
import store.app.videoapp.installCoroutines
import store.app.videoapp.installHilt
import store.app.videoapp.installHiltViewModelComposeExtension
import store.app.videoapp.installNavGraph
import store.app.videoapp.installViewModelLiveDataExt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
}

android {
    namespace = "store.app.trending"
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":features:core"))
    implementation("androidx.test.ext:junit-ktx:1.2.1")
    installAndroidCore()
    installCoroutines()
    installHilt()
    installHiltViewModelComposeExtension()
    installViewModelLiveDataExt()
    installNavGraph()
    installActivityExt()
    installCompose()
    installComposeNavigation()
}