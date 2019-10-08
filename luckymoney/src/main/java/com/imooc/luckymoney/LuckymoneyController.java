package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRespository respository;

    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){

        return respository.findAll();

    }

    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money")BigDecimal money){
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return respository.save(luckymoney);

    }

    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id){
        return respository.findById(id).orElse(null);
    }

    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional = respository.findById(id);
        if(optional.isPresent()){
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            return respository.save(luckymoney);
        }

        return null;
    }


}
