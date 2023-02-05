package scrap;
import java.text.Normalizer;
import java.util.Collection;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import java.lang.Object;

public class search {
	public int getIndexOfLargest( double[] array )
	{
	  if ( array == null || array.length == 0 ) return -1; // null or empty

	  int largest = 0;
	  for ( int i = 1; i < array.length; i++ )
	  {
	      if ( array[i] > array[largest] ) largest = i;
	  }
	  return largest; // position of the first largest found
	}
	
	public String convertStringToUnsigned(String s) { 
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD); 
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+"); 
		temp = pattern.matcher(temp).replaceAll(""); 
    return temp.replaceAll("đ", "d"); }
	public static void sortASC(double [] arr) {
        double temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

	  public static void main(String[] args) {
//		System.out.println(convertStringToUnsigned("Test thử xem có xóa được ký tự không"));
//	    char[] x = "GCAGAGAG".toCharArray();
//	    char[] y = "GCATCGCAGAGAGTATACAGTACG".toCharArray();
//	    search(x, y);
	  }
	}