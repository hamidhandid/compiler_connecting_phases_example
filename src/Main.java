import codegenerator.CodeGenerator;
import parser.Parser;
import scanner.CompilerScanner;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String inputAddress = "src/in.txt";
        String tableAddress = "src/parser/table.npt";
        CompilerScanner scanner = new CompilerScanner(new FileReader(inputAddress));
        CodeGenerator codeGenerator = new CodeGenerator(scanner);
        Parser parser = new Parser(scanner, codeGenerator, tableAddress);
        // For debugging parser, use bellow
        // Parser parser = new Parser(scanner, codeGenerator, tableAddress, true);
        parser.parse();
    }
}
