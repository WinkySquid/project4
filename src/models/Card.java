package models;

import javax.swing.ImageIcon;

public class Card {
	
	//INSTANCE VARIABLES
    private String suit;
    private String rank;
    private int pointValue;

    //CONSTRUCTOR
    public Card(String cardRank, String cardSuit, int cardPointValue) {
        this.rank = cardRank;
        this.suit = cardSuit;
        this.pointValue = cardPointValue;
    }

    //GETTERS
    public String suit() {
        return this.suit;
    }
    public String rank() {
        return this.rank;
    }
    public int pointValue() {
        return this.pointValue;
    }

    /*
     * This method returns true or false depending on whether the suits
     * of the current Card object (this) and the other Card object (otherCard)
     * are the same, the ranks of the two Card objects are the same, and
     * the point values of the two Card objects are the same.
     */
    public boolean matches(Card otherCard) {
        return otherCard.suit().equals(this.suit()) && otherCard.rank().equals(this.rank()) && otherCard.pointValue() == this.pointValue();
    }

    /*
     * This method overrides the original toString method in the Object
     * class and returns a String object representing (in order) the
     * rank of the Card object, the suit of the Card object, and the
     * point value of the Card object.
     */
    public String toString() {
        return String.valueOf(this.rank) + " of " + this.suit + " (point value = " + this.pointValue + ")";
    }

