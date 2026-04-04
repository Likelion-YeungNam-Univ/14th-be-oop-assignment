package lion.service;

import lion.model.Lion;
import java.util.ArrayList; // 배열 클래스 불러오기

public class LionManager {
    private ArrayList<Lion> list = new ArrayList<>(); // 리스트 생성

    // 등록
    public void addLion(String name, int id, String intro, int diligence) {
        if (String.valueOf(id).length() != 8) { // 학번이 8자리인지 확인
            System.out.println("학번은 8자리여야 합니다.");
            return;
        }

        list.add(new Lion(name, id, intro, diligence)); // 객체 생성 후 생성된 리스트에 저장
        System.out.println("등록 완료");
    }

    // 전체 조회
    public void showAll() {
        if (list.isEmpty()) {
            System.out.println("데이터 없음");
            return;
        }

        for (Lion l : list) {
            l.showInfo();
        }
    }

    // 개별 조회
    public Lion findById(int id) {
        for (Lion l : list) {
            if (l.getLionId() == id) {
                return l;
            }
        }
        return null;
    }
    public void showOne(int id) {
        Lion l = findById(id);
        if (l != null) {
            l.showInfo();
        } else {
            System.out.println("데이터 없음");
        }
    }

    // 자기소개 수정
    public void updateIntro(int id, String newIntro) {
        Lion l = findById(id);
        if (l != null) {
            l.setIntro(newIntro);
            System.out.println("수정 완료");
        } else {
            System.out.println("데이터 없음");
        }
    }

    // 성실도 변경
    public void updateDiligence(int id, int delta) {
        Lion l = findById(id); // 찾아서
        if (l != null) {
            l.changeDiligence(delta); // 변경하고
            System.out.println("변경 완료"); // 피드백한다
        } else {
            System.out.println("데이터 없음");
        }
    }

    // 삭제
    public void deleteLion(int id) {
        Lion target = findById(id); // 찾아서

        if (target != null) {
            list.remove(target); // 삭제하고
            System.out.println("삭제 완료"); // 마찬가지로 피드백
        } else {
            System.out.println("데이터 없음");
        }
    }
}