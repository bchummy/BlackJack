package Model;

import java.util.Collections;
import java.util.Vector;
import java.util.HashMap;

public class Pack {

    public Vector<Card> startpack;
    public HashMap<Integer,Card> startpack2 = new HashMap<Integer, Card>();

    public Pack(){
        startpack = new Vector<Card>();
        int card_id = 1;
        for (int n = 1; n < 7; n++) {
            for (int i = 1; i < 14; i++) {
                for (int r = 1; r < 5; r++) {
                    Card thisCard = new Card(i, r);
                    startpack.add(thisCard);
                    startpack2.put(card_id, thisCard);
                }
            }
        }
        Collections.shuffle(startpack);
    }

    public Card getElementAt(int num) {
        return startpack.get(num);
    }

    public Card getElementAt2(int num) {
        return startpack2.get(num);
    }
    public int getSize() {
        return startpack.size();
    }
    public int getSize2() {
        return startpack2.size();
    }
}
