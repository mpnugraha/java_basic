package com.java.test.basic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JavaBasicB {


	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException  {

		String strIn1 = "Saya sedang Belajar Bahasa PemOgraman JAVA";
		String strOut1 = "";
		for (char ch : strIn1.toCharArray()) {
			if (Character.isUpperCase(ch)) {
				strOut1 = strOut1 + Character.toLowerCase(ch);
			} else {
				strOut1 = strOut1 + Character.toUpperCase(ch);
			}
		}
		
		System.out.println("Input data: " + strIn1);
		System.out.println("Output data: " + strOut1);
		System.out.println("");
		
		String strIn2 = "Saya sedang Belajar Bahasa PemOgraman JAVA";
		String strOut2 = "";
		for (char ch : strIn2.toCharArray()) {
			if (ch!='a' && ch != 'i' && ch != 'u' && ch != 'e' && ch != 'o' &&
					ch!='A' && ch != 'I' && ch != 'U' && ch != 'E' && ch != 'O' ) {
				strOut2 = strOut2 + ch;
			} 
		}
		
		System.out.println("Input data: " + strIn2);
		System.out.println("Output data: " + strOut2);
		System.out.println("");
		
		
		
		String strIn3 = "Developer PT. Global Tiket Network";
		String strOut3 = "";
		Map<Character, Integer> map1 = new HashMap<>();
		strIn3 = strIn3.replace(" ", "");
		for (char ch : strIn3.toCharArray()) {
			if (map1.containsKey(ch) ) {
				map1.put(ch, map1.get(ch)+1) ;
			} else {
				map1.put(ch, 1) ;
			}
		}
		
		for (char ch : strIn3.toCharArray()) {
			if (map1.containsKey(ch)) {
				strOut3 = strOut3 + ch;
				if (map1.get(ch) >1 ) {
					strOut3 = strOut3 + map1.get(ch);
				}
				map1.remove(ch);
			}			
		}
		
		System.out.println("Input data: " + strIn3);
		System.out.println("Output data: " + strOut3);
		System.out.println("");
				
		
		Path path = Paths.get("aaa.txt");
		Map<String, Integer> wordCount = Files.lines(path)
		           .flatMap(line -> Arrays.stream(line.trim().split(" ")))
		           .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
		           .filter(word -> word.length() > 0)
		           .map(word -> new SimpleEntry<>(word, 1))
		           .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
		            .reduce(new LinkedHashMap<>(), (acc, entry) -> {
		               acc.put(entry.getKey(), acc.compute(entry.getKey(), (k, v) -> v == null ? 1 : v + 1));
		               return acc;
		            }, (m1, m2) -> m1);
		 
		wordCount = sortByValue(wordCount);
		wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));
		    
		
	}
	
	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
	
	

}
