<<<<<<< HEAD

=======
>>>>>>> fb2651ab46d9f9d41b7ed36f1c1aa4f8439ffbca

public class Country {
	Country westN;
	Country eastN;
	Country northN;
	Country southN;
	
	int xPos, yPos;
	
	int population;
	int healthyPopulation;
	int sickPopulation;
	int deadPopulation;
	int infectedPopulation;
	

	public Country() {
		population = 0;

	}
	
	boolean isInfected(){
		if(infectedPopulation>0 ||deadPopulation>0 || sickPopulation>0)
			return true;

		return false;
	}

	public int getPopulation() {
		// TODO Auto-generated method stub
		return population;
	}

	public void setPopulation(int population) {
		this.population=population;		
	}
}