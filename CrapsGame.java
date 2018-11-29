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
   *@author Anthony Allen
   * Methods Dice1 and Dice2 simulate two 6 sided dice being rolled.
   **/
   public int Dice1() {
      Random t = new Random();
      int resultOne = 0;
      resultOne = t.nextInt(6);
      resultOne++;
      return resultOne;
   }
   public int Dice2(){
      Random s = new Random();
      int resultTwo = 0;
      resultTwo = s.nextInt(6);
      resultTwo++;
      return resultTwo;
   }
   /**
   @author Anthony Allen
   *This method bet determines whether or not a roll was one by rolling a seven, eleven or doubles except for rolling a two.
   *It then either adds the winnings or takes away the loss from the bank.
   *@param win it takes in the int value forthe total a player has rolled.
   *@param iAmount takes in the int amount that the player has bid on that hand.
   *@param Amount takes in the int amount the player has in the bank on that current hand.
   *@param df1 takes the value of the first dice in after it's rolled;
   *@param df2 takes the value of the second dice in after its rolled;
   **/ 
   public int bet(int win,int  iAmount,int Amount,int df1, int df2) {
      if( win == 7 ){
         return iAmount + Amount;
      }else if (win == 11)
      {
         return Amount + iAmount;
      } else if ( df1 == df2 && df1 > 1) { 
         return iAmount + Amount;
      }else{
         return Amount - iAmount;
      }
   }
   /**
   @author Anthony Allen
   * betCheck method is a safety feature that checks to make sure that the player bet is with in the it's limits.
   * These limits are the number being a positve interger and the number being equal or less then the amount the player has in the bank.
   * If these are broken the bet is translated to a zero to keep the game running and unaffeted by illegal bets.
   * @param face2 takes in the integer for the bet that is placed by the player.
   * @param iA takes in the integer for what thee player has in the bank.
   **/ 
   public int betCheck(int face2,int iA){
      if( face2 <= iA && face2>=0) {
         return face2;
      }else{
         return 0;
      }
   }
      /**
      @author Anthony Allen
      * This method betCheck2 checks the bet and gives string out put to advise the player when they have made an illegal bet.
      * @param face3 this takes in the int value of thee bet the player has made.
      * @param iA1 this takes in the int value of what the player has in the bank.
       **/
   public String betCheck2(int face3,int iA1){
      if( face3 > iA1) {
         return "Insufficent funds in the bank";
      }else if(face3 < 0) {
         return "Make bet positive";
      }else if(face3 <= iA1){
         return "";
      }else{
         return "";
      }
   }
       /**
       * This is where the actionPerformed method is created, allowing GUI to run, 
       * and be accessible.
       */
   public void actionPerformed(java.awt.event.ActionEvent click) {
      if(click.getSource() == roll) {
         int t1 = Dice1();
         int t2 = Dice2();
         int total = t1+t2;
         dice1.setText("You rolled a"+" "+t1+" "+ "and a"+" " + t2);
         dice2.setText("Your total is" +" "+total);
         String bookie =(chips.getText());
         String credit =(Pot.getText());
         int placed = Integer.parseInt(bookie);
         int fargo  = Integer.parseInt(credit);
         int place = betCheck(placed,fargo);
         int damage = bet(total,place,fargo,t1,t2);
         String round = Integer.toString(damage);
         Pot.setText(round);
         betOp.setText(betCheck2(placed,fargo));
      } else if(click.getSource()== reset){
         Pot.setText("5000");
         dice1.setText("");
         dice2.setText("");
         chips.setText("0");
      }else{
      
      }
   }
     /**
      * Main method where GUI is called, and runs through ActionEvent 
      * then ActionPerformed is accessed.
      */
   public static void main(String[] work) {
      CrapsGame basicGui = new CrapsGame();
      basicGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}