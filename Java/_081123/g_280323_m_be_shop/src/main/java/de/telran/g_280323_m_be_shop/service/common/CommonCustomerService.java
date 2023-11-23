package de.telran.g_280323_m_be_shop.service.common;

import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Customer;
import de.telran.g_280323_m_be_shop.repository.interfaces.CustomerRepository;
import de.telran.g_280323_m_be_shop.service.interfaces.CustomerService;
import de.telran.g_280323_m_be_shop.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommonCustomerService implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ProductService productService;

    @Override
    public List<Customer> getAll() {
        return repository.getAll();
    }

    @Override
    public Customer getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void add(Customer customer) {
        repository.add(customer.getName());
    }

    @Override
    public void deleteById(int id) {
        repository.delete(id);
    }

    @Override
    public int getCount() {
        return getAll().size();
    }

    @Override
    public double getTotalPriceById(int id) {
        return getById(id).getCart().getTotalPrice();
    }

    @Override
    public double getAveragePriceById(int id) {
        return getById(id).getCart().getAveragePrice();
    }

    @Override
    public void deleteByName(String name) {
        Customer customer = getAll().stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElse(null);
        repository.delete(customer.getId());
    }

    @Override
    public void addToCartById(int customerId, int productId) {
        repository.addToCartById(customerId, productId);
    }

    @Override
    public void deleteFromCartById(int customerId, int productId) {
        repository.deleteFromCartById(customerId, productId);
    }

    @Override
    public void clearCartById(int id) {
        repository.clearCart(id);
    }


    @Override
    public void add(Customer customer) {
        if (customer == null || customer.getName() == null) {
            throw new IllegalArgumentException("Customer or customer name cannot be null");
        }
        repository.add(customer.getName());
    }

    @Override
    public Customer getById(int id) {
        Customer customer = repository.getById(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with id " + id + " not found");
        }
        return customer;
    }

    @Override
    public double getTotalPriceById(int id) {
        Customer customer = getById(id);
        if (customer.getCart() == null) {
            throw new IllegalStateException("Customer's cart is null");
        }
        return customer.getCart().getTotalPrice();
    }


    @Override
    public void addToCartById(int customerId, int productId) {
        try {
            repository.addToCartById(customerId, productId);
        } catch (RepositoryException e) {
            throw new RuntimeException("Failed to add product to cart", e);
        }
    }
    public void validateCustomer(CommonCustomer customer) throws CustomerValidationException {
        // Validation logic
        if (customer.getAge() < 18 || customer.getEmail() == null || !isValidEmail(customer.getEmail())) {
            throw new CustomerValidationException("Invalid customer details.");
        }
    }




