package Repository;

import Model.Gate;
import Exception.GateNotFoundException;
import java.util.HashMap;

public class GateRepository {
    private HashMap<Integer, Gate> gateHashMap;

    public GateRepository(HashMap<Integer, Gate> gateMap) {
        this.gateHashMap = new HashMap<>();
    }

    public Gate get(int gateId){
        Gate gate = gateHashMap.get(gateId);
        if (gate == null) {
            throw new GateNotFoundException("Gate not found for id: "+ gateId);
        }
        return gate;
    }
    public void put(Gate gate){
        gateHashMap.put(gate.getId(), gate);
        System.out.println("Gate has been Initialized to the Database");
    }
}
