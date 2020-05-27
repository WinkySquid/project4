package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import models.Card;
import models.Deck;

public class JOPListener implements ActionListener {
	
	//INSTANCE VARIABLES
    private int _i;
    private Card _c;
    private Deck _d;
    private Window _w;
    private Frame _f;

    //CONSTRUCTOR
    public JOPListener(int i, Card c, Deck d, Frame f) {
        this._i = i;
        this._d = d;
        this._w = new Window();
        this._c = c;
        this._f = f;
    }

    /*
     * This method overrides the original actionPerformed method
     * in the ActionListener interface and checks if the point value 
     * of the current card is higher than the point value of the next 
     * card to be drawn, checks if the point value of the current 
     * card is lower than the point value of next card to be drawn, 
     * or exits the program depending on the user's input.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        UIManager.put("OptionPane.background", new ColorUIResource(0, 150, 0));
        UIManager.put("Panel.background", new ColorUIResource(0, 150, 150));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Calibri", 1, 18)));
        if (this._i == 0) {
            this._f.getFrame().setVisible(false);
            this.checkHigher();
        } else if (this._i == 1) {
            this._f.getFrame().setVisible(false);
            this.checkLower();
        } else if (this._i == 2) {
            JOptionPane.showMessageDialog(null, "Thank you for playing!");
            System.exit(0);
        }
    }

    /*
     * This method checks if the point value of the current card
     * is greater than the point value of the next card that is 
     * drawn from the top of the deck in the method. If the point 
     * value of the next card that is drawn is less than the point
     * value of the current card, the method adds 1 point to the
     * user's score; otherwise, the method adds 1 to the number
     * of strikes the user has.
     */
    public void checkHigher() {
        Card c = this._d.deal();
        if (c.pointValue() < this._c.pointValue()) {
            this._f.setPointCount();
            this._w.msg4("Congratulations!\nYou scored yourself a point.", "Correct!", c.getIcon());
            int i = this._f.getCount();
            this._f = new Frame(this._d, "Higher or Lower?", c, ++i);
        } else {
            this._d.setCount();
            this._w.msg4("Uh Oh!\nThis card is not higher\nthan the previous card.\nStrike " + this._d.getCount() + "!", "Incorrect!", c.getIcon());
            this._d.checkCount();
            this._f = new Frame(this._d, "Higher or Lower?", c, this._f.getCount());
        }
    }

    /*
     * This method checks if the point value of the current card
     * is less than the point value of the next card that is 
     * drawn from the top of the deck in the method. If the point 
     * value of the next card that is drawn is greater than the point
     * value of the current card, the method adds 1 point to the
     * user's score; otherwise, the method adds 1 to the number
     * of strikes the user has.
     */
    public void checkLower() {
        Card c = this._d.deal();
        if (c.pointValue() > this._c.pointValue()) {
            this._f.setPointCount();
            this._w.msg4("Congratulations!\nYou scored yourself a point.", "Correct!", c.getIcon());
            int i = this._f.getCount();
            this._f = new Frame(this._d, "Higher or Lower?", c, ++i);
        } else {
            this._d.setCount();
            this._w.msg4("Uh Oh!\nThis card is not higher\nthan the previous card.\nStrike " + this._d.getCount() + "!", "Incorrect!", c.getIcon());
            this._d.checkCount();
            this._f = new Frame(this._d, "Higher or Lower?", c, this._f.getCount());
        }
    }
}

