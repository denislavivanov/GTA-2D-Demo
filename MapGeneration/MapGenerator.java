import java.util.Random;
import java.util.TreeMap;


public class MapGenerator {
    TreeMap<Coordinates, Character> map;

    public MapGenerator() {
        map = new TreeMap<Coordinates, Character>();

        for (int i = 0; i < 64; i++) {
            for(int j = 0; j < 64; j++) {
                map.put(new Coordinates(i, j), ' ');
            }
        }
        StreetT streets = new StreetT(map);

        SmallHouses smallHouses1 = new SmallHouses("Small Houses", map, 1);
        TowerBlock towerBlock1 = new TowerBlock("Tower", map, 1);
        Supermarket supermarket = new Supermarket("Billa", map);

        SmallHouses smallHouses2 = new SmallHouses("Small Houses2", map, 2);
        SkyscraperT skyscraper = new SkyscraperT("Skyscraper", map);
        Mall mall = new Mall("Mall", map);

        SmallHouses smallHouses3 = new SmallHouses("Small Houses3", map, 3);
        TowerBlock towerBlock2 = new TowerBlock("Tower", map, 2);
        ClothingStore clothingStore = new ClothingStore("ClothingStore", map);
    }

    public int getRand(int randomRange) {
        Random rand = new Random();
        return rand.nextInt(randomRange);
    }

    public void printMap(){
        for(int y = 0; y < 64; y++) {
            for(int x = 0; x < 64; x++) {
                System.out.printf("%c", map.get(new Coordinates(y, x)));
            }
            System.out.printf("\n");
        }
    }

    public void printOnlyMap(Player player){
        int X = (int)player.Position.x - 5;
        int Y = (int)player.Position.y - 5;
        int printableX = 11, printableY = 11;

        for(int column = X; column < X + printableX; column++) {
            for(int row = Y; row < Y + printableY; row++) {
                System.out.printf("%c", map.get(new Coordinates(column, row)));
            }
            System.out.printf("\n");
        }
    }

    public TreeMap<Coordinates, Character> returnMap(Player player) {
        int X = (int)player.Position.x - 5;
        int Y = (int)player.Position.y - 5;
        int printableX = 11, printableY = 11;

        TreeMap<Coordinates, Character> temp = new TreeMap<Coordinates, Character>();

        if(X < 0)
            X = 0;

        if(Y < 0)
            Y = 0;
        
        if(X + printableX > 64)
            X = 64 - printableX;
        
        if(Y + printableY > 64)
            Y = 64 - printableY;

        for(int row = Y; row < Y + printableY; row++) {
            for(int column = X; column < X + printableX; column++) {
                temp.put(new Coordinates(column - X, row - Y), map.get(new Coordinates(row, column)));
            }
        }

        return temp;
    }
}

