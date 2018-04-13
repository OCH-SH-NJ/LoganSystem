package com.logan.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logan.service.IWorkService;

@Controller
@RequestMapping("/work")
public class WorkController {

	@Autowired  
    private IWorkService iWorkService;  
	
    @RequestMapping(value = "/doSimpleWork", method = RequestMethod.POST)
    @ResponseBody
   public String getSimpleWork() throws IOException, URISyntaxException, InterruptedException, ExecutionException {
        return iWorkService.getTotalLogCount();
    }
    
    @RequestMapping(value = "/deleteLog", method = RequestMethod.DELETE)
    @ResponseBody
   public String deleteLog() {
        return iWorkService.deleteLog();
    }
    
    @RequestMapping("/getLogType")  
    @ResponseBody
    public String getLogType(@RequestParam("entityId") int id) { 
    	return iWorkService.getLogType(id);
    } 
    
    
    
}