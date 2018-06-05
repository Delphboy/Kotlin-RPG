package Screens.ScreenComponents

import Screens.GameScreen
import javafx.event.EventHandler
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Button
import javafx.scene.layout.Pane
import javafx.scene.text.Font
import updateScreen
import world.World

class WorldView : ComponentIF, Pane
{
    constructor(gc: GraphicsContext) : super()
    {
        val world: World = World(gc)
        world.renderWorld(gc)
        children.add(gc.canvas)
    }

    override fun update()
    {
        println("update")
    }

    override fun killComponent()
    {
        print("kill")
    }
}