package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comparators.CountryComparatorMen;
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
		
		//Sort the list by medals by gender
		sortByAmountMedalsMenDsc();
		
		out += "**Male***\n";
		for(int i = 0;i<countriesList.size();i++) {
			out += countriesList.get(i).toStringMenMedals()+"\n";
		}
		
		out += "----------\n";
		
		out += "**Female***\n";
		
		
		sortByAmountMedalsWomenAsc();
		
		for (int i = 0; i < countriesList.size(); i++) {
			out += countriesList.get(i).toStringWomenMedals()+"\n";
		}
		
		out += "----------\n";
		
		out += "**Combined**\n";

		bubbleSortToTotalMedals();
		for(int i =0;i<countriesList.size();i++) {
			out += countriesList.get(i).toStringTotalMedals()+"\n";
		}
		
		return out;
	}
	
	public void bubbleSortToTotalMedals() {
		int n = countriesList.size();
		boolean stop = true;
		
		for(int i = 0;i<n && stop;i++) {
			stop = false;
			for(int j = 1;j<n-i;j++) {
				if(countriesList.get(j).compareByTotalMedals(countriesList.get(j-1))>0) {
					Country temp = countriesList.get(j);
					countriesList.set(j,countriesList.get(j-1));
					countriesList.set(j-1, temp);
					stop = true;
					
				}
			}
		}
		
	}
	
	public void sortByAmountMedalsWomenAsc() {
		Collections.sort(countriesList, new CountryComparatorWomen());
	}
	
	public void sortByAmountMedalsMenDsc() {
		Collections.sort(countriesList, new CountryComparatorMen());
	}
}
