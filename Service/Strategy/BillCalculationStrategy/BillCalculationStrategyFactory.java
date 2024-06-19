package Service.Strategy.BillCalculationStrategy;

public class BillCalculationStrategyFactory {

    public BillCalculationStrategyFactory(BillingCalculationStrategyName name) {
    }

    public static BillCalculationStrategy getBillCalculationStrategy(BillingCalculationStrategyName name) {
        switch (name) {
            case BASE_CHARGE : return new BaseChargeBillStrategy();
            case TIME_BASED_CHARGES: return new TimeBasedChargeBillStrategy();
            case AGGRESSIVE_BUSINESS_CHARGE: return new AggressiveBillStrategy();
        }
        return null;
    }
}
