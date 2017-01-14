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
	private JButton continueButton;
	JLabel totalPopulation;
	JTextField nGrid;
	int rateOfInfected;
	int rateOfSuperPeople;
	JTextField numberOfVaccinated;
	int transportParameter;
	JTextField totalPop;
	JLabel dimension;
	JLabel infectionRate;
	JLabel rateOfSuperPeope;
	JLabel numOfVaccinated;
	JLabel transportParam;
	private JPanel questionPanel;
	private JTextField rateOfInfection;
	private JLabel rateOfSuper;
	private JTextField superRate;
	private JLabel rateOfDoc;
	private JTextField doctorRate;
	private JLabel rateOfTransportation;
	private JTextField transParameter;
	private JPanel southPanel;
	private int population;
	private int n;
	private int infectedPercent;
	private int superPercent;
	private int doctorPercent;
	private int vaccinatedNumber;
	private int transportationParameter;
	private String pop;
	private String nGr;
	private String infRate;
	private String supRate;
	private String docRate;
	private String numVac;
	private String transPar;
	boolean isStarted;

	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getInfectedPercent() {
		return infectedPercent;
	}
	public void setInfectedPercent(int infectedPercent) {
		this.infectedPercent = infectedPercent;
	}
	public int getSuperPercent() {
		return superPercent;
	}
	public void setSuperPercent(int superPercent) {
		this.superPercent = superPercent;
	}
	public int getDoctorPercent() {
		return doctorPercent;
	}
	public void setDoctorPercent(int doctorPercent) {
		this.doctorPercent = doctorPercent;
	}
	public int getVaccinatedNumber() {
		return vaccinatedNumber;
	}
	public void setVaccinatedNumber(int vaccinatedNumber) {
		this.vaccinatedNumber = vaccinatedNumber;
	}
	public int getTransportationParameter() {
		return transportationParameter;
	}
	public void setTransportationParameter(int transportationParameter) {
		this.transportationParameter = transportationParameter;
	}


	public Display(){
		radio=new Radio();
	}


	public void getNumbersFromUser(){
		createFrame();
		organizeFrame();

	}

	private void organizeFrame() {
		questionPanel =new JPanel(new GridLayout(8,2));
		southPanel =new JPanel();
		createFields();
		addFields();
		addButton();
		frame.setTitle("WELCOME TO EPIDEMIC SIMULATION! ");
		frame.add(questionPanel);
		frame.add(southPanel,BorderLayout.SOUTH);
		frame.setSize(550, 400);

	}

	private void getValuesFromUser() {
		pop =totalPop.getText();
		nGr=nGrid.getText();
		infRate=rateOfInfection.getText();
		supRate= superRate.getText();
		docRate= doctorRate.getText();
		numVac = numberOfVaccinated.getText();
		transPar = transParameter.getText();
	}

	private void initializeValues() {
		try{
			population = Integer.parseInt( String.valueOf(pop));
			n=Integer.parseInt(nGr);
			infectedPercent=Integer.parseInt(infRate);
			superPercent = Integer.parseInt(supRate);
			doctorPercent = Integer.parseInt(docRate);
			vaccinatedNumber = Integer.parseInt(numVac);
			transportationParameter= Integer.parseInt(transPar);
		}catch(Exception e){
			System.out.println("Not a number");

		}

	}

	private void addButton() {
		continueButton =new JButton("Continue");
		continueButton.setPreferredSize(new Dimension(300,50));
		continueButton.addActionListener(this);
		southPanel.add(continueButton);
	}

	private void createFields() {
		totalPopulation= new JLabel ("  Population :");
		totalPop= new JTextField();

		dimension = new JLabel (" N Grid :" );
		nGrid = new JTextField();

		infectionRate = new JLabel (" Infection Rate :");
		rateOfInfection = new JTextField();

		rateOfSuper = new JLabel (" Super People's Rate :");
		superRate = new JTextField();

		rateOfDoc = new JLabel (" Doctor's Rate");
		doctorRate = new JTextField();

		numOfVaccinated = new JLabel ("<html> Maximum number of people to <br>"
				+ " be vaccinated per day: <html> ");
		numberOfVaccinated = new JTextField ();

		rateOfTransportation = new JLabel (" Transportation Parameter");
		transParameter = new JTextField();
	}
	private void addFields() {

		questionPanel.add(totalPopulation);
		questionPanel.add( totalPop);
		questionPanel.add(dimension);
		questionPanel.add(nGrid);
		questionPanel.add(infectionRate);
		questionPanel.add( rateOfInfection);
		questionPanel.add(rateOfSuper);
		questionPanel.add( superRate);
		questionPanel.add(rateOfDoc);
		questionPanel.add(doctorRate);
		questionPanel.add(numOfVaccinated);
		questionPanel.add( numberOfVaccinated);
		questionPanel.add(rateOfTransportation);
		questionPanel.add( transParameter);
		questionPanel.add(totalPopulation);
		questionPanel.add( totalPop);
		questionPanel.add(dimension);
		questionPanel.add(nGrid);
		questionPanel.add(infectionRate);
		questionPanel.add( rateOfInfection);
		questionPanel.add(rateOfSuper);
		questionPanel.add( superRate);
		questionPanel.add(rateOfDoc);
		questionPanel.add(doctorRate);
		questionPanel.add(numOfVaccinated);
		questionPanel.add( numberOfVaccinated);
		questionPanel.add(rateOfTransportation);
		questionPanel.add( transParameter);

	}

	public void displayStatistics(){
		displayDailyInformation();
	}

	public void displayDailyInformation(){
		createFrame();
		addPanel();
		createInfoScreen();
		getInfoAboutWorld();
	}

	private void addPanel() {
		panel= new JPanel();
		buttonPanel =new JPanel();
		panel.setBackground(new Color(110,100,120));
		buttonPanel.setBackground(new Color(110,100,120));
		frame.add(panel);
		frame.add(buttonPanel,BorderLayout.EAST);
	}

	private void createInfoScreen() {

		dayLabel=new JLabel("---DAY "+ radio.currentDay +"-------------");
		dayLabel.setFont(new Font("Courier New", Font.BOLD, 50));

		worldLabel=new JLabel("<html>  WORLD STATISTICS "+
				"<br> Total population:" + radio.worldPopulation + 
				"<br> Healthy population: "+radio.healthyPopulation +
				"<br> Infected population: "+radio.infectedCount +
				"<br>  Sick population: "+radio.sickCount+
				"<br>  Dead population: "+radio.deadCount +"<html>.");

		worldLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		countryText = new TextArea(collectCountryInfo());
		countryText.setPreferredSize(new Dimension(500,700));
		countryText.setFont(new Font("Courier New", Font.PLAIN, 20));
		countryText.setBackground(new Color(70,10,50));
		countryText.setForeground(new Color(250,210,250));

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

				countryInfo= countryInfo +"\n"+"---- COUNTRY "+a +"-------\n"
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
		frame=new JFrame();
		frame.setSize(1100, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(1);
		frame.setResizable(false);
	}

	public void displayWorldInfo(){
		dayLabel.setText("----------------DAY "+ radio.currentDay+"------------------------");
		worldLabel.setText("<html>  WORLD STATISTICS "+
				"<br> Total population:" + radio.worldPopulation + 
				"<br> Healthy population: "+radio.healthyPopulation +
				"<br> Infected population: "+radio.infectedCount +
				"<br>  Sick population: "+radio.sickCount+
				"<br>  Dead population: "+radio.deadCount +"<html>."); 
		countryText.setText(collectCountryInfo());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == continueButton ){
			getValuesFromUser();
			initializeValues();
			createNewWorld();
		}else if (event.getSource()==nextDay && count %2 ==0 ){
			count++;
			world.currentDay=world.currentDay+1;
			getInfoAboutWorld();
		}else if (event.getSource()==nextDay && count %2 ==1 ){
			count++;
			world.currentDay=world.currentDay+1;
			getInfoAboutWorld();
		}
	}
	private void createNewWorld() {
		world = new World(population,n,infectedPercent,superPercent,doctorPercent,
				vaccinatedNumber,transportationParameter);
		world.createWorld();
		displayStatistics();
	}
}

