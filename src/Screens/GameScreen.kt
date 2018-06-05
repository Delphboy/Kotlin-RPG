package Screens

import javafx.scene.Scene
import javafx.scene.canvas.GraphicsContext
import javafx.scene.layout.Pane

class GameScreen : ScreenIF, Pane
{
    constructor(gc: GraphicsContext) : super()
    {
        println("GameScreen")
    }

    override fun killScreen()
    {

    }
}