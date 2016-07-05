package atmatm6.modem.reading;
/**
 * Adventure File binding class
 */
public class AdvFile {
    public String loadText;
    public String endText;
    public int printSpeedSeconds;
    public class choices{
        public String choice1,choice2,choice3,choice4,choice5,choice6,choice7,choice8,choice9,choice10;
        public String getChoice1() {return choice1;}
        public String getChoice2() {return choice2;}
        public String getChoice3() {return choice3;}
        public String getChoice4() {return choice4;}
        public String getChoice5() {return choice5;}
        public String getChoice6() {return choice6;}
        public String getChoice7() {return choice7;}
        public String getChoice8() {return choice8;}
        public String getChoice9() {return choice9;}
        public String getChoice10() {return choice10;}
        public void setChoice1(String choice1) {this.choice1 = choice1;}
        public void setChoice2(String choice2) {this.choice2 = choice2;}
        public void setChoice3(String choice3) {this.choice3 = choice3;}
        public void setChoice4(String choice4) {this.choice4 = choice4;}
        public void setChoice5(String choice5) {this.choice5 = choice5;}
        public void setChoice6(String choice6) {this.choice6 = choice6;}
        public void setChoice7(String choice7) {this.choice7 = choice7;}
        public void setChoice8(String choice8) {this.choice8 = choice8;}
        public void setChoice9(String choice9) {this.choice9 = choice9;}
        public void setChoice10(String choice10) {this.choice10 = choice10;}
    }
    public int getPrintSpeedSeconds() {return printSpeedSeconds;}
    public void setPrintSpeedSeconds(int printSpeedSeconds) {this.printSpeedSeconds = printSpeedSeconds;}
    public String getEndText() {return endText;}
    public void setEndText(String endText) {this.endText = endText;}
    public String getLoadText() {return loadText;}
    public void setLoadText(String loadText) {this.loadText = loadText;}
}
