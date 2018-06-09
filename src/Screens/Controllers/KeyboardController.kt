package Screens.Controllers

import Screens.GameScreen
import javafx.event.Event
import javafx.event.EventHandler
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent

class KeyboardController : EventHandler<Event>
{
    override fun handle(event: Event?)
    {
        if(event != null)
        {
            inputProc(event as KeyEvent)
        }
    }

    /**
     * Handle keyboard inputs
     */
    fun inputProc(inp: KeyEvent)
    {
        when (inp.code)
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
            else -> println("Unhandled Key press: $inp")
        }
    }

}