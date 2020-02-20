package com.allbreakers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
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
        return !books.isEmpty();
    }

    List<Book> booksThatWillBeScannedInNext(int daysForCalculation) {
        BigInteger bandwidth = BigInteger.valueOf(daysForCalculation).multiply(BigInteger.valueOf(getBooksPerDay()));
        if(bandwidth.compareTo(BigInteger.valueOf(getBooks().size())) > -1) {
            return books;
        }

        books.sort(Book::compareTo);

        List<Book> result = new ArrayList<>();
        Iterator<Book> iterator = books.iterator();
        for(long l=0; l<bandwidth.longValue(); l++){
            result.add(iterator.next());
        }
        return result;
    }

    void removeAll(List<Book> booksThatWillBeScannedTillDeadline) {
        books.removeAll(booksThatWillBeScannedTillDeadline);
    }
}
