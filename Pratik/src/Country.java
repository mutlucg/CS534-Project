import java.util.ArrayList;

public class Country {

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

	public void checkInfection(){

		checkInfectedPeople();
		checkSickPeople();
		checkDeadPeople();

	}

	public void checkSickPeople() {

		for (int i =0;i<person.size();i++){
			if (person.get(i).isSick==true){
				infectedPopulation--;
				sickPopulation++;
				healthyPopulation--;

			}

		}

	}

	public void checkInfectedPeople() {

		for (int i =0;i<person.size();i++){
			if (person.get(i).isInfected==true && person.get(i).infectionDay==currentDay) {
				infectedPopulation++;
				healthyPopulation--;
			}
		}

	}

	public void checkDeadPeople(){

		for (int i =0;i<person.size();i++){
			if (person.get(i).isDead==true) {
				person.remove(i);
				deadPopulation++;
				healthyPopulation--;
			}
		}
	}
	boolean isInfected() {
		
		checkInfection();

		return (infectedPopulation > 0 || deadPopulation > 0 || sickPopulation > 0);
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
}