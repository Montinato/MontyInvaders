package interfacce;



public interface OggettoStatico {
	int getAltezza();

    int getLarghezza();

    int getX();

    int getY();

    boolean intersect(OggettoStatico altro);
}