    /*
     * This method returns the appropriate image that represents the Card
     * object depending on its rank and its suit. If neither the suit nor
     * the rank are present in the Card object, the method returns null.
     */
    public ImageIcon getIcon() {
        if (this.rank().equals("ace")) {
            if (this.suit().equals("clubs")) {
                return new ImageIcon(this.getClass().getResource("AC.png"));
            }
            if (this.suit().equals("diamonds")) {
                return new ImageIcon(this.getClass().getResource("AD.png"));
            }
            if (this.suit().equals("hearts")) {
                return new ImageIcon(this.getClass().getResource("AH.png"));
            }
            if (this.suit().equals("spades")) {
                return new ImageIcon(this.getClass().getResource("AS.png"));
            }
        } else if (this.rank().equals("2")) {
            if (this.suit().equals("clubs")) {
                return new ImageIcon(this.getClass().getResource("2C.png"));
            }
            if (this.suit().equals("diamonds")) {
                return new ImageIcon(this.getClass().getResource("2D.png"));
            }
            if (this.suit().equals("hearts")) {
                return new ImageIcon(this.getClass().getResource("2H.png"));
            }
            if (this.suit().equals("spades")) {
                return new ImageIcon(this.getClass().getResource("2S.png"));
            }
        } else if (this.rank().equals("3")) {
            if (this.suit().equals("clubs")) {
                return new ImageIcon(this.getClass().getResource("3C.png"));
            }
            if (this.suit().equals("diamonds")) {
                return new ImageIcon(this.getClass().getResource("3D.png"));
            }
            if (this.suit().equals("hearts")) {
                return new ImageIcon(this.getClass().getResource("3H.png"));
            }
            if (this.suit().equals("spades")) {
                return new ImageIcon(this.getClass().getResource("3S.png"));
            }
        } else if (this.rank().equals("4")) {
            if (this.suit().equals("clubs")) {
                return new ImageIcon(this.getClass().getResource("4C.png"));
            }
            if (this.suit().equals("diamonds")) {
                return new ImageIcon(this.getClass().getResource("4D.png"));
            }
            if (this.suit().equals("hearts")) {
                return new ImageIcon(this.getClass().getResource("4H.png"));
            }
            if (this.suit().equals("spades")) {
                return new ImageIcon(this.getClass().getResource("4S.png"));
            }
        } else if (this.rank().equals("5")) {
            if (this.suit().equals("clubs")) {
                return new ImageIcon(this.getClass().getResource("5C.png"));
            }
            if (this.suit().equals("diamonds")) {
                return new ImageIcon(this.getClass().getResource("5D.png"));
            }
            if (this.suit().equals("hearts")) {
                return new ImageIcon(this.getClass().getResource("5H.png"));
            }
            if (this.suit().equals("spades")) {
                return new ImageIcon(this.getClass().getResource("5S.png"));
            }
        } else if (this.rank().equals("6")) {
            if (this.suit().equals("clubs")) {
                return new ImageIcon(this.getClass().getResource("6C.png"));
            }
            if (this.suit().equals("diamonds")) {
                return new ImageIcon(this.getClass().getResource("6D.png"));
            }
            if (this.suit().equals("hearts")) {
                return new ImageIcon(this.getClass().getResource("6H.png"));
            }
            if (this.suit().equals("spades")) {
                return new ImageIcon(this.getClass().getResource("6S.png"));
            }
        } else if (this.rank().equals("7")) {
            if (this.suit().equals("clubs")) {
                return new ImageIcon(this.getClass().getResource("7C.png"));
            }
            if (this.suit().equals("diamonds")) {
                return new ImageIcon(this.getClass().getResource("7D.png"));
            }
            if (this.suit().equals("hearts")) {
                return new ImageIcon(this.getClass().getResource("7H.png"));
            }
            if (this.suit().equals("spades")) {
                return new ImageIcon(this.getClass().getResource("7S.png"));
            }
        } else if (this.rank().equals("8")) {
            if (this.suit().equals("clubs")) {
                return new ImageIcon(this.getClass().getResource("8C.png"));
            }
            if (this.suit().equals("diamonds")) {
                return new ImageIcon(this.getClass().getResource("8D.png"));
            }
            if (this.suit().equals("hearts")) {
                return new ImageIcon(this.getClass().getResource("8H.png"));
            }
            if (this.suit().equals("spades")) {
                return new ImageIcon(this.getClass().getResource("8S.png"));
            }
        } else if (this.rank().equals("9")) {
            if (this.suit().equals("clubs")) {
                return new ImageIcon(this.getClass().getResource("9C.png"));
            }
            if (this.suit().equals("diamonds")) {
                return new ImageIcon(this.getClass().getResource("9D.png"));
            }
            if (this.suit().equals("hearts")) {
                return new ImageIcon(this.getClass().getResource("9H.png"));
            }
            if (this.suit().equals("spades")) {
                return new ImageIcon(this.getClass().getResource("9S.png"));
            }
        } else if (this.rank().equals("10")) {
            if (this.suit().equals("clubs")) {
                return new ImageIcon(this.getClass().getResource("10C.png"));
            }
            if (this.suit().equals("diamonds")) {
                return new ImageIcon(this.getClass().getResource("10D.png"));
            }
            if (this.suit().equals("hearts")) {
                return new ImageIcon(this.getClass().getResource("10H.png"));
            }
            if (this.suit().equals("spades")) {
                return new ImageIcon(this.getClass().getResource("10S.png"));
            }
        } else if (this.rank().equals("jack")) {
            if (this.suit().equals("clubs")) {
                return new ImageIcon(this.getClass().getResource("JC.png"));
            }
            if (this.suit().equals("diamonds")) {
                return new ImageIcon(this.getClass().getResource("JD.png"));
            }
            if (this.suit().equals("hearts")) {
                return new ImageIcon(this.getClass().getResource("JH.png"));
            }
            if (this.suit().equals("spades")) {
                return new ImageIcon(this.getClass().getResource("JS.png"));
            }
        } else if (this.rank().equals("queen")) {
            if (this.suit().equals("clubs")) {
                return new ImageIcon(this.getClass().getResource("QC.png"));
            }
            if (this.suit().equals("diamonds")) {
                return new ImageIcon(this.getClass().getResource("QD.png"));
            }
            if (this.suit().equals("hearts")) {
                return new ImageIcon(this.getClass().getResource("QH.png"));
            }
            if (this.suit().equals("spades")) {
                return new ImageIcon(this.getClass().getResource("QS.png"));
            }
        } else if (this.rank().equals("king")) {
            if (this.suit().equals("clubs")) {
                return new ImageIcon(this.getClass().getResource("KC.png"));
            }
            if (this.suit().equals("diamonds")) {
                return new ImageIcon(this.getClass().getResource("KD.png"));
            }
            if (this.suit().equals("hearts")) {
                return new ImageIcon(this.getClass().getResource("KH.png"));
            }
            if (this.suit().equals("spades")) {
                return new ImageIcon(this.getClass().getResource("KS.png"));
            }
        }
        return null;
    }
}

