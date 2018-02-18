import javax.swing.*;
import java.awt.event.*;
import java.util.*;

// @author Fueled By Java Team
// @author James Bury
// @author Quinn Fryday
// @author Xu Li
// @author Devashish Kapoor

public class Health_Services extends JFrame implements ActionListener
{
  // Create class variables
  private JButton newUser, returningUser, submitButton, backButton, getTicket, closeButton, closeButton2;
  private JPanel welcomePanel, newPanel, loginPanel;
  private JLabel logo = new JLabel("");
  private JLabel welcomeMssg;
  private String nName = "";
  private String nCard = "";
  private static int ticketNumber = 0;
  private static int  securityCounter = 3;
  private ArrayList<ArrayList<String>> database = new ArrayList<ArrayList<String>>();
  
  // Text Fields
  private JTextField userName;
  private JTextField cardNumber;
  private JTextField newName;
  private JTextField newCardNumber;
  
  public static void main(String[]args) {
    new Health_Services();
  }
  
  private Health_Services() {
    // Set up New User button
    newUser = new JButton("New User");
    newUser.setBounds(180, 200, 100, 30);
    newUser.addActionListener(this);
    
    // Set up Submit button
    submitButton = new JButton("Submit");
    submitButton.setBounds(235, 200, 100, 30);
    submitButton.addActionListener(this);
    
    // Set up Returning User button
    returningUser = new JButton("Returning User");
    returningUser.setBounds(300, 200, 120, 30);
    returningUser.addActionListener(this);
    
    // Set up Back Button
    backButton = new JButton("Back");
    backButton.setBounds(235, 235, 100, 30);
    backButton.addActionListener(this);
    
    // Set up Get Ticket button
    getTicket = new JButton("Get Ticket");
    getTicket.setBounds(180, 200, 100, 30);
    getTicket.addActionListener(this);
    
    // Set up Exit button for Welcome screen
    closeButton = new JButton("Exit");
    closeButton.setBounds(235, 235, 100, 30);
    closeButton.addActionListener(this);
    
    // Set up Exit button for Login screen
    closeButton2 = new JButton("Exit");
    closeButton2.setBounds(300, 200, 100, 30);
    closeButton2.addActionListener(this);
    
    // Welcome message
    welcomeMssg = new JLabel("Welcome to Health Services Canada!");
    welcomeMssg.setBounds(200, 100, 210, 25);
    
    // Create information labels for New User
    JLabel nName = new JLabel("Full Name:");
    nName.setBounds(200, 40, 200, 25);
    JLabel nCard = new JLabel("Health Card Number:");
    nCard.setBounds(200, 120, 200, 25);
    
    // Create information labels for Returning User
    JLabel nameLabel = new JLabel("Full Name:");
    nameLabel.setBounds(200, 40, 200, 25);
    JLabel cardLabel = new JLabel("Health Card Number:");
    cardLabel.setBounds(200, 120, 200, 25);
    
    // Import Health Services Canada Logo
    ImageIcon img = new ImageIcon("HealthServicesCanada.png");
    logo.setIcon(img);
    logo.setBounds(20, 20, 250, 220);
    
    // Login Info
    userName = new JTextField(15);
    userName.setBounds(200, 70, 200, 25);
    cardNumber = new JTextField(20);
    cardNumber.setBounds(200, 150, 200, 25);
    
    // Setup Account Info
    newName = new JTextField(15);
    newName.setBounds(200, 70, 200, 25);
    newCardNumber = new JTextField(20);
    newCardNumber.setBounds(200, 150,200, 25);
    
    // Create content newPanel
    newPanel = new JPanel();
    setContentPane(newPanel);
    newPanel.setLayout(null);
    newPanel.setVisible(false);
    
    // Add content to the newPanel
    newPanel.add(closeButton2);
    newPanel.add(submitButton);
    newPanel.add(backButton);
    newPanel.add(logo);
    newPanel.add(nName);
    newPanel.add(nCard);
    newPanel.add(newName);
    newPanel.add(newCardNumber);
    
    // Create content loginPanel
    loginPanel = new JPanel();
    setContentPane(loginPanel);
    loginPanel.setLayout(null);
    loginPanel.setVisible(false);
    
    // Add content to the loginPanel
    loginPanel.add(getTicket);
    loginPanel.add(closeButton2);
    loginPanel.add(backButton);
    loginPanel.add(logo);
    loginPanel.add(nameLabel);
    loginPanel.add(cardLabel);
    loginPanel.add(userName);
    loginPanel.add(cardNumber);
    
    // Create content welcomePanel 
    welcomePanel = new JPanel();
    setContentPane(welcomePanel);
    welcomePanel.setLayout(null);
    welcomePanel.setVisible(true);
    
    // Add content to the welcomePanel
    welcomePanel.add(welcomeMssg);
    welcomePanel.add(newUser);
    welcomePanel.add(returningUser);
    welcomePanel.add(closeButton);
    welcomePanel.add(logo);
    
    // Set up frame
    setTitle("Health Services Canada");
    setSize(450, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
  }
  
  // Allows user to navigate to the Login screen
  public void run() {
    welcomePanel.setVisible(false);
    loginPanel.setVisible(true);
    setContentPane(loginPanel);
    loginPanel.add(logo);
    loginPanel.add(backButton);
    userName.setText("");
    cardNumber.setText("");
  }
  
  // Allows user to navigate to the Registration screen
  public void runNew() {
    welcomePanel.setVisible(false);
    newPanel.setVisible(true);
    setContentPane(newPanel);
    newPanel.add(logo);
    newPanel.add(submitButton);
    newPanel.add(backButton);
    newName.setText("");
    newCardNumber.setText("");
  }
  
  // Allows user to navigate to back to the Welcome screen
  public void runBack() {
    loginPanel.setVisible(false);
    welcomePanel.setVisible(true);
    setContentPane(welcomePanel);
    welcomePanel.add(logo);
  }
  
  public void actionPerformed(ActionEvent a) {
    // Navigate Back to the Welcome screen when button is pressed
    if(a.getSource()==backButton){
      runBack();
    }
    
    // Navigate to the Login screen when button is pressed
    if(a.getSource()==returningUser) {
      run();
    }
    
    // Navigate to the New User Registeration screen when button is pressed
    if(a.getSource()==newUser) {
      runNew();
    }
    
    // Adds client information inside the data base
    if(a.getSource()==submitButton) {
      nName = newName.getText();
      nCard = newCardNumber.getText();
      
      ArrayList<String> tempDatabase = new ArrayList<String>();
      tempDatabase.add(nName);
      tempDatabase.add(nCard);
      database.add(tempDatabase);
    }
    
    // Gives out ticket when correct name and 
    if(a.getSource()==getTicket) {
      String uName = userName.getText();
      String cNumber = cardNumber.getText();
      
      uName.toLowerCase();
      cNumber.toLowerCase();
      
      // Logs in when name and health card number are located in data base
      for(int i=0; i<database.size(); i++){
        if(database.get(i).get(0).equals(uName) && database.get(i).get(1).equals(cNumber)){
          JOptionPane.showMessageDialog(null, "Welcome to Health Services Canada\n Your ticket number is: " + 
                                        Integer.toString(ticketNumber), "Health Services Canada", 
                                        JOptionPane.INFORMATION_MESSAGE);
          ticketNumber = Integer.valueOf(ticketNumber) + 1;
          System.exit(0);
        }
      } if(uName.equals("") || cNumber.equals("")) {
        // Gives error if nothing is entered
        securityCounter = Integer.valueOf(securityCounter)-1;
        JOptionPane.showMessageDialog(null, "Please fill in all fields to conitnue!\nPlease try again!\n" + 
                                      Integer.toString(securityCounter) + " tries left", "Health Services Canada", 
                                      JOptionPane.ERROR_MESSAGE);
        if(securityCounter==0) {
          JOptionPane.showMessageDialog(null, "You have reached maximum number of tries.\nThank you for using " + 
                                        "Health Services Canada!", "Health Services Canada", 
                                        JOptionPane.INFORMATION_MESSAGE);
          System.exit(0);
        }
      }else {
        // Gives error if entered values don't match
        securityCounter = Integer.valueOf(securityCounter)-1;
        JOptionPane.showMessageDialog(null, "Invalid Name or Card Number!\nPlease try again!\n" + 
                                      Integer.toString(securityCounter) + " tries left", "Health Services Canada", 
                                      JOptionPane.ERROR_MESSAGE);
        if(securityCounter==0) {
          JOptionPane.showMessageDialog(null, "You have reached maximum number of tries.\nThank you for using " + 
                                        "Health Services Canada!", "Health Services Canada", 
                                        JOptionPane.INFORMATION_MESSAGE);
          System.exit(0);
        }
      }
    } if(a.getSource()==closeButton || a.getSource()==closeButton2) {
      // Action done when closeButton is pressed
      JOptionPane.showMessageDialog(null, "Thank you for using Health Services Canada!", "Health Services Canada", 
                                    JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
    }
  }
}