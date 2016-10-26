import java.io.File;
import java.io.IOException;

public class GenerateOne {
	public static void main(String []args) {
		System.out.println(generateRML());
		System.out.println(generateWYT());
	}
	
	
	public static String generateRML() {
		
		String format="222，222，23，222。x2， 222。";
		char [] formatch=format.toCharArray();
 		String res="《如梦令》       ";
		String str1="",str2="",str3="";
		try {
			str1 = ReadFile.readFileContent(new File("result1.txt"));
			str2 = ReadFile.readFileContent(new File("result2.txt"));
			str3 = ReadFile.readFileContent(new File("result3.txt"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] string1 = str1.split("#");
		String[] string2 = str2.split("#");
		String[] string3 = str3.split("#");
		
		String temp="";
		for(int i=0;i<formatch.length;){
			switch (formatch[i]) {
			case '1':
				res+=string1[Random(50)].substring(0, 1);
				i++;
				break;
			case '2':
				res+=string2[Random(50)].substring(0, 2);
				i++;
				break;
			case '3':
				res+=string3[Random(50)].substring(0, 3);
				i++;
				break;
			case 'x':
				i++;
				if(formatch[i]=='2')
				temp=string2[Random(50)].substring(0, 2);
				res=res+temp+"，"+temp;
				i++;
				break;
			default:
				res=res+formatch[i];
				i++;
				break;
				
			}
		}
		
		return res;
	}	
	
public static String generateWYT() {
		
		String format="222，3，2223。3，3，3， 222、3。";
		char [] formatch=format.toCharArray();
 		String res="《乌夜啼》       ";
		String str1="",str2="",str3="";
		try {
			str1 = ReadFile.readFileContent(new File("result1.txt"));
			str2 = ReadFile.readFileContent(new File("result2.txt"));
			str3 = ReadFile.readFileContent(new File("result3.txt"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] string1 = str1.split("#");
		String[] string2 = str2.split("#");
		String[] string3 = str3.split("#");
		
		String temp="";
		for(int i=0;i<formatch.length;){
			switch (formatch[i]) {
			case '1':
				res+=string1[Random(50)].substring(0, 1);
				i++;
				break;
			case '2':
				res+=string2[Random(50)].substring(0, 2);
				i++;
				break;
			case '3':
				res+=string3[Random(50)].substring(0, 3);
				i++;
				break;
			case 'x':
				i++;
				if(formatch[i]=='2')
				temp=string2[Random(50)].substring(0, 2);
				res=res+temp+"，"+temp;
				i++;
				break;
			default:
				res=res+formatch[i];
				i++;
				break;
				
			}
		}
		
		return res;
	}	
	
	public static int Random(int max) {
		java.util.Random random=new java.util.Random();// 定义随机类
		int result=random.nextInt(max);// 返回[0,10)集合中的整数，注意不包括10
		return result+1; 
	}
}
