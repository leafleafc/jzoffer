package learn;

import java.util.Scanner;
import java.util.Stack;


/**
 * @author_Stone6762
 */
public class ArithExpEvaluation {

	/**
	 * @Describe_��ԭʼ�ı��ʽת����һ����׺���ʽ
	 * @param expressionԭʼ�ı��ʽ
	 * @return��Ԫ�ر��ʽ����ڵĺ�׺���ʽ
	 * @throws Exception
	 */
	public String conver2Postfix(String expression) throws Exception {
		LinkedStack st = new LinkedStack();// �����ջ
		String postFix = "";// ��׺���ʽ
		st.push('#');
		for (int i = 0; expression != null && i < expression.length(); i++) {
			//if(i==0){}
			char c = expression.charAt(i);// ����������ǲ�����������ǲ�����
			System.out.println("111111"+c);
			if (' ' != c) {// �ַ�����Ϊ��
				if (isOpenParenthesis(c)) {// ������
					// �����ž���ջ
					st.push(c);
				} else if (isCloseParenthesis(c)) {// ������
					// �����žͰ����еĲ�������ջ֪������һ��������Ϊֹ��Ȼ�󽫸������ų�ջ������
					Character ac = (Character) st.pop();
					while (!isOpenParenthesis(ac)) {
						postFix += ac.toString();
						ac = (Character) st.pop();// ���ȡ�����������ţ�����Ȼ�Ͷ�����
					}
				} else if (isOperator(c)) {// ������
					/*
					 * ���ջΪ�գ�ֱ�ӽ�ջ�� ���ջ�ǿգ�����Ҫ��ջ������������ȼ���Ҫ��ջ������������ȼ����бȽ�
					 * ��ջ�б�Ҫ��ջ����������ȼ��ߵ����������ջ��Ȼ�󽫸��������ջ
					 */
					if (!st.isEmpty()) { // ���ջ�ǿգ�����Ҫ�ж�
						Character ac = (Character) st.pop();
						System.out.println("222222"+ac);
						//if (st.isEmpty()) System.out.println("Empty");
						while (ac!='#'
								&& priority(ac.charValue()) > priority(c)) {
							postFix += ac;
							System.out.println("33333"+ac);
							ac = (Character) st.pop();
							System.out.println("44444"+ac);
							// ��Ϊ����ȡ�������ж��ǣ������������ѭ�� ��Ҫ�����һ��ȡ���Ĳ�����ѹ��ջ
						}
						// �����һ��ȡ�������ȼ��͵��������ջ
						//if (ac!='#') {
							st.push(ac);
						//}
					}
					// ��󣬽����������ջ
					st.push(c);
				} else {// ��������ֱ����ӵ���׺���ʽ ��
					postFix += c;
				}
			}
		}
		// ����ʱ�����ջ�ǿգ�����Ҫջ�е����е��������������׺���ʽ��ĩβ
		while (!st.isEmpty()) {
			String last = st.pop().toString();
			if(!last.equals("#"))
			    postFix += last ;
		}
		System.out.println(postFix);
		return postFix;
	}

	/** 
	 * @Describe_�Ժ�׺���ʽ��������
	 * @param postFix��׺���ʽ
	 * @return�����Ľ��
	 * @throws Exception
	 */
	public double numberCalculate(String postFix) throws Exception {
		LinkedStack st = new LinkedStack();// ������ջ
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
				
				st.push(d3);//��������Ľ����ջ
			}else{//���ǲ�����ʱ����ֱ�ӽ�������ջ
				st.push(c);
			}

		}

		return Double.valueOf(st.pop().toString());
	}

	/**
	 * @Describe_������������ȼ�
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

	/** @Describe�Ƿ���һ��������_
	 */
	private boolean isOperator(char c) {
		if ('+' == c || '-' == c || '*' == c || '/' == c || '^' == c
				|| '%' == c) {
			return true;
		}
		return false;
	}

	/** @Describe�Ƿ���һ��������_
	 */
	private boolean isCloseParenthesis(char c) {
		return ')' == c;
	}

	/**@Describe_�ж��Ƿ���һ��������
	 */
	private boolean isOpenParenthesis(char c) {
		return '(' == c;
	}

	public static void main(String[] args) throws Exception {
		
		ArithExpEvaluation p=new ArithExpEvaluation();
		Scanner scan = new Scanner(System.in);
		System.out.println("�������������ʽ��   ");
		while (scan.hasNext()) {
			String str=scan.next();
			String postFix=p.conver2Postfix(str);
			System.out.println("����ǣ�    "+p.numberCalculate(postFix));
			System.out.println();
			System.out.println("�������������ʽ��   ");
		}
		
	}
}



