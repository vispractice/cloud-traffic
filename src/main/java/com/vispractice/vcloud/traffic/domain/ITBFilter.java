package com.vispractice.vcloud.traffic.domain;

import org.apache.commons.lang.StringUtils;

public class ITBFilter {

	private String description;

	public String getDescription() {
		return StringUtils.isBlank(description)?
				"":
				description.replaceAll("\\n", "<br/>");
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ITBFilter(String description) {
		super();
		this.description = description;
	}
	
	
}
