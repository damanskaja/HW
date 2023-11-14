package de.telran.g_280323_m_be_lesson_2_2.controller;

import de.telran.g_280323_m_be_lesson_2_2.domain.entity.CommonUser;
import de.telran.g_280323_m_be_lesson_2_2.domain.entity.User;
import de.telran.g_280323_m_be_lesson_2_2.service.CommonUserService;
import de.telran.g_280323_m_be_lesson_2_2.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service = new CommonUserService();

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{name}")
    public User getByName(@PathVariable String name) {
        return service.getByName(name);
    }

    @PostMapping
    public void add(@RequestBody CommonUser user) {
        service.add(user);
    }
}