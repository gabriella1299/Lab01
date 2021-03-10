package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	List <String> parole;
	
	public Parole() {
		
		//SCELGO UNA O L'ALTRA STRUTTURA PER CONFRONTARE LE PRESTAZIONI
		//parole=new LinkedList<String>(); 
		parole=new ArrayList<String>();
		
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole, new ComparatoreParole());
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}
	
	public String toString() {
		String s="";
		for(String p:getElenco()) {
			s=s+p+"\n";
		}
		return s;
	}
	
	public void removeParola(String p) {
		parole.remove(p);
	}

}
