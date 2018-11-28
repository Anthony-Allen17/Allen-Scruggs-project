import javax.swing.*;
import java.awt.*;
import java.util.Random;
/**
* @author Anthony Allen @author Anthony Scruggs;
*
* This program is simple crap game GUI adaptation that use various methods to operate the game.
**/

public class CrapsGame extends JFrame implements java.awt.event.ActionListener {
   private JButton reset,roll, bet;
   private JTextField chips;
   private JLabel dice1 ,dice2,Pot,pot1,result1,result2, Bet,betOp;
   private Container contents;
   private JPanel pan;
   private ImageIcon icon,icon2;
   private int rolls, bank, bet1;
   private String roller=("You rolled a");
   public CrapsGame(){
      setSize(600,600);
      contents = getContentPane();
      pan = new JPanel();
      pan.setLayout(null);
      pan.setBackground(Color.YELLOW);//Sets the background color for the JPanel to yellow.//
      pan.setOpaque(true);
      contents.add(pan);
      reset = new JButton("reset");
      reset.setBounds(0,0,100,40);
      reset.setBackground(Color.RED);// Sets the JButton color to red.//
      reset.setOpaque(true);
      pan.add(reset);
      reset.addActionListener(this);// Adds action listner to the reset button.//
      roll = new JButton("roll");
      roll.setBounds(180,290,100,30);
      roll.setBackground(Color.WHITE);// Sets the JButton color to white.//
      roll.setOpaque(true);
      pan.add(roll);
      roll.addActionListener(this);// Adds action listner to the roll button.//
      pot1= new JLabel("             "+" Bank");
      pot1.setBounds(460,0,120,20);
      pot1.setBackground(Color.GREEN);
      pot1.setOpaque(true);
      pan.add(pot1);
      Pot = new JLabel("5000");
      Pot.setBounds(460,20,120,40);
      Pot.setBackground(Color.GREEN);
      Pot.setOpaque(true);
      pan.add(Pot);
      Bet = new JLabel("Bet");
      Bet.setBounds(50,290,20,30);
      pan.add(Bet);
      chips = new JTextField("0");
      chips.setBounds(0,340,150,20);
      pan.add(chips);
      betOp = new JLabel("");
      betOp.setBounds(0,500,170,40);
      pan.add(betOp);
      dice1 =  new JLabel();
      dice1.setBounds(180,190,200,60);
      dice1.setIcon(icon);
      pan.add(dice1);
      dice2 =  new JLabel();
      dice2.setBounds(180,220,200,60);
      dice2.setIcon(icon2);
      pan.add(dice2);
      setVisible(true);
   }
      /**
       * This is where the actionPerformed method is created, allowing GUI to run, 
       * and be accessible.
       */
      public void actionPerformed(java.awt.event.ActionEvent click) {
     }
     /**
      * Main method where GUI is called, and runs through ActionEvent 
      * then ActionPerformed is accessed.
      */
   public static void main(String[] work)
   {
      CrapsGame basicGui = new CrapsGame();
      basicGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
 

