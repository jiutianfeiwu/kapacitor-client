package com.raysdata.kapacitor_cli;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class Kapacitor {
	private final String kapacitor_manager_uri_p="kapacitor_manager_uri";
	private final String db_p="db";
	private String kapacitor_manager_uri;
	
	private String db;
	
	private KapacitorClient client;
	public KapacitorClient getClient() {
		return client;
	}
	public void setClient(KapacitorClient client) {
		this.client = client;
	}
	public String getKapacitor_manager_uri() {
		return kapacitor_manager_uri;
	}
	public void setKapacitor_manager_uri(String kapacitor_manager_uri) {
		this.kapacitor_manager_uri = kapacitor_manager_uri;
	}
	public String getDb() {
		return db;
	}
	public void setDb(String db) {
		this.db = db;
	}
	public void dofineStreamTask(Task task) throws Exception{
		String uri=this.getKapacitor_manager_uri()+task.getDifineStreamUri();
		uri=ecodeUri(uri);
		client.post(uri, task.getTICKscript().getBytes());
	}
	public void enableTask(Task task) throws Exception{
		String uri=this.getKapacitor_manager_uri()+task.getEnableUri();
		uri=ecodeUri(uri);
		client.post(uri);
	}
	public void disableTask(Task task) throws Exception{
		String uri=this.getKapacitor_manager_uri()+task.getDisableUri();
		uri=ecodeUri(uri);
		client.post(uri);
	}
	public void deleteTask(Task task) throws Exception{
		String uri=this.getKapacitor_manager_uri()+task.getDeleteUri();
		uri=ecodeUri(uri);
		client.post(uri);
	}
	public Kapacitor build(){
		Kapacitor kapacitor=new Kapacitor();
		this.setKapacitor_manager_uri(System.getProperty(kapacitor_manager_uri_p));
		this.setDb(System.getProperty(db_p));
		this.setClient(KapacitorClient.build());
		return kapacitor;
	}
	private String ecodeUri(String uri){
		try {
			return URLEncoder.encode(uri, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uri;
	}
}
