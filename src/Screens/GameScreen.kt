package Screens

import Screens.ScreenComponents.StatsView
import Main
import Screens.ScreenComponents.WorldView
import javafx.scene.Scene
import javafx.scene.canvas.GraphicsContext
import javafx.scene.layout.Pane

class GameScreen : ScreenIF, Pane
{
    constructor(gc: GraphicsContext) : super()
    {
        val worldView: WorldView = WorldView(gc)
        val statsView: StatsView = StatsView(gc)

        worldView.setMinSize(globals.width, 700.0)
        worldView.setMaxSize(globals.width, 700.0)
        worldView.layoutX = 0.0
        worldView.layoutY = 0.0

        statsView.setMinSize(globals.width, 300.0)
        statsView.setMaxSize(globals.width, 300.0)
        statsView.layoutX = 0.0
        statsView.layoutY = 700.0

        children.add(worldView)
        children.add(statsView)
    }

    override fun killScreen()
    {

    }
}