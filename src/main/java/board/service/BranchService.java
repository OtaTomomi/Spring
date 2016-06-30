package board.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dto.BranchDto;
import board.entity.Branch;
import board.mapper.BranchMapper;

@Service
public class BranchService {
	@Autowired
	private BranchMapper branchMapper;

	public List<BranchDto> getBranchAll() {
		List<Branch> branchList = branchMapper.getBranchAll();
		List<BranchDto> resultList = converToDto(branchList);
		return resultList;

	}
	public List<BranchDto> converToDto(List<Branch> branchList) {
		List<BranchDto> resultList = new LinkedList<>();
		for(Branch entity : branchList){
			BranchDto dto = new BranchDto();
			BeanUtils.copyProperties(entity, dto);
			resultList.add(dto);
		}
		return resultList;
	}


}
