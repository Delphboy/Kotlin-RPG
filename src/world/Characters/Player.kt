package world.Characters

import javafx.scene.canvas.GraphicsContext
import world.tileHeightPx
import world.tileWidthPx
import java.io.File
import javax.imageio.ImageIO

enum class direction
{
    UP, DOWN, LEFT, RIGHT
}

class Player(gc: GraphicsContext) : Character(16 * tileWidthPx, 16 * tileHeightPx, gc)
{
    init
    {
        spriteSheet = ImageIO.read(File("resources/characters/Merchant.png"))
    }
}