package world

import Screens.ScreenComponents.StatsView
import javafx.scene.canvas.GraphicsContext
import world.Characters.Character
import world.Characters.Player

class World
{
    public lateinit var worldMap: Array<Array<Tile>>
    val characters: ArrayList<Character> = ArrayList()

    constructor(gc: GraphicsContext)
    {
        generateBaseMap()
        characters.add(Player(gc))
    }

    /**
     * Populate the world array with grass tiles
     */
    fun generateBaseMap()
    {
        worldMap = Array((globals.width.toInt() / tileWidthPx), {
            Array((globals.height.toInt() / tileHeightPx), {
                Tile(TileType.GRASS, false)
            })
        })
    }

    /**
     * Render the world
     */
    fun renderWorld(gc: GraphicsContext)
    {
        for (i in 0..(globals.width.toInt() / tileWidthPx) - 1)
        {
            for (j in 0..(700 / tileHeightPx))
            {
                worldMap[i][j].drawTile(gc, i, j)
                println("Rendering $i:$j Type: " + worldMap[i][j].type)
            }
        }
    }
}