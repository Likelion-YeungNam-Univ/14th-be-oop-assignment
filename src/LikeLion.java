public class LikeLion {

    private String schoolNumber;
    private String name;
    private String memo;
    private int sincerity; // 성실도

    public LikeLion(String schoolNumber, String name, String memo, int sincerity) {
        this.schoolNumber = schoolNumber;
        this.name = name;
        this.memo = memo;
        this.sincerity = sincerity;
    }

    public String getName() {
        return name;
    }

    public String getMemo() {
        return memo;
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public int getSincerity() {
        return sincerity;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setSincerity(int sincerity) {
        this.sincerity = sincerity;
    }
}
