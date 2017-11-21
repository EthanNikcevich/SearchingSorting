public class Card {
    Integer suit;
    Integer value;
    String name="";

    public Card(int suit, int value) {
        this.suit=suit;
        this.value=value;
        if(value==1){
            this.name+="A";
        }if(value == 11){
            this.name+="J";
        }if(value == 12){
            this.name+="Q";
        }if(value == 13){
            this.name+="K";
        }if(value < 11 && value > 1){
            this.name += value;
        }switch(suit){
            case 1:
                this.name += " of Hearts";
                break;
            case 2:
                this.name += " of Spades";
                break;
            case 3:
                this.name += " of Clubs";
                break;
            case 4:
                this.name += " of Diamonds";
                break;
        }
    }
}
