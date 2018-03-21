//Marija Mumm, 2232817m
package binPacking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PackingStrategy {
	public static List<Bin> packBestFit(List<Integer> weights, int capacity) {
		// binList - resulting list of Bin objects
		List<Bin> binList = new ArrayList<Bin>();
		Collections.sort(weights, Collections.reverseOrder());
		// creating the first bin and adding it to the list
		Bin bin1 = new Bin(capacity);
		binList.add(bin1);

		// BFD algorithm
		for (int weight : weights) {
			Bin closestSizeBin = null;
			// looking for the bin whose spare capacity is nearest to the weight of the item
			for (Bin b : binList) {
				if (b.getSpace() >= weight) {
					if (closestSizeBin == null) {
						closestSizeBin = b;
					} else if (b.getSpace() < closestSizeBin.getSpace()) {
						closestSizeBin = b;
					}
				}
			}
			// if closest size bin not found, create a new bin and add the item there
			if (closestSizeBin == null) {
				Bin b2 = new Bin(capacity);
				b2.store(weight);
				binList.add(b2);
			} else {
				// or add the item to the closest size bin
				closestSizeBin.store(weight);
			}

		}
		return binList;
	}

	public static List<Bin> packBestFitParallel(List<Integer> weights, int capacity, int numThreads) {

		// create a list of threads
		List<Thread> tlist = new ArrayList<Thread>();

		// step - number of weights in the equally-sized list
		int step = (int) weights.size() / numThreads;

		// Split the list of weights into equally-sized lists
		for (int i = 0; i < weights.size(); i += step) {
			List<Integer> someWeights = weights.subList(i, i + step);

			// Create a BinPackingProblem instance based on each of the lists
			BinPackingProblem bpp = new BinPackingProblem(someWeights, capacity);
			// Start a separate Thread to run each BinPackingProblem instance in parallel
			Thread t = new Thread(bpp);
			t.start();
			tlist.add(t);
		}
		// Wait for all of the threads to complete
		for (Thread t1 : tlist) {
			try {
				t1.join();
			} catch (InterruptedException e) {
			}
		}

		// return the final result made of combined resulting sets
		return BinPackingProblem.getBins();
	}
}
