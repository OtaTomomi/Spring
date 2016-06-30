package board.mapper;

import board.dto.ReadDto;
import board.entity.Read;

public interface ReadMapper {
	Read readOrNot(ReadDto dto);
	int alreadyRead(ReadDto dto);
}
