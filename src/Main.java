import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LionManager manager = new LionManager();

        while (true) {
            System.out.println("----- 아기사자 관리 프로그램 -----");
            System.out.println("1. 아기사자 등록");
            System.out.println("2. 전체 조회");
            System.out.println("3. 개별 조회");
            System.out.println("4. 자기소개 수정");
            System.out.println("5. 성실도 증가");
            System.out.println("6. 성실도 감소");
            System.out.println("7. 삭제");
            System.out.println("8. 종료");
            System.out.println("메뉴를 선택하세요: ");

            int menu = sc.nextInt(); sc.nextLine(); // 정수값 입력 받은 후 버퍼 flush

            switch (menu){
                case 1: // 등록
                    System.out.print("이름 입력: ");
                    String name = sc.nextLine();
                    System.out.print("학번 입력: " );
                    int studentId = sc.nextInt();
                    sc.nextLine();
                    // 중복 여부 확인
                    if(manager.findStudentById(studentId) != null){
                        System.out.println("이미 존재하는 학번입니다.");
                        break;
                    }
                    System.out.print("자기소개 입력: ");
                    String introduction = sc.nextLine();
                    // 구조체 생성
                    LionStudents student = new LionStudents(name, studentId, introduction); // 생성
                    manager.addStudent(student); // List 추가
                    System.out.println("아기사자 등록이 완료되었습니다.");
                    break;
                case 2: // 전체 조회
                    manager.showAllStudents();
                    break;
                case 3: // 개별 조회
                    System.out.print("조회할 아기사자의 학번을 입력하시오: ");
                    studentId = sc.nextInt();
                    sc.nextLine();
                    manager.showStudentDetail(studentId);
                    break;
                case 4: // 자기소개 수정
                    System.out.print("수정할 아기사자의 학번을 입력하시오: ");
                    studentId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("수정할 자기소개를 입력하시오: ");
                    introduction = sc.nextLine();
                    manager.updateIntroduction(studentId,introduction);
                    break;
                case 5: // 성실도 증가
                    System.out.print("성실도를 증가시킬 아기사자의 학번을 입력하시오: ");
                    studentId = sc.nextInt(); sc.nextLine();
                    System.out.print("성실도 점수를 입력하시오: ");
                    int prize = sc.nextInt(); sc.nextLine();
                    if (prize > 6 || prize < 0){
                        System.out.println("점수의 범위는 0부터 5입니다.");
                        break;
                    }
                    manager.increasePrize(studentId,prize);
                    break;
                case 6: // 성실도 감소
                    System.out.print("성실도를 감소시킬 아기사자의 학번을 입력하시오: ");
                    studentId = sc.nextInt(); sc.nextLine();
                    System.out.print("성실도 점수를 입력하시오: ");
                    prize = sc.nextInt(); sc.nextLine();
                    if (prize > 6 || prize < 0){
                        System.out.println("점수의 범위는 0부터 5입니다.");
                        break;
                    }
                    manager.increasePrize(studentId,prize);
                    break;
                case 7: // 삭제
                    System.out.print("삭제시킬 아기사자의 학번을 입력하시오: ");
                    studentId = sc.nextInt(); sc.nextLine();
                    manager.deleteStudent(studentId);
                    break;
                case 8: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 접근입니다.");
            }
        }
    }
}


