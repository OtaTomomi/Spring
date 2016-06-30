package board.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dto.PositionDto;
import board.entity.Position;
import board.mapper.PositionMapper;

@Service
public class PositionService {
	@Autowired
	private PositionMapper positionMapper;

	public List<PositionDto> getPositionAll() {
		List<Position> positionList = positionMapper.getPositionAll();
		List<PositionDto> resultList = converToDto(positionList);
		return resultList;
	}
	public List<PositionDto> converToDto(List<Position> positionList) {
		List<PositionDto> resultList = new LinkedList<>();
		for(Position entity : positionList){
			PositionDto dto = new PositionDto();
			BeanUtils.copyProperties(entity, dto);
			resultList.add(dto);
		}
		return resultList;
	}

}
