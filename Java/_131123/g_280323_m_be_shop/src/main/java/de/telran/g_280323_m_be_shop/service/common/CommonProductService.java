package de.telran.g_280323_m_be_shop.service.common;

import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Product;
import de.telran.g_280323_m_be_shop.repository.interfaces.ProductRepository;
import de.telran.g_280323_m_be_shop.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommonProductService implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void add(Product product) {
        repository.add(product.getName(), product.getPrice());
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
    public double getTotalPrice() {
        return getAll().stream().mapToDouble(x -> x.getPrice()).sum();
    }

    @Override
    public double getAveragePrice() {
        int count = getCount();
        if (count == 0) {
            return 0;
        }
        return getTotalPrice() / count;
    }

    @Override
    public void deleteByName(String name) {
        Product product = getAll().stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElse(null);
        repository.delete(product.getId());
    }

    @Override
    public void add(Product product) {
        if (product == null || product.getName() == null) {
            throw new IllegalArgumentException("Product or product name cannot be null");
        }
        repository.add(product.getName(), product.getPrice());
    }

    @Override
    public Product getById(int id) {
        Product product = repository.getById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        return product;
    }

    @Override
    public double getTotalPrice() {
        List<Product> products = getAll();
        if (products == null) {
            throw new IllegalStateException("Product list is null");
        }
        return products.stream().mapToDouble(Product::getPrice).sum();
    }


    @Override
    public void deleteById(int id) {
        try {
            repository.delete(id);
        } catch (RepositoryException e) {
            throw new RuntimeException("Failed to delete product", e);
        }
    }

