package dreamfora.member.application;

import dreamfora.member.domain.Member;
import dreamfora.member.domain.MemberRepository;
import org.springframework.stereotype.Service;
import support.auth.userdetails.User;
import support.auth.userdetails.UserDetails;
import support.auth.userdetails.UserDetailsService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public CustomUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        Member member = memberRepository.findByEmail(email).orElseThrow(RuntimeException::new);
        return new User(member.getEmail(), member.getPassword(), member.getRoles());
    }
}
