package com.allbreakers;

import java.util.List;

class Library {
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

    @Override
    public String toString() {
        return "\nLibrary{" +
                ", signupTimeDays=" + signupTimeDays +
                ", booksPerDay=" + booksPerDay +
                ", books=" + books +
                '}';
    }
}
