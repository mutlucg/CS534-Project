
import java.util.ArrayList;
import java.util.Random;

public class Person {

    Country location;
    private Radio radio;
    private int infectionDay;
    boolean isInfected;
    boolean isSick;
    boolean isDead;
    boolean isImmune;
    boolean looksInfectious;
    int nextTravelDay;
    int currentDay;
    int transportation;

    public Person() {
        radio = new Radio();
    }

    public void setLocation(Country country) {
        location = country;

    }

    public void setCurrentDay() {
        this.currentDay = radio.currentDay;
    }

    /*
        public void getInfected() {

            if (currentDay==nextTravelDay){
                Random r = new Random();
                int infect = r.nextInt(100);
                if ( infect < 40){
                    this.isInfected = true;
                    infectionDay=world.getCurrentDay();
                    world.setInfectedPopulation(world.getInfectedPopulation()+1);

                }
                else
                    this.isInfected = false;
            }

        }

        public boolean getSick(){
            if (currentDay-infectionDay==6){

                isSick=true;
                looksInfectious= true;

                world.setInfectedPopulation(world.getInfectedPopulation()-1);
                world.setSickPopulation(world.getSickPopulation()+1);

            }
            return isSick;
        }

        public void die() {

            if(world.getCurrentDay()-infectionDay==14){

                Random r = new Random();
                int infect = r.nextInt(100);
                if (infect < 25){
                    isDead=true;
                    world.setSickPopulation(world.getSickPopulation()-1);
                    world.setPopulation(world.getPopulation()-1);
                    world.setDeadPopulation(world.getDeadPopulation()+1);



                }
            }

        }

        public void getImmune(){

            if (world.getCurrentDay()-infectionDay==16){
                isImmune=true;
                isSick=false;
                looksInfectious= false;
                world.setSickPopulation(world.getSickPopulation()-1);

            }

        }


        public void getHealty(){

            if (world.getCurrentDay()-infectionDay==18){
                isImmune=false;
                isInfected=false;
                world.setHealthyPopulation(world.getHealthyPopulation()+1);
                //	world.setInfectedPopulation(world.getInfectedPopulation()-1);
            }

        }

        public void survive(){

            if(!isInfected && !isImmune)	getInfected();
            if(isInfected) getSick();
            if (isSick) {
                die();
                if(!isDead)getImmune();
            }
            if (!isDead && isImmune)getHealty();
            chooseADayToMove();
        }

        public void chooseADayToMove(){
            if (world.getCurrentDay()==chosenDay){
                Random r=new Random();
                chosenDay=world.getCurrentDay() + (r.nextInt(5)+1);
                chooseDestination();
            }
        }*/

    public void travel(){
        chooseTransportation();
        if (transportation == 1) {
            chooseDestinationForFlight();
        } else chooseDestinationForNonFlight();
    }
    public int chooseTransportation() {
        Random r = new Random();
        int rand = r.nextInt(100);
        if (rand < radio.transportationParam) {
            transportation = 1;
        } else {
            transportation = 0;
        }
        return transportation;
    }

    private void chooseDestinationForFlight() {
        ArrayList<Country> destinationCountries = new ArrayList<>();
        for (Country c : radio.nonInfectedCountries) {
            destinationCountries.add(c);
        }
        Random r = new Random();
        int option = r.nextInt(destinationCountries.size());
        location = destinationCountries.get(option);
    }

    private void chooseDestinationForNonFlight() {
        ArrayList<Country> destinationCountries = new ArrayList<>();
        for (Country c : radio.nonInfectedCountries) {
            for (int i = 0; i < location.neighbours.size(); i++) {
                if (c == location.neighbours.get(i)) {
                    destinationCountries.add(c);
                }
            }
            Random r = new Random();
            int option = r.nextInt(destinationCountries.size());
            location = destinationCountries.get(option);
        }
    }
}
