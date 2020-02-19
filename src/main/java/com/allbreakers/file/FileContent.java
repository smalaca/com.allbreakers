package com.allbreakers.file;

import java.util.ArrayList;
import java.util.List;

public class FileContent {
    private final List<FileLine> lines = new ArrayList<>();

    void add(FileLine fileLine) {
        lines.add(fileLine);
    }

    public List<FileLine> lines() {
        return lines;
    }

    public String description() {
        StringBuilder builder = new StringBuilder();
        lines().forEach(line -> describeLine(builder, line));

        return builder.toString();
    }

    private void describeLine(StringBuilder builder, FileLine line) {
        builder.append("LINE\n");
        line.values().forEach(fileValue -> describeValue(builder, fileValue));
        builder.append("\n");
    }

    private void describeValue(StringBuilder builder, FileValue fileValue) {
        if (fileValue.isEmpty()) {
            builder.append("NO VALUE");
        } else if (fileValue.isNumeric()) {
            builder.append(fileValue.asInt() + "-" + fileValue.asDouble() + "-" + fileValue.value());
        } else {
            builder.append("NOT NUMERIC: " + fileValue.value());
        }

        builder.append("\n");
    }
}
