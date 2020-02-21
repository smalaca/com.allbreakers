package pl.nullpointer.file;

import java.util.*;
import java.util.stream.Collectors;

public class Output {
    private final Map<Integer, List<Integer>> libraries = new LinkedHashMap<>();

    public void add(int libraryId, List<Integer> books) {
        libraries.put(libraryId, books);
    }

    public Map<Integer, List<Integer>> libraries() {
        return libraries;
    }

    public String description() {
        StringBuilder builder = new StringBuilder();
        builder.append(libraries.size() + "\n");

        libraries().forEach((key, value) -> {
            builder.append(key);
            builder.append(" ");
            builder.append(value.size());

            builder.append("\n");

            builder.append(value.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" ")));
            builder.append("\n");
        });

        return builder.toString();
    }
}
