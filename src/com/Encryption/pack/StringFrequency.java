package com.Encryption.pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class StringFrequency {
	
	HashMap<Character, Float> PreMap = new HashMap<Character, Float>();
	
	HashMap<Character, Integer> SetMapCounter = new HashMap<Character, Integer>();
    
	HashMap<Character, Float> SetMapFrequency = new HashMap<Character, Float>();
    
	HashMap<Character, Character > TempSetMap = new HashMap<Character, Character>();
	LinkedHashMap<Character, Float> sortedMap = null;
	LinkedHashMap<Character, Float> sortedMap1 = null;
	
	String text = "pvskrlobsktnkprptprchzrovsjrkmtrpssukdpcnjsuiswshpvctxvpvshtlnsjcyisdkrkujcthfujsubbdnrxhtlnsjpvsjsrkubcpcyjsfthfuhzduhfcpvsjkpuprkprzubojcosjprskcyshxbrkvpseppvupluisrpmtrpssukdpcfspsjlrhsujsukchunbdxccfisdpvsyrjkpkpsorkpczubztbupspvsyjsmtshzdfrkpjrntprchcypvsbsppsjkrhpvszrovsjpseppvrkzchkrkpkcyzcthprhxvcqluhdprlsksuzvbsppsjuoosujkhuptjubshxbrkvpsepvukuwsjdfrkprhzpfrkpjrntprchpvupzuhnstksfvsbozjuzizcfsk";
	
	public StringFrequency() 
	{
		UpdateMap();
		counter();
		setField();
		int TotalCount = TotalCount(SetMapCounter);
		Frequency(TotalCount);
		System.out.println("Unsort Map......");
		
		//printMap(SetMapFrequency);
 
		System.out.println("\nSorted String Map......");
		sortedMap = sortByComparator(SetMapFrequency);
		printMap(sortedMap);
		
		
		//printMap(PreMap);
		 
		System.out.println("\nSorted Pre Map......");
		sortedMap1 = sortByComparator(PreMap);
		printMap(sortedMap1);
		//i am bored of studying 
		
		ArrayList<Character> a = new ArrayList<Character>();
		ArrayList<Character> b = new ArrayList<Character>();
		
		System.out.println("---------------ssd-----------------------------------------");
		
		
		for(Character k : sortedMap.keySet()) { 
			a.add(k);
			System.out.println("Key="+k+" Value="+sortedMap.get(k)); 
		}
		for(Character k : sortedMap1.keySet()) {
			b.add(k);
			System.out.println("Key="+k+" Value="+sortedMap1.get(k)); 
		}
		
		for(int i=0; i < 26 ; i++){
			TempSetMap.put(a.get(i),b.get(i));
		}
		
		printMap(TempSetMap);
		
	}
	

	private void mapping() {
		
		
	}


	private  LinkedHashMap<Character, Float> sortByComparator(HashMap<Character, Float> setMapFrequency2) {
		 
		// Convert Map to List
		List<Map.Entry<Character, Float>> list = 
				new LinkedList<Map.Entry<Character, Float>>(setMapFrequency2.entrySet());
		
		
		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<Character, Float>>() {
			public int compare(Map.Entry<Character, Float> o1,
                                           Map.Entry<Character, Float> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
 
		// Convert sorted map back to a Map
		LinkedHashMap<Character, Float> sortedMap = new LinkedHashMap<Character, Float>();
		for (Iterator<Entry<Character, Float>> it = list.iterator(); it.hasNext();) {
			Entry<Character, Float> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
 
	/*public static void printMap(Map<String, Integer> map) {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("[Key] : " + entry.getKey() 
                                      + " [Value] : " + entry.getValue());
		}
	}*/
 


	private void setField() 
	{
		for(char i='a';i<='z';i++){
			if(!SetMapCounter.containsKey(i)){
				SetMapCounter.put(i, 0);
			}
		}
		
	}





	private void Frequency(int totalCount) {
		Iterator it = SetMapCounter.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        int k = (Integer) pair.getValue();
		        float local = (float)  k/totalCount;
		        SetMapFrequency.put((Character) pair.getKey(), local);
		     
		    }
		  
		//printMap(SetMapFrequency);
	}





	private void counter() {
		for (char ch : text.toCharArray()){
			if(SetMapCounter.containsKey(ch)){
				int k = SetMapCounter.get(ch)+1;
				SetMapCounter.put(ch, k);
			}else{
				SetMapCounter.put(ch, 1);
			}
	    }
	
		printMap(SetMapCounter);
		//printMap(SetMapCounter);
		
	}
	
	public int TotalCount(Map preMap2){
		Integer TotalCount = 0; 
		Iterator it = preMap2.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	       // System.out.println(pair.getKey() + " = " + pair.getValue());
	        TotalCount = TotalCount + (Integer) pair.getValue();
	        //System.out.println(TotalCount);
	       // it.remove(); // avoids a ConcurrentModificationException
	    }
	    
	    
	    return TotalCount;
	}
	
	public static void printMap(Map preMap2) {
	    Iterator it = preMap2.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        //it.remove(); // avoids a ConcurrentModificationException
	    }
	    System.out.println("-----------------------------------------------------------");
	}

	private void UpdateMap() {
		PreMap.put('z',(float) 0.00074);
		PreMap.put('e',(float) 0.12702);
		PreMap.put('t',(float) 0.09056);
		PreMap.put('a',(float) 0.08167);
		PreMap.put('o',(float) 0.07507);
		PreMap.put('i',(float) 0.06966);
		PreMap.put('n',(float) 0.06749);
		PreMap.put('s',(float) 0.06327);
		PreMap.put('h',(float) 0.06094);
		PreMap.put('r',(float) 0.05987);
		PreMap.put('d',(float) 0.04253);
		PreMap.put('l',(float) 0.04025);
		PreMap.put('c',(float) 0.02782);
		PreMap.put('u',(float) 0.02758);
		PreMap.put('m',(float) 0.02406);
		PreMap.put('w',(float) 0.0236);
		PreMap.put('f',(float) 0.02228);
		PreMap.put('g',(float) 0.02015);
		PreMap.put('y',(float) 0.01974);
		PreMap.put('p',(float) 0.01929);
		PreMap.put('b',(float) 0.01492);
		PreMap.put('v',(float) 0.00978);
		PreMap.put('k',(float) 0.00772);
		PreMap.put('j',(float) 0.00153);
		PreMap.put('x',(float) 0.0015);
		PreMap.put('q',(float) 0.00095);
		
		
		printMap(PreMap);
	}


	public static void main(String[] args) {
		StringFrequency st = new StringFrequency();

	}

}
