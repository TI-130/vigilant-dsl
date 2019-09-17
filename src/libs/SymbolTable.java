package libs;

import java.util.ArrayList;
import java.util.HashMap;

// Used to store the names and types of shapes for name check and type check
public class SymbolTable {
    public static SymbolTable table = null;
    public ArrayList<String> names = null;
    public HashMap<String, String> types = null;

    private SymbolTable() {
        names =  new ArrayList<>();
        types = new HashMap<>();
    }

    public static SymbolTable getInstance() {
        if (table == null)
            table = new SymbolTable();

        return table;
    }
}
