plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.android.library)
    alias(libs.plugins.sqldelight)
}

kotlin {
    jvm()
    androidTarget()

    sourceSets {
        val commonMain by getting {
            dependencies {
                //Compose
                implementation(project.dependencies.platform(libs.androidx.compose.bom))
                implementation(compose.foundation)
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.material)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)

                //MVIKotlin
                implementation(libs.mvikotlin)
                implementation(libs.mvikotlin.main)
                implementation(libs.mvikotlin.extensions.coroutines)
                implementation(libs.mvikotlin.logging)

                //Decompose
                implementation(libs.decompose)
                implementation(libs.decompose.extensions.compose)

                //Settings
                implementation(libs.settings)

                //Di
                api(libs.koin.core)

                //SqlDelight
                implementation(libs.sqldelight.coroutines.extensions)
            }
        }

        androidMain {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.sqldelight.android.driver)
            }
        }

        jvmMain {
            dependsOn(commonMain)
            dependencies {
                api(compose.desktop.currentOs)
                implementation(libs.sqldelight.desktop.driver)
            }
        }
    }
}

android {
    namespace = findProperty("app.namespace").toString()
    compileSdk = findProperty("android.compileSdk").toString().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

sqldelight {
    databases {
        create("AppDb") {
            packageName.set("ru.rayanis.cyzlike.db")
            schemaOutputDirectory.set(file("src/commonMain/sqldelight/db"))
        }
    }
}
