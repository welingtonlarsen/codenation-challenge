package application;

import model.AlphabetModel;

public class ApplicationTestAlphabet {
    public static void main(String[] args) {

        String criptografada = "aol vusf puabpapcl pualymhjl pz aol upwwsl. hmaly aoha pa pz hss slhyulk. iybjl lkpnly";
        String descriptografada = "";

        int numeroCasas = 7;

        AlphabetModel am = new AlphabetModel(3, "aol vusf puabpapcl pualymhjl pz aol upwwsl. hmaly aoha pa pz hss slhyulk. iybjl lkpnly");
        am.denconde();

        System.out.println(am.getDeciphered());






    }




}












