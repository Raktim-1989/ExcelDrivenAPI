package Framework.ExcelDrivenAPI;

import java.io.IOException;
import java.util.ArrayList;

public class TestCase {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DataDrivenTest obj = new DataDrivenTest();
		ArrayList<String> data = obj.getData("Add Profile");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));

	}

}
