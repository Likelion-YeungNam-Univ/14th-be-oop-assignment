import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BabyLionProgram program = new BabyLionProgram();
        int num;

        while(true){
        System.out.println("1.아기사자 등록");
        System.out.println("2.아기사자 전체 조회");
        System.out.println("3.아기사자 개별 조회");
        System.out.println("4.아기사자 자기소개 수정");
        System.out.println("5.아기사자 성실도 수정(+/-)");
        System.out.println("6.아기사자 삭제");
        System.out.println("7.프로그램 종료");
        System.out.println("1~7까지의 수를 입력하세요");
            try{
                num = sc.nextInt();
            }
            catch(InputMismatchException e){ //정수가 아닌 문자가 들어오는 예외 처리
                System.out.println("오류입니다 1~7까지의 수를 입력해주세요");
                sc.nextLine(); // 무한루프 방지 버퍼 비우기
                continue;
            }

            switch(num) {
                case 1: { // 등록
                    System.out.println("이름을 입력하세요: ");
                    String name = sc.next();
                    System.out.println("학번을 입력하세요: ");
                    int studentNumber = sc.nextInt();
                    if(String.valueOf(studentNumber).length() !=8){ // 학번이 8자리가 아니면 처음으로 돌려보내기
                        System.out.println("학번은 8자리여야만 합니다 처음으로 돌아갑니다");
                        break;
                    }
                    sc.nextLine(); // 버퍼 비우기

                    System.out.println("자기소개 입력: ");
                    String introduction = sc.nextLine();
                    System.out.println("성실도 입력(0~5): ");
                    int sincerity = sc.nextInt();
                    if(sincerity < 0 || sincerity > 5){  // 성실도가 0~5 사이가 아닐 시 처음으로 돌려보내기
                        System.out.println("성실도는 0~5 사이여야만 합니다 처음으로 돌아갑니다");
                        break;
                    }
                    program.register(name, studentNumber, introduction, sincerity);
                    continue;
                }
                case 2: { //전체 조회
                    program.showAll();
                    continue;
                }
                case 3: { //개별 조회
                    System.out.println("조회할 학번을 입력하세요");
                    int studentNumber = sc.nextInt();
                    program.showOne(studentNumber);
                    continue;
                }
                case 4: { //자기소개 수정
                    System.out.println("수정할 학번을 입력하세요");
                    int studentNumber = sc.nextInt();
                    sc.nextLine(); // 버퍼 비우기
                    System.out.println("수정할 내용을 입력하세요");
                    String introduction = sc.nextLine();
                    program.change(studentNumber, introduction);
                    continue;
                }
                case 5: { //성실도 수정
                    System.out.println("성실도를 수정할 학번을 입력하세요:");
                    int studentNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("1 과 -1 중에 선택해주세요: ");
                    int number = sc.nextInt();
                    program.sincerityChagne(studentNumber, number);
                    continue;
                }
                case 6: { //삭제
                    System.out.println("삭제할 학번을 입력하세요:");
                    int studentNumber = sc.nextInt();
                    program.del(studentNumber);
                    continue;
                }
                case 7: { //종료
                    System.out.println("종료");
                    sc.close();
                    return;
                }
                default: // 다른 숫자면 다시 처음으로 돌아가기
                    continue;
            }

        }
    }
}