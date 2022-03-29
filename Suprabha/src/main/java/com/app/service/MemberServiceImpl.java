package com.app.service;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Enums.Roles;
import com.app.constant.Constants;
import com.app.dao.IBookDao;
import com.app.dao.IMemberBookDao;
import com.app.dao.IUserDao;
import com.app.dto.Login;
import com.app.dto.MemberDto;
import com.app.exception.DependanceyException;
import com.app.exception.RecordNotFound;
import com.app.pojo.Book;
import com.app.pojo.BookIdMemberMapping;
import com.app.pojo.User;


@Service
@Transactional
public class MemberServiceImpl implements IMemberService {
	@Autowired
	   private IBookDao bdao;
	   
	@Autowired
	private EntityManager manager;
	
	   @Autowired
	   private IMemberBookDao bmdao;
	   
	   @Autowired
	   private IUserDao mdao;
	

	@Override  
	public User addMemberDetails(MemberDto memberdto) {
		User user=new User();
		user.setNumOfBooksPresent(Constants.INITIAL_BOOK_OF_MEMBE);
		user.setFine(Constants.INITIAL_FINE_FOR_MEMBER);
		user.setRole(Roles.MEMBER);
		user.setName(memberdto.getName());
		user.setEmail(memberdto.getEmail());
		user.setAddress(memberdto.getAddress());
		user.setPassword(memberdto.getPassword());		
        System.out.println("added successfuly");
        return mdao.save(user);
	}


	

	@Override
	public void renewBook(Integer bookId, Integer memberId) {
		if(!bdao.findById(bookId).isPresent())
		{
			throw new RecordNotFound("no book with given Id"+bookId);
		}
		if(!mdao.findById(memberId).isPresent())
		{
			throw new RecordNotFound("no member with given Id"+memberId);
		}
		int noOftimeRenew =bmdao.findByBookIdAndMemberId(bookId,memberId).getNumOfTimesRenewed();
		if(noOftimeRenew==Constants.MAX_RENEWAL)
		{
			throw new DependanceyException("this book has been renewed by max no of times");
		}else
		{
			Float fine=mdao.findById(memberId).get().getFine();
			if(fine>0)
			{
				throw new DependanceyException("User has been charged fine. Please pay and renew books");
			}else
			{
				BookIdMemberMapping bmmapping =
						bmdao.findByBookIdAndMemberId(bookId,memberId);
				int noOfRenew=bmmapping.getNumOfTimesRenewed();
				bmmapping.setNumOfTimesRenewed(noOfRenew++);
				bmdao.save(bmmapping);
				System.out.println("renewed successfuly");
			}
		}
		
	}


	@Override   
	public void updateMemberAdd(Integer Id,String add) 
	{
		/*Consumer<Book>bookConsumer = book -> {
             Integer presentBooksAtLib = book.getAvailabilityCount();
             if(presentBooksAtLib>0)
             book.setAvailabilityCount(presentBooksAtLib--);
             else
            	 throw new DependanceyException("Book not present in library");*/
      User member= mdao.findById(Id).orElseThrow(()-> new RecordNotFound("member not found"));
       
        member.setAddress(add);
        mdao.save(member);
		
	}


	@Override   
	public void updatePassword(String email, String pass) {
		
		            List<User> member=mdao.findByEmail(email);
		            member.get(0).setPassword(pass);
		            mdao.save(member.get(0));
	}


	@Override
	public String fineToPay(Integer issueId) {
		System.out.println("in fine pay---");
		float fine=0;
		BookIdMemberMapping issueBook= bmdao.findById(issueId).orElseThrow(()->new RecordNotFound("record not found"));
		issueBook.setFineOnBook(fine);
		                int memberID=issueBook.getMemberId();
		               User user= mdao.findById(memberID).orElseThrow(()->new RecordNotFound("record not found"));
		               ///update fie in the member
		               user.setFine(fine);
		               mdao.save(user);		               
		bmdao.save(issueBook);
		return "fine payed";
		
	}

	

	@Override
	public List<Book> allBooks()  //working
	{//Integer id, String title, @NotNull Integer availabilityCount, String author
		String jpql="select new com.app.pojo.Book(id,title,availabilityCount,author) from com.app.pojo.Book b";
		
		return  manager.createQuery(jpql,Book.class).getResultList();
		
	}


	@Override
	public User validateUser(Login details)
	{System.out.println("---validate user-----");
		System.out.println("in login service ");
		System.out.println(details.getEmail());
		System.out.println(details.getPassord());
		
		System.out.println(mdao.findByEmail(details.getEmail()).get(0).toString());
//		System.out.println(mdao.findByEmailAndPassword(email, password));
//		String jpql="select u from User u where u.email=:em and u.password=:pass";
//		return manager.createQuery(jpql, User.class).setParameter("em",details.getEmail())
//				.setParameter("pass", details.getPassord()).getSingleResult();	
		return mdao.findByEmail(details.getEmail()).get(0);
	}


	@Override
	public void bookReserve(int memberId, int bookId)
	{
		
		///show only qyt 0 books for reservation
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
