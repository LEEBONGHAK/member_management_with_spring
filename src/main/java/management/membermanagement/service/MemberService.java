package management.membermanagement.service;

import management.membermanagement.domain.Member;
import management.membermanagement.repository.MemberRepository;
import management.membermanagement.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /* 회원 가입 */
    public Long join(Member member) {
        // 중복 이름 회원X
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /* 전체 회원 조회 */
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberID) {
        return memberRepository.findById(memberID);
    }
}
