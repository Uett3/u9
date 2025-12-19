package h1;

public class H1_main {
    public static void main(String[] args) {
        Patient a = new Patient("A", 1);
        Patient b = new Patient("B", 10);
        Patient c = new Patient("C", 5);
        PrioListe p = new PrioListe();
        p.addPatient(a);
        p.addPatient(b);
        p.addPatient(c);
        Patient d = new Patient("D", 7);
        p.addPatient(d);
        p.getNextPatient();


        System.out.println(p.getPosition(d));
    }
}