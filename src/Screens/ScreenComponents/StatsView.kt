package Screens.ScreenComponents

import javafx.event.EventHandler
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.text.Font

class StatsView : Pane, ComponentIF
{
    constructor(gc: GraphicsContext) : super()
    {
        val buttonStartGame = Button("Stats")
        buttonStartGame.setFont(Font("Cooper Black", 24.0))
        buttonStartGame.onAction = EventHandler {
            println("sent from stats view")
        }
        buttonStartGame.setMinSize(100.0, 100.0)
        buttonStartGame.setMaxSize(100.0, 100.0)
        buttonStartGame.layoutX = 0.0
        buttonStartGame.layoutY = 0.0

        children.add(buttonStartGame)
    }

    override fun update()
    {
        print("update")
    }

    override fun killComponent()
    {
        print("kill")
    }
}