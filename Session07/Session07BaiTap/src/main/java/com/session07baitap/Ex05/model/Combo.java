package com.session07baitap.Ex05.model;

import java.util.List;

public class Combo {
    private String name;
    private List<String> itemList;
    private String bannerPath;

    public Combo() {
    }

    public Combo(String name, List<String> itemList, String bannerPath) {
        this.name = name;
        this.itemList = itemList;
        this.bannerPath = bannerPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    /**
     * Chuyển đổi đối tượng Combo thành chuỗi JSON để in ra console.
     */
    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"name\":\"").append(name).append("\",");
        sb.append("\"itemList\":[");
        if (itemList != null) {
            for (int i = 0; i < itemList.size(); i++) {
                sb.append("\"").append(itemList.get(i)).append("\"");
                if (i < itemList.size() - 1) {
                    sb.append(",");
                }
            }
        }
        sb.append("],");
        sb.append("\"bannerPath\":\"").append(bannerPath != null ? bannerPath : "").append("\"");
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String toString() {
        return toJson();
    }
}
