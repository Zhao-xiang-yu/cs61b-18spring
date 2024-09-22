package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private static final long SEED = 5211314;
    private static Random rand = new Random(SEED);

    private static class Position {
        private int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }

    private static TETile randomTile() {
        int tileNum = rand.nextInt(6);
        switch (tileNum) {
            case 0: return Tileset.FLOWER;
            case 1: return Tileset.GRASS;
            case 2: return Tileset.MOUNTAIN;
            case 3: return Tileset.WATER;
            case 4: return Tileset.SAND;
            case 5: return Tileset.FLOOR;
            default: return Tileset.NOTHING;
        }
    }

    private static int hexagonHeight(int s) {
        return 2 * s;
    }

    private static int hexagonWidth(int s) {
        return s + (s - 1) * 2;
    }

    public static boolean needsFilling(int x, int y, int s) {
        if (y >= s) {
            y = hexagonHeight(s) - 1 - y;
        }

        if (x + y >= s - 1 && x - y <= 2 * s - 2) {
            return true;
        }
        return false;
    }

    private static void addHexagon(TETile[][] tiles, Position p,  int s) {
        TETile tile = randomTile();
        int cordX = p.getX(), cordY = p.getY();
        int height =  hexagonHeight(s);
        int width = hexagonWidth(s);
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                if (needsFilling(x, y, s)) {
                    tiles[cordX + x][cordY + y] = tile;
                }
            }
        }
    }

    private static void fillWithRandomHexagons(TETile[][] tiles) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                tiles[x][y] = Tileset.NOTHING;
            }
        }

//        for (int time = 0; time < 50; time += 1) {
//            int randomS = rand.nextInt(6) + 2;
//            int x = rand.nextInt(WIDTH);
//            int y = rand.nextInt(HEIGHT);
//            if (x + hexagonWidth(randomS) < WIDTH && y + hexagonHeight(randomS) < HEIGHT) {
//                addHexagon(tiles, x, y, randomS);
//            }
//        }
        for (int x = 0; x < WIDTH; x += 5) {
            for (int y = 0; y < HEIGHT; y += 5) {
                if (x + hexagonWidth(4) < WIDTH && y + hexagonHeight(4) < HEIGHT) {
                    addHexagon(tiles, new Position(x, y), 4);
                }
            }
        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] randomTiles = new TETile[WIDTH][HEIGHT];
        fillWithRandomHexagons(randomTiles);

        ter.renderFrame(randomTiles);
    }
}
