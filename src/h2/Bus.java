package h2;
import java.util.ArrayList;

public class Bus {

    public ArrayList<Passenger> passengers;

    public Bus(){
        passengers = new ArrayList<Passenger>();
    }

    public void enterBus(Passenger p){
        passengers.add(p);
    }

    private void exitBus(){
        for(int i = 0; i < passengers.size(); i++){
            if(passengers.get(i).visited == passengers.get(i).planned){
                passengers.remove(i);
            }
        }
    }

    public void nextStop(Passenger[] boarding){
        for (Passenger p : passengers) {
            p.visited++;
        }
        exitBus();
        for (Passenger p : boarding) {
            passengers.add(p);
        }
    }
    public void nextStop() {
        nextStop(new Passenger[0]);
    }


}
