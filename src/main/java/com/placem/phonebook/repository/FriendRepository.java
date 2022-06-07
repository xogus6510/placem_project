package com.placem.phonebook.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.placem.phonebook.entity.Friend;

public interface FriendRepository extends JpaRepository <Friend, Long> {

	Page <Friend> findByFrndSeq(long frndSeq, Pageable pageable);	
	List <Friend> findByFrndNm(String frndNm);
	List <Friend> findByCreatedDate(LocalDateTime createdDate);
	List <Friend> findByModifiedDate(LocalDateTime modifiedDate);
	Page<Friend> findAll(Pageable pageable);
	Page<Friend> findByFrndNmContaining(String frndNm, Pageable pageable);
	Page<Friend> findByFrndNmEquals(String frndNm, Pageable pageable);

	@Query(value = "SELECT a.frnd_seq, a.frnd_nm, a.created_date, a.modified_date, count(b.frnd_seq) as count FROM tb_friend a join tb_phone b on a.frnd_seq = b.frnd_seq where b.tel_no_3 = ?1 group by b.frnd_seq", nativeQuery = true)
	List<Friend> count(String TelNo3);
	//@Query(value = "select count(*) from tb_phone m where m.frnd_seq = ?1", nativeQuery = true)
	//long count(long frndSeq);
	//SELECT tb_friend.frnd_seq, tb_friend.frnd_nm, tb_friend.created_date, tb_friend.modified_date, count(tb_phone.frnd_seq) as count FROM phonebookdb.tb_phone join tb_friend on tb_friend.frnd_seq = tb_phone.frnd_seq where tb_phone.tel_no_3 = 6510 group by tb_phone.frnd_seq;

}
