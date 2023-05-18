package com.kbstar.service;

import com.kbstar.dto.Member;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements KBService<Integer, Member> {
    /**
     * 등록 및 가입 진행
     * argument: Object
     * return: null
     *
     * @param member
     */
    @Autowired
    MemberMapper mapper;

    @Override
    public void register(Member member) throws Exception {
        mapper.insert(member);
    }

    @Override
    public void remove(Integer id) throws Exception {
        mapper.delete(id);
    }

    @Override
    public void modify(Member member) throws Exception {
        mapper.update(member);
    }

    @Override
    public Member get(Integer id) throws Exception {
        return mapper.select(id);
    }

    @Override
    public List<Member> get() throws Exception {
        return mapper.selectall();
    }
}
