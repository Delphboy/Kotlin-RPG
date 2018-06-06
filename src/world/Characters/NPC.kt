package world.Characters

import javafx.embed.swing.SwingFXUtils
import javafx.scene.canvas.GraphicsContext
import world.tileHeightPx
import world.tileTypeToImage
import world.tileWidthPx
import world.worldMap
import java.awt.image.BufferedImage
import java.io.File
import java.util.*
import javax.imageio.ImageIO

class NPC(gc: GraphicsContext, spirteSheetLoc: String) : Character(16 * tileWidthPx, 16 * tileHeightPx, gc)
{
    init
    {
        spriteSheet = ImageIO.read(File(spirteSheetLoc))
    }
}