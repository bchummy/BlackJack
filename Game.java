package Model;

import java.util.Random;
import java.util.Scanner;


public class Game {
    public Pack pack = new Pack();
    public Player player = new Player();
    public Dealer dealer = new Dealer();
    public int num = 0;
    public Game(){
        System.out.println("Welcome to the Casino");
        System.out.println("Would you like to play some BlackJack ? (y/n)");
        Input1();
    }

    public void Input1() {
        num++;
        Scanner input1 = new Scanner(System.in);
        String choose1 = input1.next();
        if(choose1.equals("y")){
            StartGame();
        }else{
            System.out.println("See you next time!!");
        }
    }

    public void StartGame() {
        System.out.println("Cool !! (Dealer get 6 packs of poker and shuffle it)");
        System.out.println("-------------------------------------------------------------------------------------");

        Random pNum = new Random();
        player = new Player();
        dealer = new Dealer();

        int player1num = pNum.nextInt(pack.getSize());
        Card player1card = pack.getElementAt(player1num);
        System.out.println("Your first card is " + player1card.cardShow() + " of " + Print_clubs(player1card.getCardRank()));
        player.upDataPoint(player1card);
        if(player.playerPoint == player.playerPoint2) {
            System.out.println("Your have " + player.playerPoint + " points" );
        } else {
            System.out.println("Your have " + player.playerPoint + "/" + player.playerPoint2 + " points");
        }
        System.out.println("-------------------------------------------------------------------------------------");

        Random dNum = new Random();
        int dealer1num = dNum.nextInt(pack.getSize());
        Card dealer1card = pack.getElementAt(dealer1num);
        System.out.println("Dealer first card is "+ dealer1card.cardShow() + " of " + Print_clubs(dealer1card.getCardRank()));
        dealer.upDataPoint(dealer1card);
        if(dealer.dealerPoint == dealer.dealerPoint2) {
            System.out.println("Dealer has " + dealer.dealerPoint + " points");
        } else {
            System.out.println("Dealer has " + dealer.dealerPoint + "/" + dealer.dealerPoint2 + " points");
        }
        System.out.println("=====================================================================================");

        SecondRound();

    }

    public void SecondRound(){

        System.out.println("=====================================================================================");

        Random pNum2 = new Random();
        int player2num = pNum2.nextInt(pack.getSize());
        Card player2card = pack.getElementAt(player2num);
        System.out.println("Your second card is "+ player2card.cardShow() + " of " + Print_clubs(player2card.getCardRank()));
        player.upDataPoint(player2card);
        if(player.playerPoint == player.playerPoint2) {
            System.out.println("Your have " + player.playerPoint + " points" );
        } else {
            System.out.println("Your have " + player.playerPoint + "/" + player.playerPoint2 + " points");
        }
        System.out.println("-------------------------------------------------------------------------------------");


        System.out.println("Dealer got the second card");

        if(dealer.dealerPoint == dealer.dealerPoint2) {
            System.out.println("Dealer has " + dealer.dealerPoint + " points on the first card");
        } else {
            System.out.println("Dealer has " + dealer.dealerPoint + "/" + dealer.dealerPoint2 + " points on the first card");
        }

        Random dNum2 = new Random();
        int dealer2num = dNum2.nextInt(pack.getSize());
        Card dealer2card = pack.getElementAt(dealer2num);
        dealer.upDataPoint(dealer2card);
        System.out.println("=====================================================================================");
        System.out.println("=====================================================================================");

        PlayerCheck();
    }

    public void PlayerCheck(){
        System.out.println("Would you like to add another card ? (y/n)");
        Scanner input2 = new Scanner(System.in);
        String choose2 = input2.next();
        int PCardNum = 2;
        player.PlayerFinalPointUpdata();
        while(choose2.equals("y") && PCardNum < 5 && (player.playerPoint < 22 ||player.playerPoint2 < 22)){
            Random pNumN = new Random();
            int playerNnum = pNumN.nextInt(pack.getSize());
            Card playerNcard = pack.getElementAt(playerNnum);
            System.out.println("You got a "+ playerNcard.cardShow() + playerNcard.getCardNumAndRank());
            player.upDataPoint(playerNcard);
            PCardNum++;
            player.PlayerFinalPointUpdata();
            if(player.playerPoint == player.playerPoint2) {
                System.out.println("Your have " + player.playerPoint +  " points");
            } else {
                System.out.println("Your have " + player.playerPoint + "/" + player.playerPoint2 + " points");
            }

            if(player.playerPoint < 22 || player.playerPoint2 < 22) {
                System.out.println("Would you like to add another card ? (y/n)");
                Scanner n = new Scanner(System.in);
                choose2 = n.next();
            }else if(player.playerPoint > 22 && player.playerPoint2 > 22){
                choose2 = "n";
            } else {
                System.out.println("Maximum of cards are 5 ");
            }
        }

        EndGame();
    }

    public void EndGame(){
        System.out.println("=====================================================================================");

        dealer.DealerFinalPointUpdata();
        player.PlayerFinalPointUpdata();
        int playerF = player.playerFinalPoint;
        int dealerF = dealer.dealerFinalPoint;

        System.out.println("Your have "+ playerF + " points");
        System.out.println("Dealer flip his second card ");
        System.out.println("Dealer has "+ dealerF+ " points in total");

        if (playerF > 21){
                System.out.println("You boom and loss ! Dealer win !");
        } else {
            if (dealerF == playerF) {
                System.out.println("Tie!");
            }else{
                int DCardNum = 2;

                while (dealerF < playerF && DCardNum < 5 && dealerF < 22|| dealerF < 16){
                    Random dNumN = new Random();
                    int dealerNnum = dNumN.nextInt(pack.getSize());
                    Card dealerNcard = pack.getElementAt(dealerNnum);
                    System.out.println("Dealer got a "+ dealerNcard.cardShow() + " of " + Print_clubs(dealerNcard.getCardRank()));
                    dealer.upDataPoint(dealerNcard);
                    DCardNum++;
                    dealer.DealerFinalPointUpdata();
                    dealerF = dealer.dealerFinalPoint;
                    if(dealer.dealerPoint == dealer.dealerPoint2) {
                        System.out.println("dealer has " + dealer.dealerPoint + " points");
                    } else {
                        System.out.println("dealer has " + dealer.dealerPoint + "/" + dealer.dealerPoint2 + " points");
                    }
                }
                if (dealerF > 21){
                    System.out.println("You win ! Dealer boom !");
                } else if (dealerF == playerF){
                    System.out.println("Tie!");
                } else if (dealerF > playerF) {
                    System.out.println("You loss ! Dealer is closer!");
                }
            }
        }
        System.out.println("Would you like to play another game of BlackJack ? (y/n)");
        Input1();
    }
    public String Print_clubs(int clubs) {
        if (clubs == 1 ) {
            return "Spades";
        } else if (clubs == 2 ) {
            return "Hearts";
        } else if (clubs == 3 ) {
            return "Clubs";
        } else {
            return "Diamonds";
        }
    }
}

