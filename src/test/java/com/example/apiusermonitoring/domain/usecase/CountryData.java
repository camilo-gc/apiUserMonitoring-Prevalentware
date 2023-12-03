package com.example.apiusermonitoring.domain.usecase;

import com.example.apiusermonitoring.domain.model.Country;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CountryData {

    public static Country build(String id){
        return new Country(id, "name", new Date(), new Date(), null);
    }

    public static List<Country> buildList(int size){
        List<Country> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            list.add(build(String.valueOf(i)));
        }
        return list;
    }

}
