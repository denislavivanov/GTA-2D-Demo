import java.util.TreeMap;

public class SkyscraperGenerator extends Building {

    public SkyscraperGenerator(String name, TreeMap<Coordinates, Character> map){
        super(name);
        makeSkyscraper(map);
    }

    public void makeSkyscraper(TreeMap<Coordinates, Character> map) {
        int sizeX, sizeY, distanceX = 0, distanceY = 0;
        for(sizeX = 0; map.get(new Coordinates(0, sizeX)) != 'w'; sizeX++);
        for(sizeY = 0; map.get(new Coordinates(sizeY, 0)) != 'w'; sizeY++);
        sizeY += 9;
        sizeX += 9;

        for(int column = sizeY; map.get(new Coordinates(column, sizeX)) != 'w'; distanceY++, column++);
        //System.out.printf("Distance: %d\n", distanceY);

        for(int row = sizeX; map.get(new Coordinates(sizeY, row)) != 'w'; distanceX++, row++);
        //System.out.printf("Distance: %d\n", distanceX);

        //map.put(new Coordinates(sizeY, sizeX), '|');
        int column = (distanceY - 7) / 2;
        int row = (distanceX - 7) / 2;


        column += sizeY;
        row += sizeX;

        for(int column1 = sizeY; map.get(new Coordinates(column1, sizeX)) != 'w'; column1++){
            for(int row1 = sizeX; map.get(new Coordinates(column1, row1)) != 'w'; row1++){
                map.put(new Coordinates(column1, row1), 'p');
            }
        }

        for(int count = 0; count < 7; count++, column++){
            for(int count2 = 0, my_row = row; count2 < 7; count2++, my_row++){
                if(count == 0 && count2 == 3) {
                    for(int i = 1; map.get(new Coordinates(column - i, my_row)) != 'w'; i++){
                        map.put(new Coordinates(column - i, my_row), 'w');
                    }
                    for(int i = 1; map.get(new Coordinates(column + 6 + i, my_row)) != 'w'; i++){
                        map.put(new Coordinates(column + 6 + i, my_row), 'w');
                    }
                }
                map.put(new Coordinates(column, my_row), '^');
            }
            if(count == 3){
                for(int i = 1; map.get(new Coordinates(column, row - i)) != 'w'; i++){
                    map.put(new Coordinates(column, row - i), 'w');
                }
                for(int i = 1; map.get(new Coordinates(column, row + 6 + i)) != 'w'; i++) {
                    map.put(new Coordinates(column, row + 6 + i), 'w');
                }
            }
        }

        //System.out.printf("Column: %d; Row: %d.\n", column, row);

    }
}