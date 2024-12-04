import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import org.scilab.forge.jlatexmath.TeXFormula;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomJFrame.
 */
public class CustomJFrame extends JFrame{

	/** serialVersionUID. */ private static final long serialVersionUID = 1L;
	
	/** first name label */ private JLabel mathLabel = new JLabel("Enter Math:");
	/** The first name text field */ private JTextField math = new JTextField();
	/** answer label */ private JLabel answerLabel = new JLabel("Answer:");
	/** The first name text field */ private JLabel answer = new JLabel("");
	/** The clear button */ private JButton clear = new JButton("Clear");
	/** The submit button */ private JButton submit = new JButton("Feed");
	
		/**
		 * Instantiates a new custom J frame.
		 */
		public CustomJFrame() 
		{
			GridBagConstraints layoutManager = new GridBagConstraints();
			setTitle("Math Monster");
			
			setLayout(new GridBagLayout());
			//this right-aligns the radio buttons for later, and makes the preceding text look sharp
			layoutManager.anchor = GridBagConstraints.WEST;
			layoutManager.insets = new Insets(50,50,10,5);
			
			ButtonListener actionListener = new ButtonListener();
			
			this.getContentPane().setBackground(Color.DARK_GRAY);
			layoutManager.insets = new Insets(10,200,0,0);
			layoutManager.gridwidth = 3;
			
			layoutManager.gridx = 0;
			layoutManager.gridy = 1;
			BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(new File("./MathMonster.png"));
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				picLabel.setMinimumSize(new Dimension(160,160));
				add(picLabel,layoutManager);
			} catch (IOException e) {
				System.out.println("no monster :(");
				e.printStackTrace();
			}
			
			layoutManager.insets = new Insets(10,50,10,5);
			layoutManager.gridwidth = 1;
			
			//input label label
			layoutManager.gridx = 0;
			layoutManager.gridy = 3;
			mathLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
			mathLabel.setForeground(Color.white);
			add(mathLabel,layoutManager);
			
			layoutManager.gridwidth = 2;
			layoutManager.insets = new Insets(10,0,10,50);
			
			//input text field
			layoutManager.gridx = 1;
			layoutManager.gridy = 3;
			math.setText("");
			math.setColumns(23);
			math.setEditable(true);
			math.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
			add(math,layoutManager);
			
			layoutManager.insets = new Insets(0,50,10,50);
			
			//output label
			layoutManager.gridx = 0;
			layoutManager.gridy = 4;
			answerLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
			answerLabel.setForeground(Color.white);
			add(answerLabel,layoutManager);
			
			layoutManager.gridwidth = 3;
			
			//output field
			layoutManager.gridx = 0;
			layoutManager.gridy = 5;
			answer.setMinimumSize(new Dimension(600,160));
			answer.getMinimumSize();
			answer.setBorder(BorderFactory.createLineBorder(Color.black));
			answer.setOpaque(true);
			answer.setBackground(Color.WHITE);
			add(answer,layoutManager);
			
			layoutManager.gridwidth = 1;
			
			layoutManager.insets = new Insets(0,50,50,0);
			
			//clear button
			layoutManager.gridx = 0;
			layoutManager.gridy = 6;
			clear.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
			clear.addActionListener(actionListener);
			add(clear,layoutManager);
			
			layoutManager.insets = new Insets(0,0,50,50);
			
			layoutManager.anchor = GridBagConstraints.EAST;
			
			//submit button
			layoutManager.gridx = 2;
			layoutManager.gridy = 6;
			submit.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
			submit.addActionListener(actionListener);
			add(submit,layoutManager);
			

		
			
		}
		
		/**
		 * The listener for receiving button events.
		 */
		public class ButtonListener implements ActionListener
		{
			
			/**
			 * Action performed, called when either button (clear/submit) is pressed
			 * @param e the object that created the event
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//the submit button
				//passes the "math" text field (which contains the user input equation) to the compiler
				//the compiler returns the equation in latex syntax = the solution to the equation
				//then it pushes that into the jframe
				if(e.getActionCommand().equals("Feed"))
				{	
					if(math.getText() != "") {
					TeXFormula formula = new TeXFormula(Driver.mathCompiler(math.getText()));
					
					Image image = formula.createBufferedImage(TeXFormula.SERIF, 60, java.awt.Color.BLACK, null);
					
					answer.setIcon(new ImageIcon(image));
					
					pack();
				
					}
				}
				
				
				//it clears the form
				if(e.getActionCommand().equals("Clear"))
				{
					
					clearForm();
				}
			}
			
			/**
			 * Clear form.
			 * unsurprisingly, it clears the form, resetting all the values to their defaults
			 */
			private void clearForm()
			{
				answer.setIcon(null);
				answer.setText("");
				math.setText("");
			}
		}
		



}
