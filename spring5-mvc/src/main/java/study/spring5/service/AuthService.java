package study.spring5.service;

import study.spring5.domain.AuthInfo;
import study.spring5.domain.Member;
import study.spring5.domain.MemberDao;
import study.spring5.error.WrongIdPasswordException;

public class AuthService {

    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public AuthInfo authenticate(String email, String password) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            throw new WrongIdPasswordException();
        }
        if (!member.matchpassword(password)) {
            throw new WrongIdPasswordException();
        }
        return new AuthInfo(member.getId(), member.getEmail(), member.getName());
    }
}
