import store.app.videoapp.installActivityExt
import store.app.videoapp.installAndroidCore
import store.app.videoapp.installCompose
import store.app.videoapp.installComposeNavigation
import store.app.videoapp.installCoroutines
import store.app.videoapp.installGlide
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
    namespace = "store.app.profile"
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":features:core"))
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
    implementation("androidx.fragment:fragment-ktx:1.5.6")
    implementation("androidx.test.ext:junit-ktx:1.2.1")
    installAndroidCore()
    installCoroutines()
    installHilt()
    installGlide()
    installViewModelLiveDataExt()
    installNavGraph()
    installActivityExt()
    installHiltViewModelComposeExtension()
    installCompose()
    installComposeNavigation()
}