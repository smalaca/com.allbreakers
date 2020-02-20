package com.allbreakers;

import java.io.IOException;

class AllBreakersApp {
    public static void main(String[] args) throws IOException {
        String fileName = "f_libraries_of_the_world.txt";
        AlgorithmInputFactory algorithmInputFactory = new AlgorithmInputFactory();

        AlgorithmInput input = algorithmInputFactory.create(fileName);

        System.out.println(input.toString());
    }
}
