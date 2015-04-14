	/*
		 * 1. PreMap
		 * 2. Calculate Map
		 * 3. Calculate Frequency
		 * 4. Sort and Map (Create day type [PreMap, newMap])
		 * 5. replace Character.
		 * 6. Calculate Bi-gram
		 * 7. Load Predefined Bi-gram
		 * 8. calculate Frequency
		 * 9. Subtract Bi-grams.
		 * 10. Calculate score
		 * 
		 * 
		 * */

package com.Encryption.pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class EncrytionDecryption {
	
	String text = "pvskrlobsktnkprptprchzrovsjrkmtrpssukdpcnjsuiswshpvctxvpvshtlnsjcyisdkrkujcthfujsubbdnrxhtlnsjpvsjsrkubcpcyjsfthfuhzduhfcpvsjkpuprkprzubojcosjprskcyshxbrkvpseppvupluisrpmtrpssukdpcfspsjlrhsujsukchunbdxccfisdpvsyrjkpkpsorkpczubztbupspvsyjsmtshzdfrkpjrntprchcypvsbsppsjkrhpvszrovsjpseppvrkzchkrkpkcyzcthprhxvcqluhdprlsksuzvbsppsjuoosujkhuptjubshxbrkvpsepvukuwsjdfrkprhzpfrkpjrntprchpvupzuhnstksfvsbozjuzizcfsk";
	
	String NewText = null;
	StringBuilder str = null;
	String kText = "";
	String Mtext = "";
	char[][] beforeSwap = new char[26][26];
	float previousScore = 0;
	float currentScore = 0;
	
	HashMap<Character, Float> PreMap = new HashMap<Character, Float>();				
	HashMap<Character, Integer> SetMapCounter = new HashMap<Character, Integer>();
	HashMap<Character, Float> SetMapFrequency = new HashMap<Character, Float>();
	
	LoadDataIntoMap l1 = new LoadDataIntoMap();
	
	LinkedHashMap<Character, Float> sortedMap = null;
	LinkedHashMap<Character, Float> sortedMap1 = null;
	
	HashMap<Character, Character > TempSetMap = new HashMap<Character, Character>();
	HashMap<Character, Character > NewCalculatedTempSetMap = new HashMap<Character, Character>();
	
	HashMap<String, Float> PreBioMoni  = new HashMap<String, Float>();
	HashMap<String, Integer> BioMoni  = new HashMap<String, Integer>();
	HashMap<String, Float> BioMoniFrequncy  = new HashMap<String, Float>();
	
	
	
	public EncrytionDecryption(){
		
		PreMap = l1.UpdateMap(PreMap);
		
		counter();
		setField();
		int TotalCount = TotalCount(SetMapCounter);
		Frequency(TotalCount);
		
		sortedMap = sortByComparator(SetMapFrequency);
		sortedMap1 = sortByComparator(PreMap);
		
		ArrayList<Character> a = new ArrayList<Character>();
		ArrayList<Character> b = new ArrayList<Character>();
		
		for(Character k : sortedMap.keySet()) { 
			a.add(k);
		}
		for(Character k : sortedMap1.keySet()) {
			b.add(k);
		}
		
		for(int i=0; i < 26 ; i++){
			TempSetMap.put(a.get(i),b.get(i));
		}
		
//		System.out.println("----------------");
//		System.out.println("Mapped Alphabets");
//		System.out.println("----------------");
	//	printMap(TempSetMap);
	//	System.out.println(text);
		mapping();
		PreBioMoni = l1.UpdateMapR(PreBioMoni);
		countBio(kText);
		int TotalCountNew = TotalCount(BioMoni);
	//	System.out.println(TotalCountNew);
		countBioFrequency(TotalCountNew);
		  
	//    System.out.println("-----------------");
	   // float score = 0;
	    previousScore =  finalScore();
	   // System.out.println("Score: " + finalScore());
	//    System.out.println("-----------------");
		
	    keyswap();
	  
		
	}
	//----------------------------------------------------------------------------
	private float CalculateScore(){
		//System.out.println(text);
		//MappingSwap(NewCalculatedTempSetMap);
		BioMoni.clear();
	//	System.out.println("=="+BioMoni.size());
		BioMoniFrequncy.clear();
		
		countBio(Mtext);
		
		int TotalCountNew1 = 0;
		
		TotalCountNew1 = TotalCount(BioMoni);
		
		System.out.println(BioMoni);
		
		System.out.println(TotalCountNew1);
		countBioFrequency(TotalCountNew1);
		  
	    //System.out.println("-----------------");
	    currentScore = finalScore();
	    //System.out.println("Score: " + finalScore());
	   // System.out.println("-----------------");
	    return currentScore;
	}
	//----------------------------------------------------------------------------
//	private void MappingSwap(
//			HashMap<Character, Character> newCalculatedTempSetMap2) {
//		for (char ch : text.toCharArray()){
//			Character c = NewCalculatedTempSetMap.get(ch);
//			
//			Mtext = Mtext+c;
//	    }
//		System.out.println("---kin--"+Mtext);
//		
//	}
	//----------------------------------------------------------------------------
	private void keyswap() {
		
		@SuppressWarnings("rawtypes")
		Iterator s = TempSetMap.entrySet().iterator();
		int k = TempSetMap.size();
		//System.out.println(k);
		int temp,m=0,j;
		while(s.hasNext()){
		    Map.Entry pair = (Map.Entry)s.next();
		    Character left = (Character) pair.getKey();
		    //System.out.println(left);
		    for(j=0 ; j < 1 ; j++){
		    	beforeSwap[m][j] = left;
		    	beforeSwap[m][j+1] = (Character) pair.getValue();
		    }
		    m++;
		}
		
		int p=0;
		int x = 0;
		int u = 0;
		int z= 0;
		while(u<26){
			System.out.println("Interval = " + u);
			x=0;
			for(int i=0;i<=26;i++){
				
				if(x<beforeSwap.length-1 && x <=25){
					NewCalculatedTempSetMap.clear();
					
					if(i<25 && (i+u) < 25){
					    char tempVar = beforeSwap[i][p];
						beforeSwap[i][p] = beforeSwap[i+u][p];
						beforeSwap[i+u][p] = tempVar;
					}
					
					int b = 0;
					for(int h=0;h<=25;h++){
						NewCalculatedTempSetMap.put(beforeSwap[h][p], beforeSwap[h][p+1]);
					}
					printMap(NewCalculatedTempSetMap);
					Mtext = "";
					for (char ch : text.toCharArray()){
						Character c = NewCalculatedTempSetMap.get(ch);
						
						Mtext = Mtext+c;
				    }
					System.out.println(Mtext);
					
					currentScore = CalculateScore();
					System.out.println(i);
					if(currentScore<previousScore){
						System.out.println("currentScore = "+currentScore);
						System.out.println("previousScore = "+previousScore);
						previousScore = currentScore;
						TempSetMap  = NewCalculatedTempSetMap;
						i=0;
					}
					else{
						System.out.println("currentScore = "+currentScore);
						System.out.println("previousScore = "+previousScore);
					}
				}else{}
				x++;
				
			}
		// z=z+1;
		 
		 u=u+1;
		}
	}

	//----------------------------------------------------------------------------
	private float finalScore() {
		float score = 0;
		Iterator it = BioMoniFrequncy.entrySet().iterator();
//		System.out.println("-------------------------------------------------------------");
//        System.out.println("Difference of Predefined and Calculated frequencies for Pairs");
//        System.out.println("-------------------------------------------------------------");
		while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Float main  = (Float) pair.getValue();
	        Float sub = ((Float)PreBioMoni.get(pair.getKey()));
	        if(sub != 0){
	        float subtract = Math.abs(main - sub);
	        score+= subtract;
	       // System.out.println(""+""+subtract);
	        }
	    }
	 System.out.println(" "+score);
		return score;
	}


	//---------------------------------------------------------------------------------------------------
	private void counter() {
		for (char ch : text.toCharArray()){
			if(SetMapCounter.containsKey(ch)){
				int k = SetMapCounter.get(ch)+1;
				SetMapCounter.put(ch, k);
			}else{
				SetMapCounter.put(ch, 1);
			}
		}
	}
	
	//---------------------------------------------------------------------------------------------------
	private void setField() 
	{
		for(char i='a';i<='z';i++){
			if(!SetMapCounter.containsKey(i)){
				SetMapCounter.put(i, 0);
			}
		}
		
	}
	
	//---------------------------------------------------------------------------------------------------
	public int TotalCount(Map preMap2){
		Integer TotalCount = 0; 
		Iterator it = preMap2.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        TotalCount = TotalCount + (Integer) pair.getValue();
	    }
	    System.out.println("TotalCount  == "  + TotalCount);
	    return TotalCount;
	}
	//---------------------------------------------------------------------------------------------------
	private void Frequency(int totalCount) {
		Iterator it = SetMapCounter.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        int k = (Integer) pair.getValue();
		        float local = (float)  k/totalCount;
		        SetMapFrequency.put((Character) pair.getKey(), local);
		     
		    }
	}
	
	//---------------------------------------------------------------------------------------------------	
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
	
	//---------------------------------------------------------------------------------------------------
	private void mapping() {
		
		for (char ch : text.toCharArray()){
			Character c = TempSetMap.get(ch);
			//System.out.print(""+c);
			kText = kText+c;
	    }
		//System.out.println("main="+kText);
	}
	
	
	//---------------------------------------------------------------------------------------------------
	private void countBio(String text){
		
		int i=0;
		int j=0;
		
		String str = null;
		
		char[] ch = text.toCharArray();
		char[] test  = new char[2];
		
		while(i!=text.length()){
			if(j==2){
				String text1 = String.valueOf(test);
				if(BioMoni.containsKey(text1.toUpperCase())){
					//String text1 = String.valueOf(test);
					int k = BioMoni.get(text1.toUpperCase())+1;
					BioMoni.put(text1.toUpperCase(), k);
				
				}else{
					//String text1 = String.valueOf(test);
					BioMoni.put(text1.toUpperCase(), 1);
				}
				
				i--;
				j = 0;
			
			}else{
				test[j] = ch[i];
				j++;
			}
			
			i++;
		}
		
//		System.out.println("-----------------------------------------------");
//		System.out.println("Occurance Count for pairs in the encrypted text");
//		System.out.println("-----------------------------------------------");
	//	printMap(BioMoni);
	}
	
	
	//---------------------------------------------------------------------------------------------------
	private void countBioFrequency(int totalCountNew) {
		Iterator it = BioMoni.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        int k = (Integer) pair.getValue();
	        float local = (float)  k/totalCountNew;
	        BioMoniFrequncy.put( (String)pair.getKey(), local);
	        
	    }
	  
//	    System.out.println("--------------------------------");
//	    System.out.println("Calculated frequencies for Pairs");
//	    System.out.println("--------------------------------");
	   // printMap(BioMoniFrequncy);
		
	}
	
	//---------------------------------------------------------------------------------------------------
	public static void printMap(Map preMap2) {
	    Iterator it = preMap2.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	      //  System.out.println(pair.getKey() + " = " + pair.getValue());
	        //it.remove(); // avoids a ConcurrentModificationException
	    }
	   // System.out.println("***************************************************");
	  
	}
	
	public static void main(String[] args) {
		EncrytionDecryption k1 = new EncrytionDecryption();
		
	}
	


}
