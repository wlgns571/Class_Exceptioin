package java_day23.api;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import kjh.UtilKJH;

public class ApiJson {
	public static void main(String[] args) throws ParseException{
		// .jar 파일을 프로젝트 안에 넣기
		// 프로젝트 마우스 우클릭 - Build Path - add External Archives...
		// 혹은 프로젝트 마우스 우클릭 - Properties - Java Build Path - library 탭 - add External Archives...
		
		// 우리 프로젝트를 .jar 파일로 만들어
		// 라이브러리로 사용할 수 있도록 해보기
		// 프로젝트 우클릭 - Export - .jar file
		System.out.println(UtilKJH.makeUniqueId());
		
		// JSON 객체 만들기
		JSONObject jsonObject = new JSONObject();
		
		// JSON 데이터는 이름과 값의 쌍으로 구성이 된다.
		// Key와 Value쌍으로 구성되는 HashMap과 유사하다.
		// HashMap<String, Object> 라고 봐도 무방하다.
		jsonObject.put("name", "아이유");
		jsonObject.put("age", 30);
		
		// JSONArray 배열
		JSONArray jsonArray = new JSONArray();
		jsonArray.add("좋은날");
		jsonArray.add("밤편지");
		jsonArray.add("무릎");
		jsonArray.add("마시멜로우");
		jsonArray.add("몰라요");
		jsonArray.add("이런 엔딩");
		
		jsonObject.put("SongList", jsonArray);
		
		System.out.println(jsonObject);
		System.out.println(jsonObject.toString());
		System.out.println(jsonObject.toJSONString());
		
		System.out.println("\n================================\n");
		
		// JSON 객체 만드는 두번째 방법
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("이름", "태연");
		hashMap.put("나이", 33);
		
		ArrayList<String> SongList = new ArrayList<String>();
		SongList.add("만약에");
		SongList.add("INVU");
		SongList.add("I");
		SongList.add("Fine");
		
		hashMap.put("음악들", SongList);
		
		// HashMap을 JSONObject로 만들기
		JSONObject taeyeon = new JSONObject(hashMap);
		System.out.println(taeyeon.toJSONString());
		
		// JSON 객체 안에 JSON 객체도 당연히 들어간다.
		jsonObject.put("taeyeon", taeyeon);
		System.out.println(jsonObject.toJSONString());
		
		System.out.println("\n================================\n");
		
		// JSON 파싱 (= 키를 이용해서 값 꺼내보기)
		JSONParser jsonParser = new JSONParser();
		
		String temp ="{\"taeyeon\":{\"이름\":\"태연\",\"나이\":33,\"음악들\":[\"만약에\",\"INVU\",\"I\",\"Fine\"]},\"name\":\"아이유\",\"songList\":[\"좋은날\",\"밤편지\",\"무릎\",\"마시멜로우\",\"몰라요\",\"이런 엔딩\"],\"age\":30}";
		
		JSONObject iuJson = (JSONObject)jsonParser.parse(temp);
		
		// 아이유 꺼내보기 
		// JSONObject에서 get()을 하면 Object로 리턴을 해서
		// 변수에 담을 때 형변환을 해주어야 한다.
		System.out.println(iuJson.get("name"));
		String name = (String) iuJson.get("name");
		
		// JSONString에서 JSONObject로 파싱한 경우 숫자는 long 타입이다.
		long age = (long) iuJson.get("age");
		System.out.println(age);
		
		JSONArray songs = (JSONArray) iuJson.get("songList");
		for (int i = 0; i < songs.size(); i++) {
			System.out.println(songs.get(i));
		}
		
		JSONObject tyJson = (JSONObject) iuJson.get("taeyeon");
		
		String tyName = (String) tyJson.get("이름");
		System.out.println(tyName);
		
		long tyAge = (long)	tyJson.get("나이");
		System.out.println(tyAge);
		
		JSONArray tySongs = (JSONArray)tyJson.get("음악들");
		for (int i = 0; i < tySongs.size(); i++) {
			System.out.println(tySongs.get(i));
		}
		
		
	}
}
