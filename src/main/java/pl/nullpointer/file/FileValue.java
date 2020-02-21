package pl.nullpointer.file;

import com.google.common.base.Strings;

public class FileValue {
    private final String value;

    FileValue(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public int asInt() {
        return Integer.parseInt(value);
    }

    public double asDouble() {
        return Double.parseDouble(value);
    }

    public boolean isEmpty() {
        return Strings.isNullOrEmpty(value);
    }

    public boolean isNumeric() {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
