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
	
	HashMap<String, Float> PreBioMoni  = new HashMap<String, Float>();
	HashMap<String, Integer> BioMoni  = new HashMap<String, Integer>();
	HashMap<String, Float> BioMoniFrequncy  = new HashMap<String, Float>();
	
	String text = "pvskrlobsktnkprptprchzrovsjrkmtrpssukdpcnjsuiswshpvctxvpvshtlnsjcyisdkrkujcthfujsubbdnrxhtlnsjpvsjsrkubcpcyjsfthfuhzduhfcpvsjkpuprkprzubojcosjprskcyshxbrkvpseppvupluisrpmtrpssukdpcfspsjlrhsujsukchunbdxccfisdpvsyrjkpkpsorkpczubztbupspvsyjsmtshzdfrkpjrntprchcypvsbsppsjkrhpvszrovsjpseppvrkzchkrkpkcyzcthprhxvcqluhdprlsksuzvbsppsjuoosujkhuptjubshxbrkvpsepvukuwsjdfrkprhzpfrkpjrntprchpvupzuhnstksfvsbozjuzizcfsk";
	StringBuilder str = null;
	public StringFrequency() {
		UpdateMap();
		counter();
		setField();
		int TotalCount = TotalCount(SetMapCounter);
		Frequency(TotalCount);
		System.out.println("Unsort Map......");
		
		//printMap(SetMapFrequency);
 
		System.out.println("\nSorted String Map......");
		sortedMap = sortByComparator(SetMapFrequency);
		//printMap(sortedMap);
		
		
		//printMap(PreMap);
		 
		//System.out.println("\nSorted Pre Map......");
		sortedMap1 = sortByComparator(PreMap);
		//printMap(sortedMap1);
		//i am bored of studying 
		
		ArrayList<Character> a = new ArrayList<Character>();
		ArrayList<Character> b = new ArrayList<Character>();
		
		//System.out.println("---------------ssd-----------------------------------------");
		
		
		for(Character k : sortedMap.keySet()) { 
			b.add(k);
			//System.out.println("Key="+k+" Value="+sortedMap.get(k)); 
		}
		for(Character k : sortedMap1.keySet()) {
			a.add(k);
			//System.out.println("Key="+k+" Value="+sortedMap1.get(k)); 
		}
		
		for(int i=0; i < 26 ; i++){
			TempSetMap.put(a.get(i),b.get(i));
		}
		
		//printMap(TempSetMap);
		
		mapping();
		countBio();
		int TotalCountNew = TotalCount(BioMoni);
		System.out.println(TotalCountNew);
		countBioFrequency(TotalCountNew);
		UpdateMapR();
		
		Iterator it = BioMoniFrequncy.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        float main  = (float) pair.getValue();
	        float sub = ((float)PreBioMoni.get(pair.getKey()));
	        float subtract = main - sub;
	        System.out.println(subtract);
	    }
		
		
	}
	

	private void countBioFrequency(int totalCountNew) {
		Iterator it = BioMoni.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        int k = (Integer) pair.getValue();
	        float local = (float)  k/totalCountNew;
	        BioMoniFrequncy.put( (String)pair.getKey(), local);
	     
	    }
	  
	    printMap(BioMoniFrequncy);
		
	}


	private void mapping() {
		
		System.out.println(text);
		for (char ch : text.toCharArray()){
			Character c = TempSetMap.get(ch);
			
			System.out.print(c	);
	    }
		
		System.out.println(str);
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
	
	
	private void countBio(){
		
		int i=0;
		int j=0;
		
		String str = null;
		
		char[] ch = text.toCharArray();
		
		char[] test  = new char[2];
		
		while(i!=text.length()){
		
			if(j==2){
				String text1 = String.valueOf(test);
				if(BioMoni.containsKey(text1)){
					//String text1 = String.valueOf(test);
					int k = BioMoni.get(text1)+1;
					BioMoni.put(text1, k);
				
				}else{
					//String text1 = String.valueOf(test);
					BioMoni.put(text1, 1);
				}
				
				i--;
				j = 0;
			
			}else{
				test[j] = ch[i];
				j++;
			}
			
			i++;
		}
		
		printMap(BioMoni);
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
		
		
		//printMap(PreMap);
	}
	
	private void UpdateMapR(){
		PreBioMoni.put("TH",(float)0.02705698);
		PreBioMoni.put("HE",(float)0.02328545);
		PreBioMoni.put("IN",(float)0.020275534);
		PreBioMoni.put("ER",(float)0.017838136);
		PreBioMoni.put("AN",(float)0.016136243);
		PreBioMoni.put("RE",(float)0.014089222);
		PreBioMoni.put("ES",(float)0.013198142);
		PreBioMoni.put("ON",(float)0.01316225);
		PreBioMoni.put("ST",(float)0.012492322);
		PreBioMoni.put("NT",(float)0.011725158);
		PreBioMoni.put("EN",(float)0.011329747);
		PreBioMoni.put("AT",(float)0.011164);
		PreBioMoni.put("ED",(float)0.010787831);
		PreBioMoni.put("ND",(float)0.010682918);
		PreBioMoni.put("TO",(float)0.010664622);
		PreBioMoni.put("OR",(float)0.010574431);
		PreBioMoni.put("EA",(float)0.010020474);
		PreBioMoni.put("TI",(float)0.009918455);
		PreBioMoni.put("AR",(float)0.009794637);
		PreBioMoni.put("TE",(float)0.009781351);
		PreBioMoni.put("NG",(float)0.008919108);
		PreBioMoni.put("AL",(float)0.00883683);
		PreBioMoni.put("IT",(float)0.008773685);
		PreBioMoni.put("AS",(float)0.008735606);
		PreBioMoni.put("IS",(float)0.008637575);
		PreBioMoni.put("HA",(float)0.008318866);
		PreBioMoni.put("ET",(float)0.007602123);
		PreBioMoni.put("SE",(float)0.007292169);
		PreBioMoni.put("OU",(float)0.007195042);
		PreBioMoni.put("OF",(float)0.007062905);
		PreBioMoni.put("LE",(float)0.007026448);
		PreBioMoni.put("SA",(float)0.006956346);
		PreBioMoni.put("VE",(float)0.006780783);
		PreBioMoni.put("RO",(float)0.006759923);
		PreBioMoni.put("RA",(float)0.006624591);
		PreBioMoni.put("RI",(float)0.006390801);
		PreBioMoni.put("HI",(float)0.006358587);
		PreBioMoni.put("NE",(float)0.006320737);
		PreBioMoni.put("ME",(float)0.006299012);
		PreBioMoni.put("DE",(float)0.006250933);
		PreBioMoni.put("CO",(float)0.006183235);
		PreBioMoni.put("TA",(float)0.006046906);
		PreBioMoni.put("EC",(float)0.005960924);
		PreBioMoni.put("SI",(float)0.005957003);
		PreBioMoni.put("LL",(float)0.005697536);
		PreBioMoni.put("SO",(float)0.005527966);
		PreBioMoni.put("NA",(float)0.005445612);
		PreBioMoni.put("LI",(float)0.005386327);
		PreBioMoni.put("LA",(float)0.005360229);
		PreBioMoni.put("EL",(float)0.005340325);
		PreBioMoni.put("MA",(float)0.005048042);
		PreBioMoni.put("DI",(float)0.00501234);
		PreBioMoni.put("IC",(float)0.004964796);
		PreBioMoni.put("RT",(float)0.004961939);
		PreBioMoni.put("NS",(float)0.004927334);
		PreBioMoni.put("RS",(float)0.004911339);
		PreBioMoni.put("IO",(float)0.004905072);
		PreBioMoni.put("OM",(float)0.00487177);
		PreBioMoni.put("CH",(float)0.00465591);
		PreBioMoni.put("OT",(float)0.004645572);
		PreBioMoni.put("CA",(float)0.004609196);
		PreBioMoni.put("CE",(float)0.004579795);
		PreBioMoni.put("HO",(float)0.004562545);
		PreBioMoni.put("BE",(float)0.004502293);
		PreBioMoni.put("TT",(float)0.004478931);
		PreBioMoni.put("FO",(float)0.004376321);
		PreBioMoni.put("TS",(float)0.004376032);
		PreBioMoni.put("SS",(float)0.004374453);
		PreBioMoni.put("NO",(float)0.004369462);
		PreBioMoni.put("EE",(float)0.004277843);
		PreBioMoni.put("EM",(float)0.00419629);
		PreBioMoni.put("AC",(float)0.004140646);
		PreBioMoni.put("IL",(float)0.004134383);
		PreBioMoni.put("DA",(float)0.004066497);
		PreBioMoni.put("NI",(float)0.004035982);
		PreBioMoni.put("UR",(float)0.004010454);
		PreBioMoni.put("WA",(float)0.003894148);
		PreBioMoni.put("SH",(float)0.003878962);
		PreBioMoni.put("EI",(float)0.003706392);
		PreBioMoni.put("AM",(float)0.003694613);
		PreBioMoni.put("TR",(float)0.003658825);
		PreBioMoni.put("DT",(float)0.00364459);
		PreBioMoni.put("US",(float)0.00363064);
		PreBioMoni.put("LO",(float)0.003606811);
		PreBioMoni.put("PE",(float)0.003601493);
		PreBioMoni.put("UN",(float)0.003523878);
		PreBioMoni.put("NC",(float)0.003518541);
		PreBioMoni.put("WI",(float)0.00351817);
		PreBioMoni.put("UT",(float)0.003500629);
		PreBioMoni.put("AD",(float)0.003440517);
		PreBioMoni.put("EW",(float)0.003417199);
		PreBioMoni.put("OW",(float)0.003378815);
		PreBioMoni.put("GE",(float)0.003335938);
		PreBioMoni.put("EP",(float)0.003243284);
		PreBioMoni.put("AI",(float)0.003231847);
		PreBioMoni.put("LY",(float)0.003177989);
		PreBioMoni.put("OL",(float)0.003174395);
		PreBioMoni.put("FT",(float)0.003167362);
		PreBioMoni.put("OS",(float)0.003144279);
		PreBioMoni.put("EO",(float)0.00312761);
		PreBioMoni.put("EF",(float)0.003064717);
		PreBioMoni.put("PR",(float)0.003050599);
		PreBioMoni.put("WE",(float)0.003049197);
		PreBioMoni.put("DO",(float)0.003034212);
		PreBioMoni.put("MO",(float)0.002995001);
		PreBioMoni.put("ID",(float)0.002982517);
		PreBioMoni.put("IE",(float)0.002892039);
		PreBioMoni.put("MI",(float)0.002814196);
		PreBioMoni.put("PA",(float)0.002791016);
		PreBioMoni.put("FI",(float)0.0027737);
		PreBioMoni.put("PO",(float)0.002756055);
		PreBioMoni.put("CT",(float)0.002749399);
		PreBioMoni.put("WH",(float)0.00274111);
		PreBioMoni.put("IR",(float)0.002701436);
		PreBioMoni.put("AY",(float)0.002664911);
		PreBioMoni.put("GA",(float)0.002599319);
		PreBioMoni.put("SC",(float)0.002497761);
		PreBioMoni.put("KE",(float)0.002463079);
		PreBioMoni.put("EV",(float)0.002445351);
		PreBioMoni.put("SP",(float)0.002444568);
		PreBioMoni.put("IM",(float)0.002438508);
		PreBioMoni.put("OP",(float)0.002418859);
		PreBioMoni.put("DS",(float)0.002412021);
		PreBioMoni.put("LD",(float)0.002369398);
		PreBioMoni.put("UL",(float)0.002352721);
		PreBioMoni.put("OO",(float)0.002351655);
		PreBioMoni.put("SU",(float)0.002319775);
		PreBioMoni.put("IA",(float)0.00231307);
		PreBioMoni.put("GH",(float)0.002284946);
		PreBioMoni.put("PL",(float)0.00226918);
		PreBioMoni.put("EB",(float)0.002252199);
		PreBioMoni.put("IG",(float)0.002204045);
		PreBioMoni.put("VI",(float)0.002169232);
		PreBioMoni.put("IV",(float)0.002111231);
		PreBioMoni.put("WO",(float)0.002106008);
		PreBioMoni.put("YO",(float)0.00210181);
		PreBioMoni.put("RD",(float)0.002087273);
		PreBioMoni.put("TW",(float)0.00206059);
		PreBioMoni.put("BA",(float)0.002050694);
		PreBioMoni.put("AG",(float)0.002037235);
		PreBioMoni.put("RY",(float)0.002032442);
		PreBioMoni.put("AB",(float)0.002029446);
		PreBioMoni.put("LS",(float)0.002006289);
		PreBioMoni.put("SW",(float)0.002005776);
		PreBioMoni.put("AP",(float)0.001978182);
		PreBioMoni.put("FE",(float)0.001972488);
		PreBioMoni.put("TU",(float)0.00196051);
		PreBioMoni.put("CI",(float)0.001953246);
		PreBioMoni.put("FA",(float)0.001932859);
		PreBioMoni.put("HT",(float)0.001931384);
		PreBioMoni.put("FR",(float)0.001928568);
		PreBioMoni.put("AV",(float)0.001916892);
		PreBioMoni.put("EG",(float)0.001916332);
		PreBioMoni.put("GO",(float)0.001893725);
		PreBioMoni.put("BO",(float)0.001889952);
		PreBioMoni.put("BU",(float)0.001876279);
		PreBioMoni.put("TY",(float)0.001852146);
		PreBioMoni.put("MP",(float)0.001811966);
		PreBioMoni.put("OC",(float)0.001768438);
		PreBioMoni.put("OD",(float)0.001759942);
		PreBioMoni.put("EH",(float)0.001748131);
		PreBioMoni.put("YS",(float)0.001743617);
		PreBioMoni.put("EY",(float)0.001741008);
		PreBioMoni.put("RM",(float)0.001706237);
		PreBioMoni.put("OV",(float)0.001699768);
		PreBioMoni.put("GT",(float)0.0016993);
		PreBioMoni.put("YA",(float)0.001674222);
		PreBioMoni.put("CK",(float)0.001666253);
		PreBioMoni.put("GI",(float)0.001642676);
		PreBioMoni.put("RN",(float)0.001633771);
		PreBioMoni.put("GR",(float)0.001616502);
		PreBioMoni.put("RC",(float)0.001612825);
		PreBioMoni.put("BL",(float)0.001605189);
		PreBioMoni.put("LT",(float)0.001576566);
		PreBioMoni.put("YT",(float)0.001552718);
		PreBioMoni.put("OA",(float)0.001515732);
		PreBioMoni.put("YE",(float)0.001503033);
		PreBioMoni.put("OB",(float)0.001436709);
		PreBioMoni.put("DB",(float)0.001412243);
		PreBioMoni.put("FF",(float)0.00140734);
		PreBioMoni.put("SF",(float)0.001404675);
		PreBioMoni.put("RR",(float)0.001363561);
		PreBioMoni.put("DU",(float)0.00135549);
		PreBioMoni.put("KI",(float)0.001344631);
		PreBioMoni.put("UC",(float)0.001327987);
		PreBioMoni.put("IF",(float)0.001327531);
		PreBioMoni.put("AF",(float)0.001318779);
		PreBioMoni.put("DR",(float)0.001318619);
		PreBioMoni.put("CL",(float)0.001314301);
		PreBioMoni.put("EX",(float)0.001306475);
		PreBioMoni.put("SM",(float)0.001290608);
		PreBioMoni.put("PI",(float)0.001285626);
		PreBioMoni.put("SB",(float)0.001284348);
		PreBioMoni.put("CR",(float)0.001275251);
		PreBioMoni.put("TL",(float)0.001249532);
		PreBioMoni.put("OI",(float)0.001234149);
		PreBioMoni.put("RU",(float)0.001232747);
		PreBioMoni.put("UP",(float)0.001227287);
		PreBioMoni.put("BY",(float)0.001209972);
		PreBioMoni.put("TC",(float)0.001201819);
		PreBioMoni.put("NN",(float)0.001198137);
		PreBioMoni.put("AK",(float)0.001188057);
		PreBioMoni.put("SL",(float)0.001148211);
		PreBioMoni.put("NF",(float)0.001144817);
		PreBioMoni.put("UE",(float)0.001139614);
		PreBioMoni.put("DW",(float)0.001134752);
		PreBioMoni.put("AU",(float)0.001129515);
		PreBioMoni.put("PP",(float)0.001127023);
		PreBioMoni.put("UG",(float)0.001117526);
		PreBioMoni.put("RL",(float)0.001110801);
		PreBioMoni.put("RG",(float)0.001074422);
		PreBioMoni.put("BR",(float)0.001068673);
		PreBioMoni.put("CU",(float)0.001064734);
		PreBioMoni.put("UA",(float)0.001061485);
		PreBioMoni.put("DH",(float)0.001060506);
		PreBioMoni.put("RK",(float)0.001038683);
		PreBioMoni.put("YI",(float)0.001031703);
		PreBioMoni.put("LU",(float)0.001018226);
		PreBioMoni.put("UM",(float)0.001015169);
		PreBioMoni.put("BI",(float)0.001007478);
		PreBioMoni.put("NY",(float)0.001004431);
		PreBioMoni.put("NW",(float)0.000974987);
		PreBioMoni.put("QU",(float)0.000964223);
		PreBioMoni.put("OG",(float)0.000962767);
		PreBioMoni.put("SN",(float)0.000961579);
		PreBioMoni.put("MB",(float)0.000953201);
		PreBioMoni.put("VA",(float)0.000950799);
		PreBioMoni.put("DF",(float)0.000932877);
		PreBioMoni.put("DD",(float)0.000925337);
		PreBioMoni.put("MS",(float)0.000907201);
		PreBioMoni.put("GS",(float)0.000906697);
		PreBioMoni.put("AW",(float)0.000906301);
		PreBioMoni.put("NH",(float)0.00090548);
		PreBioMoni.put("PU",(float)0.000892237);
		PreBioMoni.put("HR",(float)0.000888734);
		PreBioMoni.put("SD",(float)0.000888561);
		PreBioMoni.put("TB",(float)0.000882365);
		PreBioMoni.put("PT",(float)0.000881675);
		PreBioMoni.put("NM",(float)0.000878079);
		PreBioMoni.put("DC",(float)0.000874738);
		PreBioMoni.put("GU",(float)0.000871489);
		PreBioMoni.put("TM",(float)0.000869507);
		PreBioMoni.put("MU",(float)0.000868576);
		PreBioMoni.put("NU",(float)0.000863203);
		PreBioMoni.put("MM",(float)0.000862719);
		PreBioMoni.put("NL",(float)0.000854042);
		PreBioMoni.put("EU",(float)0.000849681);
		PreBioMoni.put("WN",(float)0.000844012);
		PreBioMoni.put("NB",(float)0.00083316);
		PreBioMoni.put("RP",(float)0.000829806);
		PreBioMoni.put("DM",(float)0.000819797);
		PreBioMoni.put("SR",(float)0.000812605);
		PreBioMoni.put("UD",(float)0.000809304);
		PreBioMoni.put("UI",(float)0.000805129);
		PreBioMoni.put("RF",(float)0.000794665);
		PreBioMoni.put("OK",(float)0.000785724);
		PreBioMoni.put("YW",(float)0.000781444);
		PreBioMoni.put("TF",(float)0.00077899);
		PreBioMoni.put("IP",(float)0.000774404);
		PreBioMoni.put("RW",(float)0.000774261);
		PreBioMoni.put("RB",(float)0.000773847);
		PreBioMoni.put("OH",(float)0.000752674);
		PreBioMoni.put("KS",(float)0.000746355);
		PreBioMoni.put("DP",(float)0.000727324);
		PreBioMoni.put("FU",(float)0.000725904);
		PreBioMoni.put("YC",(float)0.000723395);
		PreBioMoni.put("TP",(float)0.000710068);
		PreBioMoni.put("MT",(float)0.00070672);
		PreBioMoni.put("DL",(float)0.000705563);
		PreBioMoni.put("NK",(float)0.000703772);
		PreBioMoni.put("CC",(float)0.000699908);
		PreBioMoni.put("UB",(float)0.00069167);
		PreBioMoni.put("RH",(float)0.000686544);
		PreBioMoni.put("NP",(float)0.00068641);
		PreBioMoni.put("JU",(float)0.000676394);
		PreBioMoni.put("FL",(float)0.000668537);
		PreBioMoni.put("DN",(float)0.000656901);
		PreBioMoni.put("KA",(float)0.00065517);
		PreBioMoni.put("PH",(float)0.00065339);
		PreBioMoni.put("HU",(float)0.000641015);
		PreBioMoni.put("JO",(float)0.00062934);
		PreBioMoni.put("LF",(float)0.000624987);
		PreBioMoni.put("YB",(float)0.00062366);
		PreBioMoni.put("RV",(float)0.000622656);
		PreBioMoni.put("OE",(float)0.000605049);
		PreBioMoni.put("IB",(float)0.000600917);
		PreBioMoni.put("IK",(float)0.000597837);
		PreBioMoni.put("YP",(float)0.000597083);
		PreBioMoni.put("GL",(float)0.000595909);
		PreBioMoni.put("LP",(float)0.000588317);
		PreBioMoni.put("YM",(float)0.000581915);
		PreBioMoni.put("LB",(float)0.000569755);
		PreBioMoni.put("HS",(float)0.000569369);
		PreBioMoni.put("DG",(float)0.00056477);
		PreBioMoni.put("GN",(float)0.000561137);
		PreBioMoni.put("EK",(float)0.000557717);
		PreBioMoni.put("NR",(float)0.000553541);
		PreBioMoni.put("PS",(float)0.000549715);
		PreBioMoni.put("TD",(float)0.000542656);
		PreBioMoni.put("LC",(float)0.000538389);
		PreBioMoni.put("SK",(float)0.000536961);
		PreBioMoni.put("YF",(float)0.000533112);
		PreBioMoni.put("YH",(float)0.000529881);
		PreBioMoni.put("VO",(float)0.000521097);
		PreBioMoni.put("AH",(float)0.000514617);
		PreBioMoni.put("DY",(float)0.000512945);
		PreBioMoni.put("LM",(float)0.000512592);
		PreBioMoni.put("SY",(float)0.000512073);
		PreBioMoni.put("NV",(float)0.000507509);
		PreBioMoni.put("YD",(float)0.000490813);
		PreBioMoni.put("FS",(float)0.000473486);
		PreBioMoni.put("SG",(float)0.000472643);
		PreBioMoni.put("YR",(float)0.000467595);
		PreBioMoni.put("YL",(float)0.000465745);
		PreBioMoni.put("WS",(float)0.000459914);
		PreBioMoni.put("MY",(float)0.000450757);
		PreBioMoni.put("OY",(float)0.000447002);
		PreBioMoni.put("KN",(float)0.000440282);
		PreBioMoni.put("IZ",(float)0.000431486);
		PreBioMoni.put("XP",(float)0.00042568);
		PreBioMoni.put("LW",(float)0.000424782);
		PreBioMoni.put("TN",(float)0.000412134);
		PreBioMoni.put("KO",(float)0.000406556);
		PreBioMoni.put("AA",(float)0.000398032);
		PreBioMoni.put("JA",(float)0.000396094);
		PreBioMoni.put("ZE",(float)0.000395426);
		PreBioMoni.put("FC",(float)0.000363262);
		PreBioMoni.put("GW",(float)0.000362614);
		PreBioMoni.put("TG",(float)0.000353839);
		PreBioMoni.put("XT",(float)0.000349196);
		PreBioMoni.put("FH",(float)0.000348649);
		PreBioMoni.put("LR",(float)0.000348068);
		PreBioMoni.put("JE",(float)0.000343965);
		PreBioMoni.put("YN",(float)0.000343573);
		PreBioMoni.put("GG",(float)0.000339557);
		PreBioMoni.put("GF",(float)0.000338864);
		PreBioMoni.put("EQ",(float)0.000337972);
		PreBioMoni.put("HY",(float)0.000334507);
		PreBioMoni.put("KT",(float)0.000333937);
		PreBioMoni.put("HC",(float)0.00033326);
		PreBioMoni.put("BS",(float)0.000326001);
		PreBioMoni.put("HW",(float)0.00032451);
		PreBioMoni.put("HN",(float)0.000320055);
		PreBioMoni.put("CS",(float)0.000319511);
		PreBioMoni.put("HM",(float)0.000312896);
		PreBioMoni.put("NJ",(float)0.000310522);
		PreBioMoni.put("HH",(float)0.000307576);
		PreBioMoni.put("WT",(float)0.000300938);
		PreBioMoni.put("GC",(float)0.000300533);
		PreBioMoni.put("LH",(float)0.000294637);
		PreBioMoni.put("EJ",(float)0.000290693);
		PreBioMoni.put("FM",(float)0.000289379);
		PreBioMoni.put("DV",(float)0.000286431);
		PreBioMoni.put("LV",(float)0.000286367);
		PreBioMoni.put("WR",(float)0.0002837);
		PreBioMoni.put("GP",(float)0.000281029);
		PreBioMoni.put("FP",(float)0.000277477);
		PreBioMoni.put("GB",(float)0.0002739);
		PreBioMoni.put("GM",(float)0.000272543);
		PreBioMoni.put("HL",(float)0.000270452);
		PreBioMoni.put("LK",(float)0.00026923);
		PreBioMoni.put("CY",(float)0.000264866);
		PreBioMoni.put("MC",(float)0.000254786);
		PreBioMoni.put("YG",(float)0.000242611);
		PreBioMoni.put("XI",(float)0.000236981);
		PreBioMoni.put("HB",(float)0.000234499);
		PreBioMoni.put("FW",(float)0.000232626);
		PreBioMoni.put("GY",(float)0.00022659);
		PreBioMoni.put("HP",(float)0.000226323);
		PreBioMoni.put("MW",(float)0.000216835);
		PreBioMoni.put("PM",(float)0.000215356);
		PreBioMoni.put("ZA",(float)0.000214869);
		PreBioMoni.put("LG",(float)0.000214256);
		PreBioMoni.put("IW",(float)0.000213236);
		PreBioMoni.put("XA",(float)0.000209094);
		PreBioMoni.put("FB",(float)0.000205395);
		PreBioMoni.put("SV",(float)0.000203991);
		PreBioMoni.put("GD",(float)0.000203461);
		PreBioMoni.put("IX",(float)0.000203361);
		PreBioMoni.put("AJ",(float)0.000201257);
		PreBioMoni.put("KL",(float)0.000195718);
		PreBioMoni.put("HF",(float)0.000192937);
		PreBioMoni.put("HD",(float)0.000191658);
		PreBioMoni.put("AE",(float)0.0001887);
		PreBioMoni.put("SQ",(float)0.000185088);
		PreBioMoni.put("DJ",(float)0.000184862);
		PreBioMoni.put("FY",(float)0.000182687);
		PreBioMoni.put("AZ",(float)0.000177691);
		PreBioMoni.put("LN",(float)0.000173981);
		PreBioMoni.put("AO",(float)0.000173345);
		PreBioMoni.put("FD",(float)0.000172989);
		PreBioMoni.put("KW",(float)0.000166423);
		PreBioMoni.put("MF",(float)0.000165371);
		PreBioMoni.put("MH",(float)0.000164395);
		PreBioMoni.put("SJ",(float)0.00016291);
		PreBioMoni.put("UF",(float)0.00016232);
		PreBioMoni.put("TV",(float)0.000161455);
		PreBioMoni.put("XC",(float)0.000161419);
		PreBioMoni.put("YU",(float)0.000160844);
		PreBioMoni.put("BB",(float)0.000159375);
		PreBioMoni.put("WW",(float)0.000156011);
		PreBioMoni.put("OJ",(float)0.000152882);
		PreBioMoni.put("AX",(float)0.000152823);
		PreBioMoni.put("MR",(float)0.000152775);
		PreBioMoni.put("WL",(float)0.000152119);
		PreBioMoni.put("XE",(float)0.000151232);
		PreBioMoni.put("KH",(float)0.000150341);
		PreBioMoni.put("OX",(float)0.000150337);
		PreBioMoni.put("UO",(float)0.000150298);
		PreBioMoni.put("ZI",(float)0.00014894);
		PreBioMoni.put("FG",(float)0.000147488);
		PreBioMoni.put("IH",(float)0.000141227);
		PreBioMoni.put("TK",(float)0.000141146);
		PreBioMoni.put("II",(float)0.000140404);
		PreBioMoni.put("IU",(float)0.000133364);
		PreBioMoni.put("TJ",(float)0.000129384);
		PreBioMoni.put("MN",(float)0.000129135);
		PreBioMoni.put("WY",(float)0.000128037);
		PreBioMoni.put("KY",(float)0.000127956);
		PreBioMoni.put("KF",(float)0.000124266);
		PreBioMoni.put("FN",(float)0.000123577);
		PreBioMoni.put("UY",(float)0.000123021);
		PreBioMoni.put("PW",(float)0.000122663);
		PreBioMoni.put("DK",(float)0.000121584);
		PreBioMoni.put("RJ",(float)0.000119829);
		PreBioMoni.put("UK",(float)0.00011907);
		PreBioMoni.put("KR",(float)0.000117254);
		PreBioMoni.put("KU",(float)0.000117161);
		PreBioMoni.put("WM",(float)0.000116945);
		PreBioMoni.put("KM",(float)0.000112304);
		PreBioMoni.put("MD",(float)0.000111265);
		PreBioMoni.put("ML",(float)0.000110665);
		PreBioMoni.put("EZ",(float)0.000107644);
		PreBioMoni.put("KB",(float)0.000105885);
		PreBioMoni.put("WC",(float)0.000103696);
		PreBioMoni.put("WD",(float)0.000100054);
		PreBioMoni.put("HG",(float)9.93511E-05);
		PreBioMoni.put("BT",(float)9.90433E-05);
		PreBioMoni.put("ZO",(float)9.80582E-05);
		PreBioMoni.put("KC",(float)9.71333E-05);
		PreBioMoni.put("PF",(float)9.67057E-05);
		PreBioMoni.put("YV",(float)9.51607E-05);
		PreBioMoni.put("PC",(float)9.25754E-05);
		PreBioMoni.put("PY",(float)9.16132E-05);
		PreBioMoni.put("WB",(float)9.13063E-05);
		PreBioMoni.put("YK",(float)9.06432E-05);
		PreBioMoni.put("CP",(float)8.8555E-05);
		PreBioMoni.put("YJ",(float)8.75735E-05);
		PreBioMoni.put("KP",(float)8.68737E-05);
		PreBioMoni.put("PB",(float)8.54128E-05);
		PreBioMoni.put("CD",(float)8.28919E-05);
		PreBioMoni.put("JI",(float)8.26934E-05);
		PreBioMoni.put("UW",(float)8.1573E-05);
		PreBioMoni.put("UH",(float)7.84762E-05);
		PreBioMoni.put("WF",(float)7.77528E-05);
		PreBioMoni.put("YY",(float)7.70035E-05);
		PreBioMoni.put("WP",(float)7.44071E-05);
		PreBioMoni.put("BC",(float)7.40912E-05);
		PreBioMoni.put("AQ",(float)7.28628E-05);
		PreBioMoni.put("CB",(float)6.89279E-05);
		PreBioMoni.put("IQ",(float)6.74437E-05);
		PreBioMoni.put("CM",(float)6.61271E-05);
		PreBioMoni.put("MG",(float)6.594E-05);
		PreBioMoni.put("DQ",(float)6.55193E-05);
		PreBioMoni.put("BJ",(float)6.53561E-05);
		PreBioMoni.put("TZ",(float)6.47546E-05);
		PreBioMoni.put("KD",(float)6.42863E-05);
		PreBioMoni.put("PD",(float)6.31716E-05);
		PreBioMoni.put("FJ",(float)6.24091E-05);
		PreBioMoni.put("CF",(float)6.18922E-05);
		PreBioMoni.put("NZ",(float)6.16219E-05);
		PreBioMoni.put("CW",(float)5.94925E-05);
		PreBioMoni.put("FV",(float)5.6586E-05);
		PreBioMoni.put("VY",(float)5.39027E-05);
		PreBioMoni.put("FK",(float)5.29367E-05);
		PreBioMoni.put("OZ",(float)5.2856E-05);
		PreBioMoni.put("ZZ",(float)5.11722E-05);
		PreBioMoni.put("IJ",(float)5.06757E-05);
		PreBioMoni.put("LJ",(float)5.04985E-05);
		PreBioMoni.put("NQ",(float)5.02811E-05);
		PreBioMoni.put("UV",(float)4.9039E-05);
		PreBioMoni.put("XO",(float)4.8836E-05);
		PreBioMoni.put("PG",(float)4.88267E-05);
		PreBioMoni.put("HK",(float)4.86537E-05);
		PreBioMoni.put("KG",(float)4.8395E-05);
		PreBioMoni.put("VS",(float)4.71987E-05);
		PreBioMoni.put("HV",(float)4.5683E-05);
		PreBioMoni.put("BM",(float)4.43574E-05);
		PreBioMoni.put("HJ",(float)4.39178E-05);
		PreBioMoni.put("CN",(float)4.34876E-05);
		PreBioMoni.put("GV",(float)4.31941E-05);
		PreBioMoni.put("CG",(float)4.19946E-05);
		PreBioMoni.put("WU",(float)4.18313E-05);
		PreBioMoni.put("GJ",(float)4.09209E-05);
		PreBioMoni.put("XH",(float)3.85278E-05);
		PreBioMoni.put("GK",(float)3.78874E-05);
		PreBioMoni.put("TQ",(float)3.67961E-05);
		PreBioMoni.put("CQ",(float)3.64342E-05);
		PreBioMoni.put("RQ",(float)3.62924E-05);
		PreBioMoni.put("BH",(float)3.57272E-05);
		PreBioMoni.put("XS",(float)3.56944E-05);
		PreBioMoni.put("UZ",(float)3.55531E-05);
		PreBioMoni.put("WK",(float)3.44495E-05);
		PreBioMoni.put("XU",(float)3.41186E-05);
		PreBioMoni.put("UX",(float)3.34898E-05);
		PreBioMoni.put("BD",(float)3.27816E-05);
		PreBioMoni.put("BW",(float)3.24202E-05);
		PreBioMoni.put("WG",(float)3.2351E-05);
		PreBioMoni.put("MV",(float)3.1524E-05);
		PreBioMoni.put("MJ",(float)3.10497E-05);
		PreBioMoni.put("PN",(float)3.04443E-05);
		PreBioMoni.put("XM",(float)2.94839E-05);
		PreBioMoni.put("OQ",(float)2.83703E-05);
		PreBioMoni.put("BV",(float)2.777E-05);
		PreBioMoni.put("XW",(float)2.75945E-05);
		PreBioMoni.put("KK",(float)2.74763E-05);
		PreBioMoni.put("BP",(float)2.66322E-05);
		PreBioMoni.put("ZU",(float)2.62569E-05);
		PreBioMoni.put("RZ",(float)2.62323E-05);
		PreBioMoni.put("XF",(float)2.61396E-05);
		PreBioMoni.put("MK",(float)2.56794E-05);
		PreBioMoni.put("ZH",(float)2.48926E-05);
		PreBioMoni.put("BN",(float)2.45425E-05);
		PreBioMoni.put("ZY",(float)2.44838E-05);
		PreBioMoni.put("HQ",(float)2.3413E-05);
		PreBioMoni.put("WJ",(float)2.29954E-05);
		PreBioMoni.put("IY",(float)2.2747E-05);
		PreBioMoni.put("DZ",(float)2.26723E-05);
		PreBioMoni.put("VR",(float)2.22972E-05);
		PreBioMoni.put("ZS",(float)2.19681E-05);
		PreBioMoni.put("XY",(float)2.18146E-05);
		PreBioMoni.put("CV",(float)2.17903E-05);
		PreBioMoni.put("XB",(float)2.1748E-05);
		PreBioMoni.put("XR",(float)2.08241E-05);
		PreBioMoni.put("UJ",(float)2.03898E-05);
		PreBioMoni.put("YQ",(float)2.03401E-05);
		PreBioMoni.put("VD",(float)1.97984E-05);
		PreBioMoni.put("PK",(float)1.91986E-05);
		PreBioMoni.put("VU",(float)1.91553E-05);
		PreBioMoni.put("JR",(float)1.86098E-05);
		PreBioMoni.put("ZL",(float)1.85099E-05);
		PreBioMoni.put("SZ",(float)1.84638E-05);
		PreBioMoni.put("YZ",(float)1.81033E-05);
		PreBioMoni.put("LQ",(float)1.78413E-05);
		PreBioMoni.put("KJ",(float)1.77645E-05);
		PreBioMoni.put("BF",(float)1.74259E-05);
		PreBioMoni.put("NX",(float)1.73085E-05);
		PreBioMoni.put("QA",(float)1.70039E-05);
		PreBioMoni.put("QI",(float)1.69715E-05);
		PreBioMoni.put("KV",(float)1.69246E-05);
		PreBioMoni.put("ZW",(float)1.59258E-05);
		PreBioMoni.put("WV",(float)1.47845E-05);
		PreBioMoni.put("UU",(float)1.45794E-05);
		PreBioMoni.put("VT",(float)1.45491E-05);
		PreBioMoni.put("VP",(float)1.44716E-05);
		PreBioMoni.put("XD",(float)1.3899E-05);
		PreBioMoni.put("GQ",(float)1.38178E-05);
		PreBioMoni.put("XL",(float)1.37797E-05);
		PreBioMoni.put("VC",(float)1.36499E-05);
		PreBioMoni.put("CZ",(float)1.33932E-05);
		PreBioMoni.put("LZ",(float)1.32545E-05);
		PreBioMoni.put("ZT",(float)1.31714E-05);
		PreBioMoni.put("WZ",(float)1.22189E-05);
		PreBioMoni.put("SX",(float)1.17885E-05);
		PreBioMoni.put("ZB",(float)1.17138E-05);
		PreBioMoni.put("VL",(float)1.13392E-05);
		PreBioMoni.put("PV",(float)1.11248E-05);
		PreBioMoni.put("FQ",(float)1.09858E-05);
		PreBioMoni.put("PJ",(float)1.08792E-05);
		PreBioMoni.put("ZM",(float)1.06458E-05);
		PreBioMoni.put("VW",(float)1.05473E-05);
		PreBioMoni.put("CJ",(float)9.60332E-06);
		PreBioMoni.put("ZC",(float)9.49024E-06);
		PreBioMoni.put("BG",(float)9.36975E-06);
		PreBioMoni.put("JS",(float)9.09455E-06);
		PreBioMoni.put("XG",(float)9.08599E-06);
		PreBioMoni.put("RX",(float)8.93914E-06);
		PreBioMoni.put("HZ",(float)8.5719E-06);
		PreBioMoni.put("XX",(float)8.10614E-06);
		PreBioMoni.put("VM",(float)8.09967E-06);
		PreBioMoni.put("XN",(float)8.0326E-06);
		PreBioMoni.put("QW",(float)8.01757E-06);
		PreBioMoni.put("JP",(float)7.98311E-06);
		PreBioMoni.put("VN",(float)7.65056E-06);
		PreBioMoni.put("ZD",(float)7.60986E-06);
		PreBioMoni.put("ZR",(float)7.55875E-06);
		PreBioMoni.put("FZ",(float)7.21209E-06);
		PreBioMoni.put("XV",(float)7.19613E-06);
		PreBioMoni.put("ZP",(float)7.02778E-06);
		PreBioMoni.put("VH",(float)6.98476E-06);
		PreBioMoni.put("VB",(float)6.75096E-06);
		PreBioMoni.put("ZF",(float)6.62746E-06);
		PreBioMoni.put("GZ",(float)6.59416E-06);
		PreBioMoni.put("TX",(float)6.51137E-06);
		PreBioMoni.put("VF",(float)6.49611E-06);
		PreBioMoni.put("DX",(float)6.33954E-06);
		PreBioMoni.put("QB",(float)6.31503E-06);
		PreBioMoni.put("BK",(float)6.24241E-06);
		PreBioMoni.put("ZG",(float)6.09811E-06);
		PreBioMoni.put("VG",(float)5.9168E-06);
		PreBioMoni.put("JC",(float)5.72832E-06);
		PreBioMoni.put("ZK",(float)5.61084E-06);
		PreBioMoni.put("ZN",(float)5.60599E-06);
		PreBioMoni.put("UQ",(float)5.40826E-06);
		PreBioMoni.put("JM",(float)5.1659E-06);
		PreBioMoni.put("VV",(float)5.16382E-06);
		PreBioMoni.put("JD",(float)5.0653E-06);
		PreBioMoni.put("MQ",(float)4.93926E-06);
		PreBioMoni.put("JH",(float)4.84722E-06);
		PreBioMoni.put("QS",(float)4.82109E-06);
		PreBioMoni.put("JT",(float)4.71956E-06);
		PreBioMoni.put("JB",(float)4.48183E-06);
		PreBioMoni.put("FX",(float)4.46633E-06);
		PreBioMoni.put("PQ",(float)4.30306E-06);
		PreBioMoni.put("MZ",(float)4.22536E-06);
		PreBioMoni.put("YX",(float)3.91871E-06);
		PreBioMoni.put("QT",(float)3.91154E-06);
		PreBioMoni.put("WQ",(float)3.75683E-06);
		PreBioMoni.put("JJ",(float)3.71983E-06);
		PreBioMoni.put("JW",(float)3.71936E-06);
		PreBioMoni.put("LX",(float)3.57691E-06);
		PreBioMoni.put("GX",(float)3.41757E-06);
		PreBioMoni.put("JN",(float)3.34218E-06);
		PreBioMoni.put("ZV",(float)3.31604E-06);
		PreBioMoni.put("MX",(float)3.29546E-06);
		PreBioMoni.put("JK",(float)3.23002E-06);
		PreBioMoni.put("KQ",(float)3.21568E-06);
		PreBioMoni.put("XK",(float)3.15694E-06);
		PreBioMoni.put("JF",(float)2.92313E-06);
		PreBioMoni.put("QM",(float)2.84797E-06);
		PreBioMoni.put("QH",(float)2.83826E-06);
		PreBioMoni.put("JL",(float)2.80958E-06);
		PreBioMoni.put("JG",(float)2.78045E-06);
		PreBioMoni.put("VK",(float)2.65233E-06);
		PreBioMoni.put("VJ",(float)2.64377E-06);
		PreBioMoni.put("KZ",(float)2.58827E-06);
		PreBioMoni.put("QC",(float)2.46686E-06);
		PreBioMoni.put("XJ",(float)2.45807E-06);
		PreBioMoni.put("PZ",(float)2.24253E-06);
		PreBioMoni.put("QL",(float)2.22079E-06);
		PreBioMoni.put("QO",(float)2.17246E-06);
		PreBioMoni.put("JV",(float)2.064E-06);
		PreBioMoni.put("QF",(float)2.03E-06);
		PreBioMoni.put("QD",(float)2.00688E-06);
		PreBioMoni.put("BZ",(float)1.88061E-06);
		PreBioMoni.put("HX",(float)1.74047E-06);
		PreBioMoni.put("ZJ",(float)1.65744E-06);
		PreBioMoni.put("PX",(float)1.57581E-06);
		PreBioMoni.put("QP",(float)1.4019E-06);
		PreBioMoni.put("QE",(float)1.39219E-06);
		PreBioMoni.put("QR",(float)1.38178E-06);
		PreBioMoni.put("ZQ",(float)1.33507E-06);
		PreBioMoni.put("JY",(float)1.3235E-06);
		PreBioMoni.put("BQ",(float)1.27494E-06);
		PreBioMoni.put("XQ",(float)1.25251E-06);
		PreBioMoni.put("CX",(float)1.22568E-06);
		PreBioMoni.put("KX",(float)1.1755E-06);
		PreBioMoni.put("WX",(float)1.08184E-06);
		PreBioMoni.put("QY",(float)1.05385E-06);
		PreBioMoni.put("QV",(float)9.74069E-07);
		PreBioMoni.put("QN",(float)8.8064E-07);
		PreBioMoni.put("VX",(float)7.38184E-07);
		PreBioMoni.put("BX",(float)6.98638E-07);
		PreBioMoni.put("JZ",(float)6.61174E-07);
		PreBioMoni.put("VZ",(float)6.08909E-07);
		PreBioMoni.put("QG",(float)5.93646E-07);
		PreBioMoni.put("QQ",(float)5.7792E-07);
		PreBioMoni.put("ZX",(float)5.69595E-07);
		PreBioMoni.put("XZ",(float)4.81484E-07);
		PreBioMoni.put("QK",(float)4.6784E-07);
		PreBioMoni.put("VQ",(float)3.44116E-07);
		PreBioMoni.put("QJ",(float)3.10352E-07);
		PreBioMoni.put("QX",(float)1.76914E-07);
		PreBioMoni.put("JX",(float)1.72752E-07);
		PreBioMoni.put("JQ",(float)1.6697E-07);
		PreBioMoni.put("QZ",(float)6.47529E-08);
		System.out.println("asd"+PreBioMoni.get("JQ"));
		printMap(PreBioMoni);
	}


	public static void main(String[] args) {
		StringFrequency st = new StringFrequency();

	}

}
