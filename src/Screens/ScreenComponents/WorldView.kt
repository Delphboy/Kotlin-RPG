package Screens.ScreenComponents

import javafx.animation.AnimationTimer
import javafx.scene.canvas.GraphicsContext
import javafx.scene.layout.Pane
import world.World



class WorldView(gc: GraphicsContext) : ComponentIF, Pane()
{
    val world: World = World(gc)
    var lastAnimationTime: Long = 0
    var gameLoopTimer: AnimationTimer = object : AnimationTimer()
    {
        override fun handle(l: Long)
        {
            for (c in world.characters)
            {
                // 1 * 1000000 = 1 millisecond
                if(System.nanoTime() - lastAnimationTime >= (60 * 1000000))
                {
                    c.move()
                    lastAnimationTime = System.nanoTime()
                }
            }

        }
    }

    init
    {
        world.renderWorld(gc)
        children.add(gc.canvas)
        gameLoopTimer.start()
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