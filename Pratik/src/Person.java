
import java.util.ArrayList;
import java.util.Random;

public class Person {

	Country location;
	public Radio radio;
	int infectionDay;
	boolean isInfected;
	boolean isSick;
	boolean isDead;
	boolean isImmune;
	boolean looksInfectious;
	int currentDay;
	int transportation;
	int travelDay;

	public Person() {
		radio = new Radio();
	}

	public void setLocation(Country country) {
		location = country;

	}

	public int getCurrentDay(){
		return radio.currentDay;

	}
	public void setCurrentDay() {
		this.currentDay = radio.currentDay;
	}


	public void getInfected() {

		Random r = new Random();
		int infect = r.nextInt(100);
		if ( infect < 40){
			this.isInfected = true;
			location.setInfectedPopulation(location.getInfectedPopulation()+1);
			location.setHealthyPopulation(location.getHealthyPopulation()-1);

		}
		else
			this.isInfected = false;


	}

	public boolean getSick(){
		if (currentDay-infectionDay==6){
			isSick=true;
			looksInfectious= true;

			location.setInfectedPopulation(location.getInfectedPopulation()-1);
			location.setSickPopulation(location.getSickPopulation()+1);



		}
		return isSick;
	}

	public void die() {


		if(currentDay-infectionDay==14){

			Random r = new Random();
			int infect = r.nextInt(100);
			if (infect < 25){
				isDead=true;

				location.setSickPopulation(location.getSickPopulation()-1);
				location.setdeadPopulation(location.getdeadPopulation()+1);


			}
		}

	}

	public void getImmune(){

		if (currentDay-infectionDay==16){
			isImmune=true;
			isSick=false;
			looksInfectious= false;

		//	location.setSickPopulation(location.getSickPopulation()-1);
			//location.setHealthyPopulation(location.getHealthyPopulation()+1);

			//location.setInfectedPopulation(location.getInfectedPopulation()-1);

		}

	}


	public void getHealty(){

		if (currentDay-infectionDay==18){
			isImmune=false;
			isInfected=false;

			location.setSickPopulation(location.getSickPopulation()-1);
			location.setHealthyPopulation(location.getHealthyPopulation()+1);


		}

	}

	public void survive(){

		currentDay=location.currentDay;
		chooseADayToMove();
		travel();
		if(!isInfected && infectionDay!=0 && !isImmune && travelDay==currentDay)	getInfected();
		if(isInfected) getSick();
		if (isSick) {
			die();
			if(!isDead)getImmune();
		}
		if (!isDead && isImmune)getHealty();

	}

	public void chooseADayToMove(){
		if (currentDay==1||currentDay==travelDay){

			Random r=new Random();
			travelDay=currentDay + (r.nextInt(5)+1);
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
			if(destinationCountries.size()>0){
				int option = r.nextInt(destinationCountries.size());

				location = destinationCountries.get(option);
				move();
				
			}
		}
	}

	private void move() {
		location.person.add(this);
		location.setPopulation(location.getPopulation()+1);
		if (isInfected) location.setInfectedPopulation(location.getInfectedPopulation()+1);
		else if (isSick) location.setSickPopulation(location.getSickPopulation()+1);
		else location.setHealthyPopulation(location.getHealthyPopulation()+1);
		
	}
}