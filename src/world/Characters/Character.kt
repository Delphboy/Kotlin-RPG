package world.Characters

import globals
import javafx.embed.swing.SwingFXUtils
import javafx.scene.canvas.GraphicsContext
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
    var animationTimer: Int = 65    //milliseconds per frame of animation

    open var spriteSheet = ImageIO.read(File("resources/characters/rad.png"))

    var health: Int = 100
    var stamina: Int = 100
    var majika: Int = 100
    var gold: Int = 100

    /**
     * return whether or not the Character is within the World Bounds
     */
    private fun isInBounds(): Boolean
    {
        return (y / tileHeightPx in (1..(globals.height.toInt() / tileHeightPx))) && (x / tileWidthPx in (1..(globals.width.toInt() / tileWidthPx)))
    }

    /**
     * return whether or not the Character is within the Screen Bounds (ie Can the player see the Character
     */
    private fun isInRenderBounds(): Boolean
    {
        return (y / tileHeightPx in (0..(globals.height.toInt() / tileHeightPx))) && (x / tileWidthPx in (0..(globals.width.toInt() / tileWidthPx)))
    }

    /**
     * Control the Character's movement
     * Randomly pick a direction and move the character in that direction
     */
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
     * Move the Character in a specific direction
     */
    private fun move(dir: direction)
    {
        if(dir != this.dir)
        {
            this.dir = dir
        }
        else
        {
            when(dir)
            {
                direction.UP -> if (isInBounds()) y -= tileHeightPx / 8
                direction.DOWN -> if (isInBounds()) y += tileHeightPx / 8
                direction.LEFT -> if (isInBounds()) x -= tileWidthPx / 8
                direction.RIGHT -> if (isInBounds()) x += tileWidthPx / 8
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
        var renderY = when(dir)
        {
            direction.UP -> 96
            direction.DOWN -> 0
            direction.LEFT -> 32
            direction.RIGHT -> 64
        }

        when(animationFrame)
        {
            1 -> renderX = 0
            2 -> renderX = 32
            3 -> renderX = 64
        }

        //Render Sprite and Tile
        if(isInRenderBounds())
        {
            //tile
            renderTile((x / tileWidthPx), (y / tileHeightPx))

            //sprite
            val img = SwingFXUtils.toFXImage(spriteSheet, null)
            gc.drawImage(img, renderX.toDouble(), renderY.toDouble(), 32.0, 32.0,
                    x.toDouble(), y.toDouble(), tileWidthPx.toDouble(), tileHeightPx.toDouble())
        }

    }

    /**
     * Render the tiles around the character (3x3 grid)
     */
    fun renderTile(tileX: Int, tileY: Int)
    {
        for(i in tileX - 1..tileX + 1)
        {
            for(j in tileY - 1..tileY + 1)
            {
                val tile: BufferedImage = tileTypeToImage[worldMap[tileX][tileY].type]!!
                val tileImage = SwingFXUtils.toFXImage(tile, null)
                gc.drawImage(tileImage, (i * tileWidthPx).toDouble(), (j * tileHeightPx).toDouble(), tileWidthPx.toDouble(), tileHeightPx.toDouble())
            }
        }
    }

}