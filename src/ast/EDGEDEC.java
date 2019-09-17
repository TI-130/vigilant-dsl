package ast;

import libs.NameCheckException;
import libs.Node;
import libs.SymbolTable;
import libs.TypeCheckException;

public class EDGEDEC extends STATEMENT {
    String startNode;
    String endNode;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("connect");
        startNode = tokenizer.getNext();
        tokenizer.getAndCheckNext("to");
        endNode = tokenizer.getNext();
    }

    // SEMANTICS: startNode->endNode
    @Override
    public void evaluate() {
        writer.println(indent + startNode + "->" + endNode);
    }

    @Override
    public void nameCheck() {
        if (!(SymbolTable.getInstance().names.contains(startNode))) {
            throw new NameCheckException(startNode);
        }
        if (!(SymbolTable.getInstance().names.contains(endNode))) {
            throw new NameCheckException(endNode);
        }
    }

    @Override
    public void typeCheck() {
        String fromShape = SymbolTable.getInstance().types.get(startNode);
        String toShape = SymbolTable.getInstance().types.get(endNode);
        if (!(fromShape.equals(toShape))){
            throw new TypeCheckException(startNode, fromShape, endNode, toShape);
        }
    }
}
