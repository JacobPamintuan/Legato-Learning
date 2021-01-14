package guiScreens;

import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Data {


	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static String[] QUIZZES = new String[2];
	
	public Data() throws Exception {

	}

	public void loadData() throws IOException {
		BufferedReader br = new BufferedReader(new java.io.FileReader(new File("Files/Data.txt")));

		for(int i=0;i<2;i++) {
			QUIZZES[i]= br.readLine();
		}
		
		String line = QUIZZES[0];
		System.out.println(line);
		String[] str = line.trim().split(";");

		for (int i = 0; i < str.length; i++)
			System.out.println(str[i]);

		String course = str[0];
		String diff = str[1];
		String q = str[2];
		int lessonNum = Integer.parseInt(str[3]);
		int currPane = Integer.parseInt(str[4]);
		int numQ = Integer.parseInt(str[5]);

		String[] ans = str[6].trim().split(",");
		int[] ansKey = new int[numQ];

		String[] bool = str[7].trim().split(",");
		boolean[] correct = new boolean[numQ];

		String[] wrong= str[8].trim().split(",");
		int[] numWrong = new int[numQ];
		for (int i = 0; i < numQ; i++) {
			ansKey[i] = Integer.parseInt(ans[i]);
			correct[i]=Boolean.parseBoolean(bool[i]);
			numWrong[i]=Integer.parseInt(wrong[i]);
		}
		
		ImageIcon qImage = new ImageIcon(str[9]);
		
		String[] ansImages = str[10].trim().split(":");
		ImageIcon[][] ansArr = new ImageIcon[numQ][4];
		
		String[] answers = str[11].trim().split(":");
		String[][]ansText = new String[numQ][4];
		
		for(int i=0;i<numQ;i++) {
			System.out.println(answers[i]);//
		}
		
		for(int i=0;i<numQ;i++) {
			String[] temp = answers[i].trim().split(",");
			String[] Temp = ansImages[i].trim().split(",");
			for(int j=0;j<4;j++) {
				ansText[i][j] = temp[j];
				if(Temp[j].equalsIgnoreCase("null")) {
					ansArr[i][j] = null; System.out.println("NULL IMAGE");}
				
				else{
					ansArr[i][j] = new ImageIcon("images/Test.png");//Temp[j]);
					System.out.println("Valiud IMAGE "  +Temp[j]);
				}
			}
				 
		}
		
		for(int i=0;i<numQ;i++) {
			
			for(int j=0;j<4;j++) {
				System.out.println(ansText[i][j]);
				System.out.println(ansArr[i][j]);
			}
			
			System.out.println();
				 
		}
		//br.close();
		//return new Quiz(course, diff, q, lessonNum, currPane, numQ,ansKey, correct, numWrong,  qImage, ansArr, ansText);
	}

}

//package postApp;
//import java.io.*;
//import java.util.*;
//
//public class SaveData {
//	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//	static StringTokenizer st;
//	
//	public static Map<String, Value> users = new HashMap();
//	public static int numUsers=0;
//	
//	public SaveData() throws Exception{
//		loadUsers();
//	}
//	
//	private void loadUsers() throws IOException {
//		BufferedReader br = new BufferedReader(new java.io.FileReader(new File("Files/UsernameAndPasswords.txt")));
//		
//		if(!checkLoad())return;
//		String line; //file formatting:   User Number:Username:Password (hashed)
//		while((line=br.readLine())!=null) {
//			String str[] = line.trim().split(":");
//			users.put(str[1],new Value(Integer.parseInt(str[0]),str[2]));
//			numUsers=Integer.parseInt(str[0]);
//		}
//		br.close();
//		
//	}
//	
//	public static void addUser(String username, String password) throws Exception {
//		if(checkUsername(username)) return;
//		String hash = byteArrayToHexString(computeHash(password));
//		users.put(username,new Value(++numUsers,hash));
//		try {
//			BufferedWriter pr = new BufferedWriter(new FileWriter(new File("Files/UsernameAndPasswords.txt"),true));
//			pr.write(String.format("%d:%s:%s\n", numUsers,username,hash));
//			pr.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public static boolean checkUsername(String username) {
//		return users.containsKey(username);
//	}
//	
//	public static boolean checkPassword(String username, String password) throws Exception {
//		String hash = byteArrayToHexString(computeHash(password));
//		if(checkUsername(username))
//			return users.get(username).getPassword().equals(hash);
//		return false;
//	}
//	
//	
//	public static byte[] computeHash(String password) throws Exception {
//		java.security.MessageDigest digest =null;
//		digest = java.security.MessageDigest.getInstance("SHA-1");
//		digest.reset();
//		digest.update(password.getBytes());
//		return  digest.digest();
//	}
//
//  public static String byteArrayToHexString(byte[] hash){
//		StringBuffer hexString = new StringBuffer(hash.length * 2);
//		for (int i = 0; i < hash.length; i++){
//			int hex = hash[i] & 0xff;
//			if (hex < 16)
//				hexString.append('0');
//		    hexString.append(Integer.toHexString(hex));
//		}
//		return hexString.toString().toUpperCase();
//  }
//  
//  private boolean checkLoad() {
//		File newFile = new File("Files/UsernameAndPasswords.txt");
//	    if (newFile.length() == 0) return false;
//		return true;
//	}
//	
//	
//}
//
//	class Value{
//		String password;
//		int userNum;
//		
//		public Value(int userNum,String password) {
//			this.password=password;
//			this.userNum = userNum;
//		}
//		
//		public String getPassword() {
//			return password;
//		}
//		public void setPassword(String password) {
//			this.password = password;
//		}
//		public int getUserNum() {
//			return userNum;
//		}
//		public void setUserNum(int userNum) {
//			this.userNum = userNum;
//		}
//		
//		
//	}