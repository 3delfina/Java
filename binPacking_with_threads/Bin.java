//Marija Mumm, 2232817m
package binPacking;

import java.util.ArrayList;
import java.util.List;

public class Bin {
	int capacity;
	List<Integer> weights;

	// constructor
	public Bin(int capacity) {
		this.capacity = capacity;
		this.weights = new ArrayList<Integer>();
	}

	// adds the given value to the list inside the bin
	// throws an IllegalArgumentException if the weight cannot fit
	public void store(int weight) throws IllegalArgumentException {
		int spaceLeft = getSpace();
		if (weight <= spaceLeft) {
			weights.add(weight);
		} else {
			throw new IllegalArgumentException("The weight cannot fit in this bin");
		}
	}

	// returns the remaining space in the Bin
	// based on the total weight of objects included
	public int getSpace() {
		int space = this.capacity - this.weights.stream().mapToInt(i -> i).sum();
		return space;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + ((weights == null) ? 0 : weights.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bin other = (Bin) obj;
		if (capacity != other.capacity)
			return false;
		if (weights == null) {
			if (other.weights != null)
				return false;
		} else if (!weights.equals(other.weights))
			return false;
		return true;
	}

}
