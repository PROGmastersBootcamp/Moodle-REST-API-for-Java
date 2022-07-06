package es.ubu.lsi.moodlerestapi.webservice.webservices;

import org.json.JSONObject;

public abstract class WSFunctionAbstract implements WSFunction {
	
	private WSFunctionEnum webserviceFunctions;
	protected JSONObject parameters;
	
	public WSFunctionAbstract(WSFunctionEnum webserviceFunctions) {
		this.webserviceFunctions = webserviceFunctions;
		parameters = new JSONObject();
	}
	
	@Override
	public WSFunctionEnum getWSFunction() {
		return webserviceFunctions;
	}

	@Override
	public JSONObject getParameters() {
		return parameters;
	}	
	
	@Override
	public String toString() {
		return webserviceFunctions.toString();
	}
	
	@Override
	public void addToMapParemeters() {
		//default do nothing
	}

	public void putIfNotNull(String key, Object value) {
		if (value != null) {
			parameters.put(key, value);
		}
	}

}
