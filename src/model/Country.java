package model;

public class Country{
	//Attributes
		private String name;

		private int [] menMedals;
		
		private int [] womenMedals;
		
		

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
		
	
		

}
