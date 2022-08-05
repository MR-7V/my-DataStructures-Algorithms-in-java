public class MinTilesToClean
{
	public static void main(String[] args) {
		int currPos = 4;
		int noTiles = 8;
		int mov;
		
		int rightTiles = noTiles-currPos;
		int leftTiles = currPos-1;
		
		System.out.println(rightTiles);
		System.out.println(leftTiles);
		if(currPos==1)
            System.out.println(rightTiles);
		
		else if(leftTiles>rightTiles){
            mov = (rightTiles)*2+leftTiles;
            System.out.println(mov);
		}
		
		else{
            mov = (leftTiles*2)+rightTiles;
            System.out.println(mov);
		}
	}
}

/*
	1 2 3 4 5 6 7 8
    
	
*/