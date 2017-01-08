import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JLabel label;
	private JButton startButton;

	private JTextField pop;
	private JTextField grid;
	private JLabel gridLabel;
	private JLabel populationLabel;
	private JTextField sicknessRate;
	private JLabel rateLabel;
	private int totalPopulation;
	private int NGrid;
	private int rateOfSickness;
	World world;

	private JLabel totalPop;
	private JLabel deadPopulation;
	private JLabel sickPopulation;
	private JLabel infectedPopulation;
	private boolean isInfoDisplayMode;
	private JButton next;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		
		if (e.getSource()==next){
			world.currentDay=world.currentDay+1;
		}



	}

	public void contunie() {

		pop= new JTextField();
		populationLabel=new JLabel("Population");

		grid= new JTextField();
		gridLabel=new JLabel("N");

		sicknessRate= new JTextField();
		rateLabel=new JLabel("Rate of Sickness");

		JComponent[] components = new JComponent[] {	populationLabel,pop,gridLabel,grid,rateLabel,sicknessRate	};
		JOptionPane.showMessageDialog(null, components, "	WELCOME TO EPIDEMIC SIMULATION",  JOptionPane.QUESTION_MESSAGE);

		totalPopulation = Integer.parseInt(pop.getText());
			NGrid = Integer.parseInt(grid.getText());
		rateOfSickness = Integer.parseInt(sicknessRate.getText());

	
		if (JOptionPane.OK_OPTION==0) isInfoDisplayMode=true;
		getStatistics();

	}

	public void getStatistics() {
		frame = new JFrame(" EPIDEMIC SIMULATION");
		panel =new JPanel();
		frame.add(panel);

		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		label=new JLabel("<html>Welcome to <br> epidemic simulation<br>Please click <br> start to get <br> into simulation<html>.");
		label.setFont(new Font("Courier New", Font.BOLD, 40));
		panel.add(label);
		panel.setBackground(Color.MAGENTA);

		next =new JButton("Next Day");
		panel.add(startButton);
		next.addActionListener(this);
	
	if (isInfoDisplayMode){
		displayInformationForEachDay();
	}

	}

	public void displayInformationForEachDay() {
		frame.setSize(600, 600);
		label.setText("Day "+ world.currentDay);
		totalPop=new JLabel ("Total population: " +world.population);
		deadPopulation=new JLabel ("Number of dead people: " +world.deadPopulation);
		sickPopulation=new JLabel ("Number of sick People: " +world.sickPopulation);
		infectedPopulation=new JLabel ("Infected population: " +world.infectedPopulation);


		panel.add(totalPop);
		panel.add(deadPopulation);
		panel.add(sickPopulation);
		panel.add(infectedPopulation);


	}



	public int getTotalPopulation() {
		return totalPopulation;
	}

	public void setTotalPopulation(int totalPopulation) {
		this.totalPopulation = totalPopulation;
	}

	public int getNGrid() {
		return NGrid;
	}

	public void setNGrid(int nGrid) {
		NGrid = nGrid;
	}

	public int getRateOfSickness() {
		return rateOfSickness;
	}

	public void setRateOfSickness(int rateOfSickness) {
		this.rateOfSickness = rateOfSickness;
	}

}