
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int people;
	static int n;
	static int rate;
	static int day;

	public static void main(String[] args) {
		
					
		
		
		World world=new World(5, 2, 20, 0);
		world.createWorld();
		
		
		/*	
		
		for(int i=0;i<world.countries.length;i++){
			for (int j=0;j<world.countries.length;j++){
				System.out.println(world.countries[i][j].population);
			}
}
		int a=0;
		while(a!=20){

			System.out.println("-------------------DAY--"+world.getCurrentDay()+"----------");
			System.out.println("WorldDead: "+world.getDeadPopulation());
			System.out.println("World Healty:"+world.healthyPopulation);
			System.out.println(world.infectedPopulation);
			System.out.println(world.sickPopulation);
			System.out.println(world.population);
		
		
		
			
			for(int i=0;i<world.countries.length;i++){
				for (int j=0;j<world.countries.length;j++){
					
					System.out.println("---Country "+i+j);
					
					
					world.countries[i][j].currentDay=world.getCurrentDay();
							world.countries[i][j].checkInfection();
					System.out.println("Population :" + world.countries[i][j].population);
					System.out.println("Healty :" + world.countries[i][j].healthyPopulation);
					System.out.println("Infected :" + world.countries[i][j].infectedPopulation);
					System.out.println("Sick :" + world.countries[i][j].sickPopulation);
					System.out.println("Dead :" + world.countries[i][j].deadPopulation);

				}



			}
			world.currentDay=world.currentDay+1;
			a++;
			}
		
		
	

		Gui gui=new Gui();

		gui.contunie();

		World world =new World(gui.getTotalPopulation(),gui.getNGrid(),
				gui.getRateOfSickness(),0);
		System.out.println(gui.getTotalPopulation());
		System.out.println(world.population);
		world.createWorld();
		gui.world=world;




	
		for(int i=0;i<world.countries.length;i++){
			for (int j=0;j<world.countries.length;j++){
				System.out.println(world.countries[i][j].population);
			}
}
			System.out.println("people:");
		people=scanner.nextInt();
		System.out.println("n:");
		n=scanner.nextInt();
		System.out.println("rate:");
		rate=scanner.nextInt();
		System.out.println("Day");
		day=scanner.nextInt();



		World world=new World(people,n,rate);
		world.createWorld();


		}
			int a=1;
		while(!(a==day)){
			for (int i=0;i<people;i++){
				person[i].survive();
			}
			world.setCurrentDay(a);
			System.out.println("-------------------DAY--"+world.getCurrentDay()+"----------");
			System.out.println("WorldDead: "+world.getDeadPopulation());
			System.out.println("World Healty:"+world.getHealthyPopulation());
			System.out.println(world.getInfectedPopulation());
			System.out.println(world.getSickPopulation());
			System.out.println(world.getPopulation());
			a++;
			int b=1;
			for(int i=0;i<world.countries.length;i++){
				for (int j=0;j<world.countries.length;j++){
					System.out.println("---Country "+b);
					b++;
					System.out.println("Population :" + world.countries[i][j].population);
					System.out.println("Healty :" + world.countries[i][j].healthyPopulation);
					System.out.println("Infected :" + world.countries[i][j].infectedPopulation);
					System.out.println("Sick :" + world.countries[i][j].sickPopulation);
					System.out.println("Dead :" + world.countries[i][j].deadPopulation);

				}



			}
		 */
	}
}





