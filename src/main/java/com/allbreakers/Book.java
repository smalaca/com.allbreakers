package com.allbreakers;

class Book implements Comparable<Book> {
    private int id;
    private int score;

    public Book(int id, int score) {
        this.id = id;
        this.score = score;
    }

    int getId() {
        return id;
    }

    int getScore() {
        return score;
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(o.getScore(), score);
    }
}
