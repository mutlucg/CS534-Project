
import java.util.*;

public class World implements Visitable {
	public int days = 1;
	static public Country[][] countries;
	static int transportationParameter;
	int numberOfCountries;
	int population;
	int healthyPopulation;
	int sickPopulation;
	int deadPopulation;
	int infectedPopulation;
	int currentDay;
	int superPopulation;
	ArrayList<Person> people;
	private int numberOfDoctors;

	public World(int P, int N, int X,int S,int D, int A) {
		currentDay=1;
		population = P;
		countries = new Country[N][N];
		numberOfCountries = N * N;
		superPopulation= (P*S) / 100;
		numberOfDoctors = (D*P) /100;
		transportationParameter = A;
		infectedPopulation = (P * X) / 100;
		healthyPopulation = population - infectedPopulation;
	}

	public void createWorld() {
		createPeople();
		makePeopleSuper();
		makePeopleInfected();
		createCountries();
		setCountryPopulations(population, numberOfCountries);
		setCitizens();
		setNeighbours();
	}

	public void makePeopleSuper(){
		for (int i=0;i<superPopulation;i++){
			people.get(i).setSuper(true);

		}

	}

	public void makePeopleInfected(){
		int infected=infectedPopulation;
		for (int i=0;i<population;i++){
			if(	!people.get(i).isSuper() && infected > 0){
				people.get(i).setInfected(true);
				people.get(i).setInfectionDay(0);
				infected--;
				}

			}

		}
	

	private void setCitizens() {
		int count = 0;
		for (int i = 0; i < countries.length; i++) {
			for (int j = 0; j < countries.length; j++) {
				for (int k = 0; k < countries[i][j].population; k++) {
					countries[i][j].person.add(people.get(count + k));
					people.get(count + k).setLocation(countries[i][j]);
					if(k == countries[i][j].population-1) {
						count += countries[i][j].population;
					}
				}
			}
		}
	}

	public void createPeople() {
		people = new ArrayList<>();

		for (int i = 0; i < population; i++) {
			people.add(new Person());

		}

	}


	public void createCountries() {
		for (int i = 0; i < countries.length; i++) {
			for (int j = 0; j < countries.length; j++) {
				countries[i][j] = new Country();
				countries[i][j].currentDay=currentDay;
			}
		}
	}

	public void setCountryPopulations(int pop, int num) {

		int numOfCountries=num;
		int tempPop=pop;
		int random=0;

		Random r = new Random();

		while (tempPop>0){
			for(int i=0;i<countries.length;i++){
				for(int j=0;j<countries.length;j++){
					if(countries[i][j].population==0){
						random=  r.nextInt(tempPop/numOfCountries)+1;
						countries[i][j].population = random;
						countries[i][j].healthyPopulation = countries[i][j].population ;
						tempPop= tempPop-random;

						numOfCountries--;
					}else if (tempPop>0) {
						random =r.nextInt(1)+1;
						if (tempPop-random>=0){
							countries[i][j].population = countries[i][j].population + random;
							countries[i][j].healthyPopulation =countries[i][j].population ;
							tempPop= tempPop-random;

						}
					}
				}

			}
			numOfCountries=numberOfCountries;
		}

	}

	private void setNeighbours() {
		if(numberOfCountries == 1){

		}else if(numberOfCountries == 2) {
			setCornersNeighbours();
		}else {
			setCornersNeighbours();
			setEdgeNeighbours();
			setMiddlesNeighbours();
		}
	}

