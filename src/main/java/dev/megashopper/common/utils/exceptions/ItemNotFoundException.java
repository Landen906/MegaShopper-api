package dev.megashopper.common.utils.exceptions;

import dev.megashopper.common.entities.Item;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException() {
    }

    public ItemNotFoundException(String s) {
        super(s);
    }

    public ItemNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ItemNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public ItemNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
