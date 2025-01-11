import store.app.videoapp.installAndroidCore
import store.app.videoapp.installCompose
import store.app.videoapp.installComposeNavigation
import store.app.videoapp.installExoplayer
import store.app.videoapp.installGson
import store.app.videoapp.installHilt
import store.app.videoapp.installHiltViewModelComposeExtension

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
}

android {
    namespace = "store.app.home"
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation( project(":features:core"))
    implementation(project(":features:commonui"))
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
    implementation("androidx.fragment:fragment-ktx:1.5.6")
    installAndroidCore()
    installHilt()
    installCompose()
    installComposeNavigation()
    installHiltViewModelComposeExtension()
    installExoplayer()
    installGson()
}