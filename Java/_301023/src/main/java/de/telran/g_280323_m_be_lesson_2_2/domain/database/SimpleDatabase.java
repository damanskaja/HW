package de.telran.g_280323_m_be_lesson_2_2.domain.database;

import de.telran.g_280323_m_be_lesson_2_2.domain.entity.CommonUser;
import de.telran.g_280323_m_be_lesson_2_2.domain.entity.User;

import java.util.ArrayList;
import java.util.List;

public class SimpleDatabase implements Database {

    List<User> users = new ArrayList<>();

    public SimpleDatabase() {
        users.add(new CommonUser("Vanya", "qwe"));
        users.add(new CommonUser("Petya", "asd"));
        users.add(new CommonUser("Sidor", "zxc"));
    }

    @Override
    public void execute(String query) {

        String[] parts = query.split(" ");
        users.add(new CommonUser(parts[1], parts[2]));
    }

    @Override
    public List<User> select(String query) {

        String[] parts = query.split(" ");
        if (parts[1].equals("all")) {
            return users;
        } else {
            List<User> result = new ArrayList<>();
            for (User user : users) {
                if (user.getName().equals(parts[1])) {
                    result.add(user);
                    return result;
                }
            }
        }
        return null;
    }
}