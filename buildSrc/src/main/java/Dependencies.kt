import org.gradle.api.artifacts.dsl.DependencyHandler

object Apps {
    const val compileSdk= 32
    const val minSdk = 21
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val buildToolsVersion = "29.0.3"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val proguardConsumerRules =  "consumer-rules.pro"
    const val dimension = "environment"
}

object Versions {
    const val kotlin = "1.6.10"
    const val gradle = "7.1.2"
    const val coreKtx = "1.7.0"
    const val appCompat = "1.4.1"
    const val material = "1.5.0"
    const val constraintLayout = "2.1.3"
    const val junit = "4.13.2"
    const val extJunit = "1.1.3"
    const val espresso = "3.4.0"
    const val hilt = "2.41"
    const val glide = "4.11.0"
    const val retrofit = "2.9.0"
    const val retrofitAdapter = "2.6.4"
    const val logging = "4.9.0"
    const val shimmer = "0.5.0"
    const val rxKotlin = "2.3.0"
    const val rxAndroid = "2.1.1"
    const val activityKtx = "1.4.0"
    const val lottie = "3.4.0"
}


object Dependencies {
    //std lib
    private const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //android ui
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    private const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private const val material = "com.google.android.material:material:${Versions.material}"
    private const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    private const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
    private const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    //Retrofit
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private const val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitAdapter}"
    private const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    private const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.logging}"
    //Reactive
    private const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    private const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    // Hilt
    private const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    private const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    //test libs
    private const val junit = "junit:junit:${Versions.junit}"
    private const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
        add(activityKtx)
        add(appcompat)
        add(constraintLayout)
        add(material)
        add(glide)
        add(retrofit)
        add(shimmer)
        add(lottie)
        add(retrofitAdapter)
        add(retrofitConverter)
        add(logging)
        add(hilt)
        add(rxKotlin)
        add(rxAndroid)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }

    val kaptLibraries = arrayListOf<String>().apply {
        add(hiltCompiler)
    }

}


//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}