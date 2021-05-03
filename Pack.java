package Model;

import java.util.Collections;
import java.util.Vector;

public class Pack {

    public Vector<Card> startpack;

    public Pack(){
        startpack = new Vector<Card>();
        for (int n = 1; n < 7; n++) {
            for (int i = 1; i < 14; i++) {
                for (int r = 1; r < 5; r++) {
                    Card thisCard = new Card(i, r);
                    startpack.add(thisCard);
                }
            }
        }
        Collections.shuffle(startpack);
    }

    public Card getElementAt(int num) {
        return startpack.get(num);
    }
    public int getSize() {
        return startpack.size();
    }
}
