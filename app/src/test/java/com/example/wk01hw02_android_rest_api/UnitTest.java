package com.example.wk01hw02_android_rest_api;

import static androidx.core.content.ContextCompat.startActivity;

import org.junit.Test;

import static org.junit.Assert.*;

import android.content.Intent;

import androidx.test.filters.MediumTest;

import java.util.List;
import java.util.Random;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest {
    private static final String TEST_USER = "Bob";

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void username_exists_in_list(){
        Users users = new Users();
        List<User> listUsers = users.getUsers();
        String expected = "Bob";
        String result = listUsers.get(0).getUsername();
        assertEquals("Username Exists", expected, result);
    }

    @Test
    public void password_exists_in_list(){
        Users users = new Users();
        List<User> listUsers = users.getUsers();
        String expected = "secret1";
        String result = listUsers.get(0).getPassword();
        assertEquals("Password Exists", expected, result);
    }

}