	public void setCornersNeighbours() {
		for (int i = 0; i < countries.length; i++) {
			for (int j = 0; j < countries.length; j++) {
				if (i == 0 && j == 0) {
					countries[i][j].southN = countries[i + 1][j];
					countries[i][j].northN = countries[countries.length - 1][j];
					countries[i][j].westN = countries[i][countries.length - 1];
					countries[i][j].eastN = countries[i][j + 1];
					countries[i][j].addNeighbours(countries[i + 1][j], countries[countries.length - 1][j],
							countries[i][countries.length  - 1], countries[i][j + 1]);
				} else if (i == 0 && j == countries.length - 1) {
					countries[i][j].southN = countries[i + 1][j];
					countries[i][j].northN = countries[countries.length - 1][j];
					countries[i][j].westN = countries[i][j - 1];
					countries[i][j].eastN = countries[i][0];
					countries[i][j].addNeighbours(countries[i + 1][j], countries[countries.length - 1][j],
							countries[i][j - 1], countries[i][0]);
				} else if (i == countries.length - 1 && j == 0) {
					countries[i][j].southN = countries[0][j];
					countries[i][j].northN = countries[i - 1][j];
					countries[i][j].westN = countries[i][countries.length - 1];
					countries[i][j].eastN = countries[i][j + 1];
					countries[i][j].addNeighbours(countries[0][j], countries[i - 1][j],
							countries[i][countries.length - 1], countries[i][j + 1]);
				} else if (i == countries.length - 1 && j == countries.length - 1) {
					countries[i][j].southN = countries[0][j];
					countries[i][j].northN = countries[i - 1][j];
					countries[i][j].westN = countries[i][j - 1];
					countries[i][j].eastN = countries[i][0];
					countries[i][j].addNeighbours(countries[0][j], countries[i - 1][j],
							countries[i][j - 1], countries[i][0]);

				}
			}
		}
	}

	public void setEdgeNeighbours() {
		for (int i = 0; i < countries.length; i++) {
			for (int j = 0; j < countries.length; j++) {
				if (i == 0 && j != 0 && j != countries.length - 1) {
					countries[i][j].southN = countries[i + 1][j];
					countries[i][j].northN = countries[countries.length - 1][j];
					countries[i][j].westN = countries[i][j - 1];
					countries[i][j].eastN = countries[i][j + 1];
					countries[i][j].addNeighbours(countries[i + 1][j], countries[countries.length - 1][j],
							countries[i][j - 1], countries[i][j + 1]);

				} else if (i == countries.length - 1 && j != 0 && j != countries.length - 1) {
					countries[i][j].southN = countries[0][j];
					countries[i][j].northN = countries[i - 1][j];
					countries[i][j].westN = countries[i][j - 1];
					countries[i][j].eastN = countries[i][j + 1];
					countries[i][j].addNeighbours(countries[0][j], countries[i - 1][j],
							countries[i][j - 1], countries[i][j + 1]);

				} else if (j == 0 && i != 0 && i != countries.length - 1) {
					countries[i][j].southN = countries[i + 1][j];
					countries[i][j].northN = countries[i - 1][j];
					countries[i][j].westN = countries[i][countries.length - 1];
					countries[i][j].eastN = countries[i][j + 1];
					countries[i][j].addNeighbours(countries[i + 1][j], countries[i - 1][j],
							countries[i][countries.length - 1], countries[i][j + 1]);

				} else if (j == countries.length - 1 && i != 0 && i != countries.length - 1) {
					countries[i][j].southN = countries[i + 1][j];
					countries[i][j].northN = countries[i - 1][j];
					countries[i][j].westN = countries[i][j - 1];
					countries[i][j].eastN = countries[i][0];
					countries[i][j].addNeighbours(countries[i + 1][j], countries[i - 1][j],
							countries[i][j - 1], countries[i][0]);
				}
			}
		}
	}

	public void setMiddlesNeighbours() {
		for (int i = 0; i < countries.length; i++) {
			for (int j = 0; j < countries.length; j++) {
				if (j != 0 && j != countries.length - 1 && i != 0 && i != countries.length - 1) {
					countries[i][j].southN = countries[i + 1][j];
					countries[i][j].northN = countries[i - 1][j];
					countries[i][j].westN = countries[i][j - 1];
					countries[i][j].eastN = countries[i][j + 1];
					countries[i][j].addNeighbours(countries[i + 1][j], countries[i - 1][j],
							countries[i][j - 1], countries[i][j + 1]);
				}
			}
		}
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

	public int getCurrentDay() {
		// TODO Auto-generated method stub
		return currentDay;
	}

	public int getDeadPopulation() {
		// TODO Auto-generated method stub
		return deadPopulation;
	}

}