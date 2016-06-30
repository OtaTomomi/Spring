package board.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dto.ReadDto;
import board.entity.Read;
import board.mapper.ReadMapper;

@Service
public class ReadService {
	@Autowired
	private ReadMapper readMapper;

	public int readOrNot(ReadDto dto) {
		ReadDto newDto = new ReadDto();
		Read entity = readMapper.readOrNot(dto);
		BeanUtils.copyProperties(entity, newDto);
		return newDto.getReadCheck();
	}
	public void alreadyRead(ReadDto readDto) {
		readMapper.alreadyRead(readDto);
	}

}
