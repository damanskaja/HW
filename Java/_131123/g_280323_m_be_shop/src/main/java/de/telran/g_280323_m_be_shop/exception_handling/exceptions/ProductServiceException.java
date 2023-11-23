package de.telran.g_280323_m_be_shop.exception_handling.exceptions;

public class ProductServiceException extends Exception {

    public ProductServiceException() {
        super("Product service exception occurred.");
    }

    public ProductServiceException(String message) {
        super(message);
    }
}

