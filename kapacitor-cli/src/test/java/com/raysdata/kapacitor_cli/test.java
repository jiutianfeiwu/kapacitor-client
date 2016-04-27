package com.raysdata.kapacitor_cli;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpGet get=new HttpGet("http://10.20.66.100:9092/tasks");
		HttpClient client =HttpClientBuilder.create().build();
		try {
//			HttpResponse res=client.execute(get);
//			for(Header h:res.getAllHeaders()){
//				System.out.println(h.getName()+"  "+h.getValue());
//			}
			HttpPost post=new HttpPost("http://10.20.66.100:9092/task?dbrps=%5B%7B%22db%22%3A%22telegraf%22%2C%22rp%22%3A%22default%22%7D%5D&name=task4&type=stream");
			final String tick="task2";
//			File f=new File("d:/cpu_alert.tick");
			post.setHeader("Proto", "HTTP/1.1");
			post.setHeader("ProtoMajor", "1");
			post.setHeader("ProtoMinor", "1");
			Path path = Paths.get("d:/cpu_alert.tick");
			ByteArrayEntity entity = new ByteArrayEntity(Files.readAllBytes(path));
			entity.setContentType("binary/octet-stream");
//			entity.setChunked(true);
			post.setEntity(entity);
			HttpResponse r=client.execute(post);
			System.out.println(EntityUtils.toString(r.getEntity()));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
