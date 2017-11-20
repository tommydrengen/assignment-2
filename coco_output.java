this.expr

	public String toString() {
		"" + v;
}

this.expr

	public String toString() {
		"" + name;
}

this.expr

	public String toString() {
		"" + '(' + e1 + '*' + e2 + ')';
}

this.expr

	public String toString() {
		"" + '(' + e1 + '+' + e2 + ')';
}

this.condition

	public String toString() {
		"" + e1 + '==' + e2;
}

this.condition

	public String toString() {
		"" + c1 + '&&' + c2;
}

abstract class expr{}

class Constant extends expr{     
    public expression e1;
    public expression e2;
    Constant (NUM v)  {
        this.v = v;
    
	public String toString() {
		"" + v;
}
}

class Variable extends expr{     
    public expression e1;
    public expression e2;
    Variable (ID name)  {
        this.name = name;
    
	public String toString() {
		"" + name;
}
}

class Mult extends expr{     
    public expression e1;
    public expression e2;
    Mult (expr e1, expr e2)  {
        this.e1 = e1;
        this.e2 = e2;
    
	public String toString() {
		"" + '(' + e1 + '*' + e2 + ')';
}
}

class Add extends expr{     
    public expression e1;
    public expression e2;
    Add (expr e1, expr e2)  {
        this.e1 = e1;
        this.e2 = e2;
    
	public String toString() {
		"" + '(' + e1 + '+' + e2 + ')';
}
}
abstract class condition{}

class Equals extends condition{     
    public expression e1;
    public expression e2;
    Equals (expr e1, expr e2)  {
        this.e1 = e1;
        this.e2 = e2;
    
	public String toString() {
		"" + e1 + '==' + e2;
}
}

class Conjunction extends condition{     
    public expression e1;
    public expression e2;
    Conjunction (condition c1, condition c2)  {
        this.c1 = c1;
        this.c2 = c2;
    
	public String toString() {
		"" + c1 + '&&' + c2;
}
}

