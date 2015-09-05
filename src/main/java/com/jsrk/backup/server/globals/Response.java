package com.jsrk.backup.server.globals;

import java.util.ArrayList;
import java.util.List;

public class Response<Data> {

	private Integer code;

	private String description;

	private Data data;

	private List<String> errors = new ArrayList<String>(0);

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", description=" + description
				+ ", data=" + data + ", errors=" + errors + "]";
	}

}
