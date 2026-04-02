import java.util.HashMap;
import java.util.Map;

public class LionManager {

    static final int SINCERITY_INIT = 3; // 아기사자 등록 시 성실도는 3
    private Map<String, LikeLion> lions = new HashMap<>(); // HashMap 이용하여 O(1)로 값 찾음.

    /**
     * 1. 아기사자 정보 등록
     *
     * @param schoolNumber 학번
     * @param name 이름
     * @param memo 자기소개
     */
    public void register(
            String schoolNumber,
            String name,
            String memo
    ) {
        if (lions.containsKey(schoolNumber)) {
            System.out.println("이미 등록된 학번입니다!");
            return;
        }

        lions.put(schoolNumber, new LikeLion(schoolNumber, name, memo, SINCERITY_INIT));
        System.out.println("등록완료!");
    }

    /**
     * 2. 아기사자 전체 조회
     */
    public void findAll() {

        for(Map.Entry<String, LikeLion> entry : lions.entrySet()) {
            LikeLion findLion = entry.getValue();
            System.out.println("학번: " + findLion.getSchoolNumber() + "\t" + "이름: " + findLion.getName());
        }
    }


    /**
     * 3. 아기사자 상세 조회
     *
     * @param schoolNumber 조회할 아기사자 학번
     */
    public void findLion(String schoolNumber) {

        LikeLion lion = lions.get(schoolNumber);

        if(checkLion(lion)) {
            System.out.println("존재하지 않는 아기사자 입니다.\n학번을 확인해주세요.");
            return;
        }

        System.out.println("학번: " + lion.getSchoolNumber());
        System.out.println("이름: " + lion.getName());
        System.out.println("자기소개: " + lion.getMemo());
        System.out.println("성실도: " + lion.getSincerity());
    }

    /**
     * 4. 아기사자 자기소개 수정
     *
     * @param schoolNumber 수정할 아기사자 학번
     * @param memo 자기소개 내용
     */
    public void updateMemo(String schoolNumber, String memo) {

        LikeLion lion = lions.get(schoolNumber);

        if(checkLion(lion)) {
            System.out.println("존재하지 않는 아기사자 입니다.\n학번을 확인해주세요.");
            return;
        }

        lion.setMemo(memo);

        System.out.println("수정되었습니다.");
    }

    /**
     * 5. 아기사자 성실도 변경
     *
     * @param schoolNumber 변경할 아기사자 학번
     * @param amount 증감, 감소 값
     */
    public void changeSincerity(String schoolNumber, int amount) {
        LikeLion lion = lions.get(schoolNumber);

        if(checkLion(lion)) {
            System.out.println("존재하지 않는 아기사자 입니다.\n학번을 확인해주세요.");
            return;
        }

        int sumSincerity = lion.getSincerity() + amount;
        // 성실도는 항상 0~5의 범위를 벗어나지 않음.
        if(sumSincerity < 0 || sumSincerity > 5) {
            System.out.println("성실도는 0~5의 값만 가능합니다.\n현재 성실도: " + lion.getSincerity());
            return;
        }

        lion.setSincerity(sumSincerity);

        System.out.println("변경되었습니다.");
    }

    /**
     * 6. 아기사자 삭제
     *
     * @param schoolNumber 삭제할 아기사자 학번
     */
    public void deleteLion(String schoolNumber) {

        if(lions.remove(schoolNumber) != null) {
            System.out.println("삭제되었습니다!");
        } else {
            System.out.println("존재하지 않는 아기사자 입니다.");
        }
    }

    /**
     * 아기사자 존재 여부
     *
     * @param lion 아기사자
     */
    static boolean checkLion(LikeLion lion) {
        return lion == null;
    }
}
