package de.telran.g_280323_m_be_shop.domain.entity.jpa;

import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Customer;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class JpaCustomer implements Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private JpaCart cart;

    public JpaCustomer() {
    }

    public JpaCustomer(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        validateCustomer();
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
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        validateCustomer();
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        validateCustomer();
    }

    @Override
    public JpaCart getCart() {
        return cart;
    }

    public void setCart(JpaCart cart) {
        this.cart = cart;
    }

    private void validateCustomer() {
        if (age < 0 || age > 150) {
            throw new CustomerValidationException("Invalid age");
        }

        if (email != null && !isValidEmail(email)) {
            throw new CustomerValidationException("Invalid email");
        }
    }

    private boolean isValidEmail(String email) {

        return true;
    }
}
