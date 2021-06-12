import java.util.TreeMap;

public class Mall extends Building{
    public Mall(String name, TreeMap<Coordinates, Character> map){
        super(name);
        makeMall(map);
    }

    public void makeMall(TreeMap<Coordinates, Character> map){
        int sizeX, sizeY;
        for(sizeX = 0; map.get(new Coordinates(0, sizeX)) != 'w'; sizeX++);
        for(sizeY = 0; map.get(new Coordinates(sizeY, 0)) != 'w'; sizeY++);
        sizeY += 9;
        sizeX += 9;

        for(; map.get(new Coordinates(sizeY, sizeX)) != 's'; sizeX++);
        sizeX += 8;

        //map.put(new Coordinates(sizeY, sizeX), '|');

        int distanceY = 0;
        for(int column = sizeY; map.get(new Coordinates(column, sizeX)) != 'w'; column++, distanceY++);

        int column = sizeY + (distanceY - 7) / 2;

        //map.put(new Coordinates(sizeY, sizeX), '|');

        for(int column1 = sizeY; map.get(new Coordinates(column1, sizeX)) != 'w'; column1++){
            for(int row1 = sizeX; row1 < 64; row1++){
                map.put(new Coordinates(column1, row1), 'p');
            }
        }

        for(int count = 0; count < 7; column++, count++){
            for(int count2 = 0, row = sizeX + 1; count2 < 7; count2++, row++){
                if(count == 0 && count2 == 3){
                    for(int i = 0; map.get(new Coordinates(column - i, row)) != 'w'; i++) {
                        map.put(new Coordinates(column - i, row), 'w');
                    }
                    for(int i = 0; map.get(new Coordinates(column + 7 + i, row)) != 'w'; i++) {
                        map.put(new Coordinates(column + 7 + i, row), 'w');
                    }
                }
                map.put(new Coordinates(column, row), 'm');
            }
            if(count == 3){
                map.put(new Coordinates(column, sizeX), 'w');
            }
        }
    }
}