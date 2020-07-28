public class Song {
    private String typeList;
    private String name;
    private String time;

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTypeList() {
        return this.typeList;
    }

    public String getName() {
        return this.name;
    }

    public String getTime() {
        return this.time;
    }

    public String getSong(String typeList) {
        if (typeList.equals(this.typeList) || "all".equals(typeList))
            return this.name;

        return null;
    }
}
