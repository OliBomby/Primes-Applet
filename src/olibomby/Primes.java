package olibomby;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Primes extends JApplet implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	GridBagConstraints gbc = new GridBagConstraints();
	DefaultListModel<String> PrimeList = new DefaultListModel<String>();
	JTextField primeAmount = new JTextField(10);
	JTextField primeStart = new JTextField(10);
	JLabel primeAmountlabel = new JLabel("How many primes do you want?");
	JLabel primeStartlabel = new JLabel("Primes need to be above what number?");
	JButton Start = new JButton("Start!");
	JList<String> Primes = new JList<>(PrimeList);
	
	int X;
	int Z;
	double Y;
	
	public static void main(String [] args)
	  {
		Primes theApplet = new Primes();
		theApplet.init();  
		theApplet.start(); 
		JFrame window = new JFrame("Oli's Primer");
		window.setContentPane(theApplet);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();              
		window.setVisible(true);    
		window.setSize(480, 360);
	  }
	
	public void init()
	{
		this.setLocation(0, 0);
		setSize(480, 360);
		setLayout(new GridBagLayout());
		Start.addActionListener(this);
		Start.setActionCommand("Start");
		Primes.setVisibleRowCount(1);
		
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(5, 0, 5, 0);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(primeAmountlabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(primeAmount, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(primeStartlabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(primeStart, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.ipady = 40;
		add(Start, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 16;
		gbc.weightx = 10;
		gbc.weighty = 20;
		gbc.fill = GridBagConstraints.BOTH;
		add(Primes, gbc);
		add(new JScrollPane(Primes), gbc);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if (e.getActionCommand() == "Start")
		{
			System.out.println(e);
			PrimeList.clear();
			try
			{
				Z = Math.abs(Integer.parseInt(primeAmount.getText()));
				Y = Math.floor(Double.parseDouble(primeStart.getText())) + 1;
			}
			catch(NumberFormatException ex){}

			if (Y / 2 == Math.round(Y / 2))
			{
				Y = Y + 1;
			}

			if (Z == 1)
			{
				PrimeList.addElement("Printing " + Z + " prime.");
			}
			else
			{
				PrimeList.addElement("Printing " + Z + " primes.");
			}

			while (X < Z)
			{
				if (Prime(Y))
				{
					PrimeList.addElement((X + 1) + ".     " + Y);
					X = X + 1;
				}
				Y = Y + 2;
				
			}
		}
	}
	
	
	public static boolean Prime(double Numba)
	{
		double Divider = 1;
		double Counter = 0;
		java.util.List<Double> Delers = new ArrayList<Double>();
		while (Counter < Math.round(Math.sqrt(Numba)))
		{
			double Test = Numba / Divider;
			if (Test / Math.round(Test) == 1)
			{
				Delers.add(Test);
				Delers.add(Divider);
			}
			Divider = Divider + 1;
			if (Delers.size() > 2 || Numba == 1)
			{
				return false;
			}
			Counter = Counter + 1;
		}
		return true;
	}
}
