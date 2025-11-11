package com.back;

import com.back.domain.system.controller.SystemController;
import com.back.domain.wiseSaying.controller.WiseSayingController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {
    //시작
    public void run() {
        System.out.println("== 명언 앱 ==");

        Scanner scanner = AppContext.scanner;
        SystemController systemController = AppContext.systemController;
        WiseSayingController wiseSayingController = AppContext.wiseSayingController;

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();
            Rq rq = new Rq(cmd);

            switch (rq.getActionName())
            {
                case "종료":
                    systemController.actionExit();
                    return;
                case "목록":
                    wiseSayingController.actionList();
                    break;
                case "등록":
                    wiseSayingController.actionWrite();
                    break;
                case "수정":
                    wiseSayingController.actionModify(rq);
                    break;
                case "삭제":
                    wiseSayingController.actionDelete(rq);
                    break;
            }
//            equals("종료")) {     break;
//            } else if (rq.getActionName().equals("목록")) {
//                actionList();
//            } else if (rq.getActionName().equals("등록")) {
//                actionWrite();
//            } else if (rq.getActionName().equals("삭제")) {
//                actionDelete(cmd);
//            } else if (rq.getActionName().equals("수정")) {
//                actionModify(cmd);
//            }

        }
    }




}
