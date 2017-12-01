public class Runner {
    public static void main(String[] args){
        Deck d = new Deck(true);
        d.shuffleDeck();
        d.dealHand(7);
        //  d.bubbleSortHand();
        //d.selectionSortHand();
        d.mergeSortHand(d.getList());
        d.listHand();
        d.binarySearch(2,9);
    }
}

