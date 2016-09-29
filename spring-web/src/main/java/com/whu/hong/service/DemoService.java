package com.whu.hong.service;

import com.whu.hong.pojo.DisplayField;
import com.whu.hong.pojo.Filter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * Created by lvhw on 2016/9/20 20:08.
 */
@Service
public class DemoService {


    public String handleDisplayFields(List<DisplayField> displayFields){
        return displayFields.stream().map(DisplayField::getObjName).collect(Collectors.toList()).toString();
    }

    public String handleFilters(List<Filter> filters){
        return filters.stream().map(Filter::getFieldId).collect(Collectors.toList()).toString();
    }

    public String printDemo(String input){
        String output = input + "Demo";
        System.out.println(output);
        return output;
    }
}
