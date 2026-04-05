// 아기사자 데이터를 저장하고 상태를 관리
public class Lion {
    private int studentNumber;
    private String name;
    private String introduction;
    private int sincerity;

    // 객체 생성자
    public Lion(int studentNumber, String name, String introduction, int sincerity) {
        //this를 사용하여 초기화
        this.studentNumber = studentNumber;
        this.name = name;
        this.introduction = introduction;
        this.sincerity = sincerity;
    }

    // 학번으로 학생을 검색하거나 삭제할 때 학번 값을 return하는 메서드
    public int getStudentNumber() {
        return studentNumber;
    }

    // 새로운 자기소개 내용이 전달되면 기존 자기소개 변수의 값을 변경하는 메서드
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    // 성실도 수정 메서드
    public boolean changeSincerity(int amount) {
        // 현재 점수에서 입력 값을 더하고
        int result = this.sincerity + amount;

        // 더한 결과가 0과 5 사이인지 확인
        if (result >= 0 && result <= 5) {
            // 맞다면 성실도 변경하고 return
            this.sincerity = result;
            return true;
        }
        // 범위를 벗어난다면 false
        return false;
    }

    // override를 통해서 정보 출력
    @Override
    public String toString() {
        return "학번 " + studentNumber + " 이름 " + name + " 성실도 " + sincerity + "\n자기소개 " + introduction;
    }
}