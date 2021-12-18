package study.spring5.service;

import org.springframework.transaction.annotation.Transactional;
import study.spring5.domain.Member;
import study.spring5.domain.MemberDao;
import study.spring5.error.MemberNotFoundException;

public class ChangePasswordService {

    private MemberDao memberDao;

    @Transactional
    public void changePassword(String email, String oldPwd, String newPwd) {
        Member member = memberDao.selectByEmail(email);
        if (member == null)
            throw new MemberNotFoundException();

        member.changePassword(oldPwd, newPwd);

        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
}
