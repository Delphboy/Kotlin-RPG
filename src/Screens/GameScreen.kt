package Screens

import Screens.ScreenComponents.StatsView
import Main
import Screens.Controllers.KeyboardController
import Screens.ScreenComponents.WorldView
import javafx.event.Event
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.canvas.GraphicsContext
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.layout.Pane

class GameScreen(gc: GraphicsContext) : ScreenIF, Pane()
{
    var worldView: WorldView = WorldView(gc)
    var statsView: StatsView = StatsView(gc)

    init
    {
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

        //Configure controllers
//        worldView.onKeyPressed(KeyboardController())

    }

    override fun killScreen()
    {

    }
}