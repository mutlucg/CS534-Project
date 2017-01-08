
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
    }

    public ArrayList<Country> checkCountriesForInfection(World world) {
        for (int i = 0; i < world.countries.length; i++) {
            for (int j = 0; j < world.countries[0].length; j++) {
                if(!world.countries[i][j].isInfected()){
                    nonInfectedCountries.add(world.countries[i][j]);
                }
            }
        }
        return nonInfectedCountries;
    }

}
