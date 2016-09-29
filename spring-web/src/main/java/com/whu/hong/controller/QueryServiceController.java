package com.whu.hong.controller;

import com.whu.hong.pojo.DisplayField;
import com.whu.hong.pojo.Filter;
import com.whu.hong.pojo.Message;
import com.whu.hong.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 查询服务控制器
 * Created by lvhw on 2016/6/20.
 */
//@RestController
@Controller
@RequestMapping(value = "/")
public class QueryServiceController {

    @Autowired
    private DemoService ds;

    @ResponseBody
    @RequestMapping(value = "/queryData")
    //方法参数不能用原生类型
    public Message queryData(String sql, Integer ei, String verifyInfo){

        //DemoService ds = new DemoService();
        ds.printDemo("sql");

        DisplayField displayField = new DisplayField();
        displayField.setObjName("obj1");
        displayField.setFieldId("1");
        displayField.setAliasName("alias1");

        DisplayField displayField2 = new DisplayField();
        displayField2.setObjName("obj2");
        displayField2.setFieldId("2");
        displayField2.setAliasName("alias2");
        ds.handleDisplayFields(Arrays.asList(displayField, displayField2));

        Filter filter = new Filter();
        filter.setFieldId("1");
        filter.setDbObjName("filterObje");

        ds.handleFilters(Collections.singletonList(filter));

        Message msg = new Message("test", "this is a test message!");
        return msg;
    }

    @ResponseBody
    @RequestMapping(value = "/queryDataSet")//queryData2前面的'/'可有可无，后面的必需
    List<String> getAllList(@RequestParam(required = true) String sql,
                            @RequestParam(required = true)Integer entId,
                            @RequestParam(required = true)String verify){

        System.out.println("sql:" + sql + ", entId:" + entId + ", verify:" + verify);

        return Arrays.asList(sql, String.valueOf(entId), verify);
    }
}
