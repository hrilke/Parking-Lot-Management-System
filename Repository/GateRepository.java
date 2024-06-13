package Repository;

import Model.Gate;
import Exception.GateNotFoundException;
import java.util.HashMap;

public class GateRepository {
    private HashMap<Integer, Gate> gateHashMap;

    public GateRepository() {
        this.gateHashMap = new HashMap<>();
    }

    public Gate get(int gateNumber){
        Gate gate = gateHashMap.get(gateNumber);
        if (gate == null) {
            throw new GateNotFoundException("Gate not found for id: "+ gateNumber);
        }
        return gate;
    }
    public void add(Gate gate){
        gateHashMap.put(gate.getGateNum(), gate);
        System.out.println("Gate "+ gate.getGateNum() +" has been Initialized to the Database");
    }
}
