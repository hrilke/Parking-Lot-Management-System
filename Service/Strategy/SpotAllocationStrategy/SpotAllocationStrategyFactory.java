package Service.Strategy.SpotAllocationStrategy;

public class SpotAllocationStrategyFactory {

    public SpotAllocationStrategy getSpotAllocationStrategy(SpotAllocationStrategyName spotAllocationStrategyName) {
        switch (spotAllocationStrategyName) {
            case LINEAR : return new LinearSpotAllocation();
            case NEAREST_TO_EXIT: return new NearestToExitSpotAllocation();
            case NEAREST_TO_LIFT: return new NearestToLiftSpotAllocation();
        }
        return null;
    }
}
