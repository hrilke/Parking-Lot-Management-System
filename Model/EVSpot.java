package Model;

import Model.ENUM.ParkingSpotStatus;
import Model.ENUM.VehicleType;

public class EVSpot extends ParkingSpot{
   private Staff evStationStaff;

   public EVSpot(Staff evStationStaff) {
      this.evStationStaff = evStationStaff;
   }

   public EVSpot(int spotNo, VehicleType vehicleType, ParkingSpotStatus parkingSpotStatus, Model.Vehicle vehicle, Staff evStationStaff) {
      super(spotNo, vehicleType, parkingSpotStatus, vehicle);

      this.evStationStaff = evStationStaff;
   }

   public Staff getEvStationStaff() {
      return evStationStaff;
   }

   public void setEvStationStaff(Staff evStationStaff) {
      this.evStationStaff = evStationStaff;
   }
}
