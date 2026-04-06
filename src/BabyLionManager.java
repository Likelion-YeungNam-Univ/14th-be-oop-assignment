import java.util.ArrayList;

public class BabyLionManager { // 아기사자 클래스를 관리해줄 클래스
    ArrayList<BabyLion> babyLions = new ArrayList<>(); // 아기사자 목록을 담아줄 ArrayList

    public void addBabyLion(BabyLion babyLion) { // ArrayList에 아기사자를 추가
        babyLions.add(babyLion);
    }

    public void getAllBabyLions() { // babyLions 라는 변수명의 ArrayList를 돌면서 모든 아기사자들의 학번과 이름을 출력
        for (BabyLion babyLion : babyLions) {
            System.out.println(babyLion.getStudentNumber() + " " + babyLion.getName());
        }
    }

    public BabyLion findByStudentNumber(String studentNumber) { // 학번을 입력받아 ArrayList를 돌아 동일한 학번의 아기사자를 리턴
        for (BabyLion babyLion : babyLions) {
            if (babyLion.getStudentNumber().equals(studentNumber)) {
                return babyLion;
            } else { // 해당 학번이 존재하지 않는다면 메세지 출력
                System.out.println("해당 학번의 아기사자가 존재하지 않습니다.");
            }
        }
        return null;
    }

    public void removeBabyLion(String studentNumber) { // ArrayList에서 아기사자를 삭제
        BabyLion babyLion = findByStudentNumber(studentNumber);
        if (babyLion != null) {
            babyLions.remove(babyLion);
            System.out.println("학번: " + studentNumber + "아기사자 삭제 완료!");
        }
    }
}
