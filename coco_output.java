abstract class expr{}

class Constant extends expr{     
    public expression e1;
    public expression e2;
    Constant (NUM v)  {
    
	public String toString() {
		 return "" + v;
}
}

class Variable extends expr{     
    public expression e1;
    public expression e2;
    Variable (ID name)  {
    
	public String toString() {
		 return "" + name;
}
}

class Mult extends expr{     
    public expression e1;
    public expression e2;
    Mult (expr e1, expr e2)  {
    
	public String toString() {
		 return "" + "(" + e1 + "*" + e2 + ")";
}
}

class Add extends expr{     
    public expression e1;
    public expression e2;
    Add (expr e1, expr e2)  {
    
	public String toString() {
		 return "" + "(" + e1 + "+" + e2 + ")";
}
}
abstract class condition{}

class Equals extends condition{     
    public expression e1;
    public expression e2;
    Equals (expr e1, expr e2)  {
    
	public String toString() {
		 return "" + e1 + "==" + e2;
}
}

class Conjunction extends condition{     
    public expression e1;
    public expression e2;
    Conjunction (condition c1, condition c2)  {
    
	public String toString() {
		 return "" + c1 + "&&" + c2;
}
}

