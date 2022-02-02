package study.spring5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import study.spring5.domain.Member;
import study.spring5.domain.MemberDao;
import study.spring5.error.DuplicateMemberException;
import study.spring5.error.MemberNotFoundException;
import study.spring5.service.MemberRegisterService;
import study.spring5.service.RegisterRequest;
import study.spring5.validator.RegisterRequestValidator;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
public class RestMemberController {

    private MemberDao memberDao;
    private MemberRegisterService registerService;

    @GetMapping("/api/members")
    public List<Member> members() {
        return memberDao.selectAll();
    }

    @GetMapping("/api/members/{id}")
    public ResponseEntity<Object> member(@PathVariable Long id) {
        Member member = memberDao.selectById(id);
        if (member == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new Error("no member"));
            // return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member);
    }

    @GetMapping("/api/members2/{id}")
    public Member member2(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Member member = memberDao.selectById(id);
        if (member == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        return member;
    }

    @GetMapping("/api/members3/{id}")
    public Member member3(@PathVariable Long id) {
        Member member = memberDao.selectById(id);
        if (member == null) {
            throw new MemberNotFoundException();
        }
        return member;
    }

    @PostMapping("/api/members")
    public ResponseEntity<Object> newMember(
            @RequestBody @Valid RegisterRequest regReq /*,
			Errors errors */) {
		/*
		if (errors.hasErrors()) {
			String errorCodes = errors.getAllErrors()
					.stream()
					.map(error -> error.getCodes()[0])
					.collect(Collectors.joining(","));
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResponse("errorCodes = " + errorCodes));
		}
		*/
        try {
            Long newMemberId = registerService.regist(regReq);
            URI uri = URI.create("/api/members/" + newMemberId);
            return ResponseEntity.created(uri).build();
        } catch (DuplicateMemberException dupEx) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/api/members2")
    public void newMember2(
            @RequestBody RegisterRequest regReq,
            Errors errors,
            HttpServletResponse response) throws IOException {
        try {
            new RegisterRequestValidator().validate(regReq, errors);
            if (errors.hasErrors()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            Long newMemberId = registerService.regist(regReq);
            response.setHeader("Location", "/api/members/" + newMemberId);
            response.setStatus(HttpServletResponse.SC_CREATED);
        } catch (DuplicateMemberException dupEx) {
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void setRegisterService(MemberRegisterService registerService) {
        this.registerService = registerService;
    }
}