package es.upm.dit.apsv.cris.servlets;

public class URLHelper {
	
	private static URLHelper instance;

	private String restUrl;
	
	public static URLHelper getInstance() {
		if(instance == null)
			instance = new URLHelper();
		
		return instance;
	}

	public URLHelper() {
		String envValue = System.getenv("CRISSERVICE_SRV_SERVICE_HOST");
		if(envValue == null) //not in Kubernetes with a visible CRISSERVICE
			restUrl = "http://localhost:8080/CRISSERVICE";
		else //In k8, DNS service resolution in Kubernetes
			restUrl = "http://crisservice-srv/CRISSERVICE";
	}
	
	public String getCrisURL() {
		return restUrl;
	}

	
	
}
