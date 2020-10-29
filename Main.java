import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  //create the labels
  JLabel firstLabel;
  JLabel secondLabel;
  JLabel resultLabel;

  //create the text fields
  JTextField firstField;
  JTextField secondField;
  JTextField resultField;

  //create the buttons
  JButton addButton;
  JButton subButton;
  JButton mulButton;
  JButton divButton;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Simple Calculator");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the class variables
    mainPanel = new JPanel();

    firstLabel = new JLabel("First Number");
    secondLabel = new JLabel("Second Number");
    resultLabel = new JLabel("Result");

    firstField = new JTextField();
    secondField = new JTextField();
    resultField = new JTextField();

    addButton = new JButton("Add");
    subButton = new JButton("Sub");
    mulButton = new JButton("Mul");
    divButton = new JButton("Div");

    //set class variable bounds
    firstLabel.setBounds(30, 30, 120, 20);
    secondLabel.setBounds(30, 70, 120, 20);
    resultLabel.setBounds(30, 110, 120, 20);

    firstField.setBounds(200, 30, 150, 20);
    secondField.setBounds(200, 70, 150, 20);
    resultField.setBounds(200, 110, 150, 20);

    addButton.setBounds(30, 160, 70, 20);
    subButton.setBounds(110, 160, 70, 20);
    mulButton.setBounds(190, 160, 70, 20);
    divButton.setBounds(270, 160, 70, 20);

    //add class variables to main panel
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);
    mainPanel.add(resultLabel);

    mainPanel.add(firstField);
    mainPanel.add(secondField);
    mainPanel.add(resultField);

    mainPanel.add(addButton);
    mainPanel.add(subButton);
    mainPanel.add(mulButton);
    mainPanel.add(divButton);
    
    //add action listeners to the buttons
    addButton.addActionListener(this);
    subButton.addActionListener(this);
    mulButton.addActionListener(this);
    divButton.addActionListener(this);

    //give the buttons action commands
    addButton.setActionCommand("add");
    subButton.setActionCommand("sub");
    mulButton.setActionCommand("mul");
    divButton.setActionCommand("div");

    //disable results field
    resultField.setEnabled(false);

    //turn on manual layouts
    mainPanel.setLayout(null);

    //add main panel to the frame
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    //store the strings in variables
    String firstNum = firstField.getText();
    String secondNum = secondField.getText();

    //turn the strings into integers
    int firstInt = Integer.parseInt(firstNum);
    int secondInt = Integer.parseInt(secondNum);

    //make a result variable
    int result = 0;

    //do the selected operation
    switch(command){
      case "add":
        //store the sum in the result variable
        result = firstInt + secondInt;
        break;
      case "sub":
        //store the difference in the result variable
        result = firstInt - secondInt;
        break;
      case "mul":
        //store the product in the result variable
        result = firstInt * secondInt;
        break;
      case "div":
        //store the quotient in the result variable
        result = firstInt / secondInt;
        break;
    }

    //make the result field display the result of both numbers 
    resultField.setText("" + result); //I add the "" so that it changes result variable into a string

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
