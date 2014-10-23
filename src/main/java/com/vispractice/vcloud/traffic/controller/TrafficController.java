package com.vispractice.vcloud.traffic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vispractice.vcloud.traffic.domain.TCResponse;
import com.vispractice.vcloud.traffic.service.ScriptService;
import com.vispractice.vcloud.traffic.service.TrafficService;
import com.vispractice.vcloud.traffic.service.TrafficService.TC_ALG;

@Controller
@RequestMapping(value="/tc")
public class TrafficController {
	
	@Autowired TrafficService tc;
	@Autowired ScriptService ss;
	
	@RequestMapping(value = "/debug", method = RequestMethod.GET)  
	public String debugInfoPage(ModelMap model) {
		model.addAttribute("debugInfo", tc.dumpDebugInfo());
        return "debug";  
    }
	
	@RequestMapping(value = "/traffic", method = RequestMethod.GET)  
	public String trafficPage(ModelMap model) {
		model.addAttribute("serviceReseted", tc.serviceReseted());
        return "traffic";  
    }
	
	@RequestMapping(value = "/firewall", method = RequestMethod.GET)  
	public String firewallPage(ModelMap model) {
        return "firewall";  
    }
	
	@RequestMapping(value = "/terminal", method = RequestMethod.GET)  
	public String terminalPage(ModelMap model) {
        return "terminal";  
    }
	
	@ResponseBody
	@RequestMapping(value = "/clearTrafficNics", method = RequestMethod.GET)  
	public TCResponse clearTrafficNics() {
		tc.clearTrafficNics();
        return new TCResponse(-1,"");
    }
	
	@ResponseBody
	@RequestMapping(value = "/serviceReseted", method = RequestMethod.GET)  
	public TCResponse serviceReseted() {
        return new TCResponse(-1, String.valueOf(tc.serviceReseted()));
    }
	
	@ResponseBody
	@RequestMapping(value = "/execSimpleScript", method = RequestMethod.GET)  
	public TCResponse execSimpleScript(@RequestParam String command){
        return new TCResponse(-1,ss.execSimpleScript(command));
    }
	
	@ResponseBody
	@RequestMapping(value = "/preSetupTrafficNics", method = RequestMethod.GET)  
	public TCResponse preSetupTrafficNics(@RequestParam String nicName,
			@RequestParam int start, @RequestParam int end, @RequestParam int step) {
		tc.preSetupTrafficNics(nicName, start, end, step, TC_ALG.HTB);
        return new TCResponse(-1,""); 
    }
	
	@ResponseBody
	@RequestMapping(value = "/limitTrafficFromIp", method = RequestMethod.GET)  
	public TCResponse limitTrafficFromIp(@RequestParam String fromIp,
			@RequestParam int bandwidth) {
		tc.limitTrafficFromIp(fromIp, bandwidth);
        return new TCResponse(-1,""); 
    }
	
	@ResponseBody
	@RequestMapping(value = "/unlimitTrafficFromIp", method = RequestMethod.GET)  
	public TCResponse unlimitTrafficFromIp(@RequestParam String fromIp,
			@RequestParam int bandwidth) {
		tc.unlimitTrafficFromIp(fromIp, bandwidth);
        return new TCResponse(-1,""); 
    }
	
	@ResponseBody
	@RequestMapping(value = "/limitTrafficToIp", method = RequestMethod.GET)  
	public TCResponse limitTrafficToIp(@RequestParam String toIp,
			@RequestParam int bandwidth) {
		tc.limitTrafficToIp(toIp, bandwidth);
        return new TCResponse(-1,""); 
    }
	
	@ResponseBody
	@RequestMapping(value = "/unlimitTrafficToIp", method = RequestMethod.GET)  
	public TCResponse unlimitTrafficToIp(@RequestParam String toIp,
			@RequestParam int bandwidth) {
		tc.unlimitTrafficToIp(toIp, bandwidth);
        return new TCResponse(-1,""); 
    }
}
