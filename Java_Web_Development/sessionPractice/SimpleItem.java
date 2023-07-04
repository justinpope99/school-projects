package sessionPractice;

import java.io.*;

public class SimpleItem implements Serializable {
	private String itemName;
	private int itemCount;
	
	public SimpleItem(String itemName) {
		this.itemName = itemName;
		itemCount = 1;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void incrementItemCount() {
		itemCount = itemCount + 1;
	}
	
	public String toString() {
		String item = itemName + "(" + itemCount + ")";
		return item;
	}
}
