package de.telran.g_280323_m_be_lesson_2_2.service;

import de.telran.g_280323_m_be_lesson_2_2.domain.entity.User;
import de.telran.g_280323_m_be_lesson_2_2.repository.CommonUserRepository;
import de.telran.g_280323_m_be_lesson_2_2.repository.UserRepository;

import java.util.List;

public class CommonUserService implements UserService {

    private UserRepository repository = new CommonUserRepository();

    private PasswordService passwordService = new PasswordService();

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User getByName(String name) {
        return repository.getByName(name).get(0);
    }

    @Override
    public void add(User user) {
        if (passwordService.isPasswordCorrect(user.getPassword())) {
            repository.addUser(user);
        } else {
            System.out.println("Password is incorrect!");
        }
    }
}