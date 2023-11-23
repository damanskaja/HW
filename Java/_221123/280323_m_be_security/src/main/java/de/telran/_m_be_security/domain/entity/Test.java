package de.telran._m_be_security.domain.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // qwe -> $2a$10$OA6bD..2.9fDrCgpvWzsQu/x9t0qieVjov0nLE8wIzaroM8GlcilW

        System.out.println(encoder.encode("qwe"));
    }
}
