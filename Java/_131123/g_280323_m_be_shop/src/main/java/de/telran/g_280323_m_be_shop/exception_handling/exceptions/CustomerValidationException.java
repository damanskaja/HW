package de.telran.g_280323_m_be_shop.exception_handling.exceptions;


public class CustomerValidationException extends Exception {

    public CustomerValidationException() {
        super("Customer validation failed.");
    }

    public CustomerValidationException(String message) {
        super(message);
    }
}

public class CustomerValidationException {
}
