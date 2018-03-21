//Marija Mumm, 2232817m
package wishlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WishList {

	ArrayList<BrickSet> wishList;

	// constructor
	public WishList() {
		wishList = new ArrayList<BrickSet>();
	}

	// getter
	// get the list of BrickSet objects stored in the wish list sorted by set number
	public Collection<BrickSet> getSets() {

		Collections.sort(wishList);
		return wishList;
	}

	// add the given BrickSet if it is not in the list and return true
	// return false otherwise
	public boolean addSet(BrickSet set) {
		for (BrickSet brickSet : wishList) {
			if (brickSet.equals(set)) {
				return false;
			}
		}
		return wishList.add(set);
	}

	// remove the given BrickSet if it is in the list and return true
	// return false otherwise
	public boolean removeSet(BrickSet set) {
		for (BrickSet brickSet : wishList) {
			if (brickSet.equals(set)) {
				return wishList.remove(set);
			}
		}
		return false;
	}

	// save the current wish list to a file at the given location
	// throw an exception if saving is not possible
	public void saveToFile(String filename) throws IOException {
		Path p = Paths.get(filename);

		try {
			Files.createFile(p);
			PrintWriter fw = new PrintWriter(Files.newBufferedWriter(p));
			for (BrickSet set : wishList) {
				fw.write(set.getSetNumber() + "," + set.getName() + "," + set.getTheme() + "," + set.getNumPieces()
						+ "," + set.getRetailPrice() + "\n");
			}
			fw.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	// load and return a wish list from the given file
	// throw an exception if loading is not possible
	public static WishList loadFromFile(String filename) throws IOException {

		WishList localWishList = new WishList();

		BufferedReader br = null;
		String currentLine = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			while ((currentLine = br.readLine()) != null) {
				// extract the property information from the line
				String el[] = currentLine.split(",");
				// convert setNumber, numPieces,retailPrice to int (elements 0,3,4)
				// create a BrickSet based on the extracted details
				BrickSet localBrickSet = new BrickSet(Integer.parseInt(el[0]), el[1], el[2], Integer.parseInt(el[3]),
						Integer.parseInt(el[4]));

				localWishList.addSet(localBrickSet);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ee) {
				ee.printStackTrace();
			}

		}
		return localWishList;
	}
}
