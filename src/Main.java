import java.util.Collection;
import java.util.Scanner;


public class Main {

    private static final LionManager manager = new LionManager();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("선택 > ");
            String choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1" -> registerLion();
                case "2" -> findAllLions();
                case "3" -> findByStudentId();
                case "4" -> updateIntroduction();
                case "5" -> updateDiligence();
                case "6" -> deleteLion();
                case "7" -> {                    //각 번호에 맞는 메서드 실행
                    System.out.println("프로그램을 종료합니다. 🦁");
                    sc.close();
                    return;
                }
                default -> System.out.println("[오류] 0~7 사이의 번호를 입력해주세요.");
            }
            System.out.println();
        }
    }

    // 1. 등록
    private static void registerLion() {
        System.out.print("학번     : "); String studentId    = sc.nextLine().trim();
        System.out.print("이름     : "); String name         = sc.nextLine().trim();
        System.out.print("자기소개 : "); String introduction = sc.nextLine().trim();

        String error = manager.register(studentId, name, introduction);
        if (error != null) {
            System.out.println("[오류] " + error);
        } else {
            System.out.println("[성공] " + name + " 아기사자가 등록되었습니다.");
        }
    }

    // 2. 전체 조회
    private static void findAllLions() {
        Collection<BabyLion> all = manager.findAll();
        if (all.isEmpty()) {
            System.out.println("등록된 아기사자가 없습니다.");
            return;
        }
        System.out.println("=== 🦁 전체 아기사자 목록 (" + all.size() + "명) ===");
        all.forEach(System.out::println);
    }

    // 3. 개별 조회 (학번)
    private static void findByStudentId() {
        System.out.print("조회할 학번 : ");
        String studentId = sc.nextLine().trim();

        BabyLion b = manager.findByStudentId(studentId);
        if (b == null) {
            System.out.println("[오류] 등록되지 않은 학번입니다: " + studentId);
        } else {
            System.out.println("[조회 결과]");
            System.out.println(b);
        }
    }

    // 5. 자기소개 수정
    private static void updateIntroduction() {
        System.out.print("수정할 학번      : "); String studentId = sc.nextLine().trim();
        System.out.print("새 자기소개      : "); String newIntro  = sc.nextLine().trim();

        BabyLion b = manager.updateIntroduction(studentId, newIntro);
        if (b == null) {
            System.out.println("[오류] 등록되지 않은 학번입니다: " + studentId);
        } else {
            System.out.println("[성공] 자기소개가 수정되었습니다.");
            System.out.println(b);
        }
    }

    //  6. 성실도 수정
    private static void updateDiligence() {
        System.out.print("수정할 학번  : "); String studentId = sc.nextLine().trim();
        System.out.print("증가(+) / 감소(-) : "); String direction = sc.nextLine().trim();

        if (!direction.equals("+") && !direction.equals("-")) {
            System.out.println("[오류] '+' 또는 '-'만 입력 가능합니다.");
            return;
        }

        int result = manager.updateDiligence(studentId, direction);
        switch (result) {
            case 0 -> System.out.println("[오류] 등록되지 않은 학번입니다: " + studentId);
            case 1 -> {
                BabyLion b = manager.findByStudentId(studentId);
                System.out.println("[성공] 성실도가 변경되었습니다.");
                System.out.println(b);
            }
            case 2 -> System.out.println("[경고] 성실도는 "
                    + (direction.equals("+") ? "최대 5점" : "최소 0점") + "입니다.");
        }
    }

    //  7. 삭제
    private static void deleteLion() {
        System.out.print("삭제할 학번 : ");
        String studentId = sc.nextLine().trim();

        BabyLion b = manager.deleteByStudentId(studentId);
        if (b == null) {
            System.out.println("[오류] 등록되지 않은 학번입니다: " + studentId);
        } else {
            System.out.println("[성공] " + b.getName() + " 아기사자가 삭제되었습니다.");
        }
    }

    //  화면
    private static void printMenu() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║     🦁  아기사자 관리 시스템      ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║  1. 아기사자 등록                 ║");
        System.out.println("║  2. 전체 조회                     ║");
        System.out.println("║  3. 개별 조회 (학번)              ║");
        System.out.println("║  4. 자기소개 수정                 ║");
        System.out.println("║  5. 성실도 수정 (+/-)             ║");
        System.out.println("║  6. 아기사자 삭제                 ║");
        System.out.println("║  7. 종료                          ║");
        System.out.println("╚══════════════════════════════════╝");
    }
}