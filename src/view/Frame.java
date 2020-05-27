package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import models.Card;
import models.Deck;
import view.JOPListener;

public class Frame {
	
	//INSTANCE VARIABLES
    private JFrame _frame;
    private JPanel _pan;
    private JButton[][] _labMaze;
    private JLabel _lab;
    private JLabel _lab2;
    private Deck _d;
    private String _str;
    private int _i;
    private boolean _b = false;

    //CONSTRUCTOR
    public Frame(Deck d, String str, Card c, int i) {
        UIManager.put("OptionPane.background", new ColorUIResource(0, 200, 0));
        UIManager.put("Panel.background", new ColorUIResource(0, 200, 150));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", 1, 32)));
        this._d = d;
        this._str = str;
        this._i = i;
        this.setupButtons(c);
        this.setupPanel();
        this.setupFrame();
    }

    //GETTERS
    public JFrame getFrame() {
        return this._frame;
    }
    public Deck getDeck() {
        return this._d;
    }
    public int getCount() {
        return this._i;
    }
    
    /*
     * This methods sets _b to be true.
     */
    public void setPointCount() {
        this._b = true;
    }
    
    /*
	 * This method sets up the frame for the game. It does not allow for resizing, lets you exit 
	 * the program upon closing, sets the background of the frame, sets the bounds for the frame, 
	 * sets the icon to be displayed in the frame, and sets the decoration of the frame. 
	 */
    private void setupFrame() {
        UIDefaults uiDefaults = UIManager.getDefaults();
        uiDefaults.put("activeCaption", new ColorUIResource(Color.green));
        uiDefaults.put("activeCaptionText", new ColorUIResource(Color.black));
        JFrame.setDefaultLookAndFeelDecorated(true);
        this._frame = new JFrame(this._str);
        this._frame.setVisible(true);
        this._frame.setBackground(new Color(0, 150, 0));
        this._frame.add(this._pan);
        this._frame.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("dice block.png")));
        this._frame.pack();
        this._frame.setResizable(false);
        this._frame.setBounds(300, 300, 1100, 400);
        this._frame.setDefaultCloseOperation(3);
        this._frame.repaint();
    }

    /*
     * This method sets up all the JButtons that represent that the player has while playing
	 * the round. It also sets up the margin of the buttons, sets up the background for each
	 * button, adds the text representing the options each player has to each button,
	 * and adds an ActionListener to each button. The method also sets up the JLabels that
	 * represent who has the current turn and the moves that the players have (whether
	 * they be blank, rock, paper, or scissors).
     */
    private void setupButtons(Card c) {
        String s = " Number of points: " + this._i + " point(s)";
        this._lab = new JLabel(c.getIcon());
        this._lab2 = new JLabel(s);
        this._labMaze = new JButton[1][3];
        this._labMaze[0][0] = new JButton("Higher");
        this._labMaze[0][1] = new JButton("Lower");
        this._labMaze[0][2] = new JButton("EXIT");
        for (int d = 0; d < this._labMaze[0].length; ++d) {
            this._labMaze[0][d].setBackground(new Color(255, 180, 180));
            this._labMaze[0][d].setFocusPainted(false);
            this._labMaze[0][d].setContentAreaFilled(true);
            this._labMaze[0][d].setMargin(new Insets(0, 0, 0, 0));
            this._labMaze[0][d].setOpaque(true);
            this._labMaze[0][d].addActionListener(new JOPListener(d, c, this._d, this));
        }
    }

    
    /*
	 * This method sets up the panel required to draw a round of the High or Low game.
	 * It adds the labels for the cards, the score of the round, and the status of the round. It also
	 * adds the JButtons from _labMaze that represent the options that the player has.
	 */
    private void setupPanel() {
        this._pan = new JPanel(new GridLayout(2, 3));
        this._pan.add(this._lab, 0);
        this._pan.add(new JLabel("Would this current card be higher or lower than the next card?"), 1);
        this._pan.add(this._lab2);
        JButton[][] arrjButton = this._labMaze;
        int n = arrjButton.length;
        for (int i = 0; i < n; ++i) {
            JButton[] l;
            for (JButton b : l = arrjButton[i]) {
                this._pan.add(b);
            }
        }
        this._pan.repaint();
    }

    
}

