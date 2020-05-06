
public class Operation {

    String name;
    int  operandGauche;
    int  operandDroit;
    long resultat;
    String resultatS;

    public Operation(int opG, String op, int opD) {
        this.operandGauche = opG;
        this.name = op;
        this.operandDroit = opD;
    }

    public void setResultat(long resultat) {
        this.resultat = resultat;
    }
    public void setResultatS(String resultat) {
        this.resultatS = resultat;
    }

    @Override
    public String toString() {
        if (this.name.equals("Factorielle"))
            return operandGauche+"!="+resultat;
        else if (this.name.equals("Somme"))
            return operandGauche+"+"+operandDroit+"="+resultat;
        else if (this.name.equals("Produit"))
            return operandGauche+"x"+operandDroit+"="+resultat;
        else if (this.name.equals("Trace")){
            return resultatS;
        }
        else
            return "Fin Affichage";
    }
}
