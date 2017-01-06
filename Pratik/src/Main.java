
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int people;
	static  int n;
	static int rate;
	static int day;
	
	public static void main(String[] args) {
		System.out.println("people:");
		people=scanner.nextInt();
		System.out.println("n:");
		n=scanner.nextInt();
		System.out.println("rate:");
		rate=scanner.nextInt();
		System.out.println("Day");
		day=scanner.nextInt();


		World world=new World(people,n,rate);

		Person person[]=new Person[people];
		for (int i=0;i<people;i++){
			person[i]=new Person(world);
		}

		world.createWorld (person);


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

		}


	}



}
