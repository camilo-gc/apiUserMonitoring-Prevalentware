package com.example.apiusermonitoring.databuilder;

import com.example.apiusermonitoring.domain.model.UserMonitoring;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserMonitoringDataBuilder {

    public static UserMonitoring build(String id){
        return new UserMonitoring(id, 1, "test", LocalDate.now(), UserDataBuilder.build("1"));
    }

    public static List<UserMonitoring> buildList(int size){
        List<UserMonitoring> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            list.add(build(String.valueOf(i)));
        }
        return list;
    }

}
