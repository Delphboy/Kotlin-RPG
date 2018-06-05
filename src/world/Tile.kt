package world

import javafx.embed.swing.SwingFXUtils
import javafx.scene.canvas.GraphicsContext
import java.awt.Image
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

enum class TileType
{
    GRASS,
    BIG_TREE,
    ROCK,
    DIRT,
    SIGN,
    SAND,
    LITTLE_TREES,
    CAVE,
    VILLAGE_1,
    WATER_1,
    WATER_2,
    WATER_3,
    VILLAGE_2;
}

val tileWidthPx = 32
val tileHeightPx = 32
val tileSet: BufferedImage = ImageIO.read(File("resources/tileset.png"))
val tileTypeToImage: HashMap<TileType, BufferedImage> = hashMapOf(
        TileType.GRASS to tileSet.getSubimage(0, 0, 16, 16),
        TileType.BIG_TREE to tileSet.getSubimage(16, 0, 16, 16),
        TileType.ROCK to tileSet.getSubimage(32, 0, 16, 16),
        TileType.DIRT to tileSet.getSubimage(48, 0, 16, 16),
        TileType.SIGN to tileSet.getSubimage(64, 0, 16, 16),

        TileType.SAND to tileSet.getSubimage(0, 16, 16, 16),
        TileType.LITTLE_TREES to tileSet.getSubimage(16, 16, 16, 16),
        TileType.CAVE to tileSet.getSubimage(32, 16, 16, 16),
        TileType.VILLAGE_1 to tileSet.getSubimage(48, 16, 16, 16),

        TileType.WATER_1 to tileSet.getSubimage(0, 32, 16, 16),
        TileType.WATER_2 to tileSet.getSubimage(16, 32, 16, 16),
        TileType.WATER_3 to tileSet.getSubimage(32, 32, 16, 16),
        TileType.VILLAGE_2 to tileSet.getSubimage(48, 32, 16, 16)
)

data class Tile(val type: TileType, val isBlocked: Boolean)
{
    val tileImg: BufferedImage = tileTypeToImage[type]!!

    fun drawTile(gc: GraphicsContext, x: Int, y: Int)
    {
        val img = SwingFXUtils.toFXImage(tileImg, null)
        gc.drawImage(img, x.toDouble() * tileWidthPx.toDouble(), y.toDouble() * tileHeightPx.toDouble(), tileWidthPx.toDouble(), tileHeightPx.toDouble())
    }
}