package com.vispractice.vcloud.traffic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vispractice.vcloud.traffic.service.TrafficService;
import com.vispractice.vcloud.traffic.service.TrafficService.TC_ALG;

@Controller
@RequestMapping(value="/tc")
public class TrafficController {
	
	@Autowired TrafficService tc;
	
	@RequestMapping(value = "/debug", method = RequestMethod.GET)  
	public String debugInfo(ModelMap model) {
		model.addAttribute("debugInfo", tc.dumpDebugInfo().replaceAll("\\n", "<br/>"));
        return "debug";  
    }
	
	@RequestMapping(value = "/clearTrafficNics", method = RequestMethod.GET)  
	public String clearTrafficNics() {
		tc.clearTrafficNics();
        return "debug";  
    }
	
	@RequestMapping(value = "/preSetupTrafficNics", method = RequestMethod.GET)  
	public String preSetupTrafficNics() {
		tc.preSetupTrafficNics("eth0", 1, 500, 1, TC_ALG.HTB);
        return "debug";  
    }
	
	@RequestMapping(value = "/limitTrafficFromIp", method = RequestMethod.GET)  
	public String limitTrafficFromIp() {
		tc.limitTrafficFromIp("", 10);
        return "debug";  
    }
	
	@RequestMapping(value = "/unlimitTrafficFromIp", method = RequestMethod.GET)  
	public String unlimitTrafficFromIp() {
		tc.limitTrafficFromIp("", 10);
        return "debug";  
    }
	
	@RequestMapping(value = "/limitTrafficToIp", method = RequestMethod.GET)  
	public String limitTrafficToIp() {
		tc.limitTrafficFromIp("", 10);
        return "debug";  
    }
	
	@RequestMapping(value = "/unlimitTrafficToIp", method = RequestMethod.GET)  
	public String unlimitTrafficToIp() {
		tc.limitTrafficFromIp("", 10);
        return "debug";
    }
}
