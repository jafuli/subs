package beans;

public class Ship {

	private int length;
	private boolean horizontal;
	private boolean sunk;
	private String model;

	public Ship(int length, boolean horizontal) {
		super();
		this.length = length;
		this.horizontal = horizontal;
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

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Submarine [length=" + length + ", horizontal=" + horizontal + ", sunk=" + sunk + ", model=" + model
				+ "]";
	}

}
