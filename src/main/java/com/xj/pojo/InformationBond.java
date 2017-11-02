package com.xj.pojo;

public class InformationBond {
    private Integer ibId;

    private Integer seId;

    private Integer financeId;

    private String bondCode;

    private String bondType;

    private String issuingTerm;

    private String issuingAmount;

    private String currentBalance;

    public Integer getIbId() {
        return ibId;
    }

    public void setIbId(Integer ibId) {
        this.ibId = ibId;
    }

    public Integer getSeId() {
        return seId;
    }

    public void setSeId(Integer seId) {
        this.seId = seId;
    }

    public Integer getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode == null ? null : bondCode.trim();
    }

    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType == null ? null : bondType.trim();
    }

    public String getIssuingTerm() {
        return issuingTerm;
    }

    public void setIssuingTerm(String issuingTerm) {
        this.issuingTerm = issuingTerm == null ? null : issuingTerm.trim();
    }

    public String getIssuingAmount() {
        return issuingAmount;
    }

    public void setIssuingAmount(String issuingAmount) {
        this.issuingAmount = issuingAmount == null ? null : issuingAmount.trim();
    }

    public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance == null ? null : currentBalance.trim();
    }
}