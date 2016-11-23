/*

 Vous êtes libre de :

 */
package be.manudahmen.empty3.library.script;

public interface Run {

    void evaluateExpression(Expression expression);

    void executeInstruction(Instruction instruction);

    void getVariableValue(Variable variable, Value value);

    void loopSubCode(SubCode subcode);

    void runCode(Code code);

    void setVariableValue(Variable variable, Value value);

}
