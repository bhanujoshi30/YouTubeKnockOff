package store.app.videoapp

import org.gradle.api.artifacts.dsl.DependencyHandler


private const val room_version="2.6.1"
private const val navigation_graph_version="2.5.3"
private const val coroutine_ktx_version="1.7.1"
const val hilt_Version="2.46"
private const val viewModel_livedata_ktx_version="2.7.0"

private const val retrofit_version = "2.9.0"
private const val gsonConvertor_version = "2.9.0"
private const val okHttp_version = "4.9.0"
private const val compose_Version="1.0.2"

private const val core_ktx="androidx.core:core-ktx:1.10.0"
private const val app_compact="androidx.appcompat:appcompat:1.6.1"
private const val android_material="com.google.android.material:material:1.9.0"
private const val constraintLayout="androidx.constraintlayout:constraintlayout:2.1.4"
private const val gson ="com.google.code.gson:gson:2.8.8"
 //coroutines
private const val coroutine_core="org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutine_ktx_version"
private const val coroutines_android="org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutine_ktx_version"
 //dagger
private const val hilt="com.google.dagger:hilt-android:$hilt_Version"
private const val hilt_compiler="com.google.dagger:hilt-android-compiler:$hilt_Version"
 //viewModel & livedata
private const val viewModel_ktx="androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModel_livedata_ktx_version"
private const val livedata_ktx="androidx.lifecycle:lifecycle-livedata-ktx:$viewModel_livedata_ktx_version"
//private const val viewModel_for_compose="androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1"
private const val viewModel_for_compose="androidx.hilt:hilt-navigation-compose:1.0.0"
 //ktx
private const val activity_ktx="androidx.activity:activity-ktx:1.7.2"

 // Glide
private const val glide="com.github.bumptech.glide:glide:4.13.2"
private const val glide_compiler="com.github.bumptech.glide:compiler:4.12.0"
private const val glide_compose="com.github.bumptech.glide:compose:1.0.0-beta01"
 //room

private const val room="androidx.room:room-runtime:$room_version"
private const val room_compiler="androidx.room:room-compiler:$room_version"
private const val room_ktx="androidx.room:room-ktx:$room_version"
 //shimmer
private const val shimmer="com.facebook.shimmer:shimmer:0.5.0"
private const val shimmer_compose ="androidx.compose.animation:animation:1.5.0"
 //RxJava
private const val rx_java="io.reactivex.rxjava3:rxjava:3.0.13"
private const val rx_android="io.reactivex.rxjava3:rxandroid:3.0.0"

private const val navigation_fragment="androidx.navigation:navigation-fragment:$navigation_graph_version"
private const val nav_ktx="androidx.navigation:navigation-ui-ktx:$navigation_graph_version"
private const val nav_fragment_ktx="androidx.navigation:navigation-fragment-ktx:$navigation_graph_version"

private const val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
private const val retrofit_gsonConvertor = "com.squareup.retrofit2:converter-gson:$gsonConvertor_version"
private const val retrofit_okHttp = "com.squareup.okhttp3:okhttp:$okHttp_version"


private const val compose_material = "androidx.compose.material:material:1.6.3"
private const val compose_ui = "androidx.compose.ui:ui"
private const val compose_graphic="androidx.compose.ui:ui-graphics"
private const val compose_activity="androidx.activity:activity-compose"
private const val compose_fragment_ktx="androidx.fragment:fragment-ktx:1.5.7"
private const val compose_toolPreview = "androidx.compose.ui:ui-tooling-preview"
private const val compose_ui_tooling = "androidx.compose.ui:ui-tooling"
private const val composeBom = "androidx.compose:compose-bom:2024.09.03"
private const val composeRuntime="androidx.compose.runtime:runtime"
private const val compose_navigation="androidx.navigation:navigation-compose:2.7.7"
private const val compose_constraintLayout="androidx.constraintlayout:constraintlayout-compose:1.0.1"


private const val exo_player="androidx.media3:media3-exoplayer:1.2.0"
private const val exo_player_media="androidx.media3:media3-ui:1.2.0"

//bottomSheet
private const val bottom_sheet="com.google.accompanist:accompanist-navigation-material:0.36.0"


fun DependencyHandler.installBottomSheet(){
    implement(bottom_sheet)
}


fun DependencyHandler.installCompose(){
    getPlatformAndImplement(composeBom)
    implement(composeRuntime)
    implement(compose_material)
    implement(compose_ui)
    implement(compose_toolPreview)
    implement(compose_ui_tooling)
    implement(compose_activity)
    implement(compose_graphic)
    implement(compose_fragment_ktx)
}

fun DependencyHandler.installComposeNavigation(){
    implement(compose_navigation)
}


fun DependencyHandler.installComposeConstraintLayout(){
    implement(compose_constraintLayout)
}


fun DependencyHandler.installHiltViewModelComposeExtension(){
    implement(viewModel_for_compose)
}

fun DependencyHandler.installComposeRuntimeCompiler(){
    getPlatformAndImplement(composeBom)
    implement(composeRuntime)
}


fun DependencyHandler.installAndroidCore(){
    implement(core_ktx)
    implement(app_compact)
    implement(constraintLayout)
    implement(android_material)
}


fun DependencyHandler.installRoom( ){
    implement(room)
    implement(room_compiler)
    implement(room_ktx)
}

fun DependencyHandler.installNavGraph(){
    implement(navigation_fragment)
    implement(nav_ktx)
}


fun DependencyHandler.installHilt(){
    implement(hilt)
    kapt(hilt_compiler)
}

fun DependencyHandler.installCoroutines(){
    implement(coroutine_core)
    implement(coroutines_android)
}

fun DependencyHandler.installViewModelLiveDataExt(){
    implement(viewModel_ktx)
    implement(livedata_ktx)
}

fun DependencyHandler.installActivityExt(){
    implement(activity_ktx)
}

fun DependencyHandler.installNavigationFragmentKtx(){
    implement(nav_fragment_ktx)
}

fun DependencyHandler.installRetrofit(){
    implement(retrofit)
    implement(retrofit_gsonConvertor)
    implement(retrofit_okHttp)
}

fun DependencyHandler.installGlide(){
    implement(glide_compiler)
    implement(glide)
    implement(glide_compose)
}


fun DependencyHandler.installExoplayer(){
    implement(exo_player)
    implement(exo_player_media)
}
fun DependencyHandler.installGson(){
    implement(gson)
}

fun DependencyHandler.installShimmerCompose(){
    implement(shimmer_compose)
}
