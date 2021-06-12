import java.util.Random;
import java.util.TreeMap;

public class StreetT {

    public StreetT(TreeMap<Coordinates, Character> map) {

        int area = this.getRand(1, 3);
        if(area == 1){
            this.makeStreet(map, 1);
            this.makeStreet(map, 3);
        } else{
            this.makeStreet(map, 2);
            this.makeStreet(map, 4);
        }
        //this.printStreet();

    }

    /*public void test(char[][] map){
        map[32][32] = '+';
    }*/

    public void makeStreet(TreeMap<Coordinates, Character> map, int area){
        int x = -1, y = -1;
        if(area == 1){
            x = this.getRand(45, 51);
            y = this.getRand(13, 19);
        } else if(area == 2){
            x = this.getRand(13, 19);
            y = this.getRand(13, 19);
        } else if(area == 3){
            x = this.getRand(13, 19);
            y = this.getRand(45, 51);
        } else if(area == 4){
            x = this.getRand(45, 51);
            y = this.getRand(45, 51);
        }
        //System.out.printf("X: %d; Y: %d;\n", x, y);

        for(int i = 0; i < 64; i++){

            map.put(new Coordinates(i, x), 's');
            map.put(new Coordinates(y, i), 's');
            for(int j = 1; j < 4; j++){
                map.put(new Coordinates(i, x + j), 's');
                map.put(new Coordinates(i, x - j), 's');
                map.put(new Coordinates(y + j, i), 's');
                map.put(new Coordinates(y - j, i), 's');

            }
            if(map.get(new Coordinates(i, x + 4)) != 's'){
                map.put(new Coordinates(i, x + 4), 'w');
            }
            if(map.get(new Coordinates(i, x - 4)) != 's'){
                map.put(new Coordinates(i, x - 4), 'w');
            }
            if(map.get(new Coordinates(y + 4, i)) != 's'){
                map.put(new Coordinates(y + 4, i), 'w');
            }
            if(map.get(new Coordinates(y - 4, i)) != 's'){
                map.put(new Coordinates(y - 4, i), 'w');
            }
        }
    }

    public void printStreet(TreeMap<Coordinates, Character> map){
        for(int y = 0; y < 64; y++){
            for(int x = 0; x < 64; x++){
                System.out.printf("%c", map.get(new Coordinates(y, x)));

            }
            System.out.printf("\n");
        }
    }

    public int getRand(int low, int high) {
        Random random = new Random();
        return random.nextInt(high-low) + low;
    }
}