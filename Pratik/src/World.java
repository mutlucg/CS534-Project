


import java.util.*;

public class World {
	public int days = 1;
	public Country[][] countries;
	int numberOfCountries;
	int population;
	int healthyPopulation;
	int sickPopulation;
	int deadPopulation;
	int infectedPopulation;

	public World(int P, int N, int X) {
		population = P;
		countries = new Country[N][N];
		numberOfCountries = N * N;
		infectedPopulation = P * (X / 100);
		setCountryPopulations();
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public void createWorld() {
		for (int i = 0; i < countries.length; i++) {
			for (int j = 0; j < countries.length; j++) {

			}
		}

	}

	public void setCountryPopulations() {
		Random r = new Random();
		int tempPopulation = population;
		int tempNumberOfCountries = numberOfCountries;
		int z = 0;
		while (tempPopulation > 0) {
			for (int i = 0; i < countries.length; i++) {
				for (int j = 0; j < countries.length; j++) {
					if(tempPopulation <= 0) break;
					//System.out.println(tempNumberOfCountries+"***");
					//System.out.println(tempPopulation);
					z = r.nextInt(tempPopulation / tempNumberOfCountries)+1;					
				if (countries[i][j]==null){
					countries[i][j] = new Country(z);
				}else if (countries[i][j].population+z<=numberOfCountries){
					countries[i][j].population=countries[i][j].population+z;
				}
					tempPopulation -= z;
					//tempNumberOfCountries--;
				}
			}
			tempNumberOfCountries = numberOfCountries;
		}
	}

}

class Person {
	Country position;
	int infectionDay;
	boolean isInfected;
	boolean isSick;
	boolean isDead;
	boolean isImmune;
	boolean looksInfectious;

	public void die() {

	}

	public void getInfected() {
		if (position.isInfected) {
			Random r = new Random();
			int infect = r.nextInt(100);
			if (infect < 40)
				this.isInfected = true;
			else
				this.isInfected = false;
		}
	}
}

class Country {
	Country westN;
	Country eastN;
	Country northN;
	Country southN;
	boolean isInfected;
	int population;
	int healthyPopulation;
	int sickPopulation;
	int deadPopulation;
	int infectedPopulation;

	public Country(int p) {
		population = p;

	}
}
