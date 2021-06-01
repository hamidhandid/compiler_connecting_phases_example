package scanner;
%%

%class CompilerScanner
%public
%unicode
//%standalone
%line
%column
%function nextSymbol
%type Symbol

%{
    public Symbol currentSymbol;
    private Symbol symbol(String tokenName, Object value) {
        return new Symbol(tokenName, value);
    }
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]

TraditionalComment = "/*" [^*] ~"*/" | "/*"~"*/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
Comment = {TraditionalComment} | {EndOfLineComment}

ExampleToken = "str"

%%
<YYINITIAL> {
    {Comment} {
        yybegin(YYINITIAL);
        return symbol("comment", yytext());
    }
    {WhiteSpace} {
        yybegin(YYINITIAL);
        return symbol("whitespace", yytext());
    }
    {ExampleToken} {
        return symbol("string", yytext());
    }
    [^] {
        System.err.println("Error");
        return symbol(null, null);
    }
}