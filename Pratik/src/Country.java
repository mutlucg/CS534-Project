import java.util.ArrayList;

public class Country {

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

    boolean isInfected() {
        return infectedPopulation > 0 || deadPopulation > 0 || sickPopulation > 0;
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