package edu.gqq.algorithms;

import java.util.ArrayList;
import java.util.List;

public class SeqAndDeseq {
	
//	char[] specfics = {',', ' '};
	
	public static String encode(List<String> strings) {
		if (strings.size() == 0) {
			return "";
		}
		StringBuilder sBuilder = new StringBuilder();
		for (String string : strings) {
			sBuilder.append(processSpecific(string));
			sBuilder.append(",");
		}
//		sBuilder.setLength(sBuilder.length() - 1);
		return sBuilder.toString();
	}

	private static String processSpecific(String str) {
		str = str.replaceAll("\\", "\\\\");
		str = str.replaceAll(",", "\\,");
		return str;
	}
	
	public static List<String> decode(String str) {
		List<String> strings = new ArrayList<>();
		if (str.isEmpty()) {
			return strings;
		}
		
		StringBuilder sBuilder = new StringBuilder();
		int i = 0;
		while (i < str.length()) {
			if (str.charAt(i) == '\\') {
				if (str.charAt(i+1) == '\\') {
					sBuilder.append('\\');
				} else {
					sBuilder.append(",");
				}
				i += 2;
			} else if (str.charAt(i) == ',') {
				strings.add(sBuilder.toString());
				sBuilder.setLength(0);
			} else {
				sBuilder.append(str.charAt(i));
			}
		}
		return strings;
	}
	
	
}
