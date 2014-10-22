package com.vispractice.vcloud.traffic.service;

import com.vispractice.vcloud.traffic.domain.DebugInfo;

public interface TrafficService {

	public enum TC_ALG{
		CBQ,
		HTB
	}
	
	/**
	 * 清除原流量设置
	 */
	public void clearTrafficNics();
	
	/**
	 * 预设置流量网络
	 */
	public void preSetupTrafficNics(String nicName, int startRateInKb,
			int endRateInKb, int step, TC_ALG alg);
	
	/**
	 * 设置从此IP的流量限制
	 * @param ip
	 * @param rate
	 */
	public void limitTrafficFromIp(String ip, int rate);
	
	/**
	 * 清除限制
	 * @param ip
	 */
	public void unlimitTrafficFromIp(String ip, int rate);
	
	/**
	 * 设置到此IP的流量限制
	 * @param ip
	 * @param rate
	 */
	public void limitTrafficToIp(String ip, int rate);
	
	/**
	 * 清除限制
	 * @param ip
	 */
	public void unlimitTrafficToIp(String ip, int rate);
	
	/**
	 * 导出调试日志
	 * @return
	 */
	public DebugInfo dumpDebugInfo();
}
