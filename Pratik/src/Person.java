
import java.util.ArrayList;
import java.util.Random;

public class Person {

	Country location;
	private Radio radio;
	private int infectionDay;
	boolean isInfected;
	boolean isSick;
	boolean isDead;
	boolean isImmune;
	boolean looksInfectious;
	int nextTravelDay;
	int currentDay;
	int transportation;
	int travelDay;

	public Person() {
		radio = new Radio();
	}

	public void setLocation(Country country) {
		location = country;

	}

	public void setCurrentDay() {
		this.currentDay = radio.currentDay;
	}


	public void getInfected() {

		if (currentDay==nextTravelDay){
			Random r = new Random();
			int infect = r.nextInt(100);
			if ( infect < 40){
				this.isInfected = true;
				infectionDay=radio.currentDay;
				radio.infectedCount=radio.infectedCount+1;

			}
			else
				this.isInfected = false;
		}

	}

	public boolean getSick(){
		if (currentDay-infectionDay==6){

			isSick=true;
			looksInfectious= true;

			radio.infectedCount=radio.infectedCount-1;
			radio.sickCount=radio.sickCount+1;

		}
		return isSick;
	}

	public void die() {

		if(radio.currentDay-infectionDay==14){

			Random r = new Random();
			int infect = r.nextInt(100);
			if (infect < 25){
				isDead=true;
				radio.sickCount=radio.sickCount-1;
				radio.worldPopulation=radio.worldPopulation-1;
				radio.deadCount = radio.deadCount+1;

			}
		}

	}

	public void getImmune(){

		if (radio.currentDay-infectionDay==16){
			isImmune=true;
			isSick=false;
			looksInfectious= false;
			radio.sickCount=radio.sickCount-1;;

		}

	}


	public void getHealty(){

		if (radio.currentDay-infectionDay==18){
			isImmune=false;
			isInfected=false;
			radio.healthyPopulation=radio.healthyPopulation+1;
			//	world.setInfectedPopulation(world.getInfectedPopulation()-1);
		}

	}

	public void survive(){

		if(!isInfected && !isImmune)	getInfected();
		if(isInfected) getSick();
		if (isSick) {
			die();
			if(!isDead)getImmune();
		}
		if (!isDead && isImmune)getHealty();
		chooseADayToMove();
		travel();
	}

	public void chooseADayToMove(){
		if (radio.currentDay==travelDay){
			Random r=new Random();
			travelDay=radio.currentDay + (r.nextInt(5)+1);
		}
	}

		public void travel(){
			chooseTransportation();
			if (transportation == 1) {
				chooseDestinationForFlight();
			} else chooseDestinationForNonFlight();
		}
		public int chooseTransportation() {
			Random r = new Random();
			int rand = r.nextInt(100);
			if (rand < radio.transportationParam) {
				transportation = 1;
			} else {
				transportation = 0;
			}
			return transportation;
		}

		private void chooseDestinationForFlight() {
			ArrayList<Country> destinationCountries = new ArrayList<>();
			for (Country c : radio.nonInfectedCountries) {
				destinationCountries.add(c);
			}
			Random r = new Random();
			int option = r.nextInt(destinationCountries.size());
			location = destinationCountries.get(option);
		}

		private void chooseDestinationForNonFlight() {
			ArrayList<Country> destinationCountries = new ArrayList<>();
			for (Country c : radio.nonInfectedCountries) {
				for (int i = 0; i < location.neighbours.size(); i++) {
					if (c == location.neighbours.get(i)) {
						destinationCountries.add(c);
					}
				}
				Random r = new Random();
				int option = r.nextInt(destinationCountries.size());
				location = destinationCountries.get(option);
			}
		}
	}
