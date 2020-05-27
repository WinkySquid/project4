package models;

import controller.Overseer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import view.Window;

public class Deck {
	
	//INSTANCE VARIABLES
    private List<Card> cards = new ArrayList<Card>();
    public static final String[] S = new String[]{"Yes!", "No..."};
    private int size;
    private int cnt = 0;
    private Window _w;

    //CONSTRUCTORS
    public Deck(String[] ranks, String[] suits, int[] values) {
    	_w = new Window();
        for (int j = 0; j < ranks.length; ++j) {
            for (String suitString : suits) {
                this.cards.add(new Card(ranks[j], suitString, values[j]));
            }
        }
        this.size = this.cards.size();
        this.shuffle();
    }

    //GETTERS
    public int getCount() {
        return this.cnt;
    }
    public int size() {
        return this.size;
    }

    /*
     * This method shuffles the Deck of Card objects by placing the Card
     * objects in a random order in the list. It also initializes the size
     * variable to be the size of the deck (the size of cards (the List of
     * Card objects)).
     */
    public void shuffle() {
        for (int k = this.cards.size() - 1; k > 0; --k) {
            int howMany = k + 1;
            int start = 0;
            int randPos = (int)(Math.random() * (double)howMany) + start;
            Card temp = this.cards.get(k);
            this.cards.set(k, this.cards.get(randPos));
            this.cards.set(randPos, temp);
        }
        this.size = this.cards.size();
    }

    /*
     * This method adds 1 to cnt (increments cnt by 1).
     */
    public void setCount() {
        ++this.cnt;
    }
    
    /*
     * This method returns true or false depending on if the the deck is
     * empty or not (its size is equal to 0).
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /*
     * This method checks how many cards there are in the deck and how many
     * strikes the user has while the user is playing the game. If the user
     * has 3 strikes, the method lets the user know that he/she lost the game
     * and calls the restart method to restart the game or exit the program.
     * If there are no cards in the deck, the method lets the user know
     * that he/she won the game and calls the restart method to restart 
     * the game or exit the program.
     */
    public void checkCount() {
        if (this.cnt == 3) {
            UIManager.put("Panel.background", new ColorUIResource(200, 0, 0));
            this._w.msg3("Looks like the game is over...\nYou're out!\nI guess you lost the $100...", "GAME OVER");
            this.restart();
        } else if (this.cards.size() == 0) {
            UIManager.put("Panel.background", new ColorUIResource(200, 200, 0));
            this._w.msg2("Looks like the deck is empty...\nYou win the $100!", "YOU WIN!");
            this.restart();
        }
    }

    /*
     * This method displays the option dialog box asking the user if he/she
     * would like to play again. It exits the program or restarts the game
     * depending on the user's input.
     */
    public void restart() {
        int y = this._w.option2(S, "Would you like to play again?", "?", new ImageIcon(this.getClass().getResource("octo.png")));
        if (y == 1) {
            JOptionPane.showMessageDialog(null, "Thank you for playing!", "Good-bye!", -1);
            System.exit(0);
        } else {
            this._w.msg4("Ok, let's start!", "", new ImageIcon(this.getClass().getResource("ngyes.png")));
            Overseer overseer = new Overseer();
        }
    }

    /*
     * This method deals a Card to a player (removes a Card object from
     * the top of the deck (index size minus 1)) and returns that Card
     * object. If the deck is empty, the method returns null.
     */
    public Card deal() {
        if (this.isEmpty()) {
            return null;
        }
        Card c = this.cards.remove(this.size - 1);
        this.size--;
        return c;
    }

    /*
     * This method overrides the original toString method in the Object
     * class and returns a String representing (in order) the size of 
     * the deck, the Card objects that have been undealt, and the Card
     * objects that have already been dealt.
     */
    public String toString() {
        int k;
        String rtn = "size = " + this.size + "\nUndealt cards: \n";
        for (k = this.size - 1; k >= 0; --k) {
            rtn = String.valueOf(rtn) + this.cards.get(k);
            if (k != 0) {
                rtn = String.valueOf(rtn) + ", ";
            }
            if ((this.size - k) % 2 != 0) continue;
            rtn = String.valueOf(rtn) + "\n";
        }
        rtn = String.valueOf(rtn) + "\nDealt cards: \n";
        for (k = this.cards.size() - 1; k >= this.size; --k) {
            rtn = String.valueOf(rtn) + this.cards.get(k);
            if (k != this.size) {
                rtn = String.valueOf(rtn) + ", ";
            }
            if ((k - this.cards.size()) % 2 != 0) continue;
            rtn = String.valueOf(rtn) + "\n";
        }
        rtn = String.valueOf(rtn) + "\n";
        return rtn;
    }
}

