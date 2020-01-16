## Getting Started with Java
### What is Java?
Java is a high-level programming language, owned by Oracle. It is one of the most popular programming languages in the world, and it has been on the #1 most used programming language for some years. As of 2019, it was rated the third most used  programming language ([GitHub Octoverse](https://octoverse.github.com)).

#### So why is Java so popular?:  
 * **Platform-independence**: Java code written for Windows can be run on Linux and vice versa(or any other popular platform). In fact, you don't write Java code for Windows or Linux, you just write Java code. And it will run on any popular platform. Windows, Linux, Unix, MacOS, etc. You don't need to recompile it, you just need to run it. This portability is made possible by what is called the *Java Virtual Machine(JVM)*.  
 * **Object-oriented**: Java is an Object-Oriented Programming(OOP) language,  and that provides a lot of advantages, including abstraction, code reuse, modularity, maintainability, etc. OOP is a programming paradigm which organizes programs as objects with properties(data) and behaviors(subroutines). This is a natural approach to problem-solving since the real world is full of objects. More on OOP later.  
 * **Supports multi-threading**: multi-threading allows concurrent execution of parts of a program, called threads, with so much ease. This is the reason why Java is popular in writing website backends since most web applications need to serve a lot of clients simultaneously.

### Installing the Tools
Now let's see what tools do we need to develop Java code and how to install them. First, let us introduce a few items. When we were discussing Java's platform independence, we mentioned something called a JVM. But what is it? You probably already know that many softwares written, say for Linux, cannot run on Windows and vice versa. So the JVM is an interpreter that converts Java compiled code(called *bytecode*) into a form compatible with the platform.  
**N.B**: The JVM itself is not portable, it is written specifically for each platform.  
 
What we will need:  
* a compiler  
* an editor

A compiler for Java is included in what is called a *Java Development Kit(JDK)*. The JDK consists of the Java compiler, the JVM as well as the Java core classes. 
For the editor, we can choose from a variety of popular editors, but in this tutorial we will use NetBeans.

