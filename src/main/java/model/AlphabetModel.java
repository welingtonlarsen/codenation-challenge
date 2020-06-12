package model;

public class AlphabetModel {

    private String[] alfabeth;
    private int indexNumber;
    private String encrypted;
    private String deciphered;

    public AlphabetModel(int indexNumber, String encrypted) {
        this.alfabeth = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        this.indexNumber = indexNumber;
        this.encrypted = encrypted;
        this.deciphered = "";
    }

    public String getDeciphered() {
        return deciphered;
    }

    public void denconde() {
        String letter;

        for(int index = 0; index<encrypted.length(); index++) {
            letter = encrypted.substring(index, index+1);

            if (getNewLetter(letter) != null) {
                this.deciphered = this.deciphered + getNewLetter(letter);
            }else {
                this.deciphered = this.deciphered + letter;
            }

        }
    }

    /*
    private String getNewLetter(String letter) {
        Integer positionLetterInAlphabet = getLetterPositionInAlphabet(letter);

        if (positionLetterInAlphabet != null) {
            for (int index = 0; index < indexNumber; index++) {
                if (positionLetterInAlphabet + 1 < alfabeth.length) {
                    positionLetterInAlphabet = positionLetterInAlphabet + 1;
                }else {
                    positionLetterInAlphabet = 0;
                }
            }
            return alfabeth[positionLetterInAlphabet];
        }

        return null;
    }

     */
    private String getNewLetter(String letter) {
        Integer positionLetterInAlphabet = getLetterPositionInAlphabet(letter);

        if (positionLetterInAlphabet != null) {
            for (int index = 0; index < indexNumber; index++) {
                if (positionLetterInAlphabet!=0) {
                    positionLetterInAlphabet = positionLetterInAlphabet - 1;
                }else {
                    positionLetterInAlphabet = 25;
                }
            }
            return alfabeth[positionLetterInAlphabet];
        }

        return null;
    }


    private Integer getLetterPositionInAlphabet(String letter){
        for (int index=0; index < this.alfabeth.length; index++) {
            if (this.alfabeth[index].equals(letter)) {
                return index;
            }
        }
        return null;
    }

}
