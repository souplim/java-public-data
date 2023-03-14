package com.boot.example.mapper;

//import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//import com.boot.example.domain.SubjectVO;

@Mapper
public interface ExampleMapper {

	@Select("select sysdate from dual") // 간단한 쿼리문의 경우 어노테이션으로 줘도 됨
	public String getTime();
	public String getDate();
//	public List<SubjectVO> getSubjectList(int no);
//	public String getSubjectName(String s_num); /* 학과번호를 인자로 학과명을 출력 */
//	public int subjectInsert(SubjectVO subject);
//	public int subjectUpdate(SubjectVO subject);
//	public int subjectDelete(int no);
}
