package container.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<>();
		Integer[] moreInts = {6, 7, 8, 9};
		Collections.addAll(collection, moreInts);
	}
}
