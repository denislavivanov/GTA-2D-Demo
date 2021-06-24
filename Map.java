import org.joml.Vector2f;
import java.util.TreeMap;

public class Map {
    private int width;
    private int height;
    private MapGenerator map;
    private GrassBlock grass_block;
    private Street street_block;
    private House house_block;
    private Sidewalk concrete_block;
    private Tower tower_block;
    private Skyscraper skyscraper_block;
    private TreeMap<Coordinates, Character> crop;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new MapGenerator();

        this.street_block = new Street(new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 1.0f));
        this.grass_block = new GrassBlock(new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 1.0f));
        this.house_block = new House(new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 1.0f));
        this.concrete_block = new Sidewalk(new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 1.0f));
        this.tower_block = new Tower(new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 1.0f));
        this.skyscraper_block = new Skyscraper(new Vector2f(0.0f, 0.0f), new Vector2f(1.0f, 1.0f));
    }

    public void draw(Player p) {
        this.crop = map.returnMap(p);

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                char c = this.crop.get(new Coordinates(y, x));

                if(c == 's')
                    street_block.draw(new Vector2f(y, x));

                if(c == 'p')
                    grass_block.draw(new Vector2f(y, x));

                if(c == 'h')
                    house_block.draw(new Vector2f(y, x));

                if(c == 'w')
                    concrete_block.draw(new Vector2f(y, x));

                if(c == 't')
                    tower_block.draw(new Vector2f(y, x));

                if(c == '^')
                    skyscraper_block.draw(new Vector2f(y, x));
            }
        }
    }
}  