
public class variableDetector extends CalculatorBaseListener {
	
	char variable = '0';

    @Override
    public void exitVARIABLEGRP(CalculatorParser.VARIABLEGRPContext ctx) {
        String x = ctx.VARIABLE().getText();
        variable = x.charAt(0);
    }

    public char getResult() {
        return variable;
    }

}
