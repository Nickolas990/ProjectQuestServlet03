package com.javarush.echo.nikolaymelnikov.projectservletquest_03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {
    private UserRepository userRepositoryTest;
    private User user;

    @BeforeEach
    public void init() {
        userRepositoryTest = new UserRepository();
        user = new User("test");
        userRepositoryTest.save(user);
    }


    @Test
    void test_save() {
        userRepositoryTest.save(new User("test01"));
        assertEquals("test01", userRepositoryTest.load("test01").getUsername());
    }

    @Test
    void test_load() {
        assertEquals("test", userRepositoryTest.load("test").getUsername());
    }

    @Test
    void test_isExist() {
        assertTrue(userRepositoryTest.getUsers().containsKey("test"));
    }
}