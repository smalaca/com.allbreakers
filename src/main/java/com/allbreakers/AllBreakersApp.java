package com.allbreakers;

import com.allbreakers.file.FileTransformer;

import java.io.IOException;

class AllBreakersApp {
    public static void main(String[] args) throws IOException {
        FileTransformer fileTransformer = new FileTransformer();

        System.out.println(fileTransformer.transform("/files/first", ";").description());
        System.out.println(fileTransformer.transform("/files/second", " ", ";").description());
        System.out.println(fileTransformer.transform("/files/third", "&").description());
    }
}
