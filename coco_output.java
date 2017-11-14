abstract class expr{}
class Constant extends expr{ 
public String v;

public Constant(String v, ){
this.v=v;
}
}
class Variable extends expr{ 
public String name;

public Variable(String name, ){
this.name=name;
}
}
class Mult extends expr{ 
public expr e1;
public expr e2;

public Mult(expr e1, expr e2, ){
this.e1=e1;
this.e2=e2;
}
}
class Add extends expr{ 
public expr e1;
public expr e2;

public Add(expr e1, expr e2, ){
this.e1=e1;
this.e2=e2;
}
}
abstract class condition{}
class Equals extends condition{ 
public expr e1;
public expr e2;

public Equals(expr e1, expr e2, ){
this.e1=e1;
this.e2=e2;
}
}
class Conjunction extends condition{ 
public condition c1;
public condition c2;

public Conjunction(condition c1, condition c2, ){
this.c1=c1;
this.c2=c2;
}
}

