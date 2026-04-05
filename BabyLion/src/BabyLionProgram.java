import java.util.ArrayList;
// remove, add 등의 기능을 사용하기 위해 ArrayList를 사용
public class BabyLionProgram {
    private ArrayList<BabyLion> list = new ArrayList<>();

    public void register(String name, int studentNumber, String introduction, int sincerity) { // Main에서 매개변수로 받음
        BabyLion lion = new BabyLion(name, studentNumber, introduction, sincerity); // BabyLion 객체를 만들고 각 필드에 값이 들어감
        list.add(lion); // 만든 객체에 저장
    }

    public void showAll() {
        if (list.isEmpty()) { // 리스트가 비어있으면 리턴 실행
            System.out.println("등록된 아기사자가 없습니다");
            return;
        }
        for (int i = 0; i < list.size(); i++) { //리스트에 있는 모든 BabyLion 객체를 끌어옴
            BabyLion lion = list.get(i);
            System.out.println("이름: " + lion.getName());
            System.out.println("학번: " + lion.getStudentNumber());
            System.out.println("자기소개: " + lion.getIntroduction());
            System.out.println("성실도: " + lion.getSincerity());
        }
    }

    public void showOne(int Number){
        for (int i = 0; i < list.size(); i++){
            BabyLion lion = list.get(i);
            if (lion.getStudentNumber() == Number){ //입력받은 값과 저장되어있는 학번 중에 같은게 있으면 출력
                System.out.println("이름: " + lion.getName());
                System.out.println("학번: " + lion.getStudentNumber());
                System.out.println("자기소개: " + lion.getIntroduction());
                System.out.println("성실도: " + lion.getSincerity());
                return;
            }
        }
        System.out.println("해당하는 학번이 존재하지 않습니다");

    }

    public void change(int Number, String introduction) {
        for (int i = 0; i < list.size(); i++) {
            BabyLion lion = list.get(i);
            if (lion.getStudentNumber() == Number){
                lion.setIntroduction(introduction); // Setter를 이용해 자기소개 내용을 수정함
                System.out.println("수정 완료되었습니다");
                return;
            }
        }
        System.out.println("해당하는 학번이 존재하지 않습니다");
    }

    public void sincerityChagne(int Number, int number) {
        for (int i = 0; i < list.size(); i++) {
            BabyLion lion = list.get(i);
            if (lion.getStudentNumber() == Number) {
                int newSincerity = lion.getSincerity() + number;
                if (newSincerity > 5)  // 5점을 넘으면 상승x
                    System.out.println("이미 최고 점수입니다");
                else if (newSincerity < 0) //0점 아래이면 하락x
                    System.out.println("이미 최소 점수입니다");
                else {
                    lion.setSincerity(newSincerity); // Setter를 숫자 값을 확인한 후에 호출
                    System.out.println("수정 완료되었습니다");
                }
                return;
            }
        }
        System.out.println("해당하는 학번이 존재하지 않습니다");
    }

        public void del (int Number){
            for (int i = 0; i < list.size(); i++) {
                BabyLion lion = list.get(i);
                if (lion.getStudentNumber() == Number) {
                    list.remove(i);
                    System.out.println("삭제 완료되었습니다");
                    return;
                }
            }
            System.out.println("해당하는 학번이 존재하지 않습니다");
        }
    }

