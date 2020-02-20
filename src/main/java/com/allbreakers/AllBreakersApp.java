package com.allbreakers;

import java.io.IOException;

class AllBreakersApp {
    private static final AlgorithmInputFactory algorithmInputFactory = new AlgorithmInputFactory();

    public static void main(String[] args) throws IOException {
        process("b_read_on.txt");
        process("c_incunabula.txt");
        process("d_tough_choices.txt");
        process("e_so_many_books.txt");
        process("f_libraries_of_the_world.txt");
        process("a_example.txt");
    }

    private static void process(String fileName) throws IOException {
        AlgorithmInput input = algorithmInputFactory.create(fileName);
        System.out.println(input.toString());
    }
}
