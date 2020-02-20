package com.allbreakers;

import java.math.BigInteger;
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

    boolean isBetterThan(Library library) {
        return true;
    }

    List<Book> booksThatWillBeScannedInNext(int daysForCalculation) {
        BigInteger bandwidth = BigInteger.valueOf(daysForCalculation).multiply(BigInteger.valueOf(getBooksPerDay()));
        if(bandwidth.compareTo(BigInteger.valueOf(getBooks().size())) == 0) {
            return books;
        }

        books.sort(Book::compareTo);

        return books.stream().limit(bandwidth.longValue()).collect(Collectors.toList());
    }

    void removeAll(List<Book> booksThatWillBeScannedTillDeadline) {
        books.removeAll(booksThatWillBeScannedTillDeadline);
    }
}
