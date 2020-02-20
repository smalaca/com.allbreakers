package com.allbreakers;

import java.util.Collections;
import java.util.List;

class Library {
    private int id;
    private int signupTimeDays;
    private int booksPerDay;
    private List<Integer> books;

    void addBooks(List<Integer> books) {
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

    List<Integer> getBooks() {
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

    List<Integer> booksThatWillBeScannedInNext(int daysForCalculation) {
        return Collections.emptyList();
    }

    void removeAll(List<Integer> booksThatWillBeScannedTillDeadline) {
        books.removeAll(booksThatWillBeScannedTillDeadline);
    }
}
