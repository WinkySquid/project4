package controller;

import java.awt.Font;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import models.Card;
import models.Deck;
import view.Frame;
import view.Window;

public class Overseer {
	
	//INSTANCE VARIABLES
    private Deck _d;
    private Window _w;
    private Frame _f;
    private static final String[] A = new String[]{"Play", "Help", "Exit"};
    private static final String[] RANKS = new String[]{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
    private static final String[] SUITS = new String[]{"spades", "hearts", "diamonds", "clubs"};
    private static final int[] POINT_VALUES = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    //CONSTRUCTOR
    public Overseer() {
    	_d = new Deck(RANKS, SUITS, POINT_VALUES);
    	_w = new Window();
        this.start();
    }

    /*
	 * This method displays the starting option dialog box. It sets the decoration 
	 * of the dialog box, and starts the game, displays the help message dialog, 
	 * or terminates the program depending on what option the user chooses.
	 */
    public void start() {
        UIManager.put("OptionPane.background", new ColorUIResource(0, 225, 0));
        UIManager.put("Panel.background", new ColorUIResource(30, 144, 255));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", 1, 32)));
        boolean b = false;
        while (!b) {
            int x = this._w.option2(A, "Welcome to the High and Low Guessing Game!", "High or Low Guessing Game", new ImageIcon(this.getClass().getResource("table.png")));
            if (x == 0) {
                UIManager.put("OptionPane.background", new ColorUIResource(0, 150, 0));
                UIManager.put("Panel.background", new ColorUIResource(150, 78, 0));
                b = true;
                this._w.msg2("You're sitting on a regular table in the casino\nas you're trying to play this game with your friend.\nShe bets you $100 that you will lose the game.\nCan you beat the odds and win this card game?", "");
                this._f = new Frame(this._d, "Higher or Lower?", this._d.deal(), 0);
            }
            if (x == 1) {
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Comic Sans", 2, 14)));
                this._w.msg2("In this card game,\nyou try to guess if the next\ncard being dealed is higher or lower\nthan the current card!\nIf you get it right, you score a point!\nIf not, you get a Strike!\nThree strikes and you're out!\nEnjoy!", "Help Guide");
                UIManager.put("OptionPane.background", new ColorUIResource(0, 200, 0));
                UIManager.put("Panel.background", new ColorUIResource(30, 144, 255));
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", 1, 32)));
            }
            if (x == 2) {
            System.exit(0);
        }
        } 
    }
}

