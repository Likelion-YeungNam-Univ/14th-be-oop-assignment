import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BabyLionManager babyLionManager = new BabyLionManager();

        while(true){ // while true문을 통해 종료를 입력하기전까지 루프를 순회
            System.out.println(
                    "0. 종료\n" +
                    "1. 아기사자 등록\n" +
                    "2. 아기사자 전체 조회\n" +
                    "3. 아기사자 개별 조회\n" +
                    "4. 아기사자 자기소개 수정\n" +
                    "5. 아기사자 성실도 수정(+/-)\n" +
                    "6. 아기사자 삭제");
            int action = sc.nextInt();

            if (action == 1){
                BabyLion babyLion = new BabyLion(); // 새로운 아기사자 객체를 생성하고 정보들을 입력받아 ArrayList에 추가
                System.out.println("이름: ");
                babyLion.setName(sc.next());

                System.out.println("학번: ");
                babyLion.setStudentNumber(sc.next());
                sc.nextLine();

                System.out.println("자기소개: ");
                babyLion.setIntroduction(sc.nextLine());

                System.out.println("성실도(0~5까지 입력): ");
                babyLion.setEffort(sc.nextInt());

                babyLionManager.addBabyLion(babyLion);
            }

            else if (action == 2) {
                babyLionManager.getAllBabyLions();
            }

            else if (action == 3) { // BabyLionManager 클래스의 findByStudentNumber 메소드로 아기사자 객체를 리턴받고 해당 객체의 정보를 출력
                System.out.print("학번 입력: ");
                String studentNumber = sc.next();
                BabyLion babyLion = babyLionManager.findByStudentNumber(studentNumber);

                if (babyLion != null) {
                    System.out.println("이름: "+ babyLion.name + "\n" +
                            "학번 : " + babyLion.studentNumber + "\n" +
                            "자기소개: " + babyLion.introduction + "\n" +
                            "성실도: " + babyLion.effort);
                }
            }

            else if (action == 4) { // findByStudentNumber 로 babyLion 객체를 리턴받고 해당 객체의 소개글을 출력해주고 수정.
                System.out.println("소개글을 수정할 학번: ");
                String studentNumber = sc.next();
                BabyLion babyLion = babyLionManager.findByStudentNumber(studentNumber);
                if (babyLion != null) {
                    String currentIntroduction = babyLion.getIntroduction();
                    System.out.println("현재 소개글: " + currentIntroduction);
                    System.out.println("소개글 수정: ");
                    sc.nextLine();
                    babyLion.setIntroduction(sc.nextLine());
                    System.out.println("바뀐 소개글: " + babyLion.getIntroduction());
                }
            }

            else if (action == 5) { // 위 메소드들과 비슷하게 findByStudentNumber로 객체를 리턴받고 성실도를 수정.
                System.out.println("성실도를 수정할 학번: ");
                String studentNumber = sc.next();
                BabyLion babyLion = babyLionManager.findByStudentNumber(studentNumber);
                if (babyLion != null) {
                    int effort = babyLion.getEffort();
                    System.out.println("현재 성실도(0~5까지의 범위만 가능) : " + effort);
                    System.out.println("+ or -를 입력하세요(+1혹은 -1씩 조정됨)");
                    String flag = sc.next();
                    if(flag.equals("+")) {
                        if (effort < 5) {
                            babyLion.increaseEffort();
                            System.out.println("바뀐 성실도: " + babyLion.getEffort() + "");
                        } else {
                            System.out.println("이미 최대값입니다.");
                        }
                    } else if(flag.equals("-")) {
                        if (effort > 0) {
                            babyLion.decreaseEffort();
                            System.out.println("바뀐 성실도: " + babyLion.getEffort() + "");
                        } else {
                            System.out.println("이미 최소값입니다.");
                        }
                    }
                }
            }

            else if (action == 6) { // ArrayList의 메소드 .remove() 로 구현되어있습니당
                System.out.print("삭제할 학번: ");
                String studentNumber = sc.next();
                babyLionManager.removeBabyLion(studentNumber);
            }

            else if (action == 0) { // 반복문 탈출
                break;
            }
        }

    }
}
