package Model;

public class Player {
    public int playerPoint;
    public int playerPoint2;
    public int playerFinalPoint;
    public Player(){
        playerPoint = 0;
        playerPoint2 = 0;
        playerFinalPoint = 0;
    }

    public void upDataPoint(Card card) {
        if (card.getCardNum() == 1){
            playerPoint = playerPoint + 1;
            playerPoint2 = playerPoint2 + 11;
        }else if(card.getCardNum() >= 10){
            playerPoint = playerPoint + 10;
            playerPoint2 = playerPoint2 + 10;
        } else {
            playerPoint = playerPoint + card.getCardNum();
            playerPoint2 = playerPoint2 + card.getCardNum();
        }
    }

    public void PlayerFinalPointUpdata(){
        if (playerPoint2 > 21){
            playerFinalPoint = playerPoint;
        } else {
            playerFinalPoint = playerPoint2;
        }
    }

}
