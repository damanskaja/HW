package de.telran.g_280323_m_be_lesson_2_2.repository;

import de.telran.g_280323_m_be_lesson_2_2.domain.entity.User;

import java.util.List;

public interface UserRepository {

    List<User> getAll();

    List<User> getByName(String name);

    void addUser(User user);
}