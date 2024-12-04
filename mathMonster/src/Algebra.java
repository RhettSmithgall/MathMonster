
import java.util.Stack;

public class Algebra extends CalculatorBaseListener {
	
	private final Stack<String> stack = new Stack<>();
    String LHS;
    String RHS;
    String variable;
    
    boolean neg = false;
    
    /**
     * algebra(LHS,RHS)
     * @param left the left side of the expression
     * @param right the right side of the expression
     */
    Algebra(String left, String right){
    	this.LHS = left;
    	this.RHS = right;
    }

    @Override
    public void exitUMINUS(CalculatorParser.UMINUSContext ctx){
        String right = this.stack.pop();
        if(right.equals(variable)) {
        	flip();
        }
        this.stack.push("-" + right);
    }
    
    @Override
    public void exitEXOPGRP(CalculatorParser.EXOPGRPContext ctx) {
        String right = this.stack.pop();
        String left = this.stack.pop();
        
        if(right.equals(variable)) {
        	this.RHS = "(ln("+RHS+"))/(ln("+left+"))";
        }
        else if(left.equals(variable)) {
        	this.RHS = RHS+"^(1/"+right+")";
        }
        else {
        	double temp = Math.pow(Double.parseDouble(left),  Double.parseDouble(right));
        	this.stack.push(Double.toString(temp));
        }

       
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
        	 if(left.equals(variable)) {
             	RHS ="("+RHS+"/"+right+")";
             	this.stack.push(variable);
             }
             else if(right.equals(variable)) {
             	RHS = "("+RHS+"/"+left+")";
             	this.stack.push(variable);
             }
             else
             {
            	 System.out.println("outie");
            	 double temp = Double.parseDouble(left) * Double.parseDouble(right);
            	 System.out.println(temp);
             	 this.stack.push(Double.toString(temp));
             }
        } else if(ctx.mulop().getText().equals("/")){
        	 if(left.equals(variable)) {
              	RHS ="("+RHS+"*"+right+")";
              	this.stack.push(variable);
              }
              else if(right.equals(variable)) {
              	RHS = "("+left+")/("+RHS+")";
              	this.stack.push(variable);
              }
              else
              {
            	  double temp = Double.parseDouble(left) / Double.parseDouble(right);
             	 this.stack.push(Double.toString(temp));
              }
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
            if(left.equals(variable)) {
            	RHS = "("+RHS+"-"+right+")";
            	this.stack.push(variable);
            }
            else if(right.equals(variable)) {
            	RHS = "("+RHS+"-"+left+")";
            	this.stack.push(variable);
            }
            else
            {
            	double temp = Double.parseDouble(left) + Double.parseDouble(right);
            	this.stack.push(Double.toString(temp));
            }
        } else {
            if(left.equals(variable)) {
            	RHS = "("+RHS+"+"+right+")";
            	this.stack.push(variable);
            }
            else if(right.equals(variable)) {
            	RHS = "("+RHS+"-"+left+")";
            	flip();
            	this.stack.push(variable);
            }
            else
            {
            	double temp = Double.parseDouble(left) - Double.parseDouble(right);
            	this.stack.push(Double.toString(temp)); 
            }
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
    public void exitPARENGRP(CalculatorParser.PARENGRPContext ctx) {
    	String right = this.stack.pop();
        this.stack.push(right);
    }
    

    @Override
    public void exitDOUBLE(CalculatorParser.DOUBLEContext ctx) {
        String number = ctx.NUMBER().getText();
        this.stack.push(number);
    }
    
    @Override
    public void exitVARIABLEGRP(CalculatorParser.VARIABLEGRPContext ctx) {
        String x = ctx.VARIABLE().getText();
        this.stack.push(x);
        this.variable = x;
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
    
    public void flip() {
    	if(this.neg) {
    		this.neg = false;
    	}
    	else
    	{
    		this.neg = true;
    	}
    }

    public String getResult() {
    	if(this.neg) { return "-("+RHS+")";}
    	else { return RHS;}
    }

}
