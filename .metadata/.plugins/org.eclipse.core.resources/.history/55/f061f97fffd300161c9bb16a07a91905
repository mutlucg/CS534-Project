package example;

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
	int currentDay;
	Person [] person;


	public World(int P, int N, int X) {
		population = P;
		countries = new Country[N][N];
		numberOfCountries = N * N;
		infectedPopulation = (P * X) / 100;
		healthyPopulation=population-infectedPopulation;
		setCountryPopulations();
		setNeigbours();
	}

	private void setNeigbours() {

		for (int i = 0; i < countries.length; i++) {
			for (int j = 0; j < countries.length; j++) {
				if (i==0){
					countries[i][j].eastN=countries [i+1][j];
					if (j==0){
						countries[i][j].westN=countries [countries.length-1][countries.length-1];
						countries[i][j].southN=countries [i][j+1];
						countries[i][j].northN = countries [i][countries.length-1];
					}else if (j==countries.length-1){
						countries[i][j].westN=countries [countries.length-1][j];
						countries[i][j].southN=countries [i][0];
						countries[i][j].northN = countries [i][j-1];
					}
					else{
						countries[i][j].westN=countries [countries.length-1][j];
						countries[i][j].southN=countries [i][j+1];
						countries[i][j].northN = countries [i][j-1];
					}
				}


				else if (j==0){
					countries[i][j].southN=countries [i][j+1];
					countries[i][j].westN=countries [i-1][j];
					if(i==countries.length-1){
						countries[i][j].eastN=countries [0][j];
						countries[i][j].northN = countries [i][countries.length-1];
					}else {
						countries[i][j].eastN=countries [i+1][j];
						countries[i][j].northN = countries [i][j-1];
					}


				}
				else if (i==countries.length-1){
					countries[i][j].northN = countries [i][j-1];
					countries[i][j].westN=countries [i-1][j];

					if (j == countries.length-1){
						countries[i][j].eastN=countries [0][j];
						countries[i][j].southN=countries [i][0];
					}

					else{
						countries[i][j].eastN=countries [i+1][j];
						countries[i][j].southN=countries [0][j+1];

					}

				}else if(i==countries.length-1) {
					countries[i][j].westN=countries [i-1][j];
					countries[i][j].eastN=countries [0][j];
					countries[i][j].southN=countries [i][j+1];
					countries[i][j].northN = countries [i][j-1];
				}
			}
		}



	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}


	public void createWorld(Person [] person) {
		this.person=person;
		int assignedPopulation=0;
		for (int i = 0; i < countries.length; i++) {
			for (int j = 0; j < countries.length; j++) {

				for (int a=0;a<countries[i][j].population;a++){
					person[a+assignedPopulation].setPosition(countries [i][j]);
				}	
				assignedPopulation= assignedPopulation+countries[i][j].population;
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
					z = r.nextInt(tempPopulation)+1;					
					if (countries[i][j]==null){
						countries[i][j] = new Country(z);
						tempPopulation -= z;
					}else if (countries[i][j].getPopulation()+z<=numberOfCountries){
						countries[i][j].setPopulation(countries[i][j].getPopulation()+z);
						tempPopulation -= z;
					}

					//tempNumberOfCountries--;
				}
			}
			tempNumberOfCountries = numberOfCountries;
		}
	}

	public int getHealthyPopulation() {
		return healthyPopulation;
	}

	public void setHealthyPopulation(int healthyPopulation) {
		this.healthyPopulation = healthyPopulation;
	}

	public int getSickPopulation() {
		return sickPopulation;
	}

	public void setSickPopulation(int sickPopulation) {
		this.sickPopulation = sickPopulation;
	}

	public int getDeadPopulation() {
		return deadPopulation;
	}

	public void setDeadPopulation(int deadPopulation) {
		this.deadPopulation = deadPopulation;
	}

	public int getInfectedPopulation() {
		return infectedPopulation;
	}

	public void setInfectedPopulation(int infectedPopulation) {
		this.infectedPopulation = infectedPopulation;
	}

	public int getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}


}



