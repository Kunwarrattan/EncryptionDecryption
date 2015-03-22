package com.Encryption.pack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class StringFrequency {
	
	HashMap<Character, Float> PreMap = new HashMap<Character, Float>();
	HashMap<Character, Integer> SetMapCounter = new HashMap<Character, Integer>();
	HashMap<Character, Float> SetMapFrequency = new HashMap<Character, Float>();
	HashMap<Character, Character > TempSetMap = new HashMap<Character, Character>();
	String text = "pvskrlobsktnkprptprchzrovsjrkmtrpssukdpcnjsuiswshpvctxvpvshtlnsjcyisdkrkujcthfujsubbdnrxhtlnsjpvsjsrkubcpcyjsfthfuhzduhfcpvsjkpuprkprzubojcosjprskcyshxbrkvpseppvupluisrpmtrpssukdpcfspsjlrhsujsukchunbdxccfisdpvsyrjkpkpsorkpczubztbupspvsyjsmtshzdfrkpjrntprchcypvsbsppsjkrhpvszrovsjpseppvrkzchkrkpkcyzcthprhxvcqluhdprlsksuzvbsppsjuoosujkhuptjubshxbrkvpsepvukuwsjdfrkprhzpfrkpjrntprchpvupzuhnstksfvsbozjuzizcfsk";
	
	public StringFrequency() 
	{
		UpdateMap();
		counter();
		setField();
		int TotalCount = TotalCount(SetMapCounter);
		Frequency(TotalCount);
		Mapping();
	}
	

	private void Mapping() {
		
		
	}


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
		  
		printMap(SetMapFrequency);
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
		PreMap.put('z',(float) 0.00074);
		
		printMap(PreMap);
	}


	public static void main(String[] args) {
		StringFrequency st = new StringFrequency();

	}

}
