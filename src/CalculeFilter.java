
public  class CalculeFilter extends Filter {
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
    
    public CalculeFilter(Pipe _dataINPipe, Pipe _dataOUTPipe) {
		super();
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
	}
    public Operation getData(){
        return _dataINPipe.dataOUT();
    }
     
    public void sendData( Operation operation){
        _dataOUTPipe.dataIN(operation);
    }

    @Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}

	@Override
	synchronized void execute() {
		// TODO Auto-generated method stub
		while (true) {
			Operation operation = getData();
			switch (operation.name){
				case "Somme":
					operation.setResultat(Add(operation.operandGauche,operation.operandDroit));
					break;

				case "Produit":
					operation.setResultat(Multiply(operation.operandGauche,operation.operandDroit));
					break;
				case "Factorielle":
					operation.setResultat(Fact(operation.operandGauche));
					break;
			}
			sendData(operation);
		}
	}

	public long Add(int OperandG, int OperandD){ return OperandG+OperandD; }

	public long Multiply(int OperandG, int OperandD){  return OperandG*OperandD;}

	public long Fact(int Operand){
		long resultat = 1;
		for (int factor = 2; factor <= Operand; factor++) {
			resultat  *= factor;
		}
		return resultat;
	}
}
 