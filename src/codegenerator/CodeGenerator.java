package codegenerator;

import scanner.CompilerScanner;

public class CodeGenerator implements parser.CodeGenerator {
    private CompilerScanner lexical;

    public CodeGenerator(CompilerScanner lexical) {
        this.lexical = lexical;
    }

    @Override
    public void doSemantic(String sem) {
        System.out.println("semantic = " + sem);
        switch (sem) {
            case "printValue":
                System.out.println("value: " + lexical.currentSymbol.getValue().toString());
                break;
            default:
                System.out.println("Not Supported");
        }
    }
}
