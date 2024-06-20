package Model;

import Model.ENUM.ParkingSpotStatus;
import Model.ENUM.StaffSkill;
import Model.ENUM.VehicleType;

public class HandicapSpot extends ParkingSpot{
   private Staff wheelchairHelper;
   private static int idCounter = 0;
   public HandicapSpot() {
      this.wheelchairHelper = new Staff("Wheel Chair Helper"+ ++idCounter, StaffSkill.WHEELCHAIR_STAFF);
   }

   public HandicapSpot(int spotNo, VehicleType vehicleType, ParkingSpotStatus parkingSpotStatus, Model.Vehicle vehicle, Staff wheelchairHelper) {
      super(spotNo, vehicleType, parkingSpotStatus, vehicle);
      this.wheelchairHelper = wheelchairHelper;
   }

   public Staff getWheelchairHelper() {
      return wheelchairHelper;
   }

   public void setWheelchairHelper(Staff wheelchairHelper) {
      this.wheelchairHelper = wheelchairHelper;
   }
}
