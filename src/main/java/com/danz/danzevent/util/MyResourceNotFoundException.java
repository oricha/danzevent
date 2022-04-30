package com.danz.danzevent.util;

public final class MyResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MyResourceNotFoundException(String message) {
        super(message);
    }

    public MyResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
    public MyResourceNotFoundException() {
        super();
    }

    public MyResourceNotFoundException(final Throwable cause) {
        super(cause);
    }
}
