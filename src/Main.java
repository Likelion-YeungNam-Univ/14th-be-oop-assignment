import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        LionManager lionManager = new LionManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("아기사자 관리 프로그램입니다!");
        while (true) {
            System.out.println("\n[메뉴] 1.등록 2.전체조회 3.개별조회 4.자기소개수정 5.성실도변경 6.삭제 7.종료");
            System.out.print("선택: ");

            if(!sc.hasNextInt()) {
                System.out.println("숫자만 입력 가능합니다!");
                sc.next();
                continue;
            }

            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1 :
                    System.out.print("학번 입력: ");
                    String schoolNumber = sc.nextLine();
                    System.out.print("이름 입력: ");
                    String name = sc.nextLine();
                    System.out.print("자기소개 입력: ");
                    String memo = sc.nextLine();

                    lionManager.register(schoolNumber, name, memo);

                    break;

                case 2 :
                    lionManager.findAll();

                    break;

                case 3 :
                    System.out.print("조회하고 싶은 아기사자 학번 입력: ");

                    String searchId = sc.nextLine();
                    lionManager.findLion(searchId);

                    break;

                case 4 :
                    System.out.print("자기소개 수정하고 싶은 아기사자 학번 입력: ");
                    String updateId = sc.nextLine();
                    System.out.print("자기소개 내용 입력: ");
                    String updateMemo = sc.nextLine();

                    lionManager.updateMemo(updateId, updateMemo);

                    break;

                case 5 :
                    System.out.print("성실도 변경하고 싶은 아기사자 학번 입력: ");
                    String changeId = sc.nextLine();
                    System.out.print("성실도 입력(1 혹은 -1): ");
                    int sincerity = sc.nextInt();
                    sc.nextLine();

                    if(!(sincerity == 1 || sincerity == -1)) {
                        System.out.println("1 또는 -1 값만 입력 가능합니다.");
                        continue;
                    }

                    lionManager.changeSincerity(changeId, sincerity);

                    break;

                case 6 :
                    System.out.print("삭제할 학번: ");
                    String delId = sc.nextLine();
                    lionManager.deleteLion(delId);

                    break;

                case 7 :
                    System.out.println("아기사가 관리 프로그램을 종료합니다.");
                    return;

                default :
                    System.out.println("잘못된 번호입니다. 1~7 사이를 입력해주세요.");
            }
        }
    }
}