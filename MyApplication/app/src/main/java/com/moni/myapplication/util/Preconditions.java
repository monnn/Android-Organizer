package com.moni.myapplication.util;

/**
 * Created by moni on 15-6-3.
 */
public class Preconditions {

    private Preconditions() {
        super();
    }

    /**
     * Verify that a value is not null.
     *
     * @param value the value to verify
     * @param name the name of the value that will be used in the exception message.
     */
    public static void notNull(Object value, String name) {
        if (value == null) {
            throw new IllegalArgumentException(name + " must not be null!");
        }
    }

    /**
     * Returns {@code true} if the given string is null or is the empty string.
     *
     * @param string a string reference to check
     * @return {@code true} if the string is null or is the empty string
     */
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
