package management.membermanagement;

import management.membermanagement.repository.MemberRepository;
import management.membermanagement.repository.MemoryMemberRepository;
import management.membermanagement.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
