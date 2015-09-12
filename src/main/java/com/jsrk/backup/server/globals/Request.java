package com.jsrk.backup.server.globals;

public class Request<Data> {

	private String url;

	private Data data;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Request=[url=" + url + ", data=" + data + "]";
	}

}
