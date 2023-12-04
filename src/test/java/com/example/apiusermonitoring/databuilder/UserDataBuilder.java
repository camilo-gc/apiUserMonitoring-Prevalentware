package com.example.apiusermonitoring.databuilder;

import com.example.apiusermonitoring.domain.model.User;

import java.util.*;

public class UserDataBuilder {

    public static User build(String id){
        return new User(id, "pueba@prueba.com", "prueba", "prueba/prueba.jpg", null,
                null, null, new Date(), new Date(), null, null
        );
    }

    public static List<User> buildList(int size){
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            list.add(build(String.valueOf(i)));
        }
        return list;
    }

    public static Set<User> buildSet(int size){
        Set<User> set = new HashSet<>();
        for (int i = 1; i <= size; i++) {
            set.add(build(String.valueOf(i)));
        }
        return set;
    }

}
