import java.util.ArrayList;

public class LionManager {
    private ArrayList<LionStudents> Lions;
    public LionManager(){
        Lions = new ArrayList<>();
    }

    // 등록 관리
    public void addStudent(LionStudents students){
        Lions.add(students);
    }
    // 전체 조회 (반복문으로 이름과 학번만 출력)
    public void showAllStudents(){
        if (Lions.isEmpty()){
            System.out.println("등록된 아기사자가 없습니다.");
            return;
        }
        for (LionStudents students : Lions){
            System.out.println(students.getName() + ", " + students.getStudentId());
        }
    }
    // 개인 특정 (학번 기준) 다른 값을 키로 사용 가능
    public LionStudents findStudentById(int value){
        for (LionStudents students : Lions){
            if (students.getStudentId() == value){
                return students;
            }
        }
        return null;
    }
    // 개별 조회 (개인 특정 후 사용)
    public void showStudentDetail(int value){
        LionStudents student = findStudentById(value);

        if (student == null){
            System.out.println("해당 학번의 아기사자가 없습니다.");
            return;
        }
        System.out.println(student.getDetailInfo());
    }
    // 자기소개 수정
    public void updateIntroduction(int studentId,String introduction){
        LionStudents student = findStudentById(studentId);
        if (student == null){
            System.out.println("해당 아기사자가 없습니다.");
            return;
        }
        student.setIntroduction(introduction);
        System.out.println("수정되었습니다.");
    }
    // 성실도 관리(증가)
    public void increasePrize(int studentId, int value){
        LionStudents student = findStudentById(studentId);
        if (student == null){
            System.out.println("해당 아기사자가 없습니다.");
            return;
        }
        student.increasePrize(value);
        System.out.println(studentId + "학생의 성실도가 " + student.getPrize() + " 로 변경되었습니다.");
    }
    // 성실도 관리(감소)
    public void decreasePrize(int studentId, int value){
        LionStudents student = findStudentById(studentId);
        if (student == null){
            System.out.println("해당 아기사자가 없습니다.");
            return;
        }
        student.decreasePrize(value);
        System.out.println(studentId + "학생의 성실도가 " + student.getPrize() + " 로 변경되었습니다.");
    }
    // 삭제
    public void deleteStudent(int studentId){
        LionStudents student = findStudentById(studentId);
        if (student == null){
            System.out.println("해당 아기사자가 없습니다.");
            return;
        }
        Lions.remove(student);
        System.out.println("정상 처리되었습니다.");
    }
}
