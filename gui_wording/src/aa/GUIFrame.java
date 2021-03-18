package aa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

//this class is to display the GUI frame
//using the WordList class to store data
public class GUIFrame {
	
	private WordList wList;
	
	private JFrame frame;
	private JPanel panel;
	
	private JButton add_btn;
	private JButton display_btn;
	private JButton remove_btn;
	private JButton clear_btn;
	
	private JTextField input;
	private JTextPane output;
	@SuppressWarnings("unused")
	private JScrollPane scroll;
	private StyledDocument doc;
	
	private JLabel rLabel;
	private JLabel gLabel;
	private JLabel bLabel;
	private JTextField rColor;
	private JTextField gColor;
	private JTextField bColor;
	
	//frame, panel
	public GUIFrame() {
		wList = new WordList();
		
		frame = new JFrame("CE203 assignment");
		panel = new JPanel();
		frame.add(panel);
		
		panel.setOpaque(false);
		panel.setLayout(null);
		
		frame.setBounds(0,0,600,600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		layoutPart1();
		layoutPart2();
		part1_function();
	}
	
	//layout for part 1
	public void layoutPart1() {
		//four buttons
		add_btn = new JButton("Add");
		display_btn = new JButton("Display");
		remove_btn = new JButton("Remove");
		clear_btn = new JButton("Clear");
		
		add_btn.setBounds(100, 20, 80, 80);
		display_btn.setBounds(200, 20, 80, 80);
		remove_btn.setBounds(300, 20, 80, 80);
		clear_btn.setBounds(400, 20, 80, 80);
		
		panel.add(add_btn);
		panel.add(display_btn);
		panel.add(remove_btn);
		panel.add(clear_btn);
		
		//
		output = new JTextPane();
		output.setText("display area:");
		output.setEditable(false);
		output.setBounds(80, 150, 400, 150);
		scroll = new JScrollPane(output);
		
		input = new JTextField("please type in");
		input.setBounds(80, 320, 400, 60);
		
		Font font = new Font(Font.SANS_SERIF, 3, 20);
		output.setFont(font);
		input.setFont(font);
		
		panel.add(output);
		panel.add(input);
		frame.repaint();
	}
	
	//
	public void layoutPart2() {
		rColor = new JTextField();
		rColor.setBounds(80, 450, 60, 30);
		rLabel = new JLabel("R");
		rLabel.setBounds(80, 420, 60, 30);
		
		gColor = new JTextField();
		gColor.setBounds(240, 450, 60, 30);
		gLabel = new JLabel("G");
		gLabel.setBounds(240, 420, 60, 30);
		
		bColor = new JTextField();
		bColor.setBounds(400, 450, 60, 30);
		bLabel = new JLabel("B");
		bLabel.setBounds(400, 420, 60, 30);
		
		panel.add(rLabel);
		panel.add(gLabel);
		panel.add(bLabel);	
		panel.add(rColor);
		panel.add(gColor);
		panel.add(bColor);		
		frame.repaint();
	} 
	
	public void part1_function() {		
		// when click add button
		add_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//get the entered string
				String input_str = input.getText().trim();
				
				String str = "";
				if(ExceptionHandler.wordCheck(input_str)) {
					wList.add(input_str);
					str = "Word ¡®" + input_str + "¡¯ has been added to the list";
				}else {
					str = "The string ¡®" + input_str + "¡¯ was not added to the list as it is not a valid word";
				}
				output.setText(str);
				
				//
				part2_function();
				System.out.println(wList);
			}
		});
		
		// when click display button
		display_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//get the entered string
				String input_str = input.getText().trim();
				
				String str = "";
				if(ExceptionHandler.isValidChar(input_str)) {
					char ch = input_str.charAt(0);
					str = wList.display(ch);
				}else {
					str = input_str + " is not a valid character.";
				}
				output.setText(str);
				
				//
				part2_function();
				System.out.println(wList);
			}
		});
		
		// when click remove button
		remove_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//get the entered string
				String input_str = input.getText().trim();
				
				String str = input_str + " has been removed from the list";
				wList.remove(input_str);
				output.setText(str);
				
				//
				part2_function();
				System.out.println(wList);
			}
		});
		
		// when click clear button
		clear_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = "list is cleared";
				wList.clear();
				output.setText(str);
				
				//
				part2_function();
				System.out.println(wList);
			}
		});
	}
	
	public void part2_function() {
		String red = rColor.getText();
		String green = gColor.getText();
		String blue = bColor.getText();
		
		//default value
		int r = 0;
		int g = 0;
		int b = 0;
		String str = "";
		
		try {
			r = Integer.parseInt(red);
			g = Integer.parseInt(green);
			b = Integer.parseInt(blue);
		} catch (Exception e) {
			// TODO: handle exception
			r = 0;
			g = 0;
			b = 0;
			str = "the entered value(s) for RGB is not valid, which should be between 0-200";
		}
		
		if(ExceptionHandler.isValidColor(r, g, b)) {
			
		}else {
			r = 0;
			g = 0;
			b = 0;
			str = "the entered value(s) for RGB is not valid, which should be between 0-200";
		}
		
		
		str = output.getText() + "\n" + str;
		output.setText("");
		Color color = new Color(r, g, b);
		
		//set the color
		Style style = output.addStyle("", null);
		StyleConstants.setForeground(style, color);
		doc = output.getStyledDocument();
		try { 
			doc.insertString(doc.getLength(), str,style); 
		}
        catch (Exception e){
        }
		
	}
}
