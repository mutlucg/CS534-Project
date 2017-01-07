
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
    ArrayList<Person> people;

    public World(int P, int N, int X, int A) {
        population = P;
        countries = new Country[N][N];
        numberOfCountries = N * N;
        transportationParameter = A;
        infectedPopulation = (P * X) / 100;
        healthyPopulation = population - infectedPopulation;
    }

    public void createWorld() {
        createPeople();
        createCountries();
        setCountryPopulations(population, numberOfCountries);
        setCitizens();
        setNeighbours();
    }

    private void setCitizens() {
        int count = 0;
        for (int i = 0; i < countries.length; i++) {
            for (int j = 0; j < countries.length; j++) {
                for (int k = 0; k < countries[i][j].population; k++) {
                    countries[i][j].person.add(people.get(count + k));
                    people.get(count + k).setLocation(countries[i][j]);
                    if(k == countries[i][j].population-1) count += countries[i][j].population;
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
            }
        }
    }

    public void setCountryPopulations(int pop, int num) {
        Random r = new Random();
        int rand;
        int total = 0;
        while (pop > 0) {
            if (total == population) break;
            for (int i = 0; i < countries.length; i++) {
                if (total == population) break;
                for (int j = 0; j < countries.length; j++) {
                    if (pop / num <= 0) {
                        countries[i][j].population += pop;
                        total += pop;
                        num--;
                        break;
                    } else {
                        rand = r.nextInt(pop / num) + 1;
                        countries[i][j].population += rand;
                        pop -= rand;
                        num--;
                        total += rand;
                    }
                    if (num == 0) {
                        num = numberOfCountries;
                    }
                }
            }
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

}
