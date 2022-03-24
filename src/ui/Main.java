package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
				"(3) Import countries from txt file\n"+
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
			showInformationListings(); 
			break;
		case 3:
			deserializeCountries();
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
	
	
	public void deserializeCountries() {
		File file = new File(".\\files\\Countries.txt");
		
		if(file.exists()) {
			
			try {
				FileReader fr = new FileReader(file);
				
				@SuppressWarnings("resource")
				BufferedReader breader = new BufferedReader(fr);
				 
				String line = null;
				while((line = breader.readLine()) != null) {
					String [] parts = line.split("\\;");
					if(parts.length == 7) {
						String name = parts[0];
						
						int goldMedalsWomen = Integer.valueOf(parts[1]);
						int silverMedalsWomen = Integer.valueOf(parts[2]);
						int bronzeMedalsWomen = Integer.valueOf(parts[3]);
						
						int goldMedalsMen = Integer.valueOf(parts[4]);
						int silverMedalsMen = Integer.valueOf(parts[5]);
						int bronzeMedalsmen = Integer.valueOf(parts[6]);
						
						Country obj = new Country(name,goldMedalsMen,silverMedalsMen,bronzeMedalsmen,
								goldMedalsWomen,silverMedalsWomen,bronzeMedalsWomen);
						
						list.addACountry(obj);
						
						
					}
				}
				System.out.println("The countries list has been imported....");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