The JDK is found on this [link](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). Follow the instructions to download and install.  
![JDK official site download page](https://codeswag.co.uk/wp-content/uploads/2020/01/download-jdk.png)  

Now we need to set up the path. This allows you to run Java using the command-line.

#### For Windows :
* Open Control Panel
* Open "System and Security" section
* Under System and Security, open "System" section
* Then on the left tab, open the "Advanced system settings link". A window will pop up.
* Then click the "Environment Variable" button.
* Now edit the Path variable under System variables, by appending the path to the java executables. The path will be "..\java\jdk\bin", the prefix(..) depending on the folder you chose to install java.

Now to install NetBeans, follow this [link](https://netbeans.apache.org/download/index.html) to download and install it on your machine.  
![Netbeans download page](https://codeswag.co.uk/wp-content/uploads/2020/01/download-netbeans-ide.png)

### Object-Oriented Programming(OOP)
Before we write our first Java program, let's first introduce OOP. As stated earlier, OOP is a programming paradigm in which data and the code that operates on the data are grouped into objects.
  
* **Object**: an instance of a class. It is a collection of properties and related behaviors.  
* **Class**: a blueprint/template for creating an object. It shows what properties(data) and behaviors(subroutines) an object created from it will have.

Let's take a look at a car. Any car(let's say yours) is an object of a class called *Car*. Your car has some properties. Mileage, battery level(I'm assuming you have an [electric vehicle](www.tesla.com)), age, etc. It has behaviors also. It can drive, turn, indicate, etc. Note that when you drive your car, you're decreasing its battery level and increasing mileage. If I drive my car, I cannot affect your car's battery level and mileage. That's the whole idea of OOP. We group related data and behaviors together so that we don't mistakenly modify the wrong data.

OOP has 4 pillars:  
* **Encapsulation**: it is the grouping of data and subroutines working on them into one unit. Encapsulation reduces the complexity of the programs by eliminating the need for passing many parameters to subroutines.  
* **Abstraction**: Abstraction is the hiding of implementation details of the object, only exposing interfaces through public subroutines. This makes the changing of code a lot easier, as long as we leave the interface the class as it is, we can change how the class works without affecting the code that depends on it.  
* **Inheritance**: This is when objects of one class obtain characteristics of another class. This allows for code reuse, therefore simplifying software development.  
* **Polymorphism**: This the ability of the same subroutine to exhibit different behavior in different objects(of different classes). This comes handy, for example, when we have a list of objects and we want to traverse the list, doing a different operation, depending on the type of code. Instead of using an if statement or switch case statement, we can create a method with the same name in all of the classes, but internally doing different things. So if we invoke a method on any object in the least, the required operation will be done. [This youtube video](https://youtu.be/pTB0EiLXUC8) explains these pillars in more detail.

### Hello world
``` java

package example;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello world);
	}
}
```

![Hello world output](https://codeswag.co.uk/wp-content/uploads/2020/01/Hello-world-1.png)

One thing to note is that Java tries to make sure that we don't dare to do anything without creating a class. It was designed to make sure that it is simply a difficult task to avoid all the benefits we have been talking about above, even if we're okay with *not benefitting*. This is why(most probably) we have to create a class in the above code example, even though we are not going to create an object instance of it.
  
* The first line tells the compiler which *package* the class we're creating belongs to. A *package* is just a collection of related classes and interfaces. In this case, our package is named example.  
* On line 3, we declared the class and named it HelloWorld.Everything that is part of a class body in Java has to be surrounded by squiggly-braces.  
* Line 4 is a header of a method called main with an argument of an array of objects of class String. Everything that is to be executed in a Java program has to be in the main method. When you run a Java program, the JVM looks for the main method, executes it until its end, then exit. Everything that is part of a method in Java body has to be surrounded by squiggly-braces.
The array args is a location that will contain arguments passed to our program in a command-line. More on this later. 
* In line 5, we're printing the words "Hello world" to the screen. To print anything else we can replace the "Hello world" statement with whatever we want to print. We say we're passing a value to a subroutine(called methods in Java) to act on. More on methods later. The method System.out.println() prints out the passed value, then print a new line character. There is also a method called System.out.print() which just prints out the passed value.  
  Every statement in Java should end with a ";". Line 5 is an example of a statement.


#### Few points to note
* Java is a case-sensitive language, x is not the same X.
* A java class name should be the same(with case sensitivity in mind) as the name of the file it resides, otherwise our code will refuse to compile. While still on this, it is not advisable to define two classes in one file. And if we do(for whatever reasons we will be doing that), only one class in the file should be public. This class name will be the name of the file. Java files containing class code must be saved with a ".java" file extension.
*  Every class that we intend to run must have a *main()* method in it. Otherwise it won't run.
*  Only the code in the main method is called. We can place code anywhere, but for it to run, it has to be either called by the code in the main method, or be called by the code that is being called by the code in the main method, or be called by the...

### Comments in Java
A comment is an explanatory statement used inside the code. It is used to improve code readability. It is for the people and not the computer.
In Java, we use // to tell the compiler to ignore the text that follows. If we want the comments to span more than one line we use /**/ syntax

```

[code statement]; // this text will be ignored by the compiler
/* 
this line of text will be ignored by the compiler
and this one also will be ignored
*/
[code statement];


```

### Identifiers
**Identifier**: a name arbitrarily chosen by the programmer to name a variable, method or a class.   

* The name should be *unique*.
* It should not conflict with the [Java keywords](https://www.javatpoint.com/java-keywords).
* It should start with an alphabetical character, a *$* or an underscore(_).
*  It must not include characters other than alphanumeric characters, *$* sign and the underscore.

### Variables and Data types
 **Variable**: it is a reserved memory location that is used to hold data. Classification of variables in Java:  

  * *By data type*: a variable can either be *primitive* or *reference*. A primitive variable is one created from primitive data types. There are eight primitive data-types in java:
     * **byte**: it is an eight-bit data type used to store an integer in the range of -128 to 127. The number is represented in two's complement.
     *  **short**: it is a 16-bit data type storing a two's complement integer in the range of -32,768 to 32,767.
     *  **int**: it is a 32-bit data type used to store a two's complement integer in the range of -2,147,483,648 to 2,147,483,647. 
     *  **long**: this 64-bit data type stores a two's complement integer in the range of -9,223,372,036,854,775,808 to -9,223,372,036,854,775,807.
     *  **float**: this 32-bit data type stores a floating number(a number with a decimal point) in the range of +/- 3.40282347E+38.
     *  **double**: this 64-bit data type stores a floating number(a number with a decimal point) in the range of +/- 1.7976931570E+308.
     *  **boolean**: this data type stores one bit, representing either a TRUE or FALSE.
     *  **char**: this 16-bit data type is used to store a Unicode character code.  
     The reference value holds a pointer to a variable declared using a class type. We will explain this later using an example.
  
  * *By scope*: There are three possible *scopes* of variables in Java:  
    * *local variable*: a variable declared inside a function will be only accessible in that function.  
    * *instance variable*: a variable declared inside a class(without the static non-access modifier). It will be accessible only in the class which it is defined.
    * *class variable*: a variable declared inside a class with a static non-access modifier.

	The syntax  for declaring a property of a class(class or instance variable): 
 
	```
	[access-modifier] [non-access-modifier] [data-type] [identifier];
	```  

	For example:  
	``` java
	
	private final short count;
	```
	
	The syntax for declaring a local variable:  

	``` 
	[data-type] [identifier];
	```   

	For example:  

	``` java
	boolean isTrue;
	```

* **Assignment**: an assignment statement is a line of code that gives(assigns) a variable a certain value. It has the following syntax:
   
	```
	[identifier] = [value];
	```
	
	For example:  

	``` java  
	x = 78;
	```  

After the execution of the above statement, the memory location assigned to variable x will hold a value of 78.  
* **Data type**: the interpretation of the data held by a variable. Computer memory is all about 1's and 0's, so the data type gives meaning to those 1's and 0's. The data type gives information about the layout of the variable in memory, what operations can be done on that value, etc.

### Operators
An *operator* is a symbol that is used to perform an operation on a variable or variables.
  
 * **The assignment operator**: The equal sign(=) is called the assignment operator. It is used to assign a value to a variable. 
   
```

 [identifier] [assignment-operator] [value]; // syntax

```  

The value on the right of the operator will be assigned to the variable on the left.

``` java 

x = 67; // after execution of this statement, variable x will hold the value of 67
y = x // the value of y after this statement will be 67
```  

 * **Arithmetic operators**: Arithmetic operators perform arithmetic on variables:
``` java

x = z * y; // x will be assigned the product of z and y
x = z / y; // x will be assigned the quotient of z and y
x = z + y; // x will be assigned the sum of z and y
x = z - y; // x will be assigned the difference between z and y
x++;       // the value of x(if it is an integer) will increase by 1
x--;       // the value of x(if it is an integer) will decrease by 1

``` 
Some points to note:
* If the variables are integers, the "/"  will just produce a integer result, ignoring the remainder part.
* If the variables are strings, the "+" operator just joins the two strings end to end, starting with the leftmost.

* **Relational operators**: These operators are used to compare two variables, and produce a *boolean* value(true/false). Assume z = 4, y = 5 and x is a boolean variable. We're putting brackets to make sure that the examples are more readable.

``` java

x = (z < y); // less-than operator, x will be TRUE
x = (z > y); // greater-than operator, x will be FALSE
x = (z == y); // equality operator, x will be FALSE
x = (z != y); // non-equality operator, x will be TRUE
x = (z <= y); // less-than-or-equal operator, x will be TRUE
x = (z >= y); // greater-than-or-equal operator, x will be FALSE

```

Here is the [link](https://www.javatpoint.com/operators-in-java) to read more on operators


### Modifiers
**Modifiers**: these are Java keywords that modify the scope or behavior of a class, variable or method. Modifiers are not used in variables defined inside functions(local variables). There are two types of modifiers:

 * *Access modifiers* are used to modify the scope of a class, member method or member variable. 
     * *default*: the entity declared as default can be accessed by the code in the same package only. You declare something as default by just omitting the access modifier.
     * *public*: an entity declared public will be accessible from anywhere.
     * *private*: declaring an entity as private will make it accessible only from the class which it is declared.
     * *protected*: an entity declared protected will be accessible in the package or outside the package by classes who are subclasses of the class in which it is declared.  
    **NB**: a class, unless if it is an *inner class*(one that is declared inside a class) cannot be declared as *protected* or *private*. This is because if we look at the definitions of the two modifiers, it doesn't make any sense to declare it private or protected.
  * *Non-access modifiers* are modifiers:
     * *static* the static modifier is used to declare entities that will exist independently of class instances. For example, if we declare a property variable of a class as static, there will exist only one copy of the variable, no matter how many instances of the class we create. We can access the variable by just specifying the class name and the variable name, without reference to any instance. If a method of a class is declared as static, it cannot use non-static variables inside its body. This is because it is supposed to be called without reference to any instance of a class.
     * *final*: if we declare a primitive variable as final, we can only set initialize it once. After that, we can't change its value. If we declare a reference variable as static, we can only instantiate it once. After that we can't instantiate it again or reference it to another object, however, we can change the properties of the object.  If a class is declared final, we cannot inherit it.
     * *abstract*: an abstract method is a method that has no implementation(body). The body is supposed to be provided by a class that inherits the class unless that class is also abstract. A class declared abstract cannot be instantiated, it can only be inherited. A class with at least one abstract method should be declared abstract. If a class, unless also abstract, inherits an abstract class, must implement all of its abstract methods.
     * *synchronized*: a variable is declared as synchronized if it is supposed to be accessed with only one thread at a given time.


### Java constructs
A *programming construct* is a defined structure that shows the order in which statements in a program are executed. There are three categories of programming constructs:  

* **sequential**: this type of construct shows that the order of execution is one statement after the other, in the order they appear. The syntax is as shown below. Statement 1 will be executed first, then statement 2, then statement 3.
 
```

statement 1;
statement 2;
statement 3;
```  

For example:

``` java 

package example; 

public class Example {
    public staic void main(String[] args) {
	System.out.println("hello");
	System.out.println("java");
	System.out.println("programmer");
    }
}
```

![sequential-construct-output](https://codeswag.co.uk/wp-content/uploads/2020/01/Sequential-construct-1.png)

* **conditional**: This construct shows that a statement, or a group of statements, called a block, will be executed only if a certain condition is met. There are two types of conditional constructs in Java, the **if** construct and the **switch** construct.

```

/*
if construct
statement 1 will be executed if (condition 1) is true
*/
if (condition 1) {
	statement 1;
}


/* if else construct
statement 2 will be executed if (condition 2) is true
otherwise statement 3 is executed
*/
if (condition 2) {
	statement 2;
} else {
	statement 3;
}


/*switch construct
statement 4 will be executed if the identifier equals value 1
statement 5 will be executed if the identifier equals value 2
the break keyword is there to avoid executioning of the uninteded case
as many cases as wanted can be placed
*/
switch([identifier]) {
	case [value 1]:
		statement 4;
		break;
	case [value 2]:
		statement 5;
}

```

Below is the program example with its corresponding output

``` java

package example;

public class Example {
    public static void main(String[] args) {

	int x = 4;

	if (x == 20) {
	    System.out.println("x is equal to 20");
	}

	if (x == 4) {
	    System.out.println("x is equal to 4");
	}

	if (x == 10) {
	    System.out.println("x is equal to 10");
	} else {
	    System.out.println("x is not equal to 10");
	}

	switch(x) {
	    case 2:
		System.out.println("x is equal to 2");
		break;
	    case 4:
		System.out.println("x is equal to 4");
		break;
	    default:
		System.out.println("x is equal non of the above values");
	}

    }

}

```

![Conditional-construct-output](https://codeswag.co.uk/wp-content/uploads/2020/01/Conditional-constructs-1.png)

* **iterative**: this construct shows that a statement or a group of statements will be executed until a certain condition is true, or while a certain condition is true. In Java, iterative constructs are called loops, and there are three types of loops.

The while loop will execute the statements over and over again until the condition becomes false.  
```

while([condition]) {
	statements;
}
```

The do-while loop will execute the statements at least once, then after that as long as the condition is true.  
```

do {
	statements
} while([condition])
```

The for loop will execute the initialization statement once, repeats the cycle of testing the condition to see if it is true, if true execute the statements, then execute the increment/decrement statement. The cycle will repeat until the condition become false. I marked the increment/decrement statement that way because usually an incremental/decremental statement is placed there. Otherwise, any Java legal statement can be put there.  
```

for ([initialization]; [condition]; [increment/decrement]) {
	statements;
}

```

Below is an example

``` java

package example;

public class Example {
    public static void main(String[] args) {

	int x = 0;

	while (x < 3) {
	    System.out.println(x);
	    x = x + 1;
	}

	System.out.println();
	x = 0;

	do {
	    System.out.println(x);
	    x = x + 1;
	} while (x < 3);

	System.out.println();

	for(x = 0; x < 3; x = x + 1) {
	    System.out.println(x);
	} 

    }

}
	
```

![Iterative-construct-demo-output](https://codeswag.co.uk/wp-content/uploads/2020/01/Iterative-constructs-1.png)

All the constructs can be used together, and it should be noted that the general flow of a program is sequential. That means, for example, if we write a conditional construct, then an iterative construct below, the conditional construct is executed first, then the iterative construct later. And also, we can use another construct in another construct.

### Java methods
A *subroutine* is a collection of program statements that does a certain task. A subroutine that returns a value to another variable is called a function(analogous to a math function). A procedure is the one that doesn't return a value after execution.
In Java, subroutines are called methods. Here is the syntax for creating a method.  

```

[access-modifier] [non-access-modifier] [return-type] [identifier]([parameter-definitions]) {
	statements;
	return statement;
}

```

*Parameters* are values given to a method to work on

Two methods we've encountered so far:
* System.out.println().The *println()* is a method of a static property of the class System, out. It has statements that prints the value we pass to it on the screen.
* The main() method. This one we actually defined it ourselves. Too bad we don't get to call it(it is called by the JVM when our program runs).

Every method must have a return statement. When the return statement is encountered by the compiler, it exits the function. However, in Java, the return statement is not compulsory for a method that doesn't return a value after execution. A return statement for a method that returns a value consists of the **return** keyword, followed by the value to be returned. For a method that doesn't return a value, it is just the return keyword. We use the **void** keyword on the return-type when declaring a method, to show that it does not return anything.

``` java

package example;

public class Example {

    public static int timesTwo(int x) {
	// this method takes an integer as an input and returns twice the integer as output
	x = x * 2;
	return x;
    }


    public static void printNumber(int x) {
	// this method  takes in an input as integer and prints it, then exits
	System.out.println(x);
	return;
    }

    public static void main(String[] args) {

	int x;
	/* this is how a method that returns a value is called
	we place the variable which is supposed to hold the returned value on the left of the assignmment operator*/
	x = timesTwo(78);

	printNumber(x); // calling a function that does not return a value
    }

}


```

![Methods-demo](https://codeswag.co.uk/wp-content/uploads/2020/01/Methods-1.png)

### Arrays
Arrays allows us to store two or more values of one data type under one identifier. Each element will then be distiquished by specifying its position(a number), also called an index. Below is the format for declaring and initializing an array:  

``` 

[data-type][] [identifier]; // declaring
[identifier] = new [data-type][number-of-elements]
```

For example:

``` java

int[] integers = new int[10]; // declaring and initialiazation
integers[0] = 1234; // assigning the first element a value of 1234
integers[9] = 67;   // assigning the last element a value of 67
integers[4] = 1000; // assigning the fifth element a value of 1000
```

**NB.** The indexes are zero based, that's why the first element has an index 0 and the 10th element(last element) has an index of 9.

In Java, arrays are also treated as some kind of object. An array has a property called length. If you execute the statements below, it will printout the value of 10;

``` java  

int[10] integers;
System.out.println(integers.length);

```


### Classes and objects
We have discussed what classes and objects are in the Object-Oriented Programming section. Now let's do some examples. Below is a syntax for 


``` 

package [package name];

[import statements]

public class [identifier] {

	[property declarations]

	[method declarations]

}

```

Import statements are used when we want to use a class that is not part of the package. The **import** keyword is used to make the class available to our code.

```

import [package-name].[class-name];  // importing one class from a package
import [package-name].*; 			 // importing all tha classes in the package

```    

Let's create a class example:

``` java

package example;

public class ClassExample {

	private int x = 0;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}

```

Lets create a class with a main() and play with the code above the code above.

``` java

package example;

public class Example {

	public static void main(String[] args) {

		int x; // local variable
		ClassExample example; // reference variable declaration

		example = new ClassExample(); // object creation / instantiation

		System.out.print("The value before calling setX(): ");
		x = example.getX();
		System.out.println(x);

		example.setX(12);
		x = example.getX();
		System.out.print("The value of x after calling set X: ");
		System.out.println(x);

	} 
}

```

![Class-without-constructor-demo](https://codeswag.co.uk/wp-content/uploads/2020/01/Class-example-without-constructor.png)

#### Constructors 
A constructor is a method that is called whenever an object of a class is being constructed. In the above example, we didn't write a constructor, so Java will create a default constructor for our class.
To create a constructor, we create a method in a class body with the same name as the class but with no return type(not even *void*). The method can have arguments also.
Let's rewrite the above code with a constructor:

``` java

package example;

public class ClassExample {

	private int x = 0;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public ClassExample(int x) {
		this.x = x;
	}
}

```
   
And then we rewrite the implementing code to use the constructor.   
``` java

package example;

public class Example {

	public static void main(String[] args) {

		int x; // local variable
		ClassExample example; // reference variable declaration

		example = new ClassExample(1023); // object creation / instantiation

		System.out.print("The value of the property x set by the constructor: ");
		x = example.getX();
		System.out.println(x);

	} 
	}

```

![Class-with-constrructor-demo](https://codeswag.co.uk/wp-content/uploads/2020/01/Class-example-with-constructor.png)

#### Another example
*Inheritance* is when a class gets the properties of another class. In Java, this achieved by the **extends** keyword.

We are given a task by a beverage company. They pack two categories of beverages, normal drinks, then wines. They want to create a system that calculates the amount of money they are going to make for all the batches they pack.
For a normal drink, the calculation of the total amount is pretty straight forward. It is proportional to the amount of beverage they put in that batch. However, for wine, the amount of money they make is proportional to the maturity of the wine also.

We want to create a system that allows the user to enter the information of all batches and then our system will calculate the total. Here is the information the user will provide.

* beverage category
* batch number
* amount of liquid(in liters);
* name of beverage
* price per liter
* price per year(optional)
* maturity(years)(optional)


The last two pieces of information are optional in the sense that they are only provided for the wines and not for normal drinks.
Looking at all the information we have, we can see that we need to create two classes, one for the normal drinks, and the other for the wines. Let's create one for the normal drinks. We will call it just Drink. It will have the following properties: liters, beverage_name, batch_no, price_per_liter. Then it will have the following methods: getPrice(), showInfo().

``` java

package example;

public class Drink {

    // properties are marked final because we do not wish them to be changed after instantiation
    // they are marked protected because we want the Wine class to be able to access them
    // otherwise we will have them marked private
    protected final String batch_no;  // yes it is a string
    protected final int liters; 
    protected final String beverage_name;
    protected final int price_per_liter;

    public Drink(String beverage_name, String batch_no, int liters, int price_per_liter) { // constructor
	// setting properties using values passed to the constructor
	this.beverage_name = beverage_name;
	this.batch_no = batch_no;
	this.liters = liters;
	this.price_per_liter = price_per_liter;
    }

    public int getTotalPrice() {
	// calculating the total price for the batch
	return liters * price_per_liter; 
    }

    public void showInfo() {
	// printing out all the information about this batch
	int price = getTotalPrice();
	System.out.println("\nBeverage name:\t" + this.beverage_name);
	System.out.println("Batch number:\t" + this.batch_no);
	System.out.println("Batch price:\t$" + price);
    }
}

```

Now let's define the Wine class. It will have the following the properties: liters, beverage_name, batch_no, price_per_liter, maturity, price_per_year.
As we can see, the first four properties are already there in the Drink class. We can avoid doing work twice by inheriting the Drink class, then just add what is not there. The Wine class will also have the same methods as the drink class.

``` java

package example;

public class Wine extends Drink {

    // properties marked final because we do not wish to change them after instantiation
    // marked private because we do not wish them to be accessed outside this class
    private final int maturity;
    private final int price_per_year;

    public Wine(String beverage_name, String batch_no, int liters, int price_per_liter, int maturity, int price_per_year) { // constructor
	super(beverage_name, batch_no, liters, price_per_liter); // calling the constructor of the super class
	this.maturity = maturity;
	this.price_per_year = price_per_year;
    }

    @Override
    public int getTotalPrice() {
	// calculating the total price of the batch, returning the result.
	int price, maturity_price, amount_price;
	amount_price = super.liters * super.price_per_liter;
	maturity_price = super.liters * this.maturity;
	price = maturity_price + amount_price;
	return price;
    }
}

```

What we did with *getTotalPrice()* is called *overriding*. Overriding refers to the reimplementation of a superclass method to suits the need of the subclass, keeping the interface. For example, here in the Wine class we still wanted price, but we wanted to calculate it differently. Overriding is the basis of polymorphism. We can override any member method as long as it is not declared final and we're willing to keep the interface.

Now let's create a class to implement the Wine and Drink classes:

``` java

package example;

import java.util.Scanner;

public class Beverages {
    public static void main(String[] args) {

	int number_of_batches;
	Scanner scan = new Scanner(System.in);
	String clear;

	System.out.print("Enter the number of batches: ");
	number_of_batches = scan.nextInt();
	clear = scan.nextLine();

	Drink[] batches = new Drink[number_of_batches];

	int liters, price_per_liter, maturity, price_per_year;
	String type, name, batch_no;

	for (int i = 0; i < number_of_batches; i++) {
	    System.out.print("\nEnter beverage type (drink/wine): ");
	    type = scan.nextLine();
	    System.out.print("Enter beverage name: ");
	    name = scan.nextLine();
	    System.out.print("Enter batch_no: ");
	    batch_no = scan.nextLine();
	    System.out.print("Enter amount of beverage in batch(liters): ");
	    liters = scan.nextInt();
	    clear = scan.nextLine();
	    System.out.print("Enter price per liter: $");
	    price_per_liter = scan.nextInt();
	    clear = scan.nextLine();

	    switch (type) {

		case "wine":

		    System.out.print("Enter maturity(years): ");
		    maturity = scan.nextInt();
		    clear = scan.nextLine();
		    System.out.print("Enter price per year: $");
		    price_per_year = scan.nextInt();
		    clear = scan.nextLine();

		    batches[i] = new Wine(name, batch_no, liters, price_per_liter, maturity, price_per_year);

		    break;

		case "drink":
		    batches[i] = new Drink(name, batch_no, liters, price_per_liter);
		    break;

		default: 
		    System.err.println("You entered a wrong beverage type. I'm exiting");
		    System.exit(1);
	    }
	}

	int totalPrice = 0;
	int batch_price;

	for (int i = 0; i < number_of_batches; i++) {
	    batches[i].showInfo();
	    batch_price = batches[i].getTotalPrice(); // polymorphism at work
	    totalPrice = totalPrice + batch_price; // incrementing the total price by the price of the current batch 
	}

	System.out.println("\nTotal price: $" + totalPrice);

    }
}

```

![Beverages-example-output](https://codeswag.co.uk/wp-content/uploads/2020/01/Beverages-example-2.png)

In our example we have demonstrated all the benefits of OOP:

* **Inheritance**: We have made the Wine class to inherit the Drink class, demonstrating code reuse, avoiding doing the work twice.
* **Encapsulation** We have demonstrated encapsulation just by creating classes. We've reaped the benefits of encapsulation when we were calling the *getTotalPrice()* method. If it wasn't for encapsulation, we would have needed to pass the parameters needed to calculate the price(2 when calculating price for a Drink batch, 4 when calculating that for a Wine batch). This can create complexity, and provide room for errors, especially in programs where that kind of function is called a lot of times.
* **Abstraction**: we have achieved the benefit of abstraction by hiding the implementation of the methods *getTotalPrice()* and *showInfo()*. In the software development world, it's not always the case that the person who defines the class is the one who will use them. So if someone else had written the Beverages class, they would have reaped that benefit by not caring how the code in Wine and drink classes had been written.
* **Polymorphism**: we have achieved the benefit of polymorphism by overriding the method *getTotalPrice()*. When we were iterating the batches array, we didn't have to test which class each element belonged to so as to call the correct method. We just invoked the method, and the correct method will be called depending on the class of the element.






### Multithreading
A multi-threaded program is a program that has two or more parts that can run simultaneously. The parts are called threads. All the programs we've been writing so far are single-threaded. We can achieve that in Java by creating a class and inheriting the Thread  class, then override a method called *run()*. We can create as many different classes as we want that way. The parts of our code that we want to run in parallel are the ones that we place in the overridden *run()* methods. Then we create instances of those classes. Then we call a method called *start()*, inherited from the Thread class. 

Let's do an example. We want to create a simple class that printout a name we will give it and the number of times it had run. We will create two instances of the class, give it two different names so that we can see which one is printing what lines.

``` java 

package example;

public class ThreadExample extends Thread {

    private final String name;

    public ThreadExample(String name) { // constructor
	this.name = name;  // setting name
    }

    @Override
    public void run() {
	int i;

	for (i = 0; i < 10; i++) {
	    System.out.println(this.name + "  printing " + i);
	    try {
		Thread.sleep(1000);
	    } catch (Exception e) {
		System.exit(1);
	    }
	}
    }
}

```

The following is the implementing class:

``` java 

package example;

public class Example {

    public static void main(String[] args) {

       ThreadExample threadA = new ThreadExample("A"); // creating a thread with name B
       ThreadExample threadB = new ThreadExample("B"); // creating a thread with name B

       threadA.start(); // starting threadA
       threadB.start(); // starting threadB

    }

}

```

<div><img alt="Multitheading-demo" src="https://codeswag.co.uk/wp-content/uploads/2020/01/Multithreading-example-1.png"></div>
