package com.vispractice.vcloud.traffic.service;

import org.springframework.stereotype.Service;

import com.cloud.utils.script.Script;

@Service("scriptService")
public class ScriptServiceImpl implements ScriptService {

	@Override
	public String execSimpleScript(String command) {
		return Script.runSimpleBashScript(command);
	}

}
