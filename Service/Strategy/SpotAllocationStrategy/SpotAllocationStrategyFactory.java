package Service.Strategy.SpotAllocationStrategy;

public class SpotAllocationStrategyFactory {

    public SpotAllocationStrategyFactory(SpotAllocationStrategyName strategy) {
    }

    public static SpotAllocationStrategy getSpotAllocationStartegy(SpotAllocationStrategyName spotAllocationStrategyName) {
        switch (spotAllocationStrategyName) {
            case LINEAR : return new LinearSpotAllocation();
            case NEAREST_TO_EXIT: return new NearestToExitSpotAllocation();
            case NEAREST_TO_LIFT: return new NearestToLiftSpotAllocation();
            case SPECIAL_VEHICLE: return new SpecialSpotAllocation();
        }
        return null;
    }
}
