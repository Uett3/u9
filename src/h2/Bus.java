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
                i -= 1;
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

    public ArrayList<Passenger> findPassengersWithoutTickets(){
        ArrayList<Passenger> Schwarzfahrer = new ArrayList<Passenger>();


        for (Passenger p : passengers) {
            if(p.ticket == false){
                Schwarzfahrer.add(p);
            }
        }
        passengers.removeAll(Schwarzfahrer);
        return Schwarzfahrer;

    }

    public void transferPassengers(Bus otherBus, String[] passengerNames){



        ArrayList<Passenger> Umsteiger = new ArrayList<Passenger>();
        for (Passenger p : passengers){
            for (String pName : passengerNames){
                if(p.name.equals(pName)){
                    otherBus.enterBus(p);
                    Umsteiger.add(p);
                }
            }
        }
        passengers.removeAll(Umsteiger);

    }


}
