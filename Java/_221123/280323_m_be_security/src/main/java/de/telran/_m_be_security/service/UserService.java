package de.telran.g_280323_m_be_security.service;

import de.telran.g_280323_m_be_security.domain.entity.Role;
import de.telran.g_280323_m_be_security.domain.entity.User;
import de.telran.g_280323_m_be_security.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private UserRepository repository;
    private BCryptPasswordEncoder encoder;

    public UserService(UserRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = repository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Пользователь не найден!");
        }

        return user;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User save(User user) {
        UserDetails foundUser = repository.findByUsername(user.getUsername());

        if (foundUser != null) {
            return null;
        }

        Set<Role> roles = Set.of(new Role(2, "ROLE_USER"));
        user.setRoles(roles);

        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    // Получать товар по идентификатору.
    public Product getProductById(int productId) {
        return productService.getProductById(productId);
    }

    // Добавлять товар в корзину.
    public void addToCart(int productId) {
        productService.addToCart(productId);
    }

    // Удалять товар из корзины.
    public void removeFromCart(int productId) {
        productService.removeFromCart(productId);
    }

    // Очищать корзину.
    public void clearCart() {
        productService.clearCart();
    }
}
