package lion.model;

public class Lion { // 클래스 선언
    private String name; // 프라이빗(이 클래스 내에서만 접근 가능)변수 선언
    private int lionId; // 8자리
    private String intro;
    private int diligence; // 0~5

    public Lion(String name, int lionId, String intro, int diligence) {
        this.name = name;
        this.lionId = lionId;
        this.intro = intro;
        this.diligence = diligence;
    }
    // 각각의 값을 가져오고
    public String getName() { return name; }
    public int getLionId() { return lionId; }
    public String getIntro() { return intro; }
    public int getDiligence() { return diligence; }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void changeDiligence(int delta) {
        this.diligence += delta;

        if (this.diligence > 5) this.diligence = 5; // 성실도가 0에서 5를 넘지 않도록 조정
        if (this.diligence < 0) this.diligence = 0;
    }

    public void showInfo() { // 상세 출력 내용
        System.out.println("이름: " + name);
        System.out.println("학번: " + lionId);
        System.out.println("자기소개: " + intro);
        System.out.println("성실도: " + diligence);
        System.out.println("===================");
    }
}