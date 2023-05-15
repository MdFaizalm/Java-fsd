package Array_Rotation;

public class Main {
       public static void main(String[] args) {
			RotateArray r = new RotateArray();
	        		int arr[] = { 1, 2, 3, 4, 5, 6, 7 }; 
	        		r.rotate(arr, 5); 
	        		for(int i=0;i<arr.length;i++){
	            			System.out.print(arr[i]+" ");
	     		}
    }
 }

