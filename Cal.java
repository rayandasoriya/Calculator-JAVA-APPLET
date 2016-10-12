/*
    This program perform all the basic operation that can be performed on a calculator.
    The operations include addition,subtraction,division,multiplication and power.
    Program will work on decimal numbers as well.
    This program covers the concept of
        •	Use of Variables , Arrays , Operators and Control Statements
        •	Use of Classes
        •	Use of Inheritance
        •	Use of Packages and Interfaces
        •	Use of String Handling
        •	Use of Graphics and Applets
*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
 
public class Cal extends Applet implements ActionListener   //ActionListener is used for buttons functioning
{
	String msg=" ";
	double v1,v2,result;                                 //Declaration of variables
	TextField t1;                                        //Textfield for input
	Button b[]=new Button[10];                           //Buttons for Numbers
	Button add,sub,mul,div,clear,mod,EQ,dec,pow;         //Buttons for operations
	char OP;
	public void init()                                   //Runs on initialization
	{
            
		setBackground(Color.red);                    //Background colour set to red
		t1=new TextField(10);                        //t1 declared as textfield
		GridLayout gl=new GridLayout(5,4);           //Gridlines declared
		setLayout(gl);                               //Gridline set
		for(int i=0;i<10;i++)
		{
			b[i]=new Button(""+i);               //Declaration of array of b as buttons
		}
                dec=new Button(".");                         //Declaration of . as button dec
		add=new Button("+");                         //Declaration of + as button add
		sub=new Button("-");                         //Declaration of - as button sub
		mul=new Button("x");                         //Declaration of x as button mul
		div=new Button("/");                         //Declaration of / as button div
		mod=new Button("%");                         //Declaration of % as button mod
                pow=new Button("^");                         //Declaration of ^ as button pow
		clear=new Button("CLEAR");                   //Declaration of CLEAR as button clear
		EQ=new Button("=");                          //Declaration of = as button EQ
                 
         
                //Adding of buttons and textfields on output window
                
		add(t1);                                     //Addition of textfieild      
		for(int i=0;i<10;i++)
		{
			add(b[i]);                           //Buttons for number added
		}
                add(dec);                                    //Button for decimal added
		add(add);                                    //Button for addition added
		add(sub);                                    //Button for subtraction added
		add(mul);                                    //Button for multiplication added    
		add(div);                                    //Button for division added    
		add(mod);                                    //Button for modulous added
                add(pow);                                    //Button for power added
		add(clear);                                  //Button for clear added
		add(EQ);                                     //Button for equals to added
		
                //Adding of action listener for buttons on Display window
                
                for(int i=0;i<10;i++)
		{
			b[i].addActionListener(this);
		}
                dec.addActionListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		mod.addActionListener(this);
                pow.addActionListener(this);
		clear.addActionListener(this);
		EQ.addActionListener(this);
	}
 
      
	public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();            //Gets the input of the action performed in the output window
		char ch=str.charAt(0);
		if ( Character.isDigit(ch)|| ch=='.')        //Checks if the entered digit is a digit or a decimal
		t1.setText(t1.getText()+str);                //If it is a digit,then it will accept another character and will keep on concatenating the string
		else
		if(str.equals("+"))                          //Checks if the entered character is "+"
		{
			v1=Double.parseDouble(t1.getText()); //Converts the entered String in Textview to Integer 
			OP='+';
			t1.setText("");                      //It sets the textfield to NULL
		}
		else if(str.equals("-"))                     //Checks if the entered character is "-"
		{
			v1=Double.parseDouble(t1.getText()); //Converts the entered String in Textview to Integer 
			OP='-';
			t1.setText("");                      //It sets the textfield to NULL
		}
		else if(str.equals("x"))                     //Checks if the entered character is "x"
		{
			v1=Double.parseDouble(t1.getText()); //Converts the entered String in Textview to Integer 
			OP='*';
			t1.setText("");                      //It sets the textfield to NULL
		}
		else if(str.equals("/"))                     //Checks if the entered character is "/"
		{
			v1=Double.parseDouble(t1.getText()); //Converts the entered String in Textview to Integer 
			OP='/';
			t1.setText("");                      //It sets the textfield to NULL
		}
		else if(str.equals("%"))                     //Checks if the entered character is "%"
		{
			v1=Double.parseDouble(t1.getText()); //Converts the entered String in Textview to Integer   
			OP='%';                     
			t1.setText("");                      //It sets the textfield to NULL
		}
                else if(str.equals("^"))                     //Checks if the entered character is "^"
		{
			v1=Double.parseDouble(t1.getText()); //Converts the entered String in Textview to Integer   
			OP='^';                     
			t1.setText("");                      //It sets the textfield to NULL
		}
		if(str.equals("="))                          //Checks if the entered character is "="
		{
			v2=Double.parseDouble(t1.getText()); //Converts the entered String in Textview to Integer and store it in another variable v2 
			if(OP=='+')                          //Checks for operator
				result=v1+v2;
			else if(OP=='-')
				result=v1-v2;
			else if(OP=='*')
				result=v1*v2;
			else if(OP=='/')
				result=v1/v2;
			else if(OP=='%')
				result=v1%v2;
                        else if(OP=='^')
				result=Math.pow(v1,v2);     //Use of power function
			t1.setText(""+result);              //Dispalys the result in textview
		}	
		if(str.equals("CLEAR"))                     //Checks if the entered character is "CLEAR"
		{
			t1.setText("");                     //It sets the textfield to NULL
		}
	}

}