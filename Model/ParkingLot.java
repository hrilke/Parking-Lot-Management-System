package Model;

import Model.ENUM.ParkingLotStatus;
import Model.ENUM.VehicleType;
import Service.Strategy.BillCalculationStrategy.BillCalculationStrategy;
import Service.Strategy.SpotAllocationStrategy.SpotAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseClass{
    private String name;
    private String address;
    private List<ParkingFloor> floorList;
    private List<VehicleType> vehicleTypeList;
    private ParkingLotStatus parkingLotStatus;
    private int capacity;
    private SpotAllocationStrategy spotAllocationStrategy;
    private BillCalculationStrategy billCalculationStrategy;

    public ParkingLot() {
    }

    public ParkingLot(String name, String address, List<ParkingFloor> floorList, List<VehicleType> vehicleTypeList, ParkingLotStatus parkingLotStatus, int capacity, SpotAllocationStrategy spotAllocationStrategy, BillCalculationStrategy billCalculationStrategy) {
        this.name = name;
        this.address = address;
        this.floorList = floorList;
        this.vehicleTypeList = vehicleTypeList;
        this.parkingLotStatus = parkingLotStatus;
        this.capacity = capacity;
        this.spotAllocationStrategy = spotAllocationStrategy;
        this.billCalculationStrategy = billCalculationStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<ParkingFloor> floorList) {
        this.floorList = floorList;
    }

    public List<VehicleType> getVehicleTypeList() {
        return vehicleTypeList;
    }

    public void setVehicleTypeList(List<VehicleType> vehicleTypeList) {
        this.vehicleTypeList = vehicleTypeList;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public SpotAllocationStrategy getSpotAllocationStrategy() {
        return spotAllocationStrategy;
    }

    public void setSpotAllocationStrategy(SpotAllocationStrategy spotAllocationStrategy) {
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    public BillCalculationStrategy getBillCalculationStrategy() {
        return billCalculationStrategy;
    }

    public void setBillCalculationStrategy(BillCalculationStrategy billCalculationStrategy) {
        this.billCalculationStrategy = billCalculationStrategy;
    }
}
