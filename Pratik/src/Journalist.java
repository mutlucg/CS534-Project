
public class Journalist implements Visitor  {
	int currentDay;

	public void visit(World world) {
	this.currentDay=world.currentDay;
		
	}
	public void visit(Person person){
		person.currentDay=currentDay;
	}

}
