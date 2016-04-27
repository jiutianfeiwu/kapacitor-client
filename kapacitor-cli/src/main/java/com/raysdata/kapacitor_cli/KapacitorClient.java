package com.raysdata.kapacitor_cli;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.raysdata.kapacitor_cli.exception.BlankException;

public class KapacitorClient {
	private HttpClient client;
	public KapacitorClient() {
		this.setClient(HttpClientBuilder.create().build());
	}
	public HttpClient getClient() {
		return client;
	}
	private void setClient(HttpClient client) {
		this.client = client;
	}
	public HttpResponse get(String uri) throws Exception{
		//"http://10.20.66.100:9092/tasks"
		if(StringUtils.isBlank(uri)){
			throw new BlankException("KapacitorClient get uri is blank");
		}
		HttpGet get=new HttpGet(uri);
		HttpResponse res = null;
		try {
			res = this.getClient().execute(get);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public HttpResponse post(String uri,byte[] body) throws Exception{
		if(StringUtils.isBlank(uri)){
			throw new BlankException("KapacitorClient post uri is blank");
		}
		HttpResponse res = null;
		HttpPost post=new HttpPost(uri);
		post.setHeader("Proto", "HTTP/1.1");
		post.setHeader("ProtoMajor", "1");
		post.setHeader("ProtoMinor", "1");
		ByteArrayEntity entity = new ByteArrayEntity(body);
		entity.setContentType("binary/octet-stream");
//		entity.setChunked(true);
		post.setEntity(entity);
		try {
			res=client.execute(post);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public HttpResponse post(String uri) throws Exception{
		if(StringUtils.isBlank(uri)){
			throw new BlankException("KapacitorClient post uri is blank");
		}
		HttpResponse res = null;
		HttpPost post=new HttpPost(uri);
		post.setHeader("Proto", "HTTP/1.1");
		post.setHeader("ProtoMajor", "1");
		post.setHeader("ProtoMinor", "1");
		try {
			res=client.execute(post);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public HttpResponse delete(String uri) throws Exception{
		//"http://10.20.66.100:9092/tasks"
		if(StringUtils.isBlank(uri)){
			throw new BlankException("KapacitorClient delete uri is blank");
		}
		HttpDelete get=new HttpDelete(uri);
		HttpResponse res = null;
		try {
			res = this.getClient().execute(get);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public static KapacitorClient build(){
		return new KapacitorClient();
	}
}
