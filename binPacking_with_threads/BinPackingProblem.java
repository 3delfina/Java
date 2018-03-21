//Marija Mumm, 2232817m
package binPacking;

import java.util.ArrayList;
import java.util.List;

public class BinPackingProblem implements Runnable {
	List<Integer> weights;
	int maxCapacity;
	static List<Bin> results = new ArrayList<Bin>();

	// constructor
	public BinPackingProblem(List<Integer> weights, int maxCapacity) {
		this.weights = weights;
		this.maxCapacity = maxCapacity;
	}

	// call PackingStrategy.packBestFit on the given arguments, and store the result
	@Override
	public void run() {
		List<Bin> result = (PackingStrategy.packBestFit(weights, maxCapacity));
		// adds bins from the current result to the results list
		for (Bin r : result) {
			results.add(r);
		}
	}

	// returns the list of bins produced by the BFD packing strategy
	public static List<Bin> getBins() {
		return results;

	}

}
