package com.allbreakers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Library {
    private int id;
    private int signupTimeDays;
    private int booksPerDay;
    private List<Book> books;

    void addBooks(List<Book> books) {
        this.books = books;
    }

    void setSignupTimeDays(int signupTimeDays) {
        this.signupTimeDays = signupTimeDays;
    }

    void setBooksPerDay(int booksPerDay) {
        this.booksPerDay = booksPerDay;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    int getSignupTimeDays() {
        return signupTimeDays;
    }

    int getBooksPerDay() {
        return booksPerDay;
    }

    List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "\nLibrary{" +
                ", signupTimeDays=" + signupTimeDays +
                ", booksPerDay=" + booksPerDay +
                ", books=" + books +
                '}';
    }

    boolean isBetterThan(Library library, int daysForCalculation) {
        return this.calculateScore(daysForCalculation) > library.calculateScore(daysForCalculation);
    }

    private int calculateScore(int daysForCalculation) {
        return booksThatWillBeScannedInNext(daysForCalculation).stream()
                .map(Book::getScore).reduce(0, Integer::sum);
    }

    List<Book> booksThatWillBeScannedInNext(int daysForCalculation) {
        if (daysForCalculation- signupTimeDays <= 0) {
            return Collections.emptyList();
        }
        long bandwidth = (1l*daysForCalculation- signupTimeDays) * getBooksPerDay();
        if(bandwidth >= getBooks().size()){
            return books;
        }

        return books.stream()
                .sorted(Comparator.comparingInt(Book::getScore).reversed())
                .limit(bandwidth)
                .collect(Collectors.toList());
    }

    void removeAll(List<Book> booksThatWillBeScannedTillDeadline) {
        books.removeAll(booksThatWillBeScannedTillDeadline);
    }
}
