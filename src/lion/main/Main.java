package lion.main; // 이 코드가 프로젝트에서 어디에 소속되어있는지 나타냄

import lion.service.LionManager; // 기능 담당 클래스를 불러옴
import java.util.Scanner; // 입력을 받기위해서 클래스 불러옴

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 불러온 스캐너 정의
        LionManager manager = new LionManager(); // 불러온 기능 정의

        while (true) {
            System.out.println("\n===== 아기사자 관리 프로그램 ====="); // 인터페이스
            System.out.println("1. 등록");
            System.out.println("2. 전체 조회");
            System.out.println("3. 개별 조회");
            System.out.println("4. 자기소개 수정");
            System.out.println("5. 성실도 변경");
            System.out.println("6. 삭제");
            System.out.println("0. 종료");
            System.out.println("==============================");
            System.out.print("선택: ");

            int menu = sc.nextInt(); // 메뉴를 정수로 받아야만해

            if (menu == 1) { // 등록
                System.out.print("이름: ");
                String name = sc.next();

                System.out.print("학번(8자리): ");
                int id = sc.nextInt(); // 숫자만 받고 엔터가 남아서 뒤에 엔터가 들어가기 때문에

                sc.nextLine(); // 버퍼 비워줘야함
                System.out.print("자기소개: ");
                String intro = sc.nextLine();

                System.out.print("성실도(0~5): ");
                int diligence = sc.nextInt();

                manager.addLion(name, id, intro, diligence);

            } else if (menu == 2) { // 전체 조회
                manager.showAll();

            } else if (menu == 3) { // 개별 조회
                System.out.print("학번: ");
                int id = sc.nextInt();
                manager.showOne(id);

            } else if (menu == 4) { // 학번으로 학생 조회 후 자기소개 수정
                System.out.print("학번: ");
                int id = sc.nextInt(); // 위와 같은 이유로

                sc.nextLine(); // 버퍼 비우기
                System.out.print("새 자기소개: ");
                String intro = sc.nextLine();

                manager.updateIntro(id, intro);

            } else if (menu == 5) { // 성실도 변경
                System.out.print("학번: ");
                int id = sc.nextInt();

                System.out.print("변경값(+/-): ");
                int delta = sc.nextInt();

                manager.updateDiligence(id, delta);

            } else if (menu == 6) { // 삭제
                System.out.print("학번: ");
                int id = sc.nextInt();

                manager.deleteLion(id);

            } else if (menu == 0) { // 종료
                System.out.println("프로그램 종료");
                break; // while로 반복한 것 끝내기

            } else {
                System.out.println("잘못된 입력");
            }
        }

        sc.close(); // 스캐너 닫아주기
    }
}