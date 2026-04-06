public class BabyLion { // 아기사자 클래스
    String name; // 아기사자 이름
    String studentNumber; // 학번
    String introduction; // 소개글
    int effort; // 성실도

    // 각 필드에 getter 와 setter를 사용해서 기본적인 get과 set이 가능하게 함
    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getIntroduction() {
        return introduction;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 성실도를 증감 시키는 메소드
    public void increaseEffort() {
        effort++;
    }

    public void decreaseEffort() {
        effort--;
    }
}
