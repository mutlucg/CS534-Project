import java.util.ArrayList;

public class Country  {
	int currentDay;
	Country westN;
	Country eastN;
	Country northN;
	Country southN;
	ArrayList<Country> neighbours = new ArrayList<>();
	private int population;
	private int healthyPopulation;
	private int sickPopulation;
	private int deadPopulation;
	private int infectedPopulation;
	ArrayList<Person> person = new ArrayList<>();

	boolean isInfected(int currentDay) {
		checkInfection(currentDay);
		return (getDeadPopulation() > 0 || sickPopulation > 0) ;
	}

	public void checkInfection(int currentDay){
		this.currentDay=currentDay;
		if (currentDay==1)checkInfectedPeople();
	}

	public void checkInfectedPeople() {

		for (int i =0;i<person.size();i++){
			if (person.get(i).isInfected()){
				person.get(i).setInfectionDay(0);
				infectedPopulation++;
				healthyPopulation--;
			}
		}
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

	int getInfectedPopulation() {
		return infectedPopulation;
	}

	public int getHealthyPopulation() {
		return healthyPopulation;
	}

	public void setHealthyPopulation(int healthyPopulation) {
		this.healthyPopulation=healthyPopulation;
	}

	public int getSickPopulation() {
		return sickPopulation;
	}

	public void setSickPopulation(int sickPopulation) {
		this.sickPopulation=sickPopulation;
	}

	public int getdeadPopulation() {
		return getDeadPopulation();
	}

	public void setdeadPopulation(int deadPopulation) {
		this.setDeadPopulation(deadPopulation);
	}

	public int getDeadPopulation() {
		return deadPopulation;
	}

	public void setDeadPopulation(int deadPopulation) {
		this.deadPopulation = deadPopulation;
	}



}