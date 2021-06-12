import java.util.TreeMap;

public class TowerBlock extends Building {

    public TowerBlock(String name, TreeMap<Coordinates, Character> map, int tower){
        super(name);

        int sizeX = 0, sizeY = 0, distance = 0;

        if(tower == 1){

            for(sizeX = 0; map.get(new Coordinates(0, sizeX)) != 'w'; sizeX++);
            for(sizeY = 0; map.get(new Coordinates(sizeY + 1, 0)) != 'w'; sizeY++);
            sizeX += 9;

        } else if(tower == 2){
            for(sizeX = 0; map.get(new Coordinates(0, sizeX)) != 'w'; sizeX++);
            sizeX += 9;
            for(; map.get(new Coordinates(sizeY, 0)) != 'w'; sizeY++);
            sizeY += 9;
            for(; map.get(new Coordinates(sizeY, 0)) != 'w'; sizeY++);
            sizeY += 9;

            //map.put(new Coordinates(sizeY, sizeX), '|');

        }

        makeTower(map, sizeX, sizeY, tower, distance);
        //init(map);
    }

    void makeTower(TreeMap<Coordinates, Character> map, int sizeX, int sizeY, int tower, int distance){
        if(tower == 1) {
            int row = 0, count2;
            for (int column = (sizeY - 1), count = 0; count < 7; column--, count++) {
                //System.out.printf("SizeX: %d; Column: %d\n", sizeX, column);
                for (row = (sizeX + 1), count2 = 0; count2 < 7; row++, count2++) {
                    if(count == 0 && count2 == 3){
                        map.put(new Coordinates(column + 1, row), 'w');
                    }
                    map.put(new Coordinates(column, row), 't');
                }
                if(count == 3){
                    map.put(new Coordinates(column, sizeX), 'w');
                }
            }

            while (map.get(new Coordinates(0, (row + 1))) != 'w') {
                row++;
            }

            int my_row = 0;
            for (int column = (sizeY - 1), count = 0; count < 7; column--, count++) {
                for (my_row = (row - 1), count2 = 0; count2 < 7; my_row--, count2++) {
                    if(count == 0 && count2 == 3){
                        map.put(new Coordinates(column + 1, my_row), 'w');
                    }
                    map.put(new Coordinates(column, my_row), 't');
                }
                if(count == 3){
                    map.put(new Coordinates(column, row), 'w');
                }
            }

            for (int column = (sizeY - 8); column >= 0; column--) {
                for (int row3 = sizeX; row3 <= row; row3++) {
                    map.put(new Coordinates(column, row3), 'p');
                }
            }

            for (int column = (sizeY - 1); map.get(new Coordinates(column, sizeX)) != 'p'; column--) {

                if(map.get(new Coordinates(column, sizeX)) != 'w') {
                    map.put(new Coordinates(column, sizeX), 'p');
                }

                for (int row4 = sizeX + 8; map.get(new Coordinates(column, row4)) != 't'; row4++) {
                    map.put(new Coordinates(column, row4), 'p');
                }
                if(map.get(new Coordinates(column, sizeX)) != 'w') {
                    map.put(new Coordinates(column, row), 'p');
                }
            }

            for (int row4 = sizeX; map.get(new Coordinates(sizeY, row4 + 1)) != 's'; row4++) {
                if(map.get(new Coordinates(sizeY, row4)) != 'w') {
                    map.put(new Coordinates(sizeY, row4), 'p');
                }
            }

        }else if(tower == 2){
            int row = 0, count2;
            for (int column = (sizeY + 1), count = 0; count < 7; column++, count++) {
                //System.out.printf("SizeX: %d; Column: %d\n", sizeX, column);
                for (row = (sizeX + 1), count2 = 0; count2 < 7; row++, count2++) {
                    if(count == 0 && count2 == 3){
                        map.put(new Coordinates(column - 1, row), 'w');
                    }
                    map.put(new Coordinates(column, row), 't');
                }
                if(count == 3){
                    map.put(new Coordinates(column, sizeX), 'w');
                }
            }

            while (map.get(new Coordinates(0, (row + 1))) != 'w') {
                row++;
            }

            int my_row = 0;
            for (int column = (sizeY + 1), count = 0; count < 7; column++, count++) {
                for (my_row = (row - 1), count2 = 0; count2 < 7; my_row--, count2++) {
                    if(count == 0 && count2 == 3){
                        map.put(new Coordinates(column - 1, my_row), 'w');
                    }
                    map.put(new Coordinates(column, my_row), 't');
                }
                if(count == 3){
                    map.put(new Coordinates(column, row), 'w');
                }
            }

            for (int column = (sizeY + 8); column < 64; column++) {
                for (int row3 = sizeX; row3 <= row; row3++) {
                    map.put(new Coordinates(column, row3), 'p');
                }
            }

            for (int column = sizeY + 1; map.get(new Coordinates(column, sizeX)) != 'p'; column++) {

                if(map.get(new Coordinates(column, sizeX)) != 'w') {
                    map.put(new Coordinates(column, sizeX), 'p');
                }

                for (int row4 = sizeX + 8; map.get(new Coordinates(column, row4)) != 't'; row4++) {
                    map.put(new Coordinates(column, row4), 'p');
                }

                if(map.get(new Coordinates(column, sizeX)) != 'w') {
                    map.put(new Coordinates(column, row), 'p');
                }
            }

            for (int row4 = sizeX; map.get(new Coordinates(sizeY, row4 + 1)) != 's'; row4++) {
                if(map.get(new Coordinates(sizeY, row4)) != 'w') {
                    map.put(new Coordinates(sizeY, row4), 'p');
                }
            }
        }
    }

}