package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comparators.CountryComparatorWomen;

public class CountryList {
private List<Country> countriesList;
	
	public CountryList(){
		countriesList = new ArrayList<>();
	}
	
	public void addACountry(Country country) {
		countriesList.add(country);
	}
	
	public int getSizeList() {
		return countriesList.size();
	}
	
	
	public String concatenateListInformation() {
		String out = "";
		/*
		//Sort the list by medals by gender
		sortByAmountMedalsMenDsc();
		
		String out = "";
		
		out += "**Male***\n";
		for(int i = 0;i<countriesList.size();i++) {
			out += countriesList.get(i).toStringMenMedals()+"\n";
		}
		*/
		out += "----------\n";
		
		out += "**Female***\n";
		
		
		sortByAmountMedalsWomenAsc();
		
		for (int i = 0; i < countriesList.size(); i++) {
			out += countriesList.get(i).toStringWomenMedals()+"\n";
		}
		
		
				
		
		
		return out;
	}
	
	public void sortByAmountMedalsWomenAsc() {
		Collections.sort(countriesList, new CountryComparatorWomen());
	}
	
	public void sortByAmountMedalsMenDsc() {
		
	
	}
}
