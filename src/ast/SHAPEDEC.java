package ast;

import libs.Node;
import libs.SymbolTable;

public class SHAPEDEC extends STATEMENT {
    String shape;
    String name;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("makemea");
        shape = tokenizer.getNext();
        tokenizer.getAndCheckNext("called");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("please");
    }

    // SEMANTICS:       name[shape=STRING]
    @Override
    public void evaluate() {
        // Fido[shape=circle]
        writer.println(indent + name + "[shape=" + shape + "]");
    }

    @Override
    public void nameCheck() {
        SymbolTable.getInstance().names.add(name);
    }

    @Override
    public void typeCheck() {
        SymbolTable.getInstance().types.put(name, shape);
    }
}
