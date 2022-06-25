package mybatis.boarduk.controller;

import lombok.RequiredArgsConstructor;
import mybatis.boarduk.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor // 생성자 주입
public class HomeController {

    private final BoardService boardService;

    @GetMapping("/home") // 주소 지정
    public String home() {
        return "/boards/home";
    }
}
