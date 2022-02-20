package com.app.service;

import com.app.dto.MemberDto;

public interface IMemberService {
	void addMemberDetails(MemberDto memberdto);
    void issueBook(Integer bookId,Integer memberId);
    void renewBook(Integer bookId,Integer memberId);
    void updateMemberAdd(Integer Id,String add);
    void updatePassword(String email,String pass);
    void fineToPay(Integer issueId,Float fine);
    
}
