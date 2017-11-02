package com.xj.pojo;

public class ShareholdersBackgroundType {
    private Integer sbId;

    private String shareholdersBackgroundName;

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public String getShareholdersBackgroundName() {
        return shareholdersBackgroundName;
    }

    public void setShareholdersBackgroundName(String shareholdersBackgroundName) {
        this.shareholdersBackgroundName = shareholdersBackgroundName == null ? null : shareholdersBackgroundName.trim();
    }
}