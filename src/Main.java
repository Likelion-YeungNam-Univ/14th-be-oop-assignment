// Main.java 실행, 메뉴, 입력 처리
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //사용자 입력
        BabyLionManager manager = new BabyLionManager(); //아기사자 목록 관리 객체 생성

        while (true) { // 인터페이스 출력
            System.out.println("\n==== 아기사자 관리 프로그램 ====");
            System.out.println("1. 아기사자 등록");
            System.out.println("2. 아기사자 전체 조회");
            System.out.println("3. 아기사자 개별 조회");
            System.out.println("4. 아기사자 자기소개 수정");
            System.out.println("5. 아기사자 성실도 변경 (-/+)");
            System.out.println("6. 아기사자 삭제");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            int menu;

            // 숫자 외 입력 시 예외처리
            try {
                menu = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("숫자를 입력하세요.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            // 0 입력시 프로그램 종료
            if (menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 선택한 메뉴에 따라 기능 수행
            switch (menu) {
                case 1:
                    // 아기사자 등록
                    System.out.print("학번 입력: ");
                    String studentId = scanner.nextLine();

                    System.out.print("이름 입력: ");
                    String name = scanner.nextLine();

                    System.out.print("자기소개 입력: ");
                    String introduction = scanner.nextLine();

                    // 입력받은 정보로 객체 생성
                    BabyLion lion = new BabyLion(studentId, name, introduction);

                    // 중복 학번 여부를 확인하여 등록
                    if (manager.addLion(lion)){
                        System.out.println("아기사자가 등록되었습니다.");
                    } else {
                        System.out.println("이미 존재하는 학번입니다.");
                    }

                    break;

                case 2:
                    // 전체 아기사자 조회
                    manager.printAllLions();
                    break;

                case 3:
                    // 특정 아기사자 조회
                    System.out.print("조회할 학번 입력: ");
                    String searchId = scanner.nextLine();

                    // 학번으로 아기사자 검색
                    BabyLion foundLion = manager.findLionByStudentId(searchId);

                    if (foundLion == null) {
                        System.out.println("해당 학번의 아기사자가 없습니다.");
                    } else {
                        System.out.println("조회 결과: ");
                        System.out.println(foundLion);
                    }
                    break;

                case 4:
                    // 자기소개 수정
                    System.out.print("수정할 학번 입력: ");
                    String updateId = scanner.nextLine();

                    System.out.print("새 자기소개 입력: ");
                    String newIntroduction = scanner.nextLine();

                    // 수정 성공 여부에 따라 결과 출력
                    if (manager.updateIntroduction(updateId, newIntroduction)) {
                        System.out.println("자기소개가 수정되었습니다.");
                    } else {
                        System.out.println("해당 학번의 아기사자가 없습니다.");
                    }
                    break;

                case 5:
                    // 성실도 변경 (-/+)
                    System.out.print("성실도를 변경할 학번 입력: ");
                    String targetId = scanner.nextLine();

                    BabyLion targetLion = manager.findLionByStudentId(targetId);

                    if (targetLion == null) {
                        System.out.println("해당 학번의 아기사자가 없습니다.");
                        break;
                    }

                    // 증가 감소 선택
                    System.out.print("증가(+), 감소(-) 선택: ");
                    String input = scanner.nextLine();

                    int amount;

                    if (input.equals("+")) {
                        amount = 1;
                    } else if (input.equals("-")) {
                        amount = -1;
                    } else {
                        System.out.println("잘못된 입력입니다.");
                        break;
                    }

                    // 성실도 변경
                    if (manager.changeLionSincerity(targetId, amount)) {
                        System.out.println("성실도가 변경되었습니다.");
                    } else {
                        if (amount == 1) {
                            System.out.println("성실도는 최대 5까지만 가능합니다.");
                        } else {
                            System.out.println("성실도는 최소 0까지만 가능합니다.");
                        }
                    }

                    break;

                case 6:
                    // 아기사자 삭제
                    System.out.print("삭제할 학번 입력: ");
                    String deleteId = scanner.nextLine();

                    if (manager.deleteLion(deleteId)) {
                        System.out.println("아기사자가 삭제되었습니다.");
                    } else {
                        System.out.println("해당 학번의 아기사자가 없습니다.");
                    }
                    break;

                default:
                    // 잘못된 입력 처리
                    System.out.println("올바른 메뉴 번호를 입력하세요.");
            }
        }
        scanner.close();
    }
}