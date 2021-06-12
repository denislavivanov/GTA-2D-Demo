//package com.elsys;

public class Coordinates implements Comparable<Coordinates> {
    int column;
    int row;

    public Coordinates(int column, int row) {
        this.column = column;
        this.row = row;
    }

    @Override
    public int compareTo(Coordinates o) {
        if (row < o.row) return -1;
        if (row > o.row) return +1;

        if (column < o.column) return -1;
        if (column > o.column) return +1;
        return 0;
    }
}