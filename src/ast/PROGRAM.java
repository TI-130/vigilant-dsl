package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class PROGRAM extends Node {
    private String start = "digraph G {";
    private String end = "}";
    private List<STATEMENT> statements = new ArrayList<>();
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("Hello!");
        while(!tokenizer.checkToken("Thanks!")) {
            STATEMENT s = null;
            if (tokenizer.checkToken("makemea")) {
              s = new SHAPEDEC();
            }

            else if (tokenizer.checkToken("connect")) {
                s = new EDGEDEC();
            }
            s.parse();
            statements.add(s);
        }
    }

    @Override
    public void evaluate() {
        writer.println(start);
        for (STATEMENT s : statements) {
            s.evaluate();
        }
        writer.println(end);
    }

    public void nameCheck() {
        for (STATEMENT s : statements) {
            s.nameCheck();
        }
    }
    public void typeCheck() {
        for (STATEMENT s : statements) {
            s.typeCheck();
        }
    }
}
