import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck {
    private Random deal;
    public static ArrayList<Card> allCards = new ArrayList<>();
    public static ArrayList<Card> hand = new ArrayList<>();

    public Deck(Boolean x) {
        if (x = true) {
            for (int k = 1; k < 53; k++) {
                if (k < 14) {
                    Card card = new Card(1, k);
                    allCards.add(card);
                }
                else if (k < 27) {
                    Card card = new Card(2, k - 13);
                    allCards.add(card);
                }
                else if (k < 40) {
                    Card card = new Card(3, k - 26);
                    allCards.add(card);
                } else {
                    Card card = new Card(4, k - 39);
                    allCards.add(card);
                }
            }
        } else if (x = false) {
            for (int k = 1; k < 14; k++) {
                Card card = new Card(1, k);
                allCards.add(card);
            }
        }
    }
    public void swap(int first, int second) {
        Collections.swap(hand, first, second);
    }

    public ArrayList<Card> getList() {
        return hand;
    }

    public String dealHand(int numCards){
        for (int k =0; k < numCards; k++) {
            hand.add(allCards.get(k));
            System.out.println(allCards.get(k).name);
        }
        return "";
    }

    public String listHand(){
        for (int k = 0; k < hand.size(); k++) {
            System.out.println(hand.get(k).name);
        }
        return "";
    }

    public void shuffleDeck(){
        Collections.shuffle(allCards);
        System.out.println(allCards);
    }
    public void bubbleSortHand(){
        for(int k=0; k<hand.size(); k++){
            for (int i = 0; i < hand.size()-1; i++) {
                if (hand.get(i).value > hand.get(i + 1).value) {
                    swap(i, i + 1);
                }
            }
        }
    }

    public void selectionSortHand(){
        for(int i=0; i<hand.size(); i++){
            int pos=i;
            for(int j=i;j<hand.size();j++){
                if (hand.get(j).value < hand.get(pos).value) {
                    pos = j;
                }
            }
            Card min=hand.get(pos);
            hand.set(pos, hand.get(i));
            hand.set(i, min);
        }
    }


    public ArrayList<Card> mergeSortHand(ArrayList<Card> whole) {
        ArrayList<Card> left = new ArrayList<Card>();
        ArrayList<Card> right = new ArrayList<Card>();
        int center;
        if (whole.size() == 1) {
            return whole;
        }else{
            center = whole.size()/2;
            for (int i=0; i<center; i++) {
                left.add(whole.get(i));
            }
            for (int i=center; i<whole.size(); i++) {
                right.add(whole.get(i));
            }
            left  = mergeSortHand(left);
            right = mergeSortHand(right);
            merge(left, right, whole);
        }
        return whole;
    }
    private void merge(ArrayList<Card> left, ArrayList<Card> right, ArrayList<Card> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).value.compareTo(right.get(rightIndex).value)) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            }else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }
        ArrayList<Card> rest;
        int restIndex;
        if(leftIndex >= left.size()){
            rest = right;
            restIndex = rightIndex;
        }else {
            rest = left;
            restIndex = leftIndex;
        }
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }

    public void binarySearch(int suit, int face){
        binarySearch2(hand,suit,face);
    }

    public void binarySearch2(ArrayList<Card> hand, int suit, int face){
        if(face==hand.get(hand.size()/2).value){
            int n=0;
            for(int i=0; i<hand.size(); i++){
                if(face==hand.get(i).value&&suit==hand.get(i).suit){
                    System.out.println("Found: " + hand.get(i).name);
                    n=1;
                }
            }
            if(n==0){
                System.out.println("That card isn't in your hand");
            }
        }
        else if(hand.size()==1){
            System.out.println("That card isn't in your hand");
        }
        else if(face<hand.get(hand.size()/2).value){
            ArrayList<Card> leftHalf = new ArrayList<Card>();
            for(int i=0; i<hand.size()/2; i++){
                leftHalf.add(hand.get(i));
            }
            binarySearch2(leftHalf,suit,face);
        }
        else if(face>hand.get(hand.size()/2).value){
            ArrayList<Card> rightHalf = new ArrayList<Card>();
            for(int i=hand.size()/2; i<hand.size(); i++){
                rightHalf.add(hand.get(i));
            }
            binarySearch2(rightHalf,suit,face);
        }
    }
}
