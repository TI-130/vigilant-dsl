package ui;

import ast.PROGRAM;
import libs.Node;
import libs.Tokenizer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        List<String> literals = Arrays.asList("Hello!","make me a", "called", "please", "connect", "to", "Thanks!");
        Tokenizer.makeTokenizer("input.tdot",literals);
        System.out.println("Done tokenizing");
        Node program = new PROGRAM();
        program.parse();
        System.out.println("Done parsing");
        program.nameCheck();
        program.typeCheck();
        System.out.println("Done type checking");
        Node.setWriter("target.dot");
        program.evaluate();
        System.out.println("Done evaluation");
        Node.closeWriter();

        // Turn target.dot files into target.png in runtime environment
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec("dot -Tpng target.dot -o target.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
