package resources;
public enum APIResources {
	currencyListAPI("api/system/currency/list"),
	flightList("api/cms/page");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
