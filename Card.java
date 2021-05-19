package Model;

public class Card {
    private int num;
    private int rank;

    public Card(int num, int rank) {
        this.num = num;
        this.rank = rank;
    }

    public int getCardRank() {
        return this.rank;
    }
    public int getCardNum() {
        return this.num;
    }

    public String getCardNumAndRank() {
        return "(" + this.num + ", " + this.rank + ")";
    }

    public String cardShow(){
        if (this.num == 1){
            return "A";
        } else if (this.num < 11){
            return String.valueOf(this.num);
        } else if (this.num == 11) {
            return "J";
        } else if (this.num == 12) {
            return "Q";
        } else {
            return "K";
        }
    }
}
