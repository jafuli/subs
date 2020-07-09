package beans;

public class Ship {

	private static int id = 1;
	private int visibleId;
	private int length;
	private boolean horizontal;
	private boolean sunk;
	private String model;
	private String link;
	private int hitsCounter = 0;

	public Ship(int length, boolean horizontal) {
		super();
		this.visibleId = id;
		this.length = length;
		this.horizontal = horizontal;
		setModel(length);
		setLink(length);
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

	public int getHitsCounter() {
		return hitsCounter;
	}

	public void setHitsCounter() {
		this.hitsCounter++;
		if (this.hitsCounter == length) {
			System.out.println(model + " sunk"); // ship sunk message for user
			System.out.println("Would you like to know more? " + link);
			setSunk(true);
		}
	}

	public int getId() {
		return id;
	}

	public int getVisibleId() {
		return visibleId;
	}

	public static void setId(int id) {
		Ship.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(int length) {
		if (length == 2)
			this.link = "https://13news.co.il/item/news/domestic/crime-law/crime/submarine-33866/?fbclid=IwAR29LvPYZYzEtYqRAP-OdtebmIPgHaP3HkUt-5F7CJDBkpRUtvuKCbXSSdM";
		if (length == 3)
			this.link = "https://www.maariv.co.il/journalists/Article-775234?fbclid=IwAR33xI9HE3OLU9RCfXqD_m5O_hB3UVsc4Tnbp6tiwpUaRbBR_5s4HgqTBHc";
		if (length == 4)
			this.link = "https://www.youtube.com/watch?v=EcRDd3XNl6M&t=1s&fbclid=IwAR1rrQeuGzp98VFMEYgbAJJG0Tr7FuUlUznhAWUNAYi8wEOWscoa-tX-q1E";
		if (length == 5)
			this.link = "https://www.youtube.com/watch?v=UMrJ44Ut-RY&feature=youtu.be&fbclid=IwAR2BeTlfktMqYNlae6A3itAVLVm_dZPqEo5CssZ_fUOgH2zjIwFZavKl0A4";
	}

}
