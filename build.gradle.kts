buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // هذا السطر يحل مشكلة Plugin [id: 'androidx.navigation.safeargs.kotlin'] was not found
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.6")
    }
}

plugins {
    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}