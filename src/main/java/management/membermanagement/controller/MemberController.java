package management.membermanagement.controller;

import management.membermanagement.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 멤버 서비스를 스프링 컨테이너 내의 멤버 서비스와 연결을 시켜줌
    // Dependency Injection - 생성자 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
