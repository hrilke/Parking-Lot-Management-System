package Model;

import Model.ENUM.ParkingSpotStatus;
import Model.ENUM.StaffSkill;
import Model.ENUM.VehicleType;

public class EVSpot extends ParkingSpot{
   private Staff evStationStaff;
   private static int idCounter = 0;
   public EVSpot() {
      this.evStationStaff = new Staff("EV Charging Station Helper"+ ++idCounter, StaffSkill.EV_STATION_STAFF);
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
