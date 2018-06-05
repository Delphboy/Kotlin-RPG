package world.Characters

import javafx.embed.swing.SwingFXUtils
import javafx.scene.canvas.GraphicsContext
import javafx.scene.image.Image
import world.World
import world.tileHeightPx
import world.tileTypeToImage
import world.tileWidthPx
import java.awt.image.BufferedImage
import java.io.File
import java.util.*
import javax.imageio.ImageIO

abstract class Character(var x: Int, var y: Int, val gc: GraphicsContext)
{
    var animationFrame: Int = 1
    var dir = direction.UP
    var previousDir = dir

    val spriteSheet = ImageIO.read(File("resources/characters/rad.png"))

    var health: Int = 100
    var stamina: Int = 100
    var majika: Int = 100
    var gold: Int = 100

    fun move()
    {
        fun ClosedRange<Int>.random() =
                Random().nextInt(endInclusive - start) +  start

        val rnd = (1..4).random()
        when(rnd)
        {
            1 -> move(direction.UP)
            2 -> move(direction.DOWN)
            3 -> move(direction.LEFT)
            4 -> move(direction.RIGHT)
        }
    }

    /**
     * Update the player's position and animation
     */
    fun move(dir: direction)
    {
        if(dir != this.dir)
        {
            this.dir = dir
        }
        else
        {
            when(dir)
            {
                direction.UP -> if (y in (0..globals.height.toInt())) y -= tileHeightPx
                direction.DOWN -> if (y in (0..globals.height.toInt()))y += tileHeightPx
                direction.LEFT -> if (x in (0..globals.width.toInt()))x -= tileWidthPx
                direction.RIGHT -> if (x in (0..globals.width.toInt())) x += tileWidthPx
            }

            if(animationFrame < 4)
                animationFrame++
            else
                animationFrame = 0
        }

        render()
    }

    fun render()
    {
        var renderX = 0
        var renderY = 0

        when(dir)
        {
            direction.UP -> renderY = 96
            direction.DOWN -> renderY = 0
            direction.LEFT -> renderY = 32
            direction.RIGHT -> renderY = 64
        }

        when(animationFrame)
        {
            1 -> renderX = 0
            2 -> renderX = 32
            3 -> renderX = 64
        }

        //Re-Render Tile
        val tileImg: BufferedImage = tileTypeToImage[]!!

        //Render Sprite
        val img = SwingFXUtils.toFXImage(spriteSheet, null)
        gc.drawImage(img, renderX.toDouble(), renderY.toDouble(), 32.0, 32.0,
                x.toDouble(), y.toDouble(), tileWidthPx.toDouble(), tileHeightPx.toDouble())

        println("$this: $x, $y")
    }
}