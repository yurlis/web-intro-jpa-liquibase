package mate.academy.webintro.service.skill;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.skill.CreateSkillRequestDto;
import mate.academy.webintro.dto.skill.SkillDto;
import mate.academy.webintro.mapper.SkillMapper;
import mate.academy.webintro.model.Skill;
import mate.academy.webintro.repository.skill.SkillRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Override
    public SkillDto save(CreateSkillRequestDto requestDto) {
        Skill skill = skillMapper.toModel(requestDto);
        return skillMapper.toDto(skillRepository.save(skill));
    }

    @Override
    public List<SkillDto> findAll() {
        return skillRepository.findAll()
                .stream()
                .map(skillMapper::toDto)
                .toList();
    }
}
