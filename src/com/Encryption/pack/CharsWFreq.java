package com.Encryption.pack;

import java.util.Comparator;

public class CharsWFreq {

	private char charName;
	private double Frequency;
	private char charMapping;
	private int count;
	public void setCharMapping(char charMapping) {
		this.charMapping = charMapping;
		
	}

	public CharsWFreq(char charName,double Frequency)
	{
		this.charName =charName;
		this.Frequency = Frequency;
	}
	
	public CharsWFreq(char charName)
	{
		this.charName =charName;
		count=0;
	}
	
	public char getCharName() {
		return charName;
	}


	public void setCharName(char charName) {
		this.charName = charName;
	}


	public double getFrequency() {
		return Frequency;
	}
	
	public void increaseCount(){
		this.count++;
	}
	
	public int getCount()
	{
		return this.count++;
	}


	public void setFrequency(double frequency) {
		Frequency = frequency;
	}

	

	
}
