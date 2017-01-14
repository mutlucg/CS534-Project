
import java.util.*;

public class Radio implements Visitor {
	int currentDay;
	int worldPopulation;
	int deadCount;
	int sickCount;
	int infectedCount;
	int healthyPopulation;
	int transportationParam;
	ArrayList<Country> nonInfectedCountries = new ArrayList<>();

	public void visit(World world) {
		this.currentDay = world.currentDay;
		this.worldPopulation = world.population;
		this.deadCount = world.deadPopulation;
		this.sickCount = world.sickPopulation;
		this.infectedCount = world.infectedPopulation;
		this.healthyPopulation = world.healthyPopulation;

		checkCountriesForInfection(world);
		getStatistics(world);
	}

	public ArrayList<Country> checkCountriesForInfection(World world) {
		nonInfectedCountries = new ArrayList<>();
		for (int i = 0; i < world.countries.length; i++) {
			for (int j = 0; j < world.countries[0].length; j++) {
				if(!world.countries[i][j].isInfected(currentDay)){
					nonInfectedCountries.add(world.countries[i][j]);
				}
			}
		}
		return nonInfectedCountries;
	}

	public int getCurrentDay(){
		return currentDay;
	}


	public void getStatistics(World world){
		if (currentDay>1){

			worldPopulation=0;
			deadCount=0;
			infectedCount=0;
			sickCount=0;
			healthyPopulation =0;

			for (int i = 0; i < world.countries.length; i++) {
				for (int j = 0; j < world.countries.length; j++) {
					worldPopulation=worldPopulation + world.countries [i][j].population;
					deadCount = deadCount + world.countries [i][j].deadPopulation;
					infectedCount= infectedCount +world.countries [i][j].infectedPopulation;
					sickCount = sickCount+ world.countries [i][j].sickPopulation;
					healthyPopulation = healthyPopulation + world.countries[i][j].healthyPopulation;
				}
			}
		}
		world.population=worldPopulation;
		world.deadPopulation=deadCount;
		world.infectedPopulation=infectedCount;
		world.sickPopulation= sickCount;
		world.healthyPopulation= healthyPopulation;

	}
}
