package Model;

import Model.ENUM.GateStatus;
import Model.ENUM.GateType;

public class Gate extends BaseClass{
    private GateType gateType;
    private int gateNum;
    private String Operator;
    private GateStatus gateStatus;

    public Gate() {
    }

    public Gate(GateType gateType, int gateNum, String operator, GateStatus gateStatus) {
        this.gateType = gateType;
        this.gateNum = gateNum;
        Operator = operator;
        this.gateStatus = gateStatus;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public int getGateNum() {
        return gateNum;
    }

    public void setGateNum(int gateNum) {
        this.gateNum = gateNum;
    }

    public String getOperator() {
        return Operator;
    }

    public void setOperator(String operator) {
        Operator = operator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
