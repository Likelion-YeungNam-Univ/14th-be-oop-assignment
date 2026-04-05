import java.util.Collection;
import java.util.HashMap;

public class LionManager {

    private final HashMap<String, BabyLion> lions = new HashMap<>(); //학번(key) 아기사자(value)인 HashMap

    //  1. 등록
    public String register(String studentId, String name, String introduction) {
        if (lions.containsKey(studentId)) { //containsKey 사용해 학번 중복 체크
            return "이미 존재하는 학번입니다: " + studentId;
        }
        lions.put(studentId, new BabyLion(studentId, name, introduction)); // 중복 없을시 새로운 BabyLion객체 생성 후 HashMap에 저장
        return null;
    }

    // 2. 전체 조회
    public Collection<BabyLion> findAll() {
        return lions.values(); //HashMap의 value메서드 호출해 아기사자 객체만 반환
    }

    // 3. 개별 조회 (학번)
    public BabyLion findByStudentId(String studentId) {
        return lions.get(studentId); // HashMap 키로 즉시 탐색 → 없으면 null
    }



    //  4. 자기소개 수정
    // 반환: 수정된 BabyLion → 성공 / null → 학번 없음
    public BabyLion updateIntroduction(String studentId, String newIntroduction) {
        BabyLion b = lions.get(studentId); //HashMap의 Key 로 Value 객체 탐색
        if (b == null) return null; // 객체 없으면 Null
        b.updateIntroduction(newIntroduction); //객체 내부의 메서드 호출해 수정 요청
        return b;
    }

    // 5. 성실도 수정
    public int updateDiligence(String studentId, String direction) {
        BabyLion b = lions.get(studentId); // HashMap에서 학번으로 아기사자 찾기

        if (b == null) {
            return 0;
        } //아기사자가 없으면 종료

        // 방향에 따라 점수 변경 시도
        boolean changed;

        if (direction.equals("+")) {
            changed = b.increaseDiligence(); // + 입력 시 증가 메서드 호출
        } else {
            changed = b.decreaseDiligence(); // - 입력 시 감소 메서드 호출
        }

        //성공 여부에 따라 코드 리턴
        if (changed) {
            return 1; // 점수 수정 성공
        } else {
            return 2; // 이미 0점이거나 5점이라 수정 실패
        }
    }

    // 6. 삭제 (학번 기준)
    public BabyLion deleteByStudentId(String studentId) {
        return lions.remove(studentId); //HashMap.remove()로 삭제 , 없으면 자동으로 null 반환
    }
}