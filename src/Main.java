import java.util.Scanner;

// 사용자에게 메뉴를 보여주고 명령을 관리자에게 전달하는 역할
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListManagement manager = new ListManagement();

        // 사용자가 0번 종료 번호를 누르기 전까지 메뉴를 계속 띄워주기 위해 while반복문을 사용
        while (true) {
            System.out.println("\n===== 아기사자 관리 시스템 =====");
            System.out.println("1번 등록");
            System.out.println("2번 전체 조회");
            System.out.println("3번 개별 조회");
            System.out.println("4번 자기소개 수정");
            System.out.println("5번 성실도 변경");
            System.out.println("6번 삭제");
            System.out.println("0번 종료");
            System.out.print("메뉴 선택 ==>  ");

            int sel = scanner.nextInt();
            // 버퍼 지우기
            scanner.nextLine();

            // 사용자가 입력한 숫자에 따라 class호출
            switch (sel) {
                case 1:
                    manager.addList();
                    break;
                case 2:
                    manager.searchAll();
                    break;
                case 3:
                    manager.searchIndividual();
                    break;
                case 4:
                    manager.updateIntroduction();
                    break;
                case 5:
                    manager.updateSincerity();
                    break;
                case 6:
                    manager.deleteLion();
                    break;
                case 0:
                    // 프로그램 종료
                    System.out.println("프로그램 종료");
                    return;
                default:
                    // 메뉴에 없는 번호를 누르면 경고를 띄우고 반복문의 처음으로 돌아가 메뉴를 다시 띄움
                    System.out.println("잘못된 입력입니다. 다시 선택하세요");
            }
        }
    }
}