plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    id("kotlin-android")
    id("kotlin-kapt")


}

android {
    namespace = "com.example.examen_m5_paulamarkov"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.examen_m5_paulamarkov"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    val nav_version = "2.7.7"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")


    // view model y livedata
    val lifecycle_version = "2.2.0"
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-extensions:$lifecycle_version")

    // Room
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    kapt("androidx.room:room-compiler:$room_version")

    // Retrofit  -  Convertor
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")

    //Picasso
    implementation ("com.squareup.picasso:picasso:2.8")

    //Interception
    implementation("com.squareup.okhttp3:okhttp:4.9.3")


//test

    implementation ("com.squareup.okhttp3:okhttp:4.9.3")
    testImplementation ("com.squareup.okhttp3:mockwebserver:4.9.3")

    testImplementation ("org.mockito:mockito-core:3.6.0")
    testImplementation ("org.mockito:mockito-inline:3.6.0")
    testImplementation ("io.mockk:mockk:1.12.0")

    testImplementation ("org.robolectric:robolectric:4.9")
    testImplementation ("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("com.nhaarman.mockitokotlin2:mockito-kotlin:2.0.0-alpha03@jar")
    testImplementation ("androidx.test:core-ktx:1.5.0")
    testImplementation ("androidx.test.ext:junit-ktx:1.1.5")


    // For Robolectric tests.
    testImplementation ("com.google.dagger:hilt-android-testing:2.44")
    testAnnotationProcessor ("com.google.dagger:hilt-android-compiler:2.44")

    // For instrumented tests.
    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.44")
    androidTestAnnotationProcessor ("com.google.dagger:hilt-android-compiler:2.44")




}