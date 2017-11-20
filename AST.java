import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

class faux{ // collection of non-OO auxiliary functions (currently just error)
    public static void error(String msg){
	System.err.println("Interpreter error: "+msg);
	System.exit(-1);
    }
}

abstract class AST{
    abstract String codegen(String dataTypeName);

}

class Start extends AST{
    public static List<String> tokens = new ArrayList<>();
    public List<TokenDef> tokendefs;
    public List<DataTypeDef> datatypedefs;
    Start(List<TokenDef> tokendefs, List<DataTypeDef> datatypedefs){
	this.tokendefs=tokendefs;
	this.datatypedefs=datatypedefs;
    }

    public String codegen(String dataTypeName){
        String out ="";

        for (TokenDef t : tokendefs) {
            t.codegen("");
        }
        for (DataTypeDef def: datatypedefs) {
            out = out + def.codegen("");
        }
        return out;
    }
}

class TokenDef extends AST{
    public String tokenname; // "NUM"
    public String ANTLRCODE;
    TokenDef(String tokenname, String ANTLRCODE){
	this.tokenname=tokenname;
	this.ANTLRCODE=ANTLRCODE;
    }

    public String codegen(String dataTypeName){
        Start.tokens.add(tokenname);
        return "";
    }
}

class DataTypeDef extends AST{
    public String dataTypeName;
    public List<Alternative> alternatives;
    DataTypeDef(String dataTypeName, List<Alternative> alternatives){
	this.dataTypeName=dataTypeName;
	this.alternatives=alternatives;
    }
    public String codegen(String tmp){
        String out= "abstract class " + dataTypeName + "{}\n";
        for (Alternative alt : alternatives) {
            out = out + alt.codegen(dataTypeName);

        }
        return out;
    }
}

class Alternative extends AST{
    public String constructor;
    public List<Argument> arguments;
    public List<Token> tokens;
    Alternative(String constructor, List<Argument> arguments,  List<Token> tokens){
	this.constructor=constructor;
	this.arguments=arguments;
	this.tokens=tokens;
    }

    @Override
    public String codegen(String dataTypeName){
        String res = "class " + constructor + " extends " + dataTypeName + "{ " ;
            String space = "    ";
            String out = "";
            //System.out.println(Start.tokens);

            System.out.println("this."+dataTypeName);

            for(Argument argument:arguments){
                String temp = "";
                if (Start.tokens.contains(argument.type)) {
                    temp = "String";
                } else {
                    temp = argument.type;
                }


                }


            out += space+"\n    public expression e1;\n    public expression e2;\n    " + constructor + " (";
            for(Argument  argument:arguments){
                out += argument.type + " " + argument.name + ", ";
            }
            out = out.substring(0, out.length() - 2);
            out += ")  {\n    ";
            for(Argument argument:arguments){
                out += space + "this." + argument.name + " = " + argument.name + ";\n    ";


            }


            String toStringMetode = "\n\t" + "public String toString() {" + "\n\t\t" + "\"\"";
            for(Token token: tokens){
                toStringMetode += " + " + token.stringify();

            }
            toStringMetode += ";" + "\n";
            toStringMetode += "}\n";
            //String afslut = ;
            System.out.println(toStringMetode);
            
            return  "\n" + res + out +  toStringMetode + "}\n";

    }

}

class Argument extends AST{
    public String type; // "NUM"  -> "String"
    public String name; // "v"
    Argument(String type, String name){
        this.type=type;
        this.name=name;
    }
    public String codegen(String dataTypeName){


return "";

    }
}

abstract class Token extends AST{
    abstract String stringify();
}

class Nonterminal extends Token{
    public String name;
    Nonterminal(String name){
        this.name=name;
    }
    public String codegen(String dataTypeName){
        return "";
}

    @Override
    public String stringify() {
        return name;
    }
}

class Terminal extends Token{
    public String token;
    Terminal(String token){
        this.token=token;
        this.stringify();
    }
    public String codegen(String x){

        return "";
    }

    @Override
    public String stringify() {
        return token;
    }
}

