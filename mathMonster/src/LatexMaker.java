
import java.util.Stack;

public class LatexMaker extends CalculatorBaseListener {

    private final Stack<String> stack = new Stack<>();

    @Override
    public void exitUMINUS(CalculatorParser.UMINUSContext ctx){
        String right = this.stack.pop();
        this.stack.push("-" + right);
    }
    
    @Override
    public void exitEXOPGRP(CalculatorParser.EXOPGRPContext ctx) {
        String right = this.stack.pop();
        String left = this.stack.pop();

        this.stack.push(left+"^{ "+right+"}");
    }
    
    /*
    @Override
    public void exitIMPMUL(CalculatorParser.IMPMULContext ctx) {
        String right = this.stack.pop();
        String left = this.stack.pop();

        this.stack.push(left + right);
    }
    */

    @Override
    public void exitMULOPGRP(CalculatorParser.MULOPGRPContext ctx) {
        String right = this.stack.pop();
        String left = this.stack.pop();

        if (ctx.mulop().getText().equals("*")) {
            this.stack.push(left+"*"+right);
        } else if(ctx.mulop().getText().equals("/")){
            this.stack.push("\\frac{"+left+"}{"+right+"}");
        }
        else {
        	this.stack.push(left +"\\bmod"+ right);
        }
    }

    @Override
    public void exitADDOPGRP(CalculatorParser.ADDOPGRPContext ctx) {
        String right = this.stack.pop();
        String left = this.stack.pop();

        if (ctx.addop().getText().equals("+")) {
            this.stack.push(left + "+" + right);
        } else {
            this.stack.push(left + "-" + right);
        }
    }

    @Override
    public void exitTRIGOPGRP(CalculatorParser.TRIGOPGRPContext ctx){
        String right = this.stack.pop();

        switch(ctx.funcname().getText()){
            case "sin":
                this.stack.push("\\sin{ \\left( "+ right +"\\right) }");
                break;
            case "cos":
                this.stack.push("\\cos{ \\left( "+ right +"\\right) }");
                break;
            case "tan":
                this.stack.push("\\tan{ \\left( "+ right +"\\right) }");
                break;
            case "asin":
                this.stack.push("\\arcsin{ \\left( "+ right +"\\right) }");
                break;
            case "acos":
                this.stack.push("\\arccos{ \\left( "+ right +"\\right) }");
                break;
            case "atan":
                this.stack.push("\\arctan{ \\left( "+ right +"\\right) }");
                break;
            case "log":
                this.stack.push("\\log{ \\left( "+ right +"\\right) }");
                break;
            case "ln":
                this.stack.push("\\ln{ \\left( "+ right +"\\right) }");
                break;
            case "sqrt":
                this.stack.push("\\sqrt{ "+ right +" }");
                break;
        }
    }
    
    @Override
    public void exitVARIABLEGRP(CalculatorParser.VARIABLEGRPContext ctx) {
        String x = ctx.VARIABLE().getText();
        this.stack.push("x");
    }

    
    @Override
    public void exitPARENGRP(CalculatorParser.PARENGRPContext ctx) {
    	String right = this.stack.pop();
        this.stack.push("\\left(" + right + "\\right)");
    }
    

    @Override
    public void exitDOUBLE(CalculatorParser.DOUBLEContext ctx) {
        String number = ctx.NUMBER().getText();
        this.stack.push(number);
    }

    @Override 
    public void exitIRRATIONAL(CalculatorParser.IRRATIONALContext ctx){

        if(ctx.constant().getText().equals("pi")){
            this.stack.push("\\pi");
        } 
        else
        {
            this.stack.push("e");
        }
    }

    public String getResult() {
        return this.stack.pop();
    }

}
