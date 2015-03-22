package com.Encryption.pack;

import java.util.ArrayList;
import java.util.Comparator;

public class demo {

	public static void main (String args[]){
		
		ArrayList<CharsWFreq> monogram = new ArrayList<CharsWFreq>();
		ArrayList<CharsWFreq> computation = new ArrayList<CharsWFreq>();
		String test = "yo";
		String text = "pvskrlobsktnkprptprchzrovsjrkmtrpssukdpcnjsuiswshpvctxvpvshtlnsjcyisdkrkujcthfujsubbdnrxhtlnsjpvsjsrkubcpcyjsfthfuhzduhfcpvsjkpuprkprzubojcosjprskcyshxbrkvpseppvupluisrpmtrpssukdpcfspsjlrhsujsukchunbdxccfisdpvsyrjkpkpsorkpczubztbupspvsyjsmtshzdfrkpjrntprchcypvsbsppsjkrhpvszrovsjpseppvrkzchkrkpkcyzcthprhxvcqluhdprlsksuzvbsppsjuoosujkhuptjubshxbrkvpsepvukuwsjdfrkprhzpfrkpjrntprchpvupzuhnstksfvsbozjuzizcfsk";
		monogram.add(new  CharsWFreq('e',0.12702));
		monogram.add(new  CharsWFreq('t',0.09056));
		monogram.add(new  CharsWFreq('a',0.08167));
		monogram.add(new  CharsWFreq('o',0.07507));
		monogram.add(new  CharsWFreq('i',0.06966));
		monogram.add(new  CharsWFreq('n',0.06749));
		monogram.add(new  CharsWFreq('s',0.06327));
		monogram.add(new  CharsWFreq('h',0.06094));
		monogram.add(new  CharsWFreq('r',0.05987));
		monogram.add(new  CharsWFreq('d',0.04253));
		monogram.add(new  CharsWFreq('l',0.04025));
		monogram.add(new  CharsWFreq('c',0.02782));
		monogram.add(new  CharsWFreq('u',0.02758));
		monogram.add(new  CharsWFreq('m',0.02406));
		monogram.add(new  CharsWFreq('w',0.0236));
		monogram.add(new  CharsWFreq('f',0.02228));
		monogram.add(new  CharsWFreq('g',0.02015));
		monogram.add(new  CharsWFreq('y',0.01974));
		monogram.add(new  CharsWFreq('p',0.01929));
		monogram.add(new  CharsWFreq('b',0.01492));
		monogram.add(new  CharsWFreq('v',0.00978));
		monogram.add(new  CharsWFreq('k',0.00772));
		monogram.add(new  CharsWFreq('j',0.00153));
		monogram.add(new  CharsWFreq('x',0.0015));
		monogram.add(new  CharsWFreq('q',0.00095));
		monogram.add(new  CharsWFreq('z',0.00074));

		computation.add(new  CharsWFreq('e'));
		computation.add(new  CharsWFreq('t'));
		computation.add(new  CharsWFreq('a'));
		computation.add(new  CharsWFreq('o'));
		computation.add(new  CharsWFreq('i'));
		computation.add(new  CharsWFreq('n'));
		computation.add(new  CharsWFreq('s'));
		computation.add(new  CharsWFreq('h'));
		computation.add(new  CharsWFreq('r'));
		computation.add(new  CharsWFreq('d'));
		computation.add(new  CharsWFreq('l'));
		computation.add(new  CharsWFreq('c'));
		computation.add(new  CharsWFreq('u'));
		computation.add(new  CharsWFreq('m'));
		computation.add(new  CharsWFreq('w'));
		computation.add(new  CharsWFreq('f'));
		computation.add(new  CharsWFreq('g'));
		computation.add(new  CharsWFreq('y'));
		computation.add(new  CharsWFreq('p'));
		computation.add(new  CharsWFreq('b'));
		computation.add(new  CharsWFreq('v'));
		computation.add(new  CharsWFreq('k'));
		computation.add(new  CharsWFreq('j'));
		computation.add(new  CharsWFreq('x'));
		computation.add(new  CharsWFreq('q'));
		computation.add(new  CharsWFreq('z'));
	


		
		//System.out.println(computation.get(0).getCount());
		System.out.println(text.length());
		
		
	}
}
