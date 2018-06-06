package world

import Screens.ScreenComponents.StatsView
import javafx.scene.canvas.GraphicsContext
import world.Characters.Character
import world.Characters.NPC
import world.Characters.Player

//global declaration of worldMap
var worldMap: Array<Array<Tile>> = Array((globals.width.toInt() / tileWidthPx), {
    Array((globals.height.toInt() / tileHeightPx), {
        Tile(TileType.GRASS, false)
    })
})

class World
{
    val characters: ArrayList<Character> = ArrayList()

    constructor(gc: GraphicsContext)
    {
        characters.add(Player(gc))
    }

    fun generateMap()
    {
        TODO("Implement a world generation algorithm")
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