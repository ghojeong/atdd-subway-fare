package dreamfora;

import dreamfora.member.domain.Member;
import dreamfora.member.domain.MemberRepository;
import dreamfora.member.domain.RoleType;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader {
    private final MemberRepository memberRepository;

    public DataLoader(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void loadData() {
        memberRepository.save(new Member("admin@email.com", "password", 20, Arrays.asList(RoleType.ROLE_ADMIN.name())));
        memberRepository.save(new Member("member@email.com", "password", 20, Arrays.asList(RoleType.ROLE_MEMBER.name())));
    }
}