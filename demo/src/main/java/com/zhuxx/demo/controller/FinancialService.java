package com.zhuxx.demo.controller;

import com.zhuxx.demo.dao.BatchMapper;
import com.zhuxx.demo.model.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


public class FinancialService {
    @Autowired
    private BatchMapper batchMapper;
    @GetMapping("/text11")
    public  String testBatchCustomer(){
        Batch batch = batchMapper.findBatchCustomer();
        if(batch != null){
            return batch.toString();
        } return "error";
    }

}
