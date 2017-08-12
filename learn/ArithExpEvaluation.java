package learn;

import java.util.Scanner;
import java.util.Stack;


/**
 * @author_Stone6762
 */
public class ArithExpEvaluation {

	/**
	 * @Describe_将原始的表达式转换成一个后缀表达式
	 * @param expression原始的表达式
	 * @return与元素表达式相对于的后缀表达式
	 * @throws Exception
	 */
	public String conver2Postfix(String expression) throws Exception {
		LinkedStack st = new LinkedStack();// 运算符栈
		String postFix = "";// 后缀表达式
		st.push('#');
		for (int i = 0; expression != null && i < expression.length(); i++) {
			//if(i==0){}
			char c = expression.charAt(i);// 遍历，如果是操作数，如果是操作符
			System.out.println("111111"+c);
			if (' ' != c) {// 字符不能为空
				if (isOpenParenthesis(c)) {// 左括号
					// 左括号就入栈
					st.push(c);
				} else if (isCloseParenthesis(c)) {// 右括号
					// 右括号就把所有的操作符出栈知道遇到一个左括号为止，然后将该左括号出栈并丢弃
					Character ac = (Character) st.pop();
					while (!isOpenParenthesis(ac)) {
						postFix += ac.toString();
						ac = (Character) st.pop();// 如果取出的是左括号，很显然就丢弃了
					}
				} else if (isOperator(c)) {// 操作符
					/*
					 * 如果栈为空，直接进栈。 如果栈非空，则需要将栈顶运算符的优先级和要入栈的运算符的优先级进行比较
					 * 将栈中比要入栈的运算符优先级高的运算符都出栈，然后将该运算符入栈
					 */
					if (!st.isEmpty()) { // 如果栈非空，则需要判断
						Character ac = (Character) st.pop();
						System.out.println("222222"+ac);
						//if (st.isEmpty()) System.out.println("Empty");
						while (ac!='#'
								&& priority(ac.charValue()) > priority(c)) {
							postFix += ac;
							System.out.println("33333"+ac);
							ac = (Character) st.pop();
							System.out.println("44444"+ac);
							// 因为是先取出来后判断是，所以如果跳出循环 需要将最后一次取出的操作符压入栈
						}
						// 将最后一次取出的优先级低的运算符入栈
						//if (ac!='#') {
							st.push(ac);
						//}
					}
					// 最后，将该运算符入栈
					st.push(c);
				} else {// 操作数，直接添加到后缀表达式 中
					postFix += c;
				}
			}
		}
		// 最后的时候，如果栈非空，则需要栈中的所有的运算符串联到后缀表达式的末尾
		while (!st.isEmpty()) {
			String last = st.pop().toString();
			if(!last.equals("#"))
			    postFix += last ;
		}
		System.out.println(postFix);
		return postFix;
	}

	/** 
	 * @Describe_对后缀表达式进行运算
	 * @param postFix后缀表达式
	 * @return计算后的结果
	 * @throws Exception
	 */
	public double numberCalculate(String postFix) throws Exception {
		LinkedStack st = new LinkedStack();// 操作数栈
		for (int i = 0; i < postFix.length(); i++) {
			char c = postFix.charAt(i);
			if (isOperator(c)) {
				double d2 = Double.valueOf(st.pop().toString());
				double d1 = Double.valueOf(st.pop().toString());
				double d3 = 0;
				switch (c) {
				case '+':
					d3=d1+d2;
					break;
				case '-':
					d3=d1-d2;
					break;
				case '*':
					d3=d1*d2;
					break;
				case '/':
					d3=d1/d2;
					break;
				case '%':
					d3=d1%d2;
					break;
				case '^':
					d3=Math.pow(d1, d2);
					break;
				
				default:
					break;
				}
				
				st.push(d3);//将操作后的结果入栈
			}else{//当是操作数时，就直接进操作数栈
				st.push(c);
			}

		}

		return Double.valueOf(st.pop().toString());
	}

	/**
	 * @Describe_求运算符的优先级
	 */
	private int priority(char c) {
		switch (c) {
		case '^':
			return 4;
		case '*':
		case '/':
		case '%':
			return 3;
		case '-':
			return 2;
		case '+':
			return 1;
		}
		return 0;
	}

	/** @Describe是否是一个操作符_
	 */
	private boolean isOperator(char c) {
		if ('+' == c || '-' == c || '*' == c || '/' == c || '^' == c
				|| '%' == c) {
			return true;
		}
		return false;
	}

	/** @Describe是否是一个右括号_
	 */
	private boolean isCloseParenthesis(char c) {
		return ')' == c;
	}

	/**@Describe_判断是否是一个左括号
	 */
	private boolean isOpenParenthesis(char c) {
		return '(' == c;
	}

	public static void main(String[] args) throws Exception {
		
		ArithExpEvaluation p=new ArithExpEvaluation();
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入算术表达式：   ");
		while (scan.hasNext()) {
			String str=scan.next();
			String postFix=p.conver2Postfix(str);
			System.out.println("结果是：    "+p.numberCalculate(postFix));
			System.out.println();
			System.out.println("请输入算术表达式：   ");
		}
		
	}
}



