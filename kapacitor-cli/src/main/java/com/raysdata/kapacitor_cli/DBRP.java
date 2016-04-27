package com.raysdata.kapacitor_cli;
/**
	 * type DBRP struct {
			Database        string `json:"db"`
			RetentionPolicy string `json:"rp"`
		}
	 * @author wangshuo
	 *
	 */
	public class DBRP{
		private String database;
		private String retentionPolicy;
		public DBRP(String database){
			this.setDatabase(database);
			this.setRetentionPolicy("default");
		}
		public DBRP(String database,String retentionPolicy){
			this.setDatabase(database);
			this.setRetentionPolicy(retentionPolicy);
		}
		public String getDatabase() {
			return database;
		}
		public void setDatabase(String database) {
			this.database = database;
		}
		public String getRetentionPolicy() {
			return retentionPolicy;
		}
		public void setRetentionPolicy(String retentionPolicy) {
			this.retentionPolicy = retentionPolicy;
		}
		
	}