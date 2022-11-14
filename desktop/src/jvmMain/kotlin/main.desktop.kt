import javax.swing.JFrame
import javax.swing.SwingUtilities
import platform.PlatformConfiguration
import setup.setupThemedNavigation

fun main() = SwingUtilities.invokeLater {
    PlatformSDK.init(PlatformConfiguration())

    JFrame().setupThemedNavigation()
}