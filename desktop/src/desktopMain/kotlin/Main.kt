import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import ru.rayanis.instroy.SayHelloFromCommon
import ru.rayanis.instroy.sayHello

fun main() {
    sayHello()

    application {
        Window(
            onCloseRequest = { exitApplication() },
            state = rememberWindowState(),
            title = "InStroy"
        ) {
            SayHelloFromCommon()
        }
    }
}