package Model;

import java.util.HashMap;

public class Pack {


    public HashMap<Integer, Card> startpack;

    public Pack() {
        startpack = new HashMap<Integer, Card>();

        int card_id = 1;
        for (int n = 1; n < 7; n++) {
            for (int i = 1; i < 14; i++) {
                for (int r = 1; r < 5; r++) {
                    Card thisCard = new Card(i, r);
                    startpack.put(card_id, thisCard);
                    card_id++;
                }
            }
        }
    }
    public Card getElementAt(int num) { return startpack.get(num); }

    public int getSize() { return startpack.size(); }
}

