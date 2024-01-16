package utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParamsConverter {
	
	public static Map<String, String> convertParamsMapToMap(Map<String , String[]> paramsMap) {
		Map<String, String> map = new HashMap<>();
		
		paramsMap.forEach((k,v) -> {
			// name = [ 0,1,0,9,9,8,8,....] / k: name v: 배열값
			StringBuilder builder = new StringBuilder();
			// StringBuilder : 비어있는 문자열을 담을 수 있는 공간을 만들어줌. 
			
			Arrays.asList(v).forEach(value -> builder.append(value));
//			배열을 넣어줌 : StringList가 됨. // value에 들어간 값을 하나씩 출력 
			map.put(k,builder.toString());
	});
		
		return map;
	}
		

}
