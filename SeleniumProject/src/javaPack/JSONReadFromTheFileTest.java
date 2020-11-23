package javaPack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReadFromTheFileTest {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try{
			Object obj = parser.parse(new FileReader("./src/com/project/testdata/course.json"));
			JSONObject jsonObject = (JSONObject)obj;
			String name = (String)jsonObject.get("Name");
			String course = (String)jsonObject.get("Course");
			JSONArray subjects = (JSONArray)jsonObject.get("Subjects");
			System.out.println("Name: " + name);
			System.out.println("Course: " + course);
			System.out.println("Subjects:");
			Iterator iterator = subjects.iterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
