package com.vispractice.vcloud.traffic.domain;

public class DebugInfo {

	private TCQdisc eth0Qdisc;
	private TCQdisc eth1Qdisc;
	private TCQdisc eth2Qdisc;
	private TCClass eth0Class;
	private TCClass eth1Class;
	private TCClass eth2Class;
	
	private ITBMangle mangle;
	private ITBMangle filter;
	private ITBMangle nat;
	public TCQdisc getEth0Qdisc() {
		return eth0Qdisc;
	}
	public void setEth0Qdisc(TCQdisc eth0Qdisc) {
		this.eth0Qdisc = eth0Qdisc;
	}
	public TCQdisc getEth1Qdisc() {
		return eth1Qdisc;
	}
	public void setEth1Qdisc(TCQdisc eth1Qdisc) {
		this.eth1Qdisc = eth1Qdisc;
	}
	public TCQdisc getEth2Qdisc() {
		return eth2Qdisc;
	}
	public void setEth2Qdisc(TCQdisc eth2Qdisc) {
		this.eth2Qdisc = eth2Qdisc;
	}
	public TCClass getEth0Class() {
		return eth0Class;
	}
	public void setEth0Class(TCClass eth0Class) {
		this.eth0Class = eth0Class;
	}
	public TCClass getEth1Class() {
		return eth1Class;
	}
	public void setEth1Class(TCClass eth1Class) {
		this.eth1Class = eth1Class;
	}
	public TCClass getEth2Class() {
		return eth2Class;
	}
	public void setEth2Class(TCClass eth2Class) {
		this.eth2Class = eth2Class;
	}
	public ITBMangle getMangle() {
		return mangle;
	}
	public void setMangle(ITBMangle mangle) {
		this.mangle = mangle;
	}
	public ITBMangle getFilter() {
		return filter;
	}
	public void setFilter(ITBMangle filter) {
		this.filter = filter;
	}
	public ITBMangle getNat() {
		return nat;
	}
	public void setNat(ITBMangle nat) {
		this.nat = nat;
	}
	
	public DebugInfo(TCQdisc eth0Qdisc, TCQdisc eth1Qdisc, TCQdisc eth2Qdisc,
			TCClass eth0Class, TCClass eth1Class, TCClass eth2Class,
			ITBMangle mangle, ITBMangle filter, ITBMangle nat) {
		super();
		this.eth0Qdisc = eth0Qdisc;
		this.eth1Qdisc = eth1Qdisc;
		this.eth2Qdisc = eth2Qdisc;
		this.eth0Class = eth0Class;
		this.eth1Class = eth1Class;
		this.eth2Class = eth2Class;
		this.mangle = mangle;
		this.filter = filter;
		this.nat = nat;
	}
}
