import com.sun.source.tree.Tree;

import java.util.TreeMap;

public class SmallHouses extends Building {
    public SmallHouses(String name, TreeMap<Coordinates, Character> map, int house){
        super(name);

        int sizeX = 0, sizeY = 0, distance = 0;
        if(house == 1){
            for(sizeX = 0; map.get(new Coordinates(0, sizeX)) != 'w'; sizeX++);
            for(sizeY = 0; map.get(new Coordinates(sizeY, 0)) != 'w'; sizeY++);
            distance = sizeY;

        } else if(house == 2){
            for(sizeX = 0; map.get(new Coordinates(0, sizeX)) != 'w'; sizeX++);
            for(sizeY = 0; map.get(new Coordinates(sizeY, 0)) != 'w'; sizeY++);
            sizeY += 9;
            for(; map.get(new Coordinates(sizeY, sizeX - 1)) != 'w'; distance++, sizeY++);
            //System.out.printf("Distance: %d\n", distance);

        } else if(house == 3){
            for(sizeX = 0; map.get(new Coordinates(0, sizeX)) != 'w'; sizeX++);
            for(sizeY = 0; map.get(new Coordinates(sizeY, 0)) != 'w'; sizeY++);
            sizeY += 9;
            for(; map.get(new Coordinates(sizeY, 0)) != 'w';sizeY++);
            sizeY += 9;

            //System.out.printf("SizeY: %d\n", sizeY);
            distance = 64 - sizeY;
            sizeY = 64;
            //System.out.printf("Distance: %d; SizeY: %d\n", distance, sizeY);
            //map.put(new Coordinates(sizeY, sizeX), 'o');
        }

        makeHouse(map, sizeX, sizeY, house, distance);
    }

    public void makeHouse(TreeMap<Coordinates, Character> map, int sizeX, int sizeY, int house, int distance){
        //System.out.printf("SizeX: %d; SizeY: %d; Distance: %d.\n", sizeX, sizeY, distance);
        //System.out.println((sizeY - 1) / 8);

        int column = sizeY - distance, row;

        for(int i = 0; i < sizeX; i++){
            map.put(new Coordinates(column, i), 'p');
        }
        column++;

        for(int i = 0; i < ((distance - 1) / 8); i++){
            for(int count = 0; count < 7; column++, count++) {
                if(count == 3){
                    map.put(new Coordinates(column, (sizeX - 1)), 'w');
                } else {
                    map.put(new Coordinates(column, (sizeX - 1)), 'p');
                }
                for (row = (sizeX - 2); row > (sizeX - 9); row--) {
                    map.put(new Coordinates(column, row), 'h');
                }
                for(int countForHouses = row; countForHouses >= 0; countForHouses--) {
                    map.put(new Coordinates(column, countForHouses), 'p');
                }
            }

            for(int row2 = sizeX - 1; row2 >= 0; row2--){
                map.put(new Coordinates(column, row2), 'p');
            }
            column++;
        }

        for(; column < sizeY; column++){
            for(int my_row = 0; my_row < sizeX; my_row++){
                map.put(new Coordinates(column, my_row), 'p');
            }
        }
    }

}