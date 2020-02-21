package pl.nullpointer;

class Book {
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
}
