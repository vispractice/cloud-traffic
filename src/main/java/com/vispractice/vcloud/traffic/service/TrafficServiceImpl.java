package com.vispractice.vcloud.traffic.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cloud.utils.script.Script;

@Service("trafficService")
public class TrafficServiceImpl implements TrafficService {

	private static final Logger s_logger = LoggerFactory.getLogger(TrafficServiceImpl.class);
	private static final int MARK_BASE_RATE = 100;
	
	public void clearTrafficNics() {
		String[] nics = findHostNics();
		
		s_logger.debug("founded nics: {}", Arrays.toString(nics));
		
		for(String nic : nics){
			clearNicTrafficSetting(nic);
			s_logger.debug("cleared nic {} traffic setting", nic);
		}
		
		s_logger.debug("cleared all nics traffic setting");
	}

	public void preSetupTrafficNics(String nicName, int startRateInMb,
			int endRateInMb, int step, TC_ALG alg) {
		
		if(alg.equals(TC_ALG.HTB)){
			Script.runSimpleBashScript("tc qdisc add dev " + nicName + " root handle 1: htb");
			Script.runSimpleBashScript("tc class add dev " + nicName + " parent 1: classid 1:1 htb rate "+startRateInMb+"Mbit ceil "+startRateInMb+"Mbit");
			s_logger.debug("init htb nic root qdisc and class");
		}else{
			s_logger.warn("no other alg implemented");
		}
	}

	public void limitTrafficFromIp(String ip, int rate) {
		int id = (MARK_BASE_RATE + rate);
		String cid = "1:"+id;
		String defaultNic = "eth0";
		
		if(Script.runSimpleBashScript("tc class show dev "+defaultNic).indexOf(cid) == -1){
			Script.runSimpleBashScript("tc class add dev "+defaultNic+" parent 1:1 classid "+cid+" htb rate "+rate+"Mbit ceil "+rate+"Mbit");
			Script.runSimpleBashScript("tc filter add dev "+defaultNic+" parent 1:0 protocol ip handle "+id+" fw classid "+cid);
			s_logger.debug("init class {} and rate {} for dev {}",
					new Object[]{cid, rate, defaultNic});
		}
		
		Script.runSimpleBashScript("iptables -I PREROUTING -t mangle -p tcp -s "
				+ ip + " -j MARK --set-mark " + id);
	}

	public void unlimitTrafficFromIp(String ip, int rate) {
		Script.runSimpleBashScript("iptables -D PREROUTING -t mangle -p tcp -s "
				+ ip + " -j MARK --set-mark " + (MARK_BASE_RATE + rate));
	}

	public void limitTrafficToIp(String ip, int rate) {
		int id = (MARK_BASE_RATE + rate);
		String cid = "1:"+id;
		String defaultNic = "eth2";
		
		if(Script.runSimpleBashScript("tc class show dev "+defaultNic).indexOf(cid) == -1){
			Script.runSimpleBashScript("tc class add dev "+defaultNic+" parent 1:1 classid "+cid+" htb rate "+rate+"Mbit ceil "+rate+"Mbit");
			Script.runSimpleBashScript("tc filter add dev "+defaultNic+" parent 1:0 protocol ip handle "+id+" fw classid "+cid);
			s_logger.debug("init class {} and rate {} for dev {}",
					new Object[]{cid, rate, defaultNic});
		}
		
		Script.runSimpleBashScript("iptables -I PREROUTING -t mangle -p tcp -d "
				+ ip + " -j MARK --set-mark " + id);
	}

	public void unlimitTrafficToIp(String ip, int rate) {
		Script.runSimpleBashScript("iptables -D PREROUTING -t mangle -p tcp -d "
				+ ip + " -j MARK --set-mark " + (MARK_BASE_RATE + rate));
	}

	public String dumpDebugInfo() {
		StringBuffer info = new StringBuffer();
		
		info.append("dump eth0:\n");
		info.append(Script.runSimpleBashScript("tc qdisc show dev eth0"));
		info.append(Script.runSimpleBashScript("tc class show dev eth0"));
		info.append("\ndump eth1:\n");
		info.append(Script.runSimpleBashScript("tc qdisc show dev eth1"));
		info.append(Script.runSimpleBashScript("tc class show dev eth1"));
		info.append("\ndump eth2:\n");
		info.append(Script.runSimpleBashScript("tc qdisc show dev eth2"));
		info.append(Script.runSimpleBashScript("tc class show dev eth2"));
		info.append("\ndump iptables:\n");
		info.append(Script.runSimpleBashScript("iptables -L -n -t mangle"));
		info.append(Script.runSimpleBashScript("iptables -L -n -t filter"));
		info.append(Script.runSimpleBashScript("iptables -L -n -t nat"));
		
		return info.toString();
	}
	
	private String[] findHostNics(){
		return new String[]{"eth0", "eth1", "eth2"};
	}
	
	private void clearNicTrafficSetting(String nicName){
		Script.runSimpleBashScript("tc qdisc del " + nicName + " root");
	}

}
