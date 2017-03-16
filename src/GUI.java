import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI extends JFrame {
 JLabel label1,label2,label3,label4,label5,dep;
 JTextField Fn,Ln,Cp,de;
 JButton Add,Cle,Prt;
 JComboBox combo;
 ButtonGroup group;
 CheckboxGroup ingGrp;
 
	public GUI(){
	setTitle("ClientEditor");
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setPreferredSize(new Dimension(500,300));
	pack();
	createContents();
	setVisible(true);
	
	
	
	}
	
	private void createContents()
	{
		label1 = new JLabel("Title",SwingConstants.CENTER);
		combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[]{"Mr.","Ms.","Mrs.","Dr.","Col.","Prof."}));
		label2 = new JLabel("First Name",SwingConstants.CENTER);
		Fn = new JTextField();
		label3 = new JLabel("Last Name",SwingConstants.CENTER);
		Ln = new JTextField();
		label4 = new JLabel("Gender",SwingConstants.CENTER);
	
		JRadioButton option1 = new JRadioButton("Male");
		JRadioButton option2 = new JRadioButton("Female");
		JRadioButton option3 = new JRadioButton("Other");
		
		/*
		Checkbox option1= new Checkbox("Male",ingGrp,false);
		Checkbox option2= new Checkbox("Female",ingGrp,false);
		Checkbox option3= new Checkbox("Other",ingGrp,false);
		*/
		option1.setActionCommand(getName());
		option2.setActionCommand(getName());
		option3.setActionCommand(getName());
		
		group = new ButtonGroup();
		group.add(option1);
		group.add(option2);
		group.add(option3);
		
		
		
		
		JPanel space=new JPanel();
		space.setLayout(new GridLayout(1,3));
		space.add(option1);
		space.add(option2);
		space.add(option3);
		
		dep = new JLabel("Department",SwingConstants.CENTER);
		de = new JTextField();
		
		label5 = new JLabel("Phone Number",SwingConstants.CENTER);
		Cp = new JTextField();
		Add= new JButton("ADD");
		Cle= new JButton("CLE");
		Prt= new JButton("PRINT");
		
		JPanel Container = new JPanel();
		Container.setLayout(new GridLayout(7,2));
		
		Container.add(label1);
		Container.add(combo);
		Container.add(label2);
		Container.add(Fn);
		Container.add(label3);
		Container.add(Ln);
		Container.add(label4);
		Container.add(space);
		Container.add(dep);
		Container.add(de);
		Container.add(label5);
		Container.add(Cp);
		
		JPanel Button=new JPanel();
		Button.add(Add);
		Button.add(Cle);
		Container.add(Button);
		Container.add(Prt);
		add(Container);
		
	}
	
	
}
