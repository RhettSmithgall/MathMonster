import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;


public class Driver{

	//the main function which generates the Jframe
    public static void main(String[] args) throws Exception  {
        CustomJFrame frame = new CustomJFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
    }
    
    //replaces multiplication by juxtoposition with explicit math operators
    public static String implicitMul(String equation) {
        equation = equation.replaceAll("\\)\\(", ")*(");
        Pattern pattern = Pattern.compile("(\\d)\\(");
        Matcher matcher = pattern.matcher(equation);
        equation = matcher.replaceAll("$1*(");
        
        
        return equation;
    }
    
    
    //compiles the math
    //returns in the form "String of the equation in latex syntax = the calculated answer"
    public static String mathCompiler(String expression) {
    	
    	//implicit multiplication, meaning (10)(10) or 5(10) cause issues for the compiler
    	//perhaps a more clever grammar or implementation could solve the problem but for now
    	//this function implicitMul() replaces all instances of implicit multiplication with explicit math operators
    	expression = implicitMul(expression);
    	
    	System.out.println(expression);
    	
    	ANTLRInputStream input = new ANTLRInputStream(expression);
        CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.start();
        ParseTreeWalker walker = new ParseTreeWalker();
        
        Calculator calculator = new Calculator();
        LatexMaker latex = new LatexMaker();
        
        walker.walk(latex, tree);
        walker.walk(calculator, tree);
        
        
        String stringy = latex.getResult() + "=" + calculator.getResult();
    	
        JFrame frame2 = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
        viewr.setScale(3);//scale a little
        panel.add(viewr);
        frame2.add(panel);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(600,400);
        frame2.setVisible(true);
        
        return stringy;
    }
    
    
    public static ParseTree treer(String expression) {
    	ANTLRInputStream input = new ANTLRInputStream(expression);

        CalculatorLexer lexer = new CalculatorLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalculatorParser parser = new CalculatorParser(tokens);

        ParseTree tree = parser.start();
        
        return tree;
    }
    
    public static char detector(String expression) {
    	ParseTree tree = treer(expression);
    	
    	ParseTreeWalker walker = new ParseTreeWalker();
    	
    	variableDetector detector = new variableDetector();
    	
    	walker.walk(detector, tree);
    	
    	char x = detector.getResult();
    	
    	if(x != '0') {
    		return x;
    	}
    	
    	return '0';
    }
}
