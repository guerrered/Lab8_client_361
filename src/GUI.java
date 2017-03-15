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

public class GUI extends JFrame {

	public GUI(){
	JFrame frame = new JFrame("ClientEidtor");
	
	frame.setResizable(false);
	frame.setSize(500, 400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	createContents();
	setVisible(true);
	
	
	}
	
	private void createContents()
	{
		JLabel label1 = new JLabel("Title");
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[]{"Mr.","Ms.","Mrs.","Dr.","Col.","Prof."}));
		JLabel laber2 = new JLabel("First Name");
		JTextField Fn = new JTextField();
		JLabel laber3 = new JLabel("Last Name");
		JTextField Ln = new JTextField();
		JLabel laber4 = new JLabel("Gender");
		JRadioButton option1 = new JRadioButton("Male");
		JRadioButton option2 = new JRadioButton("Female");
		JRadioButton option3 = new JRadioButton("Other");
		ButtonGroup group = new ButtonGroup();
		group.add(option1);
		group.add(option2);
		group.add(option3);
		JPanel space=new JPanel();
		space.setLayout(new GridLayout(1,3));
		space.add(option1);
		space.add(option2);
		space.add(option3);
		
		JLabel laber5 = new JLabel("Phone Number");
		JTextField Cp = new JTextField();
		JButton Add= new JButton();
		JButton Cle= new JButton();
		JButton Prt= new JButton();
		
		JPanel Container = new JPanel();
		Container.setLayout(new GridLayout(7,2));
		
		Container.add(label1);
		Container.add(comboBox);
		Container.add(laber2);
		Container.add(Fn);
		Container.add(laber3);
		Container.add(Ln);
		Container.add(laber4);
		Container.add(space);
		Container.add(laber5);
		Container.add(Cp);

		add(Container);
		
	}
	
	
}
