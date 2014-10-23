package com.vispractice.vcloud.traffic.service;

import org.springframework.stereotype.Service;

import com.cloud.utils.script.OutputInterpreter;
import com.cloud.utils.script.Script;

@Service("scriptService")
public class ScriptServiceImpl implements ScriptService {

	@Override
	public String execSimpleScript(String command) {
		Script s = new Script("/bin/bash", 0);
        s.add("-c");
        s.add(command);

        OutputInterpreter.AllLinesParser parser = new OutputInterpreter.AllLinesParser();
        if (s.execute(parser) != null)
            return null;

        String result = parser.getLines();
        if (result == null || result.trim().isEmpty())
            return null;
        else
            return result.trim();
	}

}
