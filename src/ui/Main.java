package ui;

import java.util.Scanner;

import model.Country;
import model.CountryList;

public class Main {
private Scanner sc;
	
	private CountryList list;
	
	public Main() {
		sc = new Scanner(System.in);
		list = new CountryList();
		
	}
	public static void main(String [] args) {
		Main pc = new Main();
		
		System.out.println("Starting the APP.....");
		
		int option = 0;
		do {
			option = pc.showMenu();
			pc.executeOperation(option);
		}while(option != 0);
		
		
	}
	
	public int showMenu() {
		System.out.println("***OLYMPIC GAMES***\n"+
				"(1) add a country\n"+
				"(2) Show list\n"+
				"(0) exit");
		
		int option = sc.nextInt();
		sc.nextLine();
		
		return option;
	}
	
	public void executeOperation(int option){
		switch(option) {
		case 0:
			System.out.println("Bye see you soon.....");
			break;
		case 1:
			addACountry();
			break;
		case 2:
			 pruebas();
			showInformationListings(); 
			break;
		default:
			System.out.println("Invalid option!!!");
			break;
		}
	}
	
	public void addACountry() {
		System.out.println("***ADD A COUNTRY***\n"+
				"How many countries do you want to save?");
		
		String numCountries = "";
		
		do {
			numCountries = sc.nextLine();
			if(!isInt(numCountries)) {
				System.out.println("You must enter a valid value!!!!");
			}
		}while(!isInt(numCountries));
		
		
		
		System.out.println("Enter the country information in the following format:\n"+
				"Colombia;2;3;6;0;2;9\n"
				+ "**Note:**"+
				" Where the first three numbers represent the men's medals\n"
				+ "and the next three the number of women's medals");
		
		for(int i = 0;i<Integer.parseInt(numCountries);i++) {
			

			String country = sc.nextLine();
			String [] countryValues = country.split("\\;");
			
			if(countryValues.length != 7) {
				i--;
				System.out.println("The input format is not valid, enter it again");
			}
			else {
				String name = countryValues[0];
				
				//***MEN´S MEDALS***
				int [] menMedals = new int[3];
				//Gold medals
				menMedals[0] = Integer.valueOf(countryValues[1]);
				
				//Silver medals
				menMedals[1] = Integer.valueOf(countryValues[2]);;
				//Bronze medals
				menMedals[2] = Integer.valueOf(countryValues[3]);
				
				//***FEMALE MEDALS***
				int [] femaleMedals = new int[3];
				//Gold medals
				femaleMedals[0] = Integer.valueOf(countryValues[4]);
				//Silver medals
				femaleMedals[1] = Integer.valueOf(countryValues[5]);
				//Bronze medals
				femaleMedals[2] = Integer.valueOf(countryValues[6]);
				
				Country countryObj = new Country(name,menMedals[0],menMedals[1],menMedals[2],
						femaleMedals[0],femaleMedals[1],femaleMedals[2]);
				
				list.addACountry(countryObj);
				System.out.println("The country has been added....");
			}
				
			
		}
			
	}
	
	public void pruebas() {
		/*
		Country obj1 = new Country("Colombia",2,3,6,0,2,9);
		list.addACountry(obj1);
		Country obj2 = new Country("China",1,4,4,0,2,9);
		list.addACountry(obj2);
		Country obj3 = new Country("Rusia",10,21,17,26,27,15);
		list.addACountry(obj3);
		Country obj4 =  new Country("USA",10,15,17,11,12,16);
		list.addACountry(obj4);
		*/
		
		Country obj1 = new Country("Colombia",3,2,2,0,2,9);
		list.addACountry(obj1);
		Country obj2 = new Country("China",2,2,2,0,2,9);
		list.addACountry(obj2);
		Country obj3 = new Country("Rusia",2,2,2,26,27,15);
		list.addACountry(obj3);
		Country obj4 =  new Country("USA",2,2,2,11,12,16);
		list.addACountry(obj4);
		
		
	}
	
	public void showInformationListings() {
		
		if (list.getSizeList() >= 2) {
			System.out.println(list.concatenateListInformation());
		}else {
			System.out.println("You must register at least two countries");
		}
		
		
	}
	
	public boolean isInt(String value) {
		@SuppressWarnings("unused")
		int v;
		
		try {
			v = Integer.valueOf(value);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
		
		
	}

}
