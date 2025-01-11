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
    namespace = "store.app.commonui"
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":features:core"))
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
    installCompose()
    installHilt()
    installComposeNavigation()
    installHiltViewModelComposeExtension()
    installExoplayer()
    installGson()
}