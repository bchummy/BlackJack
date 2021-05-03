package Model;

public class Dealer {
    public int dealerPoint;
    public int dealerPoint2;
    public int dealerFinalPoint;
    public int dealerPointShow;
    public Dealer(){
        dealerPoint = 0;
        dealerPoint2 = 0;
        dealerFinalPoint = 0;
        dealerPointShow = 0;

    }


    public void upDataPoint(Card card){

        if (card.getCardNum() == 1){
            dealerPoint = dealerPoint + 1;
            dealerPoint2 = dealerPoint2 + 11;
        }else if(card.getCardNum() >= 10){
            dealerPoint = dealerPoint + 10;
            dealerPoint2 = dealerPoint2 + 10;
        } else {
            dealerPoint = dealerPoint + card.getCardNum();
            dealerPoint2 = dealerPoint2 + card.getCardNum();
        }
    }

    public void DealerFinalPointUpdata(){
        if (dealerPoint2 > 21){
            dealerFinalPoint = dealerPoint;
        } else {
            dealerFinalPoint = dealerPoint2;
        }
    }
}
