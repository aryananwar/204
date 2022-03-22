
public class Notation {
	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException 
	{
		MyQueue<Character> solution = new MyQueue<Character>(20);
		MyStack<Character> operators = new MyStack<Character>(20);
		
		try
		{
			for (int i =0; i<infix.length(); i++)
			{
				/*
				switch (infix.charAt(i))
				{
					case ' ':
						break;
					case '(':
						operators.push(infix.charAt(i));
						continue;
					case '+':
					case '-':
					case '*':
					case '/':
						while(checker(infix.charAt(i)) <= checker(operators.top()) && operators.isEmpty() != true)
						{
							solution.enqueue(operators.top());
							operators.pop();
						}
						operators.push(infix.charAt(i));
						break;
					case ')':
						while(operators.top() != '(' && operators.isEmpty() != true)
						{
							solution.enqueue(operators.top());
							operators.pop();
						}
						operators.pop();
						break;
						
				}
				*/
				
				if (infix.charAt(i) == ' ')
					continue;
				if (Character.isDigit(infix.charAt(i)))
				{
					solution.enqueue(infix.charAt(i));
					continue;
				}
				if (infix.charAt(i) == '(')
				{
					operators.push(infix.charAt(i));
					continue;
				}
				if(infix.charAt(i) == '+' 
							|| infix.charAt(i) == '-' 
							|| infix.charAt(i) == '*'
							|| infix.charAt(i) == '/')
				{
					while(checker(infix.charAt(i)) <= checker(operators.top()) && operators.isEmpty() != true)
					{
						solution.enqueue(operators.top());
						operators.pop();
					}
					operators.push(infix.charAt(i));
					continue;
				}
				if (infix.charAt(i) == ')')
				{
					while(operators.top() != '(' && operators.isEmpty() != true)
					{
						solution.enqueue(operators.top());
						operators.pop();
					}
					operators.pop();
					continue;
				}
				
				while (operators.isEmpty() != true)
				{
					solution.enqueue(operators.top());
					operators.pop();
				}

			
			}
		}
		catch (Exception e)
		{
			throw new InvalidNotationFormatException();
		}
		
		return solution.toString();


	}

	public static String convertPostfixToInfix(String expr) throws  InvalidNotationFormatException 
	{
		MyStack<String> end = new MyStack<String>(20);
		try
		{
			for (int i=0; i< expr.length(); i++)
			{
				if(Character.isDigit(expr.charAt(i)))
				{
					end.push(Character.toString(expr.charAt(i)));
					continue;
				}
	
				if (expr.charAt(i) == ' ')
					continue;
				if(expr.charAt(i) == '+' 
						|| expr.charAt(i) == '-' 
						|| expr.charAt(i) == '*'
						|| expr.charAt(i) == '/')
				{
					String test = end.pop();
					String temp = end.pop();
					end.push("(" + temp + expr.charAt(i) + test + ")");
				}
					
				/*
				switch(expr.charAt(i))
				{
					case ' ':
						break;
					case '(':
						stack.push(expr.charAt(i));
						break;
					case '+':
					case '-':
					case '*':
					case '/':
						
					
				}
				*/
			}
		}
		catch(Exception e)
		{
			throw new InvalidNotationFormatException();
		}
		return end.toString();
	}
	
	public static double evaluatePostfixExpression(String expr) throws InvalidNotationFormatException {
		MyStack<String> s = new MyStack<String>(10);

		try 
		{
			for (int i = 0; i < expr.length(); i++) {
				if (expr.charAt(i) == ' ')
					continue;
				if (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '(')
					s.push(Character.toString(expr.charAt(i)));

				else if (expr.charAt(i) == '-' || expr.charAt(i) == '+' || expr.charAt(i) == '*'
						|| expr.charAt(i) == '/') {
					
					Double second = Double.parseDouble(s.pop());
					Double first = Double.parseDouble(s.pop());
						
					if (expr.charAt(i) == '*')
					{
						Double t = first * second;
						s.push(t.toString());
						continue;
					}
					if (expr.charAt(i) == '-')
					{
						Double t = first - second;
						s.push(t.toString());
						continue;
					}
					if (expr.charAt(i) == '+')
					{
						Double t = first + second;
						s.push(t.toString());
						continue;
					}
					if (expr.charAt(i) == '/')
					{
						Double t = first / second;
						s.push(t.toString());
						continue;
					}
				
				}

			}

			return Double.parseDouble(s.pop());
		} 
		catch (Exception e)
		{
			throw new InvalidNotationFormatException();
		}

	}
	
	static int checker(char op)
	{
		if (op == '+' || op == '-')
			return 0;
		if (op == '/' || op == '*')
			return 1;
		return -2;
	}
	
}
