//Mr.Cooper Training Question 5 Aug 2022

public class MinTilesToClean {
	public static void main(String[] args) {
		int currPos = 1;
		int noTiles = 6;
		int mov;

		int rightTiles = noTiles - currPos;
		int leftTiles = currPos - 1;

		System.out.println(rightTiles);
		System.out.println(leftTiles);

		/*
		 * if (currPos == 1) //no need this edge cond. below conditions can handle them
		 * (0*2)+5=5
		 * System.out.println(rightTiles);
		 * else if(currPos == noTiles)
		 * System.out.println(leftTiles);
		 */

		if (leftTiles > rightTiles) {
			mov = (rightTiles) * 2 + leftTiles;
			System.out.println(mov);
		}

		else {
			mov = (leftTiles * 2) + rightTiles;
			System.out.println(mov);
		}
	}
}

/*
 * Number of minimum moves cleaner make to clean each tile he can move one step
 * forward or backward
 * ignore the current tile.
 * 
 * ALGORITHM:
 * STEP 1: if currPos = 1; (EDGE CASE)
 * no need come back, go upto n;
 * STEP 2: if (leftTiles>rightTiles)
 * move right and come back - totalsteps*2
 * go to tile 1 - (left tiles)
 * STEP 3: if (rightTiles>leftTiles)
 * move left and come back - totalsteps*2
 * go to tile n - (righttiles)
 * 
 */