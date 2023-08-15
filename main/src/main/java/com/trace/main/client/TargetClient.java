package com.trace.main.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "targetClient", url = "http://localhost:7071/target")
public interface TargetClient {
    
    @RequestMapping(method = RequestMethod.GET, value = "trace")
    public String getTargetTrace();
}
