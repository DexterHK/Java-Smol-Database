package StudentenVerwaltung.UI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
public class GUI implements ActionListener{

	private JButton studentbtn;
	private JButton retrievebtn;
	private JTextField lastName;
	private JTextField firstName;
	private JTextField numberOfSemesters;
	private JTextField MatriculationField;
	private CLI cli;
	
	public void show() throws IOException
	{
		
	
		JFrame jf = new JFrame("Student Panel");
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setSize(1200, 720);
		
		BufferedImage image = ImageIO.read(new File("src/Icon/icon.jfif"));
		jf.setIconImage(image);
		
		JLabel jl = new JLabel("Student Section");
		jl.setForeground(Color.WHITE);
		jf.add(jl,"North");
		JPanel jp = new JPanel();
		jf.add(jp);
		 studentbtn = new JButton("Add Student");
		 studentbtn.addActionListener(this);
		studentbtn.setLayout(null);
		studentbtn.setLocation(0,0);
		
		//Testing Theory
		JLabel LastNameLabel = new JLabel("Last name:");
		jp.add(studentbtn);
		jp.add(LastNameLabel);
		LastNameLabel.setForeground(Color.WHITE);
		 lastName = new JTextField(12);
		jp.add(lastName);
		JLabel firstNameLabel = new JLabel("First name:");
		jp.add(firstNameLabel);
		firstNameLabel.setForeground(Color.WHITE);
		 firstName = new JTextField(12);
		jp.add(firstName);
		JLabel NumberOfSemesterLabel = new JLabel("Number of Semester:");
		jp.add(NumberOfSemesterLabel);
		NumberOfSemesterLabel.setForeground(Color.WHITE);
		 numberOfSemesters = new JTextField(12);
		jp.add(numberOfSemesters);
		jf.getContentPane().setBackground(Color.BLACK);
		jp.setBackground(Color.BLACK);
		jp.setSize(1000,100);
		
		//TWO TEST
		JPanel jpTwo = new JPanel();
		retrievebtn = new JButton("retrieve");
		jpTwo.add(retrievebtn);
		retrievebtn.addActionListener(this);
		retrievebtn.setLayout(null);
		retrievebtn.setLocation(10,0);
		jf.add(jpTwo);
		

		JLabel MatriculationLabel = new JLabel("Matriculation Number :");
		jpTwo.add(MatriculationLabel);
		MatriculationLabel.setForeground(Color.WHITE);
		MatriculationField = new JTextField(12);
		jpTwo.add(MatriculationField);
		jpTwo.setBackground(Color.BLACK);
		jpTwo.setSize(1000,100);

		jf.setVisible(true);
		
	}
	
		public void actionPerformed(ActionEvent e) {
			System.out.println(((JButton)e.getSource()).getText());
			
			cli = new CLI();
			if (e.getSource() == studentbtn) {
		cli.adduser(lastName.getText(),firstName.getText(),Integer.parseInt(numberOfSemesters.getText()));
			}
			
		}
}
