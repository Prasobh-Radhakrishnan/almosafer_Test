package resources;
import pojo.flightPayload;

public class TestDataBuild {

	public flightPayload flightPayload (String country){
		flightPayload fp = new flightPayload();
		fp.setCountry(country);
		fp.setLocale("en_us");
		fp.setMedia("mobile");
		fp.setTemplate("top-airports-v2.json");
		return fp;
	}
}
