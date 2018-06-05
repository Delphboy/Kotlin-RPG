package Screens

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Button
import javafx.scene.layout.Pane
import javafx.scene.text.Font
import updateScreen

class MainMenuScreen : ScreenIF, Pane
{
    constructor(gc: GraphicsContext) : super()
    {
        val buttonStartGame = Button("Start Game")
        buttonStartGame.setFont(Font("Cooper Black", 24.0))
        buttonStartGame.onAction = EventHandler {
            updateScreen(GameScreen(gc))
        }
        buttonStartGame.setMinSize(280.0, 110.0)
        buttonStartGame.setMaxSize(280.0, 110.0)
        buttonStartGame.layoutX = 900.0
        buttonStartGame.layoutY = 700.0

        children.add(buttonStartGame)
    }

    override fun killScreen()
    {

    }

}