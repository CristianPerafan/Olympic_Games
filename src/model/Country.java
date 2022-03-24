package model;

public class Country{
	//Attributes
		private String name;

		private int [] menMedals;
		
		private int [] womenMedals;
		
		private int totalGoldMedals;
		private int totalSilverMedals;
		private int totalBronzeMedals;
		
		
		

		public Country(String name, int GmenMedals, int SmenMedals, int BmenMedals, int GwomenMedals,
				int SwomenMedals, int BwomenMedals) {
			super();
			
			this.name = name;
			
			menMedals = new int[3];
			//Gold medals
			menMedals[0] = GmenMedals;
			//Silver medals 
			menMedals[1] = SmenMedals;
			//Bronze medals
			menMedals[2] = BmenMedals;
			
			
		
			womenMedals = new int[3];
			//Gold medals
			womenMedals[0] = GwomenMedals;
			//Silver medals
			womenMedals[1] = SwomenMedals;
			//Bronze medals
			womenMedals[2] = BwomenMedals;
			
			totalGoldMedals = menMedals[0]+womenMedals[0];
			totalSilverMedals = menMedals[1]+womenMedals[1];
			totalBronzeMedals =menMedals[2]+womenMedals[2];
			
			
		
		}
		
	
		
		
		//=== GETTERS AND SETTERS ===
		
		////
		public int getGoldMedalsMen() {
			return menMedals[0];
		}
		public int getSilverMedalsMen() {
			return menMedals[1];
		}
		public int getBronzeMedalsMen() {
			return menMedals[2];
		}
		////
		
		////
		public int getGoldMedalsWomen() {
			return womenMedals[0];
		}
		
		public int getSilverMedalsWomen() {
			return womenMedals[1];
		}
		
		public int getBronzeMedalsWomen() {
			return womenMedals[2];
		}
		public String getName() {
			return name;
		}
		////
		
		////
		public int getTotalGoldMedals() {
			return totalGoldMedals;
		}
		public int getTotalSilverMedals() {
			return totalSilverMedals;
		}
		public int getTotalBronzedMedals() {
			return totalBronzeMedals;
		}
		////
		
		
		public int compareByTotalMedals(Country other) {
			int out = 0;
			
			if(this.getTotalGoldMedals()<other.getTotalGoldMedals()) {
				out = -1;
			}
			else if (this.getTotalGoldMedals()>other.getTotalGoldMedals()){
				out = 1;
			}
			else {
				if(this.getTotalSilverMedals()<other.getTotalSilverMedals()) {
					out = -1;
				}
				else if(this.getTotalSilverMedals()>other.getTotalSilverMedals()) {
					out = 1;
				}
				else {
					if(this.getTotalBronzedMedals()<other.getTotalBronzedMedals()) {
						out = -1;
					}
					else if(this.getTotalBronzedMedals()>other.getTotalBronzedMedals()) {
						out = 1;
					}
					else {
						if(this.getName().compareTo(other.getName())>0) {
							out = 1;
						}
						else if(this.getName().compareTo(other.getName())<0) {
							out = -1;
						}
					}
				}
			}
			
			return out;
		}
		
		
		public String toStringWomenMedals() {
			String out = "";
			out += name+" ";
			for (int i = 0; i < womenMedals.length; i++) {
				out += womenMedals[i]+" ";
			}
			return out;
		}

		public String toStringMenMedals() {
			String out = "";
			out += name+" ";
			for(int i = 0;i<menMedals.length;i++) {
				out += menMedals[i]+" ";
			}
			return out;
		}
		
		public String toStringTotalMedals() {
			String out = "";
			out += name+" ";
			out += totalGoldMedals+" "+totalSilverMedals+" "+totalBronzeMedals;
			return out;
		}
		
	
		

}
