package com.example.order.back.controller;

import com.example.order.back.entity.Orderback;
import com.example.order.back.repository.OrderbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
//
public class OrderbackHandler {
//    自动装载
    @Autowired
    private OrderbackRepository orderbackRepository;

    @GetMapping("/findAll")
    public List<Orderback> findAll(){
        return orderbackRepository.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody Orderback orderback){
        Orderback result = orderbackRepository.save(orderback);
        if (result != null){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Orderback findById(@PathVariable("id") Integer id){
        return orderbackRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Orderback orderback){
        Orderback result = orderbackRepository.save(orderback);
        if (result != null){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        orderbackRepository.deleteById(id);
    }
}
