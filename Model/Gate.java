package Model;

import Model.ENUM.GateStatus;
import Model.ENUM.GateType;
import Model.ENUM.StaffSkill;

public class Gate extends BaseClass{
    private GateType gateType;
    private int gateNum;
    private Staff operator;
    private GateStatus gateStatus;

    public Gate() {
    }

    public Gate(GateType gateType, int gateNum, GateStatus gateStatus) {
        this.gateType = gateType;
        this.gateNum = gateNum;
        operator = new Staff("GateOperator", StaffSkill.GATE_OPERATOR);
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

    public Staff getOperator() {
        return operator;
    }

    public void setOperator(Staff operator) {
        this.operator = operator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
