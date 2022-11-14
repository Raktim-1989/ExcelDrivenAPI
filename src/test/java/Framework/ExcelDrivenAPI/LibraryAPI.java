package Framework.ExcelDrivenAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

public class LibraryAPI {

	@Test
	public void addBookAPI() throws IOException {

		DataDrivenTest d = new DataDrivenTest();
		ArrayList<String> list = d.getData("RestAddBook");
		
		HashMap<String, Object>  map = new HashMap<String, Object>();
		map.put("name", list.get(1));
		map.put("isbn", list.get(2));
		map.put("aisle",list.get(3) );
		map.put("author", list.get(4));
				
		RestAssured.baseURI = "http://216.10.245.166";

		Response res = given().header("Content-Type", "application/json").body(map)
				.when().post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response();

		String id = Utils.getJsonPath(res, "ID");
		System.out.println(id);

	}
}
