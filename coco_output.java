this.expr
this.expr
this.expr
this.expr
this.condition
this.condition
abstract class expr{}

class Constant extends expr{ 
    public Constant (NUM v)  {
    this.v = v;
}

class Variable extends expr{ 
    public Variable (ID name)  {
    this.name = name;
}

class Mult extends expr{ 
    public Mult (expr e1, expr e2)  {
    this.e1 = e1;
    this.e2 = e2;
}

class Add extends expr{ 
    public Add (expr e1, expr e2)  {
    this.e1 = e1;
    this.e2 = e2;
}
abstract class condition{}

class Equals extends condition{ 
    public Equals (expr e1, expr e2)  {
    this.e1 = e1;
    this.e2 = e2;
}

class Conjunction extends condition{ 
    public Conjunction (condition c1, condition c2)  {
    this.c1 = c1;
    this.c2 = c2;
}

