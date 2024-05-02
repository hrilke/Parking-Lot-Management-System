package Model;

import Model.ENUM.ParkingSpotStatus;
import Model.ENUM.VehicleType;

public class EVSpot extends ParkingSpot{
   private int accessCard;

   public EVSpot() {

   }

   public EVSpot(int spotNo, VehicleType vehicleType, ParkingSpotStatus parkingSpotStatus, Model.Vehicle vehicle, int accessCard) {
      super(spotNo, vehicleType, parkingSpotStatus, vehicle);
      this.accessCard = accessCard;
   }

   public int getAccessCard() {
      return accessCard;
   }

   public void setAccessCard(int accessCard) {
      this.accessCard = accessCard;
   }
}
