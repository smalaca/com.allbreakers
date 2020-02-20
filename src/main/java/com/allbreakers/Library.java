package com.allbreakers;

import java.util.Collections;
import java.util.List;

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

    boolean isBetterThan(Library library) {
        return true;
    }

    List<Book> booksThatWillBeScannedInNext(int daysForCalculation) {
        int bandwidth = daysForCalculation * getBooksPerDay();
        if(bandwidth > getBooks().size()){
            return books;
        }

//        List<Book> bookz = 0

        return Collections.emptyList();
    }

    void removeAll(List<Book> booksThatWillBeScannedTillDeadline) {
        books.removeAll(booksThatWillBeScannedTillDeadline);
    }
}
