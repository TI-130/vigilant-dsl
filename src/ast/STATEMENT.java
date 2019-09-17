package ast;

import libs.Node;

public abstract class STATEMENT extends Node {
    abstract public void parse();
    abstract public void nameCheck();
    abstract public void typeCheck();
    protected String indent = "    ";
}
