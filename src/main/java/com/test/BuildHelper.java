package com.test;

import com.test.bean.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuildHelper {

    private BuildHelper() {
    }

    public static List<User> buildUsers() {
        final int COUNT = 10;
        List<User> users = new ArrayList<>(COUNT);
        String[] names = {"明", "拍", "吗", "在", "有", "楠", "哦", "被", "男", "红"};
        for (int i = 0; i < COUNT; i++) {
            users.add(new User(i + 1, "小" + names[i], i + 10, new Date()));
        }
        return users;
    }
}