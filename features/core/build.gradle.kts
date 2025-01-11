import store.app.videoapp.implement
import store.app.videoapp.installAndroidCore
import store.app.videoapp.installCompose
import store.app.videoapp.installComposeConstraintLayout
import store.app.videoapp.installExoplayer
import store.app.videoapp.installGlide
import store.app.videoapp.installGson
import store.app.videoapp.installHilt
import store.app.videoapp.installRetrofit
import store.app.videoapp.installShimmerCompose

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = "store.app.core"
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    installAndroidCore()
    installRetrofit()
    installGlide()
    installCompose()
    installExoplayer()
    installComposeConstraintLayout()
    installGson()
    installHilt()
    installShimmerCompose()
}