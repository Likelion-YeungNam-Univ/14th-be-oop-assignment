
public class BabyLion {

    private final String studentId;   // 학번 (String 타입)
    private final String name;        // 이름
    private String introduction;      // 자기소개
    private int diligence;            // 성실도 (0 ~ 5)
    //모든 필드는 private으로 캡슐화


    public BabyLion(String studentId, String name, String introduction) {
        this.studentId    = studentId;
        this.name         = name;
        this.introduction = introduction;
        this.diligence    = 0; // 아기사자 등록시 성실도 0 초기화
    }

    //  성실도 증가 (+1)
    public boolean increaseDiligence() {
        if (diligence >= 5) return false; // 5점 넘으면 false 반환
        diligence++; // 5점 안넘으면 성실도 증가
        return true;
    }

    // 성실도 감소 (-1)
    public boolean decreaseDiligence() {
        if (diligence <= 0) return false; // 0점이면 false 반환
        diligence--; // 0점 아니면 성실도 감소
        return true;
    }

    // 자기소개 수정
    public void updateIntroduction(String introduction) {
        this.introduction = introduction;
    }

    // Getters
    public String getStudentId()    { return studentId; } //학번 반환
    public String getName()         { return name; } //이름 반환
    public String getIntroduction() { return introduction; } //자기소개 반환
    public int    getDiligence()    { return diligence; } //성실도 점수 반환


    @Override
    public String toString() {
        return String.format("[%s] %s | %s | 성실도: %d점",
                studentId, name, introduction, diligence);
    }
}