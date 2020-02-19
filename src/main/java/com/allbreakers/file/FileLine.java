package com.allbreakers.file;

import java.util.ArrayList;
import java.util.List;

public class FileLine {
    private final List<FileValue> values = new ArrayList<>();

    void add(FileValue fileValue) {
        values.add(fileValue);
    }

    public List<FileValue> values() {
        return values;
    }

    public FileValue getValue(int index) {
        return values.get(index);
    }

    public boolean hasValueAt(int index) {
        return values.size() >= index;
    }
}
