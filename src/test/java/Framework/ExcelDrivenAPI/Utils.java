package Framework.ExcelDrivenAPI;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utils {
	
	public static String getJsonPath(Response response, String key)
	{
		String resPath = response.asString();
		JsonPath js = new JsonPath(resPath);
		return js.get(key).toString();
		
	}

}
