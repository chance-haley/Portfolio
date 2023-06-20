//@author is Chance Haley

public class Ch02{
	
	public static void main(String[]args){
		
		fibonacci();
		
		System.out.println("\n \n");
		
		triangleNum();
		
		System.out.println("\n \n");
		
		triangleNumMirror();
		
		System.out.println("\n \n");
		
		slashFigure();
		
	}
		
		
		
		public static void fibonacci(){
			int x=1;
			int y=1;
			System.out.print("1 1 ");
			for(int z=x+y; z<=144;z=x+y){
				x=y;
				y=z;
				System.out.print(z + " ");
			
			
			}
		}
		
			public static void triangleNum(){
		
				for (int k=1;k<=7; k++){
				
					for ( int i=k;i>=1; i--){
						
				System.out.print(k);
			}
				System.out.println(" ");
				
			}
			System.out.println(" ");
		}
		
		public static void triangleNumMirror(){
			
			for(int j=1; j<=5; j++){
				
				for (int i=5-j; i>=0;i--){
					
					System.out.print(" ");
				}
			
				for (int k=j;k>0;k--){
				System.out.print(j);
			}
			System.out.println(" ");
				
		}
	}
	
		public static void slashFigure(){
			
			var x= "\\";
			var y= "!!";
			var z= "/";
			
			for (int i=0;i<=10;i=i+2){
				
				
				for (int k= 1;k<=i;k++){
					System.out.print(x);
					
				}
				
				for (int j=i; j<=10;j++){
					
					System.out.print(y);
				}
				for (int l= 1; l<=i;l++){
					System.out.print(z);
					
				}
				System.out.println(" ");
			
		}
	}	
}		

				

