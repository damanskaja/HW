package de.telran.g_280323_m_be_shop.domain.entity.common;

import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonProduct implements Product {

    private static final Logger logger = LoggerFactory.getLogger(CommonProduct.class);

    private int id;
    private String name;
    private double price;

    public CommonProduct() {
        logger.info("CommonProduct constructor called.");
    }

    public CommonProduct(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CommonProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}