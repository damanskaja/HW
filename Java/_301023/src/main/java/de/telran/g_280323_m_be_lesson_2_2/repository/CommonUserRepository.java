package de.telran.g_280323_m_be_lesson_2_2.repository;

import de.telran.g_280323_m_be_lesson_2_2.domain.database.Database;
import de.telran.g_280323_m_be_lesson_2_2.domain.database.SimpleDatabase;
import de.telran.g_280323_m_be_lesson_2_2.domain.entity.User;

import java.util.List;

public class CommonUserRepository implements UserRepository {

    private Database database = new SimpleDatabase();

    @Override
    public List<User> getAll() {
        return database.select("get all");
    }

    @Override
    public List<User> getByName(String name) {
        return database.select("get " + name);
    }

    @Override
    public void addUser(User user) {
        database.execute("add " + user.getName() + " " + user.getPassword());
    }
}