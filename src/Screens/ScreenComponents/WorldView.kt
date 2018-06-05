package Screens.ScreenComponents

import javafx.animation.AnimationTimer
import javafx.scene.canvas.GraphicsContext
import javafx.scene.layout.Pane
import world.Characters.Player
import world.World
import com.oracle.util.Checksums.update



class WorldView(gc: GraphicsContext) : ComponentIF, Pane()
{
    val world: World = World(gc)
    var gameLoopTimer: AnimationTimer = object : AnimationTimer()
    {
        override fun handle(l: Long)
        {
            for (c in world.characters)
            {
                c.move()
            }
        }
    }

    init
    {
        world.renderWorld(gc)
        gameLoopTimer.start()
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