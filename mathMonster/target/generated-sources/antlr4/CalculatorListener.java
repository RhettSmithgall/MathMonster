// Generated from Calculator.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(CalculatorParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(CalculatorParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UMINUS}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUMINUS(CalculatorParser.UMINUSContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UMINUS}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUMINUS(CalculatorParser.UMINUSContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IRRATIONAL}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIRRATIONAL(CalculatorParser.IRRATIONALContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IRRATIONAL}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIRRATIONAL(CalculatorParser.IRRATIONALContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VARIABLEGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVARIABLEGRP(CalculatorParser.VARIABLEGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VARIABLEGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVARIABLEGRP(CalculatorParser.VARIABLEGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EXOPGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEXOPGRP(CalculatorParser.EXOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EXOPGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEXOPGRP(CalculatorParser.EXOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PARENGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPARENGRP(CalculatorParser.PARENGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PARENGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPARENGRP(CalculatorParser.PARENGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TRIGOPGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTRIGOPGRP(CalculatorParser.TRIGOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TRIGOPGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTRIGOPGRP(CalculatorParser.TRIGOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDOUBLE(CalculatorParser.DOUBLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDOUBLE(CalculatorParser.DOUBLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMULOPGRP(CalculatorParser.MULOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMULOPGRP(CalculatorParser.MULOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterADDOPGRP(CalculatorParser.ADDOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitADDOPGRP(CalculatorParser.ADDOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#equals}.
	 * @param ctx the parse tree
	 */
	void enterEquals(CalculatorParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#equals}.
	 * @param ctx the parse tree
	 */
	void exitEquals(CalculatorParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(CalculatorParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(CalculatorParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(CalculatorParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(CalculatorParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#exop}.
	 * @param ctx the parse tree
	 */
	void enterExop(CalculatorParser.ExopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#exop}.
	 * @param ctx the parse tree
	 */
	void exitExop(CalculatorParser.ExopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#funcname}.
	 * @param ctx the parse tree
	 */
	void enterFuncname(CalculatorParser.FuncnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#funcname}.
	 * @param ctx the parse tree
	 */
	void exitFuncname(CalculatorParser.FuncnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(CalculatorParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(CalculatorParser.ConstantContext ctx);
}