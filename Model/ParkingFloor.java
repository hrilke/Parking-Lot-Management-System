package Model;

import Model.ENUM.ParkingFloorStatus;

import java.util.List;

public class ParkingFloor extends BaseClass{
    private List<ParkingSpot> spotList;
    private Gate entryGate;
    private Gate exitGate;
    private int floorNo;
    private ParkingFloorStatus parkingFloorStatus;

    public ParkingFloor(List<ParkingSpot> spotList, Gate entryGate, Gate exitGate, int floorNo, ParkingFloorStatus parkingFloorStatus) {
        this.spotList = spotList;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
        this.floorNo = floorNo;
        this.parkingFloorStatus = parkingFloorStatus;
    }

    public ParkingFloor() {
    }

    public List<ParkingSpot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<ParkingSpot> spotList) {
        this.spotList = spotList;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }
}
