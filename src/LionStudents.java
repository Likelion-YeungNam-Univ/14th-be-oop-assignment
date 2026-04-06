public class LionStudents {
    private String name;
    private int studentId;
    private String introduction;
    private int prize;

    // 초기 구조체 생성
    public LionStudents(String name, int studentId, String introduction){
        this.name = name;
        this.studentId = studentId;
        this.introduction = introduction;
        this.prize = 0;
    }
    // getter 생성
    public String getName(){
        return name;
    }
    public int getStudentId(){
        return studentId;
    }
    public int getPrize() {
        return prize;
    }

    // 개별 조회용
    public String getDetailInfo(){
        return "이름: " + name + ", 학번: " + studentId + ", 자기소개: " + introduction + ", 성실도: " + prize;
    }
    // 자기 소개 수정
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    // 성실도 변경
    public void increasePrize(int value){
        prize += value;
    }
    public void decreasePrize(int value){
        prize -= value;
    }
}
