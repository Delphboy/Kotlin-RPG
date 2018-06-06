package world.Characters

import com.sun.org.apache.xpath.internal.operations.Bool
import javafx.embed.swing.SwingFXUtils
import javafx.scene.canvas.GraphicsContext
import javafx.scene.image.Image
import world.*
import java.awt.image.BufferedImage
import java.io.File
import java.util.*
import javax.imageio.ImageIO

abstract class Character(var x: Int, var y: Int, val gc: GraphicsContext)
{
    var animationFrame: Int = 1
    var dir = direction.UP
    var previousDir = dir

    open var spriteSheet = ImageIO.read(File("resources/characters/rad.png"))

    var health: Int = 100
    var stamina: Int = 100
    var majika: Int = 100
    var gold: Int = 100

    fun isInBounds(): Boolean
    {
        val isBound: Boolean = (y / tileHeightPx in (1..(globals.height.toInt() / tileHeightPx))) && (x / tileWidthPx in (1..(globals.width.toInt() / tileWidthPx)))
        return isBound
    }

    fun isInRenderBounds(): Boolean
    {
        val isRender: Boolean = (y / tileHeightPx in (0..(globals.height.toInt() / tileHeightPx))) && (x / tileWidthPx in (0..(globals.width.toInt() / tileWidthPx)))
        return isRender
    }

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
//        move(direction.LEFT)
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
            println("$x:$y")
            for(i in (x / tileWidthPx) - 1..(x / tileWidthPx) + 1)
            {
                for(j in (y  / tileHeightPx)-1..(y / tileHeightPx)+1)
                {
                    val tile: BufferedImage = tileTypeToImage[worldMap[i][j].type]!!
                    val tileImage = SwingFXUtils.toFXImage(tile, null)
                    gc.drawImage(tileImage, (i).toDouble(), j.toDouble(), tileWidthPx.toDouble(), tileHeightPx.toDouble())
                    println("$tileImage at: $i, $j")
                }
            }
            println("\n")

            when(dir)
            {
                direction.UP -> if (isInBounds()) y -= tileHeightPx / 4
                direction.DOWN -> if (isInBounds()) y += tileHeightPx / 4
                direction.LEFT -> if (isInBounds()) x -= tileWidthPx / 4
                direction.RIGHT -> if (isInBounds()) x += tileWidthPx / 4
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

        //Render Sprite
        if(isInRenderBounds())
        {
            val img = SwingFXUtils.toFXImage(spriteSheet, null)
            gc.drawImage(img, renderX.toDouble(), renderY.toDouble(), 32.0, 32.0,
                    x.toDouble(), y.toDouble(), tileWidthPx.toDouble(), tileHeightPx.toDouble())

            println("Rendering $this: $x, $y")
        }

    }
}