import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;


public class Display implements ActionListener{

	private World world;
	private Radio radio;

	private JLabel dayLabel;
	private JLabel worldLabel ;
	private JFrame frame;
	private JPanel panel ;
	private JButton nextDay;

	private int count =0;


	private String countryInfo;

	private JPanel buttonPanel;

	private TextArea countryText;


	public Display(World world, Radio radio){
		this.world=world;
		this.radio=radio;
	}

	public void display(){

		displayDailyInformation();
	}

	public void displayDailyInformation(){
		createFrame();
		createInfoScreen();
		getInfoAboutWorld();


	}

	private void createInfoScreen() {

		dayLabel=new JLabel("---DAY "+ radio.currentDay +"-------------");
		dayLabel.setFont(new Font("Courier New", Font.BOLD, 50));

		worldLabel=new JLabel("<html> Total population:" + radio.worldPopulation + 
				"<br>  Total infected population: "+radio.infectedCount +
				"<br>  Total sick population: "+radio.sickCount+
				"<br>  Total dead population: "+radio.deadCount +"<html>");

		worldLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));

		countryText = new TextArea(collectCountryInfo());
		countryText.setFont(new Font("Courier New", Font.BOLD, 30));
		countryText.setBackground(Color.LIGHT_GRAY);

		panel.add(dayLabel);
		panel.add(countryText);
		panel.add(worldLabel);

		nextDay =new JButton("NEXT DAY");
		buttonPanel.add(nextDay);
		nextDay.addActionListener(this);

	}

	private String collectCountryInfo() {
		countryInfo="";
		int a=1;
		for (int i =0;i<world.countries.length;i++){
			for (int j =0;j<world.countries.length;j++){

				countryInfo= countryInfo +"---- COUNTRY "+a +"-------\n"
						+ " Total Population :"+ world.countries[i][j].population+ "\n"
						+ "Healthy Population: " + world.countries[i][j].healthyPopulation+ "\n"
						+ " Infected Population "+ world.countries[i][j].infectedPopulation+ "\n"
						+ " Sick Population "+ world.countries[i][j].sickPopulation+ "\n"
						+ " Dead Population "+ world.countries[i][j].deadPopulation+ "\n";
				a++;

			}


		}
		return countryInfo;
	}

	public void getInfoAboutWorld(){
		radio.visit(world);
		displayWorldInfo();

	}

	public void createFrame(){
		frame= new JFrame();
		panel= new JPanel();
		buttonPanel =new JPanel();

		panel.setBackground(Color.pink);
		buttonPanel.setBackground(Color.pink);

		frame.add(panel);
		frame.add(buttonPanel,BorderLayout.EAST);

		frame.setVisible(true);
		frame.setSize(1200, 800);
		frame.setDefaultCloseOperation(1);
		frame.setResizable(false);

	}

	public void displayWorldInfo(){

		dayLabel.setText("----------------DAY "+ radio.currentDay+"------------------------");
		worldLabel.setText("<html> Total population:" + radio.worldPopulation + 
				"<br>  Total infected population: "+radio.infectedCount +
				"<br>  Total sick population: "+radio.sickCount+
				"<br>  Total dead population: "+radio.deadCount +"<html>.");
		
		countryText.setText(collectCountryInfo());

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource()==nextDay && count %2 ==0){
			count++;
			world.currentDay=world.currentDay+1;
			getInfoAboutWorld();

		}

		else if (event.getSource()==nextDay && count %2 ==1){
			count++;
			world.currentDay=world.currentDay+1;
			getInfoAboutWorld();

		}

	}

}

