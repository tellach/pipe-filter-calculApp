
public class Operation {

    String name;
    int og;
    int od;
    long result;
    String results;

    public Operation(int opG, String op, int opD) {
        this.og = opG;
        this.name = op;
        this.od = opD;
    }

    public void setResultat(long result) {
        this.result = result;
    }

    public void setResultatS(String result) {
        this.results = result;
    }

    @Override
    public String toString() {
        if (this.name.equals("Factoriel"))
            return og + "!=" + result;
        else if (this.name.equals("Somme"))
            return og + "+" + od + "=" + result;
        else if (this.name.equals("Produit"))
            return og + "x" + od + "=" + result;
        else if (this.name.equals("Trace")) {
            return results;
        } else
            return "Fin Affichage";
    }
}
