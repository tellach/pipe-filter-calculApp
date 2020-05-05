
public class Operation {

    String name;
    int  operandGauche;
    int  operandDroit;
    long resultat;

    public Operation(int opG, String op, int opD) {
        this.operandGauche = opG;
        this.name = op;
        this.operandDroit = opD;
    }

    public void setResultat(long resultat) {
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        if (this.name.equals("Factorielle"))
            return operandGauche+"!="+resultat;
        else if (this.name.equals("Somme"))
            return operandGauche+"+"+operandDroit+"="+resultat;
        else if (this.name.equals("Produit"))
            return operandGauche+"x"+operandDroit+"="+resultat;
        else
            return "Fin Affichage";
    }
}
