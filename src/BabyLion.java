// BabyLion.java: 아기사자 한 명의 정보 저장 클래스
public class BabyLion { // 클래스선언 (학번, 이름, 자기소개, 성실도)
    private String studentId;
    private String name;
    private String introduction;
    private int sincerity;

    // 생성자: 학번, 이름, 자기소개를 받아 객체를 생성하고 성실도는 0으로 초기화.
    public BabyLion(String studentId, String name, String introduction) {
        this.studentId = studentId;
        this.name = name;
        this.introduction = introduction;
        this.sincerity =  0;
    }

    // 학번 반환
    public String getStudentId(){
        return studentId;
    }

    // 이름 반환
    public String getName(){
        return name;
    }

    // 자기소개 수정
    public void setIntroduction(String introduction){
        this.introduction = introduction;
    }

    public boolean changeSincerity(int amount) {
        int newSincerity = sincerity + amount;
        if (newSincerity < 0 || newSincerity > 5) { return false; }
        sincerity = newSincerity;
        return true;
    }

    // 객체 정보를 문자열 형태로 반환. 전체 조회나 개별 조회 시 출력 활용
    @Override
    public String toString(){
        return "학번: " + studentId +
                ", 이름: " + name +
                ", 자기소개: " + introduction +
                ", 성실도: " + sincerity;
    }
}
