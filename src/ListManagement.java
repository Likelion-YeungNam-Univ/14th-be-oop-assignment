import java.util.ArrayList;
import java.util.Scanner;

// 등록된 아기사자를 목록으로 모아서 관리하고 각 기능을 수행하는 관리자 클래스
public class ListManagement {
    private Scanner scanner = new Scanner(System.in);
    // 데이터의 길이를 모르기에 ArrayList로 선언
    private ArrayList<Lion> lionList;

    public ListManagement() {
        lionList = new ArrayList<>();
    }

    // 리스트에서 학번이 일치하는 아기사자가 있으면 그 아기사자 객체를 return, 없으면 null return.
    private Lion findLion(int studentNumber) {
        for (Lion lion : lionList) {
            if (lion.getStudentNumber() == studentNumber) {
                return lion;
            }
        }
        return null;
    }

    // 새로운 아기사자의 정보를 입력받고 객체로 만들어서 리스트에 추가하는 메서드
    public void addList() {
        System.out.print("\n이름을 입력하세요 ==> ");
        String name = scanner.nextLine();

        System.out.print("학번을 입력하세요 ==> ");
        int studentNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("자기소개를 입력하세요 ==> ");
        String introduction = scanner.nextLine();

        int sincerity;
        // 올바른 점수를 입력할 때까지 반복문을 사용
        while (true) {
            System.out.print("성실도를 입력하세요(1 ~ 5) ==> ");
            sincerity = scanner.nextInt();
            // 입력한 값이 조건에 맞으면 반복문을 빠져나가고 아니면 경고문을 띄운 뒤 다시 물어봄
            if (sincerity >= 0 && sincerity <= 5) {
                break;
            }
            System.out.println("입력이 잘못되었습니다. 0~ 5 사이로 다시 입력하세요.");
        }
        scanner.nextLine();

        //리스트에 추가
        lionList.add(new Lion(studentNumber, name, introduction, sincerity));
        System.out.println("등록 완료");
    }

    // 리스트에 들어있는 모든 아기사자의 정보를 순서대로 화면에 보여주는 메서드
    public void searchAll() {
        System.out.println("\n=== 전체 아기사자 목록 ===");
        // 리스트가 비어있는지 확인.
        if (lionList.isEmpty()) {
            System.out.println("등록된 사자가 없음");
            return;
        }
        // 리스트 안에 있는 아기사자 객체 return.
        for (Lion lion : lionList) {
            System.out.println(lion);
            System.out.println("-------------------------");
        }
    }

    // 학번을 입력받아 특정 아기사자 정보를 보여주는 메서드
    public void searchIndividual() {
        System.out.print("\n조회할 아기사자의 학번을 입력하세요 ==> ");
        int id = scanner.nextInt();

        // 미리 만들어둔 findLion에 학번을 넘겨서 사자 객체를 받아옴
        Lion lion = findLion(id);

        // 받아온 객체가 빈 값이 아니라면 찾았다는 뜻이므로 정보를 출력함
        if (lion != null) {
            System.out.println("=== 개별 조회 결과 ===");
            System.out.println(lion);
        } else {
            System.out.println("해당 학번의 아기사자가 존재하지 않습니다.");
        }
    }

    // 자기소개 수정
    public void updateIntroduction() {
        System.out.print("\n자기소개를 수정할 학번을 입력하세요 ==> ");
        int id = scanner.nextInt();
        scanner.nextLine();


        // 미리 만들어둔 findLion에 학번을 넘겨서 사자 객체를 받아옴
        Lion lion = findLion(id);

        if (lion != null) {
            System.out.print("새로운 자기소개를 입력하세요 ==> ");
            String newIntro = scanner.nextLine();
            // 사자 객체가 스스로 가지고 있는 정보 수정 기능을 호출해서 값을 바꿈
            lion.setIntroduction(newIntro);
            System.out.println("자기소개가 수정되었습니다.");
        } else {
            System.out.println("해당 학번의 아기사자가 존재하지 않습니다.");
        }
    }

    // 성실도 수정
    public void updateSincerity() {
        System.out.print("\n성실도를 변경할 학번을 입력하세요 ==> ");
        int id = scanner.nextInt();

        Lion lion = findLion(id);
        if (lion != null) {
            System.out.print("변경할 수치를 입력하세요 (예: 1 증가면 1, 1 감소면 -1) ==> ");
            int amount = scanner.nextInt();

            // 사자 객체에게 점수 변경을 시도하게 하고 조건에 맞아 성공했는지 여부를 돌려받아 확인함
            if (lion.changeSincerity(amount)) {
                System.out.println("성실도가 성공적으로 변경되었습니다.");
            } else {
                System.out.println("변경 실패: 성실도는 0에서 5 사이만 유지 가능합니다.");
            }
        } else {
            System.out.println("해당 학번의 아기사자가 존재하지 않습니다.");
        }
    }

    // 삭제
    public void deleteLion() {
        System.out.print("\n삭제할 아기사자의 학번을 입력하세요 ==> ");
        int id = scanner.nextInt();

        Lion lion = findLion(id);
        if (lion != null) {
            // remove명령어로 리스트에서 해당 아기사자 객체 삭제
            lionList.remove(lion);
            System.out.println("삭제가 완료되었습니다.");
        } else {
            System.out.println("해당 학번의 아기사자가 존재하지 않습니다.");
        }
    }
}