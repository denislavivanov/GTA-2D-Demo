import java.util.TreeMap;

public class Supermarket extends Building{

    public Supermarket(String name, TreeMap<Coordinates, Character> map){
        super(name);
        makeSupermarket(map);
    }

    public void makeSupermarket(TreeMap<Coordinates, Character> map) {
        int sizeX, sizeY;
        for(sizeX = 0; map.get(new Coordinates(0, sizeX)) != 'w'; sizeX++);

        for(sizeY = 0; map.get(new Coordinates(sizeY, 0)) != 'w'; sizeY++);
        sizeX += 9;

        for(; map.get(new Coordinates(0, sizeX)) != 'w'; sizeX++);
        sizeX+= 9;

        //System.out.printf("SizeX: %d\n", sizeX);

        for(int column = sizeY - 2, count = 0; count < 7; count++, column--){
            for(int row = sizeX + 1, count2 = 0; count2 < 7; count2++, row++){
                map.put(new Coordinates(column, row), 'f');
            }
        }
        for(int row = sizeX; row < 64; row++){
            if(row == sizeX + 4){
                map.put(new Coordinates(sizeY - 1, row), 'w');
            } else {
                map.put(new Coordinates(sizeY - 1, row), 'p');
            }
        }

        for(int column = sizeY - 2; column >= 0; column--){
            if(column == sizeY - 5){
                map.put(new Coordinates(column, sizeX), 'w');
            } else{
                map.put(new Coordinates(column, sizeX), 'p');
            }
        }

        for(int column = (sizeY - 2); column >= 0; column--) {
            for(int row = (sizeX + 8); row < 64; row++){
                map.put(new Coordinates(column, row), 'p');
            }
        }

        for(int column = (sizeY - 9); column >= 0; column--) {
            for(int row = sizeX + 1; map.get(new Coordinates(column, row)) == ' '; row++){
                map.put(new Coordinates(column, row), 'p');
            }
        }
    }
}