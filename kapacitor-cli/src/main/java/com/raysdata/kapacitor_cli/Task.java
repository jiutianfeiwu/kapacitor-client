package com.raysdata.kapacitor_cli;
/**
 * Name           string
	Type           string
	DBRPs          []DBRP
	TICKscript     string
	Dot            string
	Enabled        bool
	Executing      bool
	Error          string
	ExecutionStats ExecutionStats
 * @author wangshuo
 *
 */
public class Task {
	private String name;
	private TaskType type;
	private DBRP[] DBRPs;
	private String TICKscript;
	private String dot;
	private boolean Enabled;
	private boolean Executing;
	private String error;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDot() {
		return dot;
	}
	public void setDot(String dot) {
		this.dot = dot;
	}
	public boolean isEnabled() {
		return Enabled;
	}
	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}
	public boolean isExecuting() {
		return Executing;
	}
	public void setExecuting(boolean executing) {
		Executing = executing;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public TaskType getType() {
		return type;
	}
	public DBRP[] getDBRPs() {
		return DBRPs;
	}
	public String getTICKscript() {
		return TICKscript;
	}
	public Task(String name,DBRP[] DBRPs,String TICKscript,TaskType type){
		
	}
	/**
	 * http://10.20.66.100:9092/task?dbrps=[{"db":"telegraf","rp":"default"}]&name=task4&type=stream
	 * @return
	 */
	public String getDifineStreamUri(){
		return String.format("/task?dbrps=[{\"db\":\"%s\",\"rp\":\"default\"}]&name=%s&type=%s", getDBRPs().clone()[0].getDatabase(),getName(),getType().toString());
	}
	/**
	 * 10.20.66.100:9092/enable?name=task5
	 * @return
	 */
	public String getEnableUri(){
		return String.format("/enable?name=%s", getName());
	}
	/**
	 * 10.20.66.100:9092/disable?name=task5
	 */
	public String getDisableUri(){
		return String.format("/disable?name=%s", getName());
	}
	/**
	 * 10.20.66.100:9092/task?name=task1
	 * @return
	 */
	public String getDeleteUri(){
		return String.format("/task?name=%s", getName());
	}
	public static Task buildStreamTask(String name,DBRP[] dbrps,String tickScript){
		Task task=new Task(name,dbrps,tickScript,TaskType.stream);
		return task;
	}
	public enum TaskType{
		stream,batch
	}
}
