public class Buerger {
	
	private String name;
	private Rang rang;
	private String rangname;
	private boolean istmaennlich;
	private Buerger linkerNf;
	private Buerger rechterNf;
	
	Buerger(String name, Rang rang, Buerger linkerNf, Buerger rechterNf, boolean istmaennlich){
		this.name = name;
		this.rang = rang;
		this.rangname = rang.toString();
		this.linkerNf = linkerNf;
		this.rechterNf = rechterNf;
		this.istmaennlich = istmaennlich;
	}
	
	public String getName(){
		return name;
	}
	
	public Rang getRang(){
		return rang;
	}
	
	public Buerger getLinks(){
		return linkerNf;
	}
	
	public Buerger getRechts(){
		return rechterNf;
	}
	
	public boolean getIstMaennlich()
	{
		return istmaennlich;
	}
	
	public void setLinks(Buerger linkerNf){
		this.linkerNf = linkerNf;
	}
	
	public void setRechts(Buerger rechterNf){
		this.rechterNf = rechterNf;
	}

	public void vorstellen() {
		System.out.println("Mein Name ist "+name+", ich habe den Rang "+rangname+" und bin " + (istmaennlich?"ein Mann":"eine Frau")+ "");
	}

	@Override
	public String toString() {
		return this.name + " | " + this.getRang().name();
	}
}
