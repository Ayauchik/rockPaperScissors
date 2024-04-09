// Top-level build file where you can add configuration options common to all sub-projects/modules.
//buildscript {
//    // Добавление репозитория Maven Central
//    repositories {
//        mavenCentral()
//    }
//    dependencies {
//        classpath("com.android.tools.build:gradle:8.2.0")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.21")
//        classpath("com.google.dagger:hilt-android-gradle-plugin:2.44")
//    }
//}
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
   // id ("com.google.dagger.hilt.android") version "2.44" apply false
}