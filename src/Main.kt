import Screens.MainMenuScreen
import Screens.ScreenIF
import globals.height
import globals.scene
import globals.width
import globals.window
import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.stage.Stage
import javafx.stage.StageStyle
import world.World
import sun.audio.AudioPlayer.player
import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.W
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.canvas.GraphicsContext
import javafx.scene.layout.Pane





object globals
{
    public val width = 1280.0
    public val height = 900.0
    public var scene: Scene = Scene(MainMenuScreen(gc), width, height)
    public var window: Stage = Stage()
}

private val canvas = Canvas(globals.width, globals.height)
private val gc = canvas.graphicsContext2D

/**
 * Update the screen being displayed to the user
 */
public fun updateScreen(newParent: ScreenIF)
{
    val oldParent = scene.root
    val oldPane = oldParent as Pane
    (oldPane as ScreenIF).killScreen()

    scene = Scene(newParent as Parent, width, height)
    window.scene = scene
}

class Main : Application()
{
    val root: Group = Group()
    val scene: Scene = Scene(root)

    //Static entry point
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }

    /**
     * Main method
     * Set up window and display it
     */
    override fun start(primaryStage: Stage)
    {
        window = primaryStage

        window.setOnCloseRequest {
            System.exit(1)
        }

        window.addEventFilter(KeyEvent.KEY_PRESSED) { ke ->
            inputProc(ke.code)
        }

        window.title = "RPG"
        window.isResizable = false
        window.initStyle(StageStyle.DECORATED)

        updateScreen(MainMenuScreen(gc))

        window.show()
    }

    /**
     * Handle keyboard inputs
     */
    fun inputProc(inp: KeyCode)
    {
        when (inp)
        {
            KeyCode.W ->
            {
                print("Up")
            }
            KeyCode.A ->
            {
                print("Left")
            }
            KeyCode.S ->
            {
                print("Down")
            }
            KeyCode.D ->
            {
                print("Right")
            }
            else -> println("Unhandled Key press: " + inp)
        }
    }

}