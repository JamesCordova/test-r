package Estructuras;

public class Par<VerticeID, distancia> {
	private VerticeID ID;
	private distancia distance;
	
	public Par(VerticeID id, distancia costo) {
        this.ID = id;
        this.distance = costo;
    }
	public VerticeID getID() {
		return ID;
	}
	public distancia getDistance() {
		return distance;
	}
	public void setDistance(distancia distance) {
		this.distance = distance;
	}
}
