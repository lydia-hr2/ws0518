package com.kbstar.service;

import com.kbstar.dto.Member;
import com.kbstar.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MemberService implements ShopService<Integer, Member>{

    @Autowired
    MemberMapper mapper;

    @Override
    public void register(Member member) throws Exception {
        mapper.insert(member);
    }

    @Override
    public void remove(Integer k) throws Exception {
        mapper.delete(k);
    }

    @Override
    public void modify(Member member) throws Exception {
        mapper.update(member);
    }

    @Override
    public Member get(Integer k) throws Exception {
        return mapper.Select(k);
    }

    @Override
    public List<Member> get() throws Exception {
        return mapper.selectall();
    }
}
