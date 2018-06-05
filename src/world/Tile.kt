package world

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

val tileWidthPx = 16
val tileHeightPx = 16
val tileSet: BufferedImage = ImageIO.read(File("resources/tileset.png"))
val tileTypeToImage: HashMap<TileType, java.awt.Image> = hashMapOf(
        TileType.GRASS to tileSet.getSubimage(0, 0, tileWidthPx, tileHeightPx),
        TileType.BIG_TREE to tileSet.getSubimage(16, 0, tileWidthPx, tileHeightPx),
        TileType.ROCK to tileSet.getSubimage(32, 0, tileWidthPx, tileHeightPx),
        TileType.DIRT to tileSet.getSubimage(48, 0, tileWidthPx, tileHeightPx),
        TileType.SIGN to tileSet.getSubimage(64, 0, tileWidthPx, tileHeightPx),

        TileType.SAND to tileSet.getSubimage(0, 16, tileWidthPx, tileHeightPx),
        TileType.LITTLE_TREES to tileSet.getSubimage(16, 16, tileWidthPx, tileHeightPx),
        TileType.CAVE to tileSet.getSubimage(32, 16, tileWidthPx, tileHeightPx),
        TileType.VILLAGE_1 to tileSet.getSubimage(48, 16, tileWidthPx, tileHeightPx),

        TileType.WATER_1 to tileSet.getSubimage(0, 32, tileWidthPx, tileHeightPx),
        TileType.WATER_2 to tileSet.getSubimage(16, 32, tileWidthPx, tileHeightPx),
        TileType.WATER_3 to tileSet.getSubimage(32, 32, tileWidthPx, tileHeightPx),
        TileType.VILLAGE_2 to tileSet.getSubimage(48, 32, tileWidthPx, tileHeightPx)
)

data class Tile(val type: TileType, val isBlocked: Boolean)
{
    val tileImg: Image = tileTypeToImage.get(type)!!
}