package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {
 public Player [] players = new Player[4];
public Card[] deck = new Card[52];
public int highScores ;
public void generate(){
 int counter =0;
 for(int i=0;i<4;i++) {
  for (int j = 0; j < 13; j++) {
   int value = (j>=10) ? 10 : j + 1;
   Card card = new Card(i, j, value);
   deck[counter] = card;
   counter++;
  }
 }
 }
 public Card draw() {

  Random random = new Random();
  Card card = null;
  do {
   int randomNum = random.nextInt(51);
   card = deck[randomNum];
   deck[randomNum]= null ;
  } while (card == null);
  return card;
 }

 public void setInfo(){
  Scanner scanner = new Scanner(System.in);
  for (int i=0 ; i< players.length;i++)
  {
   System.out.println("Enter name of player");
   players[i] = new Player();
   players[i].name = scanner.next() ;
   players[i].addCard(this.draw());
   players[i].addCard(this.draw());
  }
  players[3] = new Player();
  players[3].name =  "dealer" ;
  players[3].addCard(this.draw());
  players[3].addCard(this.draw());
 }
 public void updateGameScore(){
 int highScores = 0;
 for (int i=0;i<3;i++)
 {
  if (players[i].score<=21 && players[i].score>highScores){
    highScores = players[i].score ;
  }
 }
 }
}
