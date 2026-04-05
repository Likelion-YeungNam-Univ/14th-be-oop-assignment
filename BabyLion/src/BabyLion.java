public class BabyLion { //아기사자 정보를 담은 클래스 private으로 캡슐화
    private String name;
    private int studentNumber;
    private String introduction;
    private int sincerity;

    //생성자
    public BabyLion(String name, int studentNumber, String introduction, int sincerity){
        this.name = name;
        this.studentNumber = studentNumber;
        this.introduction = introduction;
        this.sincerity = sincerity;
    }
    //Getter
    public String getName(){
        return name;  //이름
    }
    public int getStudentNumber(){
        return studentNumber; //학번
    }
    public String getIntroduction(){
        return introduction; //자기소개
    }
    public int getSincerity(){
        return sincerity; //성실도
    }
    //Setter
    public void setIntroduction(String introduction){
        this.introduction = introduction;
    }
    public  void setSincerity(int sincerity) {
        this.sincerity = sincerity;
    }
}
