package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;


@Mapper
public interface BoardMapper {

	void addBoard(Board id);
	List<Board> allview(Paging paging);
	void delete(int no);
	void update(Board vo);
	Board select(int no);
}
