package comparators;

import java.util.Comparator;

import model.Country;

public class CountryComparatorMen implements Comparator<Country> {

	@Override
	public int compare(Country c1, Country c2) {
		int result = 0;
		if(c1.getGoldMedalsMen()<c2.getGoldMedalsMen()) {
			result = 1;
		}
		else if(c1.getGoldMedalsMen()>c2.getGoldMedalsMen()) {
			result = -1;
		}
		else {
			/*
			If the countries have the same number of gold medals, 
			they will be ordered by the number of silver medals.
			*/
			if(c1.getSilverMedalsMen()<c2.getSilverMedalsMen()) {
				result = 1;
			}
			else if(c1.getSilverMedalsMen()>c2.getSilverMedalsMen()){
				result = -1;
			}
			else {
				/*
				If the countries have the same number of silver medals, 
				they will be ordered by the number of bronze medals.
				*/
				if(c1.getBronzeMedalsMen()<c2.getBronzeMedalsMen()) {
					result = 1;
				}
				else if(c1.getBronzeMedalsMen()>c2.getBronzeMedalsMen()) {
					result = -1;
				}
				else {
					/*
					If the countries have the same number of bronze medals, 
					they will be ordered by the name.
					*/
					
					if(c1.getName().compareTo(c2.getName())>0) {
						result = -1;
					}
					else if(c1.getName().compareTo(c2.getName())<0) {
						result = 1;
					}
				}
			}
		}
		return result;
	}

}
