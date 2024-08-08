package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ChattingTest.dto.ChattingRoom;




@Mapper
public interface MemberMapper {
	List<ChattingRoom> basicRoomList();
}
