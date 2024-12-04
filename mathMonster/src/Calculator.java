
import java.util.Stack;

public class Calculator extends CalculatorBaseListener {

    private final Stack<Double> stack = new Stack<>();

    @Override
    public void exitUMINUS(CalculatorParser.UMINUSContext ctx){
        double right = this.stack.pop();
        this.stack.push(-1 * right);
    }
    
    /*
    @Override
    public void exitIMPMUL(CalculatorParser.IMPMULContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(left*right);
    }
    
    /*
    @Override
    public void exitIMPLICITFUNC(CalculatorParser.IMPLICITFUNCContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(left*right);
    }
    */
    
    @Override
    public void exitEXOPGRP(CalculatorParser.EXOPGRPContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        this.stack.push(Math.pow(left, right));
    }

    @Override
    public void exitMULOPGRP(CalculatorParser.MULOPGRPContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        if (ctx.mulop().getText().equals("*")) {
            this.stack.push(left * right);
        } else if(ctx.mulop().getText().equals("/")){
            this.stack.push(left / right);
        }
        else
        {
        	this.stack.push(left % right);
        }
    }

    @Override
    public void exitADDOPGRP(CalculatorParser.ADDOPGRPContext ctx) {
        Double right = this.stack.pop();
        Double left = this.stack.pop();

        if (ctx.addop().getText().equals("+")) {
            this.stack.push(left + right);
        } else {
            this.stack.push(left - right);
        }
    }

    @Override
    public void exitTRIGOPGRP(CalculatorParser.TRIGOPGRPContext ctx){
        Double right = this.stack.pop();

        switch(ctx.funcname().getText()){
            case "sin":
                this.stack.push(Math.sin(right));
                break;
            case "cos":
                this.stack.push(Math.cos(right));
                break;
            case "tan":
                this.stack.push(Math.tan(right));
                break;
            case "asin":
                this.stack.push(Math.asin(right));
                break;
            case "acos":
                this.stack.push(Math.acos(right));
                break;
            case "atan":
                this.stack.push(Math.atan(right));
                break;
            case "log":
                this.stack.push(Math.log10(right));
                break;
            case "ln":
                this.stack.push(Math.log(right));
                break;
            case "sqrt":
                this.stack.push(Math.sqrt(right));
                break;
        }
    }

    /*
    @Override
    public void exitPARENGRP(CalculatorParser.PARENGRPContext ctx) {
        this.stack.push(ctx.expr());
    }
    */

    @Override
    public void exitDOUBLE(CalculatorParser.DOUBLEContext ctx) {
        Double number = Double.parseDouble(ctx.NUMBER().getText());
        this.stack.push(number);
    }

    @Override 
    public void exitIRRATIONAL(CalculatorParser.IRRATIONALContext ctx){

        if(ctx.constant().getText().equals("pi")){
            this.stack.push(Math.PI);
        } 
        else
        {
            this.stack.push(Math.E);
        }
    }

    public Double getResult() {
        return this.stack.pop();
    }

}
