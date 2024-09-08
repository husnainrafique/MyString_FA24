import java.util.Arrays;

//CSC330 Assignment 1
//complete the MyString class

public class MyString implements Comparable {
	//provided code
	private char [] str_arr;
	private int curr_len;
	
	//constructors
	public MyString() {
		str_arr = null;
		curr_len = 0;
	}
	public MyString(String str) {
		//make the array
		str_arr = new char[str.length()];
		//copy the characters
		for(int i = 0; i < str.length(); i++) {
			str_arr[i] = str.charAt(i);
		}
		//update the length
		curr_len = str.length();
	}
	public MyString(MyString str) {
		this.str_arr = new char[str.curr_len];
		for(int i = 0; i < str.curr_len; i++) {
			this.str_arr[i] = str.str_arr[i];
		}
		this.curr_len = str.curr_len;
	}
	
	
	//utilities
	private void ensureCapacity() {
		if(str_arr == null) {
			str_arr = new char[5];
		}
		else if(curr_len == str_arr.length){
			//need more room
			char [] temp = new char[str_arr.length*2];
			//copy the chars to new space
			for(int i = 0; i < curr_len; i++) {
				temp[i] = str_arr[i];
			}
			//update str_arr 
			str_arr = temp;
		}
	}
	
	private void addChar(char ch) {
		ensureCapacity();
		str_arr[curr_len++] = ch;
	}
	
	
	@Override
	public String toString() {
		String s = "";
		for(char c : str_arr) {
			s+=c;
		}
		return s;
	}
	
	//accessors
	public char get(int index) {
		if(index < 0 || index >= curr_len) {
			throw new IndexOutOfBoundsException();
		}
		return str_arr[index];
	}
	
	public int length() {
		return curr_len;
	}
	
	//using String class methods
	public MyString toUpper() {
		String str = this.toString();
		str = str.toUpperCase();
		MyString result = new MyString(str);
		return result;
	}
	
	//manipulating the data directly
	public MyString toLower() {
		//make a new MyString
		MyString str = new MyString(this);
		for(int i = 0; i < str.length(); i++) {
			if(str.str_arr[i] >= 'A' && str.str_arr[i] <= 'Z') {
				str.str_arr[i] = Character.toLowerCase(str.str_arr[i]);
			}
		}
		return str;		
	}
	
	
	
	//end of provided code.
	
	//write your implementations here
	
	//+compareTo(str : MyString) : int
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof MyString))
		{
			throw new ClassCastException("Object is not an instance of MyString")
				
		}
		MyString str = (MyString) o;
		int len = Math.min(this.length(), str.length());
		for( int i=0; i<len;i++)
			{
				if(this.get(i) != str.get(i)){
				return this.get(i) - str.get(i);
			}
			}
		return this.length() - str.length();
		// TODO Auto-generated method stub
		return 0;
	}
	
	//+concat(str : MyString) : MyString
	public MyString concat (MyString str)
	{
		MyString result = new MyString(this);
		for (int i=0; i< str.length(); i++)
			{
				result.addChar(str.get(i));
			}
		return result;
	}
	
	//+concat(str : String) : MyString
		public MyString concat (String str)
	{
		MyString result = new MyString(this);
		for (int i=0; i< str.length(); i++)
			{
				result.addChar(str.charAt(i));
			}
		return result;
	}
	
	//+indexOf(str : MyString) : int
	public int indexOf(MyString str)
	{
		int len = str.length();
		for(int i=0; i<=this.length() - len; i++)
			{
				boolean match= true;
				for(int j= 0; i<len; j++)
					{
						if(this.get(i+j) != str.get(j))
						{
							match=false;
							break;
						}
					}
				if (match){
					return i;
				}
			}
				return -1;
	}
	
	
	//+lastIndexOf(str : MyString) : int
		public int lastIndexOf(MyString str)
	{
		int len = str.length();
		for(int i=this.length() - len; i>=0; i--)
			{
				boolean match= true;
				for(int j= 0; i<len; j++)
					{
						if(this.get(i+j) != str.get(j))
						{
							match=false;
							break;
						}
					}
				if (match){
					return i;
				}
			}
				return -1;
	}
	
	
	//+substring(start : int) : MyString
	public MyString substring(int start)
	{
		if(start < 0 || start > this.length())
		{
			throw new IndexOutOfBoundsException();
		}
		MyString result = new MyString();
		for(int i= start; i <this.length(); i++)
			{
				result.addChar(this.get(i));
			}
		return result;
	}
	//+substring(start : int, end : int) : MyString
		public MyString substring(int start,int end)
	{
		if(start < 0 || end > this.length() || start>end)
		{
			throw new IndexOutOfBoundsException();
		}
		MyString result = new MyString();
		for(int i= start; i <end; i++)
			{
				result.addChar(this.get(i));
			}
		return result;
	}

	
	
}
