package com.back.domain.wiseSaying.service;

import com.back.AppContext;
import com.back.WiseSaying;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {


    private final WiseSayingRepository wiseSayingRepository = AppContext.wiseSayingRepository;

    // 내부 로직
    public WiseSaying write(String content, String author) {

        WiseSaying wiseSaying = new WiseSaying(content, author);

        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    public boolean delete(int id) {
//        int deleteIndex = findIndexById(id);
//
//        if (deleteIndex == -1) return deleteIndex;
//
//        wiseSayings.remove(deleteIndex);
//
//        return deleteIndex;

        // 기존 로직보다 성능은 안 좋지만, 가독성이 좋음
        // 실무에서는 이런 선택을 하면 안된다.
        // 하지만 removeIf를 보여주기 위해서 사용함

        return wiseSayingRepository.deleteById(id);
    }

//    private int findIndexById(int id) {
    ////        for (int i = 0; i <= wiseSayings.size(); i++) {
    ////            if (wiseSayings.get(i).getId() == id) {
    ////                return i;
    ////            }
    ////        }
    ////        return -1;
//        return IntStream.range(0, wiseSayings.size())
//                .filter(index -> wiseSayings.get(index).getId() == id)
//                .findFirst()
//                .orElse(-1);
//    }

    public WiseSaying findById(int id) {
//        int index = findIndexById(id);
//        if (index == -1) return null;
//        return wiseSayings.get(index);
        return wiseSayingRepository.findById(id);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }

    public List<WiseSaying> findForList() {
        return wiseSayingRepository.findForList();

    }
}
