import com.sun.source.tree.Tree;

import java.util.TreeMap;

public class ClothingStore extends Building{
    public ClothingStore(String name, TreeMap<Coordinates, Character> map){
        super(name);
        makeClothingStore(map);
    }

    public void makeClothingStore(TreeMap<Coordinates, Character> map){
        int sizeX = 63, sizeY = 63;

        for(; map.get(new Coordinates(sizeY, 63)) != 'w'; sizeY--);
        for(; map.get(new Coordinates(63, sizeX)) != 'w'; sizeX--);
        sizeX++;
        sizeY++;

        //map.put(new Coordinates(sizeY, sizeX), '|');

        for(int column = sizeY; column < 64; column++){
            for(int row = sizeX; row < 64; row++) {
                map.put(new Coordinates(column, row), 'p');
            }
        }

        for(int count = 0, column = sizeY + 1; count < 7; count++, column++){
            for(int count2 = 0, row = sizeX + 1; count2 < 7; count2++, row++){
                if(count == 0 && count2 == 3){
                    map.put(new Coordinates(column - 1, row), 'w');
                }
                map.put(new Coordinates(column, row), 'c');
            }
            if(count == 3){
                map.put(new Coordinates(column, sizeX), 'w');
            }
        }

    }
}