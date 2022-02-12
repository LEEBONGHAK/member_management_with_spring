package management.membermanagement;

import management.membermanagement.repository.JDBCMemberRepository;
import management.membermanagement.repository.MemberRepository;
import management.membermanagement.repository.MemoryMemberRepository;
import management.membermanagement.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JDBCMemberRepository(dataSource);
    }
}
