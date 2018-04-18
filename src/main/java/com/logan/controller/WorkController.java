package com.logan.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.logan.pojo.ResponsePoJo;
import com.logan.service.IWorkService;

@Controller
@RequestMapping("/discover")
public class WorkController {

	@Autowired  
    private IWorkService iWorkService;  
	
    @RequestMapping(value = "/executeQuery", method = RequestMethod.POST)
    @ResponseBody
   public String executeQuery(@RequestBody String queryString) throws IOException, URISyntaxException, InterruptedException, ExecutionException {
        ResponsePoJo poJo = iWorkService.executeQuery(queryString);
        System.out.println("Json= "+queryString);
        String intarrJSON = JSON.toJSONString(poJo);  
        return intarrJSON;
    }
    
    
}