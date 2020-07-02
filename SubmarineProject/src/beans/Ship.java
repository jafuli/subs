package beans;

public class Ship {

	private static int id = 0;
	private int visibleId;
	private int length;
	private boolean horizontal;
	private boolean sunk;
	private String model;
	private int hitsCounter = 0;

	public Ship(int length, boolean horizontal) {
		super();
		++id;
		this.visibleId = id;
		this.length = length;
		this.horizontal = horizontal;
		setModel(length);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public boolean isSunk() {
		return sunk;
	}

	public void setSunk(boolean sunk) {
		this.sunk = sunk;
	}

	public String getModel() {
		return model;
	}

	public void setModel(int length) {
		if (length == 2)
			this.model = "Submarine";
		if (length == 3)
			this.model = "Cruiser";
		if (length == 4)
			this.model = "Destroyer";
		if (length == 5)
			this.model = "Aircraft Carrier";

	}

	@Override
	public String toString() {
		return model + " [length=" + length + ", horizontal=" + horizontal + ", sunk=" + sunk + ", model=" + model
				+ "]";
	}

	public int getHitsCounter() {
		return hitsCounter;
	}

	public void setHitsCounter() {
		this.hitsCounter++;
		if (this.hitsCounter == length) {
			System.out.println(model + " sunk");
			setSunk(true);
		}
	}

	public int getId() {
		return id;
	}

	public int getVisibleId() {
		return visibleId;
	}

}
