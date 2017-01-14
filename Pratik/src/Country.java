import java.util.ArrayList;

public class Country  {

	int currentDay;
	Country westN;
	Country eastN;
	Country northN;
	Country southN;
	ArrayList<Country> neighbours = new ArrayList<>();

	String name;
	int population;
	int healthyPopulation;
	int sickPopulation;
	int deadPopulation;
	int infectedPopulation;
	ArrayList<Person> person = new ArrayList<>();

	public Country() {
		

	}	

	public void checkInfection(int currentDay){
		this.currentDay=currentDay;

		if (currentDay==1)checkInfectedPeople();
		
		for (int i =0;i<person.size();i++){
			person.get(i).survive();
		}
	}


	public void checkInfectedPeople() {

		for (int i =0;i<person.size();i++){
			if (person.get(i).isInfected){
				person.get(i).infectionDay=0;
				infectedPopulation++;
				healthyPopulation--;
			}
		}

	}


	boolean isInfected(int currentDay) {

		checkInfection(currentDay);
		return (deadPopulation > 0 || sickPopulation > 0) ; // infected olup belli olmayabilir
	}

	public void addNeighbours(Country s, Country n, Country w, Country e){
		neighbours.add(s);
		neighbours.add(n);
		neighbours.add(w);
		neighbours.add(e);
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {

		this.population = population;

	}

	public void setInfectedPopulation(int infectedPopulation) {
		this.infectedPopulation=infectedPopulation;

	}

	public int getInfectedPopulation() {
		// TODO Auto-generated method stub
		return infectedPopulation;
	}

	public int getHealthyPopulation() {
		// TODO Auto-generated method stub
		return healthyPopulation;
	}

	public void setHealthyPopulation(int healthyPopulation) {
		this.healthyPopulation=healthyPopulation;
		// TODO Auto-generated method stub

	}

	public int getSickPopulation() {
		// TODO Auto-generated method stub
		return sickPopulation;
	}

	public void setSickPopulation(int sickPopulation) {
		this.sickPopulation=sickPopulation;		
	}

	public int getdeadPopulation() {
		// TODO Auto-generated method stub
		return deadPopulation;
	}

	public void setdeadPopulation(int deadPopulation) {
		this.deadPopulation=deadPopulation;		
	}



}