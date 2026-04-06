// BabyLionManaver.java: 아기사자 목록 관리
import java.util.*;

// 여러 명의 아기사자 정보를 리스트로 관리하는 클래스
public class BabyLionManager {
    private List<BabyLion> lions = new ArrayList<>();

    // 아기사자 등록
    public boolean addLion(BabyLion lion){
        if (findLionByStudentId(lion.getStudentId()) != null){ return false; }
        lions.add(lion);
        return true;
    }

    // 등록된 모든 아기사자 정보 출력
    public void printAllLions() {
        // 등록된 아기사자가 없을 경우
        if (lions.isEmpty()) {
            System.out.println("등록된 아기사자가 없습니다.");
            return;
        }

        for (BabyLion lion : lions){
            System.out.println(lion);
        }
    }

    // 학번으로 특정 아기사자 조회
    public BabyLion findLionByStudentId(String studentId){
        for (BabyLion lion : lions){
            if (lion.getStudentId().equals(studentId)){ return lion; }
        }
        return null;
    }

    // 학번으로 아기사자를 찾아 자기소개 수정
    public boolean updateIntroduction(String studentId, String newIntroduction){
        BabyLion lion = findLionByStudentId(studentId);
        if (lion == null){ return false; }
        lion.setIntroduction(newIntroduction);
        return true;
    }

    // 학번으로 아기사자를 찾아 성실도 변경
    public boolean changeLionSincerity(String studentId, int amount){
        BabyLion lion = findLionByStudentId(studentId);
        if (lion == null) { return false; }
        return lion.changeSincerity(amount);
    }

    // 학번으로 아기사자를 찾아 삭제
    public boolean deleteLion(String studentId){
        BabyLion lion = findLionByStudentId(studentId);
        if (lion == null){ return false; }
        lions.remove(lion);
        return true;
    }
}
