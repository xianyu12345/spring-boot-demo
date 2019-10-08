package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class HelloControler {

    @Autowired
    private  LimitConfig limitConfig;

    @GetMapping("/hello")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0")Integer id){
        //return "说明"+limitConfig.getDes();
        return "id:"+id;
    }
}